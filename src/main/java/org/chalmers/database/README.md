# How to use the database interface
### Author: Oscar Cronvall
## 1. UserDB
### 1.1 Create an instance of the type UsersDB
>       UsersDB db = new UsersDB(1); //The 1 is the uid of the specific user

### 1.2 Create a document for a UserDB
You NEED to create a doucument before initalizing a new UsersDB.
This so that the UsersDB object actually has a corresponding document with it's data.
How to do this?
>       //This create a document for the next uid. This does not create an instance of a UsersDB (for that read 1.)
>       UsersDB.createUserDoc(name, password, balance, standardBalance);
Good to know: This command will also create a document for the TransactionDB to interact with.
### 1.3 Using the getters
Using the getters is straight forward you can call on them aslong as you haven't opened the file stream
more on this in point 3 about the setters. Eg.
>       db.getUserName();
will return the username of the user read from the already given userID. 

### 1.4 Using the setters
Using the setters requires you to open a filestream between the java object and the actual file that
contains the data. This is done by calling on the method:
>       db.openSetters();
Now when the filestream is open you can call on any setter and give a valid arguemnt Eg.
>       db.setUserName("Oscar");
Will change the username of the chosen user to Oscar. Now when we have changed the username we HAVE to 
call on the method
>       db.closeSetters();
This so that the filestream closes and the new data will be stored. If not done all data in the file will be lost.

## 2. TransactionsDB
### 2.1 Create an instance of the type TransactionsDB
>       TransactionsDB db = new TransactionsDB(1); //The 1 is the uid of the specific
 
### 2.2 Add a transaction to the document
Before adding a transaction we need to know that their is a document existing.
If unsure check the database and if you know that the document for this user doesn't exist, call on the method:
>       UsersDB.createUserDoc(name, password, balance, standardBalance);
This will create a document for the TransactionsDB object to interact and a general document for the UsersDB to interact with.
If you want to know more about that read (1.2). </br>
Now that we know a document exists for our user we can create an instance of the TransactionsDB according to (2.1)
and after that call on the metod:
>       TransactionsDB tdb = new TransactionsDB(1);
>       tdb.addTransaction(name, description, amount, date, budgetPostName);
> 
>       //We can also accomplish the same result by calling through the UsersDB object via deligation
> 
>       UsersDB udb = new UsersDB(1);
>       udb.addTransaction(name, description, amount, date, budgetPostName);

### 2.3 Removing a transaction TODO

###2.4 Updating a transaction TODO