import java.util.*;

class TicketManager implements ITicketManager {
    private List<Ticket> tickets;
    private Map<String, Integer> supporterWorkload;

    public TicketManager() {
        this.tickets = new ArrayList<>();
        this.supporterWorkload = new HashMap<>();
    }

    @Override
    public int createTicket(String user, String title, Ticket.ImportanceLevel importanceLevel, String message) {
        Ticket ticket = new Ticket(user,title,importanceLevel, message);
        tickets.add(ticket);

        // Assign the ticket to the least busy supporter
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
            updateLastSeen(supporter);
        }
    }

    @Override
    public void setTicketStatus(int ticketId, boolean active) {
        Ticket ticket = getTicketById(ticketId);
        if (ticket != null) {
            ticket.setStatus(active);
            if (!active) {
                // If the ticket is finished, decrement the supporter's workload
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
    public List<Integer> getUserActiveTickets(String user) {
        List<Integer> activeTicketIds = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getUser().equals(user) && ticket.isActive()) {
                activeTicketIds.add(ticket.getTicketId());
            }
        }
        return activeTicketIds;
    }

    @Override
    public List<Integer> getUserFinishedTickets(String user) {
        List<Integer> finishedTicketIds = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getUser().equals(user) && !ticket.isActive()) {
                finishedTicketIds.add(ticket.getTicketId());
            }
        }
        return finishedTicketIds;
    }

    // ... (remaining methods)

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
                .orElse("DefaultSupporter");
    }

    // Update last seen timestamp for a participant
    private void updateLastSeen(String participant) {
        for (Ticket ticket : tickets) {
            Date lastSeen = ticket.getLastSeen(participant);
            if (lastSeen != null) {
                // Update the last seen timestamp for the participant
                ticket.updateLastSeen(participant);
            }
        }
    }
}
