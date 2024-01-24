import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Ticket {
    public enum ImportanceLevel {
        LOW,
        MEDIUM,
        HIGH
    }
    private static int ticketCounter = 1;
    private int ticketId;
    private String user;
    private String title;
    private ImportanceLevel importanceLevel;
    private Map<String, List<Message>> messageHistory;
    private Map<String, Date> lastSeen;
    private boolean active;
    private String assignedSupporter;

    public Ticket(String user, String title, ImportanceLevel importanceLevel, String message) {
        this.ticketId = ticketCounter++;
        this.user = user;
        this.title = title;
        this.importanceLevel = importanceLevel;
        this.messageHistory = new HashMap<>();
        this.lastSeen = new HashMap<>();
        this.active = true;
        this.assignedSupporter = "";
        addMessage(user, message);
        updateLastSeen(user);
    }

    public void addMessage(String sender, String message) {
        messageHistory.computeIfAbsent(sender, k -> new ArrayList<>())
                .add(new Message(sender, message));
        updateLastSeen(sender);
    }
    public List<Message> getHistoryForSender(String sender) {
        return messageHistory.getOrDefault(sender, Collections.emptyList());
    }
    public Date getLastSeen(String participant) {
        return lastSeen.getOrDefault(participant, null);
    }

    public void setStatus(boolean active) {
        this.active = active;
    }

    public void assignToSupporter(String supporter) {
        this.assignedSupporter = supporter;
    }

    public String getAssignedSupporter() {
        return assignedSupporter;
    }
    public int getTicketId() {
        return ticketId;
    }

    public String getUser() {
        return user;
    }
    public boolean isActive() {
        return active;
    }
    public String getTitle() {
        return title;
    }
    public ImportanceLevel getImportanceLevel() {
        return importanceLevel;
    }
    public void updateLastSeen(String participant) {
        lastSeen.put(participant, new Date());
    }
    public void saveHistory() {
        try (FileWriter writer = new FileWriter("ticket_" + ticketId + "_history.txt")) {
            for (List<Message> senderHistory : messageHistory.values()) {
                for (Message message : senderHistory) {
                    writer.write(message.toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
