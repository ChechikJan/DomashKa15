package TestManager;

import Manager.ManagerTicket;
import Repository.RepositoryTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ticket.Ticket;

public class TestManager {
    RepositoryTicket repo = new RepositoryTicket();
    ManagerTicket manager = new ManagerTicket(repo);
    Ticket ticket1 = new Ticket(1, 17000, "AAA", "BBB", 300);
    Ticket ticket2 = new Ticket(2, 12000, "EEE", "BBB", 700);
    Ticket ticket3 = new Ticket(3, 9000, "SSS", "AAA", 500);
    Ticket ticket4 = new Ticket(4, 21000, "XXX", "CCC", 240);
    Ticket ticket5 = new Ticket(5, 11000, "AAA", "BBB", 450);
    Ticket ticket6 = new Ticket(6, 14000, "AAA", "BBB", 420);

    @Test
    public void searchTicket() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.searchBy("XXX", "CCC");
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchMultipleTicket() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] expected = {ticket5, ticket6, ticket1};
        Ticket[] actual = manager.searchBy("AAA", "BBB");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchNotTicketTo() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("AAA", "WWW");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchNotTicketFrom() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("QQQ", "BBB");
        Assertions.assertArrayEquals(expected, actual);
    }

}
