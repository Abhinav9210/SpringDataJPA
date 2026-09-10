package sdj;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sdj.entity.Ticket;
import sdj.repository.TicketRepository;
import sdj.service.TicketService;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainApplication4Tests {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketService ticketService;
    @Test
    public void testTicketBooking() {
        // Create a new ticket
        Ticket ticket = new Ticket("Bus Stop 1", "Bus Stop 2", LocalDate.of(2024, 6, 15));
        try {
            ticketService.bookTicket(ticket);
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }finally {
            assertThat(ticketRepository.findAll().isEmpty()).isTrue();
        }

    }

}
