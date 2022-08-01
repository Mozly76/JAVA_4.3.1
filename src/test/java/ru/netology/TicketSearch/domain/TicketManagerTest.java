package ru.netology.TicketSearch.domain;

import org.junit.jupiter.api.Test;
import ru.netology.TicketSearch.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {

    TicketManager manager = new TicketManager(new TicketRepository());
    Ticket ticket1 = new Ticket(1, 6_702, "AER", "DME", 240);
    Ticket ticket2 = new Ticket(2, 6_977, "AER", "LED", 265);
    Ticket ticket3 = new Ticket(3, 4_481, "VKO", "LED", 90);
    Ticket ticket4 = new Ticket(4, 9_117, "DME", "AER", 245);
    Ticket ticket5 = new Ticket(5, 9_363, "LED", "AER", 300);
    Ticket ticket6 = new Ticket(6, 5_698, "AER", "DME", 230);
    Ticket ticket7 = new Ticket(7, 6_702, "AER", "DME", 230);
    Ticket ticket8 = new Ticket(8, 6_887, "AER", "DME", 250);

    @Test
    public void shouldAddAndRemoveTicketsFromRepository() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.removeTicketById(ticket3.getId());

        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5};
        Ticket[] actual = manager.getSavedTickets();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketByTwoAirportsAndSortThem() {
        ;
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);

        Ticket[] expected = {ticket6, ticket1, ticket7, ticket8};
        Ticket[] actual = manager.findAll("AER", "DME");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketByTwoAirportsAndSortThemIfNoItemsInRepository() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("AER", "DME");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketByTwoAirportsAndSortThemIfOneItemInRepository() {

        manager.addTicket(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("AER", "DME");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketByTwoAirportsAndSortThemIfOneItemInRepositoryButDoesNotQualify() {

        manager.addTicket(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("AER", "DME");

        assertArrayEquals(expected, actual);
    }
}