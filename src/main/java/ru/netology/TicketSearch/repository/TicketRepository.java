package ru.netology.TicketSearch.repository;

import ru.netology.TicketSearch.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void addTicket(Ticket newTicket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = newTicket;
        tickets = tmp;
    }

    public void removeTicketById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] getSavedTickets() {
        return tickets;
    }
}