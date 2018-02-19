package library.dao;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import library.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book findBook(int book_id) {
        return jdbcTemplate.queryForObject("select title, author, year from books where book_id = ?",
            (ResultSet rs, int rowNum) -> {
                Book book = new Book();
                book.setBook_id(book_id);
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setYear(rs.getInt("year"));
                return book;
            }, book_id);
    }

    @Override
    public void createBook(Book book) {
        jdbcTemplate.update("insert into books(title,author,year) values(?,?,?)",
            book.getTitle(), book.getAuthor(), book.getYear());
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update("update books set title = ?, author = ?, year = ? where book_id = ?",
            book.getTitle(), book.getAuthor(), book.getYear(), book.getBook_id());
    }

    @Override
    public void deleteBook(int book_id) {
        jdbcTemplate.update("delete from books where book_id = ?", book_id);
    }
}
