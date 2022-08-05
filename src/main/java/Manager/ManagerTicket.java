package Manager;

import Repository.RepositoryTicket;
import org.ticket.Ticket;

import java.util.Arrays;

public class ManagerTicket {
    private RepositoryTicket repo;

    public ManagerTicket(RepositoryTicket repo) {
        this.repo = repo;
    }

    public void addTicket(Ticket ticket) {
        repo.save(ticket);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public Ticket[] getTickets() {
        return repo.getTickets();
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;

            }
            Arrays.sort(result);

        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {

        if (ticket.getFromAirport().contains(from) && ticket.getToAirport().contains(to)) {
            return true;
        }

        else {
            return false;
        }
    }

}
