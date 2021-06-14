# DNDDB

The goal of this project is to practice using both Java and SQL together

I'm using PostgresSQL and creating a database using the D&D 5E SRD information.

## Tooling
I'm using IntelliJ as my IDE and PGAdmin4 to manage the database.

## Notes 
JDBC driver (java Database Connectivity) is required to allow a connection between the database and the Java application.

This is a Java API also allows SQL statements and queries to be made. The driver can be obtained from the 
[PostgresSQL website](https://jdbc.postgresql.org/download.html).

The downloaded file will be a .jar file that should be compiled with the main program. In IntelliJ, you can automatically 
do this by adding the driver as a dependency for the project. This is done by going into the Modules settings (f4 on the
project in Intellij) and adding it to the dependencies in the Modules tab.