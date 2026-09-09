package sdj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sdj.entity.Student;
import sdj.repository.StudentRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
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


}
