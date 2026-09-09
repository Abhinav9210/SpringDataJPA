package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import sdj.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEnrollmentId(String enrollmentId);
    List<Student> findByEnrollmentIdStartingWithAndNameLike(String enrollmentIdPrefix, String namePattern);
    List<Student> findFirst2ByEnrollmentIdStartingWithAndNameLike(String enrollmentIdPrefix, String namePattern);
    @Query(value = "select * from student where name like %?", nativeQuery = true)
    List<Student> findByNameEndingWith(String nameSuffix);
 }
