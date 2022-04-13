package sales;

interface IISales {

	Jobsheets getJobSheets();

	Invoice getInvoice();

	Profit getProfit();

	JobsheetsCollection getJobsheetsCollection();

	void makePayment();

	boolean addProfit(String name);

	boolean addInvoice();

	boolean addJobSheets(long id, String owner, String make);
}
