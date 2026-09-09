package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdj.entity.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    //Is,Equals
    User findByUsername(String username);
    User findByUsernameIs(String username);
    User findByUsernameEquals(String username);

    //OrderBy
    List<User> findAllByOrderByRegistrationDate();
    //finding all the users by their registration date and order the result by their username
    List<User> findByRegistrationDateOrderByUsername(LocalDate registrationDate);

    //find all the users registered between a certain period
    List<User> findByRegistrationDateBetween(LocalDate start, LocalDate end);
    //find all the users registered before a certain date
    List<User> findByRegistrationDateBefore(LocalDate date);
    //find all the users registered after a certain date
    List<User> findByRegistrationDateAfter(LocalDate date);

    //In, NotIn
    List<User> findByLevelIn(Collection<Integer> levels);
    List<User> findByLevelNotIn(Collection<Integer> levels);

    //less than, less than or equal, greater than, greater than or equal
    List<User> findByLevelLessThan(Integer level);
    List<User> findByLevelLessThanEqual(Integer level);
    List<User> findByLevelGreaterThan(Integer level);
    List<User> findByLevelGreaterThanEqual(Integer level);

    //starting with, ending with, containing, like, not like
    List<User> findByUsernameStartingWith(String prefix);
    List<User> findByUsernameEndingWith(String suffix);
    List<User> findByUsernameContaining(String infix);
    List<User> findByUsernameLike(String pattern);
    List<User> findByUsernameNotLike(String pattern);

    //Ignore case
    List<User> findByUsernameIgnoreCase(String username);

    //Null, NotNull
    List<User> findByEmailIsNull();
    List<User> findByEmailNull();
    List<User> findByEmailIsNotNull();
    List<User> findByEmailNotNull();

    //IsNot, IsEmpty, IsNotEmpty, IsBlank, IsNotBlank
    List<User> findByLevelIsNot(Integer level);
    List<User> findByLevelNot(Integer level);
    List<User> findByEmailIsEmpty();
    List<User> findByEmailEmpty();
    List<User> findByEmailIsNotEmpty();
    List<User> findByEmailNotEmpty();
    List<User> findByEmailIsBlank();
    List<User> findByEmailBlank();
    List<User> findByEmailIsNotBlank();
    List<User> findByEmailNotBlank();

    //True, False
    List<User> findByIsActiveTrue();
    List<User> findByIsActiveIsTrue();
    List<User> findByIsActiveFalse();
    List<User> findByIsActiveIsFalse();

    //And, Or
    List<User> findByUsernameAndLevel(String username, Integer level);
    List<User> findByUsernameOrLevel(String username, Integer level);
    //Distinct
    List<User> findDistinctByLevel(Integer level);





}
