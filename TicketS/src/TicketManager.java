import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class TicketManager implements ITicketManager {
    private ArrayList<Ticket> tickets;
    private Map<String, Integer> supporterWorkload;
    public TicketManager() {
        this.tickets = loadTicketsFromDirectory("AuthenricationSource/");
        this.supporterWorkload = new HashMap<>();
    }
    public ArrayList<Ticket> loadTicketsFromDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                String[] fileNameParts = file.getName().split("_");
                int ticketId = Integer.parseInt(fileNameParts[1]);
                try (BufferedReader reader = new BufferedReader(new FileReader(directoryPath+"/"+file.getName()))) {
                    reader.readLine();
                    String line=reader.readLine();
                    String[] TicketData = line.split(",");
                    while ((line = reader.readLine()) != null){
                    String[] messageHistory = line.split(":");
                    }
                    Ticket ticket = new Ticket(TicketData[0],TicketData[1],TicketData[2],);
                    tickets.add(ticket);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return tickets;
    }
    @Override
    public int createTicket(String userEmail, String title, String importanceLevel ,String message ) {
        Ticket ticket = new Ticket(userEmail,title,importanceLevel, message);
        tickets.add(ticket);
        String leastBusySupporter = findLeastBusySupporter();
        ticket.assignToSupporter(leastBusySupporter);
        incrementSupporterWorkload(leastBusySupporter);
        return ticket.getTicketId();
    }
    @Override
    public void replyToTicket(int ticketId, String supporter, String message) {
        Ticket ticket = getTicketById(ticketId);
        if (ticket != null) {
            ticket.addMessage(supporter, message);
        }
    }
    @Override
    public void setTicketStatus(int ticketId, boolean active) {
        Ticket ticket = getTicketById(ticketId);
        if (ticket != null) {
            ticket.setStatus(active);
            if (!active) {
                decrementSupporterWorkload(ticket.getAssignedSupporter());
            }
        }
    }
    @Override
    public void saveTicketHistory(int ticketId) {
        Ticket ticket = getTicketById(ticketId);
        if (ticket != null) {
            ticket.saveHistory();
        }
    }
    @Override
    public List<Integer> getUserActiveTickets(String userEmail) {
        List<Integer> activeTicketIds = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getUserEmail().equals(userEmail) && ticket.isActive()) {
                activeTicketIds.add(ticket.getTicketId());
            }
        }
        return activeTicketIds;
    }
    @Override
    public List<Integer> getUserFinishedTickets(String userEmail) {
        List<Integer> finishedTicketIds = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getUserEmail().equals(userEmail) && !ticket.isActive()) {
                finishedTicketIds.add(ticket.getTicketId());
            }
        }
        return finishedTicketIds;
    }
    // Helper method to get a ticket by its ID
    private Ticket getTicketById(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }
    // Increment supporter workload
    private void incrementSupporterWorkload(String supporter) {
        supporterWorkload.put(supporter, supporterWorkload.getOrDefault(supporter, 0) + 1);
    }
    // Decrement supporter workload
    private void decrementSupporterWorkload(String supporter) {
        int currentWorkload = supporterWorkload.getOrDefault(supporter, 0);
        if (currentWorkload > 0) {
            supporterWorkload.put(supporter, currentWorkload - 1);
        }
    }
    // Assign the ticket to the least busy supporter
    private String findLeastBusySupporter() {
        return supporterWorkload.entrySet().stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Supporter1");
    }
}
