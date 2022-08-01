package ru.netology.TicketSearch.repository;

import org.junit.jupiter.api.Test;
import ru.netology.TicketSearch.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, 5_462, "AER", "DME", 234);
    Ticket ticket2 = new Ticket(2, 6_977, "AER", "LED", 265);
    Ticket ticket3 = new Ticket(3, 4_481, "VKO", "LED", 90);
    Ticket ticket4 = new Ticket(4, 9_117, "DME", "AER", 245);
    Ticket ticket5 = new Ticket(5, 9_363, "LED", "AER", 300);

    @Test
    public void test() {

        TicketRepository repo = new TicketRepository();
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.removeTicketById(ticket3.getId());

        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5};
        Ticket[] actual = repo.getSavedTickets();

        assertArrayEquals(expected, actual);
    }
}