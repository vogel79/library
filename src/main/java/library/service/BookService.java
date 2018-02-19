package library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.dao.BookDao;
import library.model.Book;

@Service
@Transactional
public class BookService {
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book findBook(int book_id) {
        return bookDao.findBook(book_id);
    }

    public void createBook(Book book) {
        bookDao.createBook(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public void deleteBook(int book_id) {
        bookDao.deleteBook(book_id);
    }
}