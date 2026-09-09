package sdj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(name="registration_date")
    private LocalDate registrationDate;

    private String email;
    private Integer level;

    @Column(name="active")
    private Boolean isActive;

    public User() {
    }

}
