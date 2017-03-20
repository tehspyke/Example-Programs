#Mike Rozier

#Imports
import sys
from py4j.java_gateway import JavaGateway
from Account import Account

accounts = {} #Dictionary for accounts
tqueues = {} #Dictionary for transaction queues
gateway = JavaGateway() #Sets up the gateway

file = open(str(sys.argv[1]), 'r') #Opens a file for reading

#Read in each line from the file
for line in file:
	tokens = line.replace(',','').replace('\n','').split() #Retrieves all tokens after removing delimiters and newlines
	
	if int(tokens[0]) not in tqueues: #If the account number is not in the dictionary...
		tqueues[int(tokens[0])] = gateway.entry_point.newTQ() #Create a new transaction queue to store as the value for the key
	
	#Create and enqueue each transaction
	currentTransaction = gateway.entry_point.newTransaction(int(tokens[1]), float(tokens[2]), tokens[3], tokens[4], float(tokens[5]), tokens[6])
	tqueues[int(tokens[0])].enqueue(currentTransaction)

#Loop over all of the dictionary entries
for accNum in tqueues.keys():
	accounts[accNum] = Account(accNum) #Create a new account with the account number
	accounts[accNum].addTransactions(tqueues[accNum]) #Add all of the transactions associated with the account
	
	#Output
	print("*****************************************************")
	print(accounts[accNum])
	print("*****************************************************")
	counter = 1
	for transaction in accounts[accNum].transactionList:
		print("Transaction #%i" % counter)
		print('{0:<20} {1:<20} {2:<20}'.format("Amount","Date","Description"))
		print('${0:<19.2f} {1:<20} {2:<20}'.format(transaction.getUSD(), transaction.getDate(), transaction.getDescription()))
		counter += 1
		print("")
