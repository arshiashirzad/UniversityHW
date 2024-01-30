import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class Ticket {
    private static int ticketCounter = 1;
    private int ticketId;
    private String userEmail;
    private String title;
    private String importanceLevel;
    private Map<String, List<Message>> messageHistory;
    private boolean active;
    private String assignedSupporter;

    public Ticket(String userEmail, String title, String importanceLevel, String message) {
        this.ticketId = ticketCounter++;
        this.userEmail = userEmail;
        this.title = title;
        this.importanceLevel = importanceLevel;
        this.messageHistory = new HashMap<>();
        this.active = true;
        this.assignedSupporter ="";
        addMessage(userEmail, message);
    }
    public void addMessage(String userEmail, String message) {
        messageHistory.computeIfAbsent(userEmail, k -> new ArrayList<>())
                .add(new Message(userEmail, message));
    }
    public List<Message> getHistoryForSender(String sender) {
        return messageHistory.getOrDefault(sender, Collections.emptyList());
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
    public String getUserEmail() {
        return userEmail;
    }
    public boolean isActive() {
        return active;
    }
    public String getTitle() {
        return title;
    }
    public String getImportanceLevel() {
        return importanceLevel;
    }
    public void saveHistory() {
        try (FileWriter writer = new FileWriter("ticket_" + ticketId + "_chat.txt")) {
            writer.write("Ticket Information:");
            writer.write( userEmail + "," + title + "," + importanceLevel + "," + active + "," + assignedSupporter);
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
