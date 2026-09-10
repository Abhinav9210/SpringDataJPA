package sdj.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import sdj.entity.Ticket;
import sdj.service.TicketService;

import java.time.LocalDate;

//@Component
public class BookTicketClient implements ApplicationRunner{
    @Autowired
    TicketService ticketService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Implementation for booking a ticket
        Ticket ticket = new Ticket("Bus Stop 1", "Bus Stop 2", LocalDate.of(2024, 6, 15));
        ticketService.bookTicket(ticket);
    }
}
