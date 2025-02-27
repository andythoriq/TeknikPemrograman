import java.util.ArrayList;

public class Tickets
{
    private ArrayList<Ticket> ticketList;

    public Tickets()
    {
        this.ticketList = new ArrayList<>();
    }

    public Tickets(ArrayList<Ticket> ticketList)
    {
        this.ticketList = ticketList;
    }

    public void addTicket(Ticket ticket)
    {
        this.ticketList.add(ticket);
    }

    public void displayTickets() {
        if (ticketList.isEmpty()) {
            System.out.println("Tidak ada Tiket.");
            return;
        }

        System.out.println("List Ticket:");
        for (Ticket ticket : ticketList) {
            ticket.printTicket();
        }
    }


    public ArrayList<Ticket> getTickets() {
        return this.ticketList;
    }

    public void setTickets(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
