package library;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import library.model.Book;
import library.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration("classpath:/spring-beans.xml")
public class BookServiceIntegrationTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void CreateNewBook() {
        Book book = new Book();
        book.setTitle("За голубым порогом");
        book.setAuthor("Ольга Хлудова");
        book.setYear(1963);

        int countBeforeInsert = jdbcTemplate.queryForObject("select count(*) from books", Integer.class);
        Assert.assertEquals(4, countBeforeInsert);

        bookService.createBook(book);

        int countAfterInsert = jdbcTemplate.queryForObject("select count(*) from books", Integer.class);
        Assert.assertEquals(5, countAfterInsert);
    }

 /*  @Test
    public void DeleteNewBook() {
        int countBeforeDelete = jdbcTemplate.queryForObject("select count(*) from books", Integer.class);
        Assert.assertEquals(5, countBeforeDelete);

        bookService.deleteBook(50);

        int countAfterDelete = jdbcTemplate.queryForObject("select count(*) from books", Integer.class);
        Assert.assertEquals(5, countAfterDelete);
    }*/

    @Test
    public void FindBooks() {
        Book book = bookService.findBook(48);
        Assert.assertNotNull(book);
        Assert.assertEquals("Волны над нами", book.getTitle());
        Assert.assertEquals("Ольга Хлудова", book.getAuthor());
        Assert.assertEquals(1960, book.getYear());
    }
}
