package lk.ijse.dep10.library.book.api;

import lk.ijse.dep10.library.book.dto.BookDTO;
import lk.ijse.dep10.library.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void saveBook(@RequestBody @Validated BookDTO bookDTO){
        bookService.saveBook(bookDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{isbn}",consumes = "application/json")
    public void updateBook(@PathVariable String isbn, @RequestBody @Validated BookDTO bookDTO){
        bookDTO.setIsbn(isbn);
        bookService.updateBook(bookDTO);
    }

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBook(@PathVariable String isbn){
        bookService.deleteBook(isbn);
    }

    @GetMapping("/{isbn}")
    public BookDTO getBook(@PathVariable String isbn){
        return bookService.getBook(isbn);
    }

    @GetMapping
    public List<BookDTO> findBooks(@RequestParam(name="q", required = false) String query){
        if (query == null) query = "";
        return bookService.findBooks(query);
    }
}
