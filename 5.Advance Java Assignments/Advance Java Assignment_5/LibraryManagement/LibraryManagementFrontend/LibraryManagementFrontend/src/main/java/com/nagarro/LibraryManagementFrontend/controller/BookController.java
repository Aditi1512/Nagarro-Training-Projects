package com.nagarro.LibraryManagementFrontend.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.LibraryManagementFrontend.model.Book;
import com.nagarro.LibraryManagementFrontend.service.AuthorService;
import com.nagarro.LibraryManagementFrontend.service.BookService;

/**
 * This Book Controller class handle all request for a web applications.
 *
 */
@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	/**
	 * this method is use to open add book page
	 * 
	 * @return add book page
	 */
	@RequestMapping("addBook")
	public String showAddBookPage() {
		return "addBook";
	}

	/**
	 * this method is use to open edit page
	 * 
	 * @return edit book page
	 */
	@RequestMapping("editBook")
	public String showEditBookPage() {
		return "editBook";
	}

	/**
	 * this method is use to open show book page
	 * 
	 * @return show book page
	 */
	@RequestMapping("showBooks")
	public String showBooksPage() {
		return "showBooks";
	}

	/**
	 * this method add new book to library.
	 * 
	 * @param book  - object of book.
	 * @param model - this model contain book object data.
	 * @return
	 */
	@RequestMapping(value = "add_book", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {

		bookService.addBook(book);

		return "redirect:/show_books";
	}

	/**
	 * this method use to handle edit book request and redirects to edit book page
	 * to edit book details of provided book code.
	 * 
	 * @param bookCode - book code of the book which need to be edited.
	 * @return - redirect to edit book page.
	 */
	@RequestMapping("/edit_book/{code}")
	public String handleEditBook(@PathVariable("code") long bookCode, HttpSession session) {

		Book book = bookService.getBook(bookCode);
		session.setAttribute("book", book);
		session.setAttribute("bookCode", bookCode);
		session.setAttribute("date", book.getDate());
		return "redirect:/editBook";
	}

	/**
	 * this method use to edit the book details of the provided book.
	 * 
	 * @param bookCode - book code of the book which is edited
	 * @param name     - name of the book which is edited
	 * @param author   - author name which is edited
	 * @return details of edited book
	 */
	@RequestMapping("/edit_Book/{code}")
	public String editBook(@PathVariable("code") long bookCode, @RequestParam("name") String name,
			@RequestParam("author") String author) {

		Book book = bookService.getBook(bookCode);
		book.setAuthor(author);
		book.setName(name);
		bookService.editBook(book);
		return "redirect:/show_books";
	}

	/**
	 * this method is use to display the details of the book
	 * 
	 * @param model   - this model contains book data
	 * @param session - current session
	 * @return - details of the book to be displayed
	 */
	@RequestMapping("/show_books")
	public String showBooks(Model model, HttpSession session) {

		List<Book> books = this.bookService.getBooks();
		model.addAttribute("books", books);
		session.setAttribute("books", books);

		return "redirect:/showBooks";
	}

	/**
	 * this method use to delete the book of provided book code and use to display
	 * remaining books.
	 * 
	 * @param bookCode - code of the book which is to deleted
	 * @return - delete the book and display the remaining book.
	 */
	@RequestMapping("/deleteBook/{code}")
	public String deleteBook(@PathVariable("code") long bookCode) {

		bookService.deleteBook(bookCode);
		return "redirect:/show_books";
	}

}