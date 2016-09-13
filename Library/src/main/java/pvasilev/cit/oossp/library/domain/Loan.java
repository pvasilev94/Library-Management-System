package pvasilev.cit.oossp.library.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Loan {
	@NotNull
	@Size(min = 2, max = 2)
	private String bookId;

	@NotNull
	@Size(min = 2, max = 2)
	private String memberId;

	@NotNull
	private String loanDate;
	private String returnDate;
	
	public Loan() {
		
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
}
