package ru.netology.TicketSearch.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    Ticket ticket = new Ticket();

    @Test
    public void shouldSetId() {

        ticket.setId(11);

        int expected = 11;
        int actual = ticket.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrice() {

        ticket.setPrice(1_500);

        int expected = 1_500;
        int actual = ticket.getPrice();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetDepartureAirport() {

        ticket.setDepartureAirport("DME");

        String expected = "DME";
        String actual = ticket.getDepartureAirport();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetArrivalAirport() {

        ticket.setArrivalAirport("VKO");

        String expected = "VKO";
        String actual = ticket.getArrivalAirport();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetTravelTime() {

        ticket.setTravelTime(200);

        int expected = 200;
        int actual = ticket.getTravelTime();

        assertEquals(expected, actual);
    }
}