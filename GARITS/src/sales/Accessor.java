package sales;

public class Accessor implements IISales {
	
	public Jobsheets getJobSheets() {
		return null;
	}
	
	public Invoice getInvoice() {
		return null;
	}
	
	public Profit getProfit() {
		return null;
	}
	
	public JobsheetsCollection getJobsheetsCollection() {
		return null;
	}
	
	public void makePayment() {
		
	}
	
	public boolean addProfit(String name) {
		return false;
	}
	
	public boolean addInvoice() {
		return false;
	}
	
	public boolean addJobSheets(long id, String owner, String make) {
		return false;
	}
}
