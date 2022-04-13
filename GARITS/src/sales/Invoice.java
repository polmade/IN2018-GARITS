package sales;

public class Invoice {
	private double labourRate;
	private double partsRate;
	private double vat;
	private String address;
	private String make;
	private String model;
	private long registrationNumber;
	private double partsQty;
	private long invoiceNumber;
	private double totalRate;

	public Invoice(long invoiceNumber, double totalRate) {
		this.invoiceNumber = invoiceNumber;
		this.totalRate = totalRate;
	}

	public double getLabourRate() {
		return labourRate;
	}

	public void setLabourRate(double labourRate) {
		this.labourRate = labourRate;
	}

	public double getPartsRate() {
		return partsRate;
	}

	public void setPartsRate(double partsRate) {
		this.partsRate = partsRate;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public double getPartsQty() {
		return partsQty;
	}

	public void setPartsQty(double partsQty) {
		this.partsQty = partsQty;
	}

	public long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public double getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(double totalRate) {
		this.totalRate = totalRate;
	}

}
