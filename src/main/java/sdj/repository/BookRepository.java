package sdj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdj.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
