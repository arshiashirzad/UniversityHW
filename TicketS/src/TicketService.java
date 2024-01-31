import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketService {
    public static void StartTicket(Member member) {
        if (member instanceof User) {
            Scanner input = new Scanner(System.in);
            TicketManager Ticket = new TicketManager();
            while (true) {
                System.out.println("""
                        +==User=Pannel=================+
                        | 1.Check Tickets              |
                        | 2.New Ticket                 |
                        +==========================+""");
                System.out.println("Select Option: ");
                int operation = input.nextInt();
                if (operation == 1) {
                    System.out.println("""
                            +==User=Pannel=================+
                            | 1.Active Tickets             |
                            | 2.Finished Tickets           |
                            +==============================+
                            Enter here: """);
                    int tick = input.nextInt();
                    if (tick == 1) {
                        ArrayList<Integer> ActiveIds = Ticket.getUserActiveTickets(member.email);
                        System.out.println("Select the id of your ticket to see the history of it:");
                        for (Integer f : ActiveIds) {
                            System.out.println(f);
                        }
                        System.out.println("Enter id: ");
                        int ticketId = input.nextInt();
                        Ticket userTicket = Ticket.getTicketById(ticketId);
                        List<Message> messages = userTicket.getHistoryForSender(member.email);
                        for (Message k : messages) {
                            System.out.println(k.toString());
                        }
                        System.out.println("""
                                +==User=Pannel=================+
                                | 1.Add message                |
                                | 2.close ticket               |
                                +==============================+
                                Enter here: """);
                        int x = input.nextInt();
                        if (x == 1) {
                            String newMessage = input.nextLine();
                            userTicket.addMessage(member.email, newMessage);
                            userTicket.saveHistory();
                            System.out.println("Message submitted successfully");
                        }
                    } else if (tick==2) {
                        ArrayList<Integer> FinishedIds = Ticket.getUserFinishedTickets(member.email);
                        System.out.println("Select the id of your ticket to see the history of it:");
                        for (Integer f : FinishedIds) {
                            System.out.println(f);
                        }
                        System.out.println("Enter id: ");
                        int ticketId = input.nextInt();
                        Ticket userTicket = Ticket.getTicketById(ticketId);
                        List<Message> messages = userTicket.getHistoryForSender(member.email);
                        for (Message k : messages) {
                            System.out.println(k.toString());
                        }
                    }
                }else if (operation == 2) {
                    System.out.println("Enter the title of your ticket: ");
                    input.nextLine();
                    String title = input.nextLine();

                    System.out.println("""
                                1.Low
                                2.Medium
                                3.High
                                Emergency level: """);
                    int x = input.nextInt();
                    String importance = "MEDIUM";
                    switch (x) {
                        case 1:
                            importance = "LOW";
                            break;

                        case 2:
                            importance = "MEDIUM";
                            break;

                        case 3:
                            importance = "HIGH";
                            break;
                    }
                    System.out.println("Enter your message:");
                    input.nextLine();
                    String message = input.nextLine();
                    int ticketId = Ticket.createTicket(member.email, title, importance, message);
                    System.out.println("Your ticket info:");
                    System.out.println("Title: " + title);
                    System.out.println("Emergency: " + importance);
                    System.out.println("message: " + message);
                    System.out.println("DO YOU WANT TO SUBMIT YOUR TICKET?");
                    System.out.println("""
                                1.YES
                                2.NO
                                Enter here: """);
                    int submitKey = input.nextInt();
                    if (submitKey == 1) {
                        Ticket.saveTicketHistory(ticketId);
                        System.out.println("YOUR TICKET HAS BEEN SUBMITED SUCCESSFULLY");
                        System.out.println("KEEP THIS ID : " + ticketId);
                    } else {
                        System.out.println("Your Ticket has not been written into file");
                    }
                }
            }
        }else if(member instanceof Supporter){
            Scanner input = new Scanner(System.in);
            TicketManager Ticket = new TicketManager();
            while()
        }
    }
}