package sdj;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sdj.entity.User;
import sdj.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainApplication2Tests {

    @Autowired
    UserRepository userRepository;

    @BeforeAll
    public void setup() {
        //add dummy users using userRepository.save() method
        userRepository.save(new User("user1", LocalDate.of(2022, 1, 1), "user1@example.com", 1, true));
        userRepository.save(new User("user2", LocalDate.of(2022, 2, 1), "user2@example.com", 2, false));
        userRepository.save(new User("user3", LocalDate.of(2022, 3, 1), "user3@example.com", 3, true));
        userRepository.save(new User("user4", LocalDate.of(2022, 4, 1), "user4@example.com", 4, false));
        userRepository.save(new User("user5", LocalDate.of(2022, 5, 1), "user5@example.com", 5, true));
        userRepository.save(new User("user6", LocalDate.of(2022, 6, 1), "user6@example.com", 6, false));

    }
    @AfterAll
    public void cleanup() {
        //delete all users using userRepository.deleteAll() method
        userRepository.deleteAll();
    }
    //Page1
    @Test
    public void testPage0of3Users(){
        Page<User> page = userRepository.findAll(PageRequest.of(0, 3));
        List<User> users = page.getContent();
        assertThat(users.size()).isEqualTo(3);
        assertThat(users.get(2).getUsername()).isEqualTo("user3");
    }
}
