package pvasilev.cit.oossp.library.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Member {
	@NotNull
	private String memberId;

	@NotNull
	private String name;
	private String adress;
	private String DOB;

	@NotNull
	@Size(min = 2, max = 4)
	private String limit;
	private String loan_lenght; // in seconds
	private String fines;
	public Member() {
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getLoan_lenght() {
		return loan_lenght;
	}

	public void setLoan_lenght(String loan_lenght) {
		this.loan_lenght = loan_lenght;
	}

	public String getFines() {
		return fines;
	}

	public void setFines(String fines) {
		this.fines = fines;
	}
}
