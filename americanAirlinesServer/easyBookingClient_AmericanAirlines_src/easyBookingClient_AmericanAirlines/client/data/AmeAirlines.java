package easyBookingClient_AmericanAirlines.client.data;

public class AmeAirlines {
	private String concepto;
	private double pay;
	
	public AmeAirlines(String concepto, Double pay) {
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
