package sales;

public class Profit {
	private long expenses;
	private long revenue;
	private long profits;

	public Profit(long revenue, long expenses) {
		this.revenue = revenue;
		this.expenses = expenses;
	}

	public long getExpenses() {
		return expenses;
	}

	public void setExpenses(long expenses) {
		this.expenses = expenses;
	}

	public long getRevenue() {
		return revenue;
	}

	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}

	public long getProfits() {
		return profits;
	}

	public void setProfits(long profits) {
		this.profits = profits;
	}

}
