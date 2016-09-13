package pvasilev.cit.oossp.library.controller;

import pvasilev.cit.oossp.library.domain.Book;
import pvasilev.cit.oossp.library.domain.Loan;
import pvasilev.cit.oossp.library.domain.Member;
import pvasilev.cit.oossp.library.service.LibraryService;
import pvasilev.cit.oossp.library.service.SpringContextBridgeImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 30/08/2016.
 */
public class DataBean {
    private String memberId;
    private String amount;
    private LibraryService libraryService = SpringContextBridgeImpl.services().getService();
    private List<Book> bookList;
    private List<Member> memberList;
    private List<Loan> loanList;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public List<Book> getBookList() {
        bookList = libraryService.findAllBooks();
        loanList = libraryService.findAllLoan();
        for (Book book : bookList) {
            for (Loan loan : loanList) {
                if (loan.getBookId().equals(book.getBookId())) {
                    book.setStatus(false);
                    break;
                }
                else{
                    book.setStatus(true);

                }
            }
        }
        return bookList;
    }
    public List<Member> getMemberList() {
        memberList = libraryService.findAllMembers();
        return memberList;
    }
    public List<Loan> getLoanList() {
        loanList = libraryService.findAllLoan();
        return loanList;
    }
    public List<Member> getMemberListWithFines(){
        memberList = libraryService.findAllMembersWithFine();
        return memberList;
    }
    public boolean loanBook(Loan loan) {
        boolean status = false;
        for (Member member : getMemberList()) {
            if (loan.getMemberId().equals(member.getMemberId())) {
                int fine = Integer.parseInt(member.getFines());
                if (fine == 0) {
                    if (Integer.parseInt(member.getLimit()) > 0) {
                        String todayDate = simpleDateFormat.format(new Date());
                        loan.setLoanDate(todayDate);
                        libraryService.add(loan);
                        status = true;
                    }
                }
            }
        }
        return status;
    }
    public List<Loan> getOverdueList(){
        loanList = libraryService.findAllLoan();
        List<Loan> removeList = new ArrayList<>();
        String today = simpleDateFormat.format(new Date());

        for (Loan loan : loanList) {
            if ((getDayCount(loan.getLoanDate(), today)) <  14) {
                System.out.print(loan.toString());
                removeList.add(loan);
            }
            else
            {
                int days =(getDayCount(loan.getLoanDate(), today)) - 14;
                double fine = days * 0.25;
                //libraryService.getFined(fine);
            }
        }
        loanList.removeAll(removeList);
        return loanList;
    }
    public List<Book> getBookByTitle(String title ) {
        bookList = libraryService.findByTitle(title);
        return bookList;
    }
    /**
     *  http://stackoverflow.com/questions/7103064/java-calculate-the-number-of-days-between-two-dates
     */
    public static int getDayCount(String start, String end) {
        long diff = -1;
        try {
            Date dateStart = simpleDateFormat.parse(start);
            Date dateEnd = simpleDateFormat.parse(end);

            //time is always 00:00:00 so rounding should help to ignore the missing hour when going from winter to summer time as well as the extra hour in the other direction
            diff = Math.round((dateEnd.getTime() - dateStart.getTime()) / (double) 86400000);
        } catch (Exception e) {
            //handle the exception according to your own situation
        }
        int number = (int) diff;
        return number;
    }
}
