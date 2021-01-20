package easyBookingClient_PayPal.client.data;

public class PayPal {
	private String concepto;
	private double pay;
	
	public PayPal(String concepto, Double pay) {
		super();
		this.concepto = concepto;
		this.pay = pay;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	
	
}
