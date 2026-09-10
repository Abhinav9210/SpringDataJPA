package sdj;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        userRepository.save(new User("user1", "John", "Brown", LocalDate.of(2022, 1, 1), "user1@example.com", 1, true));
        userRepository.save(new User("user2", "Jane", "Smith", LocalDate.of(2022, 2, 1), "user2@example.com", 2, false));
        userRepository.save(new User("user3", "Bob", "Johnson", LocalDate.of(2022, 3, 1), "user3@example.com", 3, true));
        userRepository.save(new User("user4", "Alice", "Williams", LocalDate.of(2022, 4, 1), "user4@example.com", 4, false));
        userRepository.save(new User("user5", "Charlie", "Brown", LocalDate.of(2022, 5, 1), "user5@example.com", 2, true));
        userRepository.save(new User("user6", "David", "Davis", LocalDate.of(2022, 6, 1), "user6@example.com", 6, false));
        userRepository.save(new User("user7", "Eve", "Miller", LocalDate.of(2022, 7, 1), "user7@example.com", 7, true));
        userRepository.save(new User("user8", "Frank", "Wilson", LocalDate.of(2022, 8, 1), "user8@example.com", 8, false));
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
    //Query BY Example
    @Test
    public void testQueryByExample1(){
        User user = new User();
        user.setLastname("Smith");
        user.setLevel(2);

        Example example = Example.of(user);
        List<User> users = userRepository.findAll(example);
        System.out.println("Found users: " + users);
//        assertThat(users.size()).isEqualTo(1);

    }
    @Test
    public void testQueryByExample2() {
        User user = new User();
        user.setLastname("Smith");
//        user.setLevel(2);

        Example example = Example.of(user);
        List<User> users = userRepository.findAll(example);
        System.out.println("Found users: " + users);

    }
    @Test
    public void testQueryByExample3() {
        User user=new User();
        user.setLastname("Brown");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("level");
        Example example = Example.of(user, matcher);
        List<User> users = userRepository.findAll(example);
        System.out.println("Found users: " + users);
    }
    @Test
    public void testQueryByExample4() {
        User user=new User();
        user.setFirstname("j");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("level")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();
        Example example = Example.of(user, matcher);
        List<User> users = userRepository.findAll(example);
        System.out.println("Found users: " + users);
    }
    @Test
    public void testQueryByExample5() {
        User user = new User();
        user.setFirstname("j");
        user.setLastname("wn");

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withIgnorePaths("level")
                .withMatcher("firstname",(match)->match.startsWith())
                .withMatcher("lastname",(match)->match.endsWith())
                .withIgnoreCase();
        List<User> users = userRepository.findAll(Example.of(user, matcher));
        System.out.println("Found users: " + users);
    }
}
