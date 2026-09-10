package sdj.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String origin;
    private String destination;

    @Column(name="scheduled_at")
    LocalDate scheduledAt;

    public Ticket() {
    }
    public Ticket(String origin, String destination, LocalDate scheduledAt) {
        this.origin = origin;
        this.destination = destination;
        this.scheduledAt = scheduledAt;

    }

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public LocalDate getScheduledAt() {
        return scheduledAt;
    }
    public void setScheduledAt(LocalDate scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

}
