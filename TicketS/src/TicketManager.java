import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class TicketManager implements ITicketManager {
    private ArrayList<Ticket> tickets= new ArrayList<Ticket>();
    private Map<String, Integer> supporterWorkload;
    public TicketManager() {
        this.tickets = loadTicketsFromDirectory();
        this.supporterWorkload = new HashMap<>();
        supporterWorkload.put("Supporter1",5);
        supporterWorkload.put("Supporter2",2);
        supporterWorkload.put("Supporter3",3);
    }
    public ArrayList<Ticket> loadTicketsFromDirectory() {
        File directory = new File("/Users/arshia/IdeaProjects/JavaMiniProjects/TicketS");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if(file.getName().startsWith("ticket")){
                String[] fileNameParts = file.getName().split("_");
                int ticketId = Integer.parseInt(fileNameParts[1]);
                try (BufferedReader reader = new BufferedReader(new FileReader(file.getName()))) {
                    reader.readLine();
                    String line=reader.readLine();
                    String[] TicketData = line.split(",");
                    line = reader.readLine();
                    String[] firstMessage = line.split(":");
                    Ticket ticket = new Ticket(TicketData[0],TicketData[1],TicketData[2],firstMessage[1]);
                    ticket.assignToSupporter(TicketData[4]);
                    while ((line = reader.readLine()) != null){
                    String[] messageHistory = line.split(":");
                    String[] sender = messageHistory[0].split("-");
                    ticket.addMessage(sender[1].replaceAll(" ", ""),messageHistory[1]);
                    }
                    ticket.ticketId = ticketId;
                    tickets.add(ticket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
            }
        }
        return tickets;
    }
    public Ticket getTicketById(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }
    @Override
    public int createTicket(String userEmail, String title, String importanceLevel ,String message) {
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
    public ArrayList<Integer> getUserActiveTickets(String userEmail) {
        ArrayList<Integer> activeTicketIds = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getUserEmail().equals(userEmail) && ticket.isActive()) {
                activeTicketIds.add(ticket.getTicketId());
            }
        }
        return activeTicketIds;
    }
    @Override
    public ArrayList<Integer> getUserFinishedTickets(String userEmail) {
        ArrayList<Integer> finishedTicketIds = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getUserEmail().equals(userEmail) && !ticket.isActive()) {
                finishedTicketIds.add(ticket.getTicketId());
            }
        }
        return finishedTicketIds;
    }
    private void incrementSupporterWorkload(String supporter) {
        supporterWorkload.put(supporter, supporterWorkload.getOrDefault(supporter,0) + 1);
    }
    private void decrementSupporterWorkload(String supporter) {
        int currentWorkload = supporterWorkload.getOrDefault(supporter,0);
        if (currentWorkload > 0) {
            supporterWorkload.put(supporter, currentWorkload - 1);
        }
    }
    private String findLeastBusySupporter() {
        return supporterWorkload.entrySet().stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Supporter1");
    }
    @Override
    public ArrayList<Integer> getSupporterTickets(String supporterName) {
        ArrayList<Integer> supporterTicketIds = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getAssignedSupporter().equals(supporterName) && ticket.isActive()) {
                supporterTicketIds.add(ticket.getTicketId());
            }
        }
        return supporterTicketIds;
    }
}
