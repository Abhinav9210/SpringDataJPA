package sdj.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String firstname;
    private String lastname;

    @Column(name="registration_date")
    private LocalDate registrationDate;

    private String email;
    private int level;

    @Column(name="active")
    private Boolean isActive;

    public User() {
    }
    public User(String username, String firstname, String lastname, LocalDate registrationDate, String email, Integer level, Boolean isActive) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.registrationDate = registrationDate;
        this.email = email;
        this.level = level;
        this.isActive = isActive;
    }

    // getters and setters for username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    // getters and setters for firstname and lastname
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public Integer getLevel() {
        return level;
    }
    //to string method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", level=" + level +
                ", isActive=" + isActive +
                '}';
    }
}
