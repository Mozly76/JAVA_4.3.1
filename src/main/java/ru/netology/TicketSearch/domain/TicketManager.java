package ru.netology.TicketSearch.domain;

import ru.netology.TicketSearch.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void addTicket(Ticket newTicket) {
        repo.addTicket(newTicket);
    }

    public void removeTicketById(int id) {
        repo.removeTicketById(id);
    }

    public Ticket[] getSavedTickets() {
        return repo.getSavedTickets();
    }

    public Ticket[] findAll(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getSavedTickets()) {
            if (matches(ticket, departureAirport, arrivalAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String departureAirport, String arrivalAirport) {

        if (ticket.getDepartureAirport().contains(departureAirport)) {
            return ticket.getArrivalAirport().contains(arrivalAirport);
        }
        return false;
    }
}