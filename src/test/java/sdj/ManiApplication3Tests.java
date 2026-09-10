package sdj;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sdj.entity.Book;
import sdj.repository.BookRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ManiApplication3Tests {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void testAuditing(){
        Book book = new Book();
        book.setTitle("Spring Data JPA");
        book.setIsbn("1234567890");
        Book savedBook = bookRepository.save(book);
        System.out.println("Saved Book: " + savedBook);
        savedBook.setTitle("Spring Data JPA - Updated");
        Book updatedBook = bookRepository.save(savedBook);
        System.out.println("Updated Book: " + updatedBook);
    }
}
