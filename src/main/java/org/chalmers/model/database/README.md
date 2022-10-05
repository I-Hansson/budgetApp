# How to use the database interface
## UserDB
### 1. Create an instance of the type UsersDB
>       UsersDB db = new UsersDB(1); //The 1 is the uid of the  specific user

### 2. Using the getters
Using the getters is straight forward you can call on them aslong as you haven't opened the file stream
more on this in point 3 about the setters. Eg.
>       db.getUserName();
will return the username of the user read from the already given userID. 

### 3. Using the setters
Using the setters requires you to open a filestream between the java object and the actual file that
contains the data. This is done by calling on the method:
>       db.openSetters();
Now when the filestream is open you can call on any setter and give a valid arguemnt Eg.
>       db.setUserName("Oscar");
Will change the username of the chosen user to Oscar. Now when we have changed the username we HAVE to 
call on the method
>       db.closeSetters();
This so that the filestream closes and the new data will be stored. If not done all data in the file will be lost.

## BudgetPostDB
### 1. Create an instance of the type BudgetPostDB
>       BudgetPostsDB db = new BudgetPostsDB("test");

### 2. Using the getters
Using the getters works just like the getters for the UsersDB

### 3. using the setters
Using the setters follow the same principles as for the UsersDB
