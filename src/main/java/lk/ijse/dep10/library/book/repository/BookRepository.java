package lk.ijse.dep10.library.book.repository;

import lk.ijse.dep10.library.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    // SELECT * FROM books WHERE isbn LIKE q1 OR title LIKE q2 OR author LIKE q3
    List<Book> findBooksByIsbnLikeOrTitleLikeOrAuthorLike(String q1, String q2, String q3);

//    @Query("SELECT b FROM Book b WHERE b.isbn LIKE :query OR b.title LIKE :query OR b.author LIKE :query")
//    List<Book> findBooksByQuery(String query);
}
