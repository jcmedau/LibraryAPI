# LibraryAPI
This repository has an example of a simple API.
The API is a CRUD of Books with endpoints to insert, retrieve, retrieve all, update, and delete Books.
Each Book has an Id and a Title. Both must be unique, although only the Id is the primary key.
It uses a MySQL database. To run JUnit tests, it uses a H2 in memory database.
If the MySQL database does not exist, it creates the database and the table automatically.
