import java.io.*;
import java.util.*;
class Ticket {
    public int ticketId;
    private String userEmail;
    private String title;
    private String importanceLevel;
    private Map<String, List<Message>> messageHistory;
    private boolean active;
    private String assignedSupporter;
    public Ticket(String userEmail, String title, String importanceLevel, String message) {
        this.ticketId =getTicketId()+1 ;
        this.userEmail = userEmail;
        this.title = title;
        this.importanceLevel = importanceLevel;
        this.messageHistory = new HashMap<>();
        this.active = true;
        this.assignedSupporter ="";
        addMessage(userEmail, message);
    }
    public int lastTicketId(){
        int lastTicketId=0;
        try (BufferedReader reader = new BufferedReader(new FileReader("lastTicketId.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lastTicketId = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastTicketId;
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
        try (PrintWriter writer = new PrintWriter(new FileWriter("lastTicketId.txt"))) {
            writer.println(ticketId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
