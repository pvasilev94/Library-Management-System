package pvasilev.cit.oossp.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pvasilev.cit.oossp.library.domain.Book;
import pvasilev.cit.oossp.library.domain.Loan;
import pvasilev.cit.oossp.library.service.LibraryService;

import java.util.List;
import java.util.Locale;

/**
 * Created by Pavel on 30/08/2016.
 */
@Controller
public class ViewController {
    @Autowired
    LibraryService service;


    @RequestMapping(value={"/", "/home"}, method= RequestMethod.GET)
    public String home(Model model, Locale locale) {
        List<Book> list = this.service.findAllBooks();
        model.addAttribute("books", list);
        return "home";
    }
    @RequestMapping(value="/books", method=RequestMethod.GET)
    public String books(@ModelAttribute DataBean dataBean, Model model, Locale locale) {
        return "books";
    }
    @RequestMapping
            (value="/members", method=RequestMethod.GET)
    public String members(@ModelAttribute DataBean dataBean, Model model, Locale locale) {
        return "members";
    }
    @RequestMapping
            (value="/members/{memberId}", method=RequestMethod.POST)
    public String membersId(@ModelAttribute DataBean dataBean, Model model, Locale locale, @PathVariable("memberId") String memberId) {
        return "members";
    }
    @RequestMapping
            (value="/members/fines", method=RequestMethod.GET)
    public String membersFines(@ModelAttribute DataBean dataBean, Model model, Locale locale) {
        return "reportFines";
    }
    @RequestMapping
            (value="/members/payfine", method=RequestMethod.POST)
    public String payFine(@ModelAttribute DataBean dataBean, Model model, Locale locale) {
        return "payFine";
    }
    @RequestMapping
            (value="/loan/overdue", method=RequestMethod.GET)
    public String overdueLoans(@ModelAttribute DataBean dataBean, Model model, Locale locale) {
        return "reportOverdue";
    }
    @RequestMapping(value="/books/title", method=RequestMethod.GET)
    public String booksByTitleGET(@ModelAttribute Book book, Model model, Locale locale) {
        return "search";
    }
    @RequestMapping(value="/books/title", method=RequestMethod.POST)
    public String booksByTitlePOST(@ModelAttribute Book book, Model model, Locale locale) {
        return "books";
    }
    @RequestMapping(value ="/loan", method = RequestMethod.GET)
    public String listLoan(Model model) {
        model.addAttribute("loan", new Loan());
        return "loan";
    }
    @RequestMapping(value ="/loans", method = RequestMethod.GET)
    public String loanForm(@ModelAttribute DataBean databean, Model model) {
        return "listLoan";
    }
    @RequestMapping(value="/loan", method = RequestMethod.POST)
    public String loanSubmit(@ModelAttribute Loan received) {
        DataBean dataBean = new DataBean();
        Loan loan = new Loan();
        loan.setBookId(received.getBookId());
        loan.setMemberId(received.getMemberId());
        if (dataBean.loanBook(loan)) {
            return "redirect:/home";
        }
        return null;
    }
//    @RequestMapping
//            (value="/loan")
//    public String loanAdd(@ModelAttribute DataBean dataBean,@PathVariable{"bookId"} String bookId, Model model, Locale locale) {
//        return "loan";
//    }
}
