/*Mike Rozier*/
import java.util.LinkedList;
import java.util.List;

public class TransactionQueue{
	//Instance variable
	private List<Transaction> TQueue = new LinkedList<Transaction>();
	
	//Operations
	public void enqueue(Transaction entry){
		this.TQueue.add(entry);
	}
	
	public Transaction dequeue(){
		return this.TQueue.remove(0);
	}
	
	public int queueLength(){
		return this.TQueue.size();
	}
	
	//Getter
	public List<Transaction> getTQueue(){
		return this.TQueue;
	}
}