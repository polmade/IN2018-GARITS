package sales;

public class PaymentController implements IPayment {
	private int amount;
	private String typeOfPayment;
	private String dateOfPayment;
	private String date;
	
	public long addPayment() {
		return 0;
	}

	public String getTypeOfPayment() {
		return typeOfPayment;
	}

	public void setTypeOfPayment(String typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}

	public String getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
}
