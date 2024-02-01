import java.util.ArrayList;
import java.util.List;
import java.util.Map;

interface ITicketManager {
    int createTicket(String userEmail, String title, String importanceLevel,String message );
    void replyToTicket(int ticketId, String supporter, String message);
    void setTicketStatus(int ticketId, boolean active);
    void saveTicketHistory(int ticketId);
    ArrayList<Integer> getUserActiveTickets(String userEmail);
    ArrayList<Integer> getUserFinishedTickets(String userEmail);
    ArrayList<Integer> getSupporterTickets(String supporterName);
}
