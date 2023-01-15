# LibraryAPI
This repository has an example of a simple API.<br>
The API is a CRUD of Books with endpoints to insert, retrieve, retrieve all, update, and delete Books.<br>
Each Book has an Id and a Title. Both must be unique, although only the Id is the primary key.<br>
It uses a MySQL database. To run JUnit tests, it uses a H2 in memory database.<br>
If the MySQL database does not exist, it creates the database and the table automatically.
