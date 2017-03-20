#Mike Rozier
class Account:
	'Class to hold accounts'
	def __init__(self, acc):
		'Initializer for Account class'
		self.accountNumber = acc
		self.transactionList = []
		self.balance = 0.0
	
	def __str__(self):
		'String representation for an instance of Account'
		return '{0:<20} {1:<20} \n{2:<20} ${3:<20.2f}'.format("Account#: ", self.accountNumber, "Balance (USD): ", self.balance)

	def __len__(self):
		'Returns the length of the transaction list'
		return len(self.transactionList)

	def __getitem__(self, index):
		'Returns a transaction at the given index'
		return self.transactionList[index]
		
	def getBalance(self):
		'Returns the account balance'
		return self.balance
		
	def apply(self, transaction):
		'Adds a transaction to the transaction list and updates the balance'
		self.transactionList.append(transaction)
		self.balance += transaction.getUSD()
		
	def addTransactions(self, tqueue):
		'Takes in a TransactionQueue and calls apply() for all transactions in the queue'
		while tqueue.queueLength() > 0:
			self.apply(tqueue.dequeue())
		
	def __iter__(self):
		'Initializes iteration'
		self.index = 0
		return self
		
	def __next__(self):
		'Returns a value for the current iteration'
		#Error checking
		if len(self) == 0:
			print("Error! Transaction list empty.")
			raise StopIteration
		
		if self.index >= len(self):
			raise StopIteration
			
		transaction = self.transactionList[self.index]
		self.index += 1
		
		return transaction
