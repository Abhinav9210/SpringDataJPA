package sdj;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sdj.entity.Student;
import sdj.repository.StudentRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainApplicationTests {
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void testCrud(){
		//create
		Student student = new Student("Alisa Simmons", "2022AN50123");
		Student returnedStudent = studentRepository.save(student);
		assertThat(returnedStudent.getId()).isNotNull();
		//update
		returnedStudent.setName("Alissa Simmons");
		Student updatedStudent = studentRepository.save(returnedStudent);
		assertThat(updatedStudent.getName()).isEqualTo("Alissa Simmons");
		//read
		Student readStudent = studentRepository.findById(updatedStudent.getId()).get();
		assertThat(updatedStudent.getId()).isEqualTo(readStudent.getId());
		//delete
		studentRepository.deleteById(updatedStudent.getId());
		assertThat(studentRepository.findById(readStudent.getId()).isPresent()).isFalse();
	}

	@Test
	public void testFindByEnrollmentId(){
		Student foundStudent = studentRepository.findByEnrollmentId("2022AN50125");
		assertThat(foundStudent.getEnrollmentId()).isEqualTo("2022AN50125");
	}
	@Test
	public void testfindByEnrollmentIdStartingWithAndNameLike(){
		List<Student> foundStudents = studentRepository.findByEnrollmentIdStartingWithAndNameLike("2022AN501", "%Smith%");
		assertThat(foundStudents.size()).isEqualTo(1);
		System.out.println("Found student: " + foundStudents.get(0));
	}
	@Test
	public void testfindFirst2ByEnrollmentIdStartingWithAndNameLike(){
		List<Student> foundStudents = studentRepository.findFirst2ByEnrollmentIdStartingWithAndNameLike("2022AN501", "%o%");
		assertThat(foundStudents.size()).isEqualTo(2);
		System.out.println("Found students: " + foundStudents);
	}
	@Test
	public void testfindByNameEndingWith(){
		List<Student> foundStudents = studentRepository.findByNameEndingWith("son");
		assertThat(foundStudents.size()).isEqualTo(1);
		System.out.println("Found students: " + foundStudents);
	}
	@BeforeAll
	public void setup(){
		//add dummy students using studentRepository.save() method
		studentRepository.save(new Student("John Doe", "2022AN50124"));
		studentRepository.save(new Student("Jane Smith", "2022AN50125"));
		studentRepository.save(new Student("Bob Johnson", "2022AN50126"));

	}
	@AfterAll
	public void cleanup(){
		//delete all students using studentRepository.deleteAll() method
		studentRepository.deleteAll();
	}


}
