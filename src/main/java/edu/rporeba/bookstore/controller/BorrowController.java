package edu.rporeba.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rporeba.bookstore.service.BorrowService;
import edu.rporeba.bookstore.util.BookAlreadyBorrowedException;

@Controller
public class BorrowController {

	@Autowired
	private BorrowService borrowService;

	@RequestMapping(value = "/borrow", method = RequestMethod.POST)
	public String borrowBook(@RequestParam("itemId") Long itemId, @RequestParam("borrowerId") Long borrowerId) {

		try {

			borrowService.borrowBook(itemId, borrowerId);
			return "redirect:books";

		} catch (BookAlreadyBorrowedException e) {

			e.getErrMsg();
			return "exception";

		}
	}

	@RequestMapping(value = "/returnBook", method = RequestMethod.POST)
	public String giveBookBack(@RequestParam("borrowId") Long borrowId, @RequestParam("itemId") Long itemId) {

		borrowService.giveBookBack(borrowId, itemId);

		return "redirect:/";

	}
}
