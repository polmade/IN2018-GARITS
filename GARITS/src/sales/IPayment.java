package sales;

interface IPayment {

	long addPayment();

	String getTypeOfPayment();

	void setTypeOfPayment(String typeOfPayment);

	String getDateOfPayment();

	void setDateOfPayment(String dateOfPayment);

}
