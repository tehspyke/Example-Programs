/*Mike Rozier*/
public class Transaction{
	//Instance variables
	private int transactionNumber;
	private double amount;
	private String date;
	private String currency = "USD";
	private String description;
	private double conversionRate;
	
	//Constructor
	public Transaction(int tNum, double amt, String date, String curr, double rate, String desc){
		this.transactionNumber = tNum;
		this.amount = amt;
		this.date = date;
		this.currency = curr;
		this.description = desc;
		this.conversionRate = rate;
	}
	
	//Getters
	public int getTransNum(){
		return this.transactionNumber;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getCurrency(){
		return this.currency;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public double getConvRate(){
		return this.conversionRate;
	}
	
	public double getUSD(){
		return (this.amount * this.conversionRate);
	}
}