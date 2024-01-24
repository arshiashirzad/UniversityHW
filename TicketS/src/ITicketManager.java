import java.util.List;

interface ITicketManager {
    int createTicket(String user, String title, Ticket.ImportanceLevel importanceLevel, String message);
    void replyToTicket(int ticketId, String supporter, String message);
    void setTicketStatus(int ticketId, boolean active);
    void saveTicketHistory(int ticketId);
    List<Integer> getUserActiveTickets(String user);
    List<Integer> getUserFinishedTickets(String user);
}
