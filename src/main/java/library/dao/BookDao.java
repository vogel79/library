package library.dao;

import library.model.Book;

public interface BookDao {
    public Book findBook(int book_id);
    public void createBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(int book_id);
}
