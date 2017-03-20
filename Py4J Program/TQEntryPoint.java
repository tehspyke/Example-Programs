/*Mike Rozier*/
import py4j.GatewayServer;

public class TQEntryPoint{
	//Allows for creation of a new queue through the entry point
	public TransactionQueue newTQ(){
		return new TransactionQueue();
	}
	
	//Allows for creation of a new transaction through the entry point
	public Transaction newTransaction(int tNum, double amt, String date, String curr, double rate, String desc){
		return new Transaction(tNum, amt, date, curr, rate, desc);
	}
	
	//Main method that runs the server
	public static void main(String[] args){
		//Start the gateway server
		GatewayServer gatewayServer = new GatewayServer(new TQEntryPoint());
        gatewayServer.start();
        System.out.println("Gateway Server Started");
	}
}
