package sales;

public class InvoiceCollection {
	private int index;
	
	public InvoiceCollection() {
		
	}
	
	public void addSales(long invoiceNumber, String make, String mode, double vat, Invoice invoice) {
		
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public boolean removeSale(long id) {
		return false;
	}
	
	public Invoice getNextSale() {
		return null;
	}
}
