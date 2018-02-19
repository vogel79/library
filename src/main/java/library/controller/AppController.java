package library.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import library.model.Book;
import library.service.BookService;


@Controller
@RequestMapping("/")
@ComponentScan("library") 
public class AppController {
	
    @Autowired
    BookService service;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing books.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listBooks(@PathVariable int book_id, ModelMap model) {
        Book book = service.findBook(book_id);
        model.addAttribute("books", book);
        return "allbooks";
    }
 
    /*
     * This method will provide the medium to add a new book.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newBook(ModelMap model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving book in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String createBook(@Valid Book book, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "registration";
        }
        service.createBook(book);
        return "redirect:/list";
    }
 
    /*
     * This method will provide the medium to update an existing book.
     */
    @RequestMapping(value = { "/edit-{book_id}-book" }, method = RequestMethod.GET)
    public String editBook(@PathVariable int book_id, ModelMap model) {
        Book book = service.findBook(book_id);
        model.addAttribute("book", book);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating book in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{book_id}-book" }, method = RequestMethod.POST)
    public String updateBook(@Valid Book book, BindingResult result,
            ModelMap model, @PathVariable int book_id) {
        if (result.hasErrors()) {
           return "registration";
        }
        service.updateBook(book);
        return "redirect:/list";
    }
 
    /*
     * This method will delete an book by it's book_id value.
     */
    @RequestMapping(value = { "/delete-{book_id}-book" }, method = RequestMethod.GET)
    public String deleteBook(@PathVariable int book_id) {
        service.deleteBook(book_id);
        return "redirect:/list";
    }
}

