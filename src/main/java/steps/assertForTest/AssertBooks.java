package steps.assertForTest;

import entity.AuthorTable;
import entity.BookTable;
import io.restassured.response.ValidatableResponse;
import repository.AuthorRepository;
import repository.BookRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;


public class AssertBooks {
    static BookRepository bookRepository = new BookRepository();
    static AuthorRepository authorRepository = new AuthorRepository();

    public static void verifyBodyGetBooks(ValidatableResponse allBooks, long id, String bookTitle) {
        LocalDate lc = LocalDate.now(ZoneId.of("UTC"));
        allBooks.assertThat()
                .body("find{it.bookTitle=='" + bookTitle + "'}.bookTitle", equalTo(bookTitle))
                .body("author.find{it.id==" + id + "}.id", equalTo((int) id));
        assertNotNull(allBooks.extract().jsonPath().getString("updated"));
        assertTrue(allBooks.extract().jsonPath().getString("updated").contains(lc.toString()));

        List<BookTable> bookList = bookRepository.findBookByTitle(bookTitle);
        assertEquals(bookTitle, bookList.get(0).getBookTitle());
    }

    public static void bookSaveVerification(String bookTitle) {
        bookRepository.findBookByTitle(bookTitle);
    }

    public static void validateBookTitlesAndAuthor(long id, String bookTitle, String first_name) {
        List<BookTable> listOfBooks = bookRepository.findBookByAuthorId(id);
        System.out.println(listOfBooks);
        assertEquals(listOfBooks.get(0).getBookTitle(), bookTitle);
        List<AuthorTable> authorList = authorRepository.findAuthorById(id);
        assertEquals(first_name, authorList.get(0).getFirstName());
    }


}
