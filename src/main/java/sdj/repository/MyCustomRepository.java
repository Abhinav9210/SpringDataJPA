package sdj.repository;

import org.springframework.data.repository.Repository;
import sdj.entity.Student;

import java.util.List;
import java.util.Optional;

public interface MyCustomRepository extends Repository<Student, Long> {
    Student save(Student student);
    Optional<Student> findById(Long id);
    List<Student> findAll();
}
