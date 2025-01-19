# JDBC Demo Project

This project demonstrates how to use JDBC (Java Database Connectivity) to interact with a MySQL database. Below is an explanation of each term and step in the code.

## Steps and Explanation

### 1. Importing Required Packages
```java
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
```
These imports are necessary for using JDBC classes and interfaces.

### 2. Registering the Driver
```java
Driver driver = new com.mysql.cj.jdbc.Driver();
DriverManager.registerDriver(driver);
```
Here, we load and register the MySQL JDBC driver.

### 3. Establishing a Connection
```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
```
We establish a connection to the database using the `DriverManager.getConnection` method. The URL specifies the database location, and the username and password are used for authentication.

### 4. Creating Statements
```java
Statement st1 = conn.createStatement();
Statement st2 = conn.createStatement();
```
We create `Statement` objects to execute SQL queries.

### 5. Executing SQL Queries
```java
int rowInserted = st1.executeUpdate("insert into student values(103,'vivek')");
int rowUpdated = st2.executeUpdate("update student set name='rohit' where id=101");
```
We execute SQL queries using the `executeUpdate` method. This method returns the number of rows affected by the query.

### 6. Handling Results
```java
if(rowInserted > 0) {
    System.out.println("Data inserted into DB");
} else {
    System.out.println("Data not inserted into DB");
}

if(rowUpdated > 0) {
    System.out.println("Data Updated");
} else {
    System.out.println("Data not Updated");
}
```
We check the result of the SQL operations and print appropriate messages.

### 7. Closing the Connection
```java
conn.close();
```
We close the database connection to free up resources.

### 8. Exception Handling
```java
catch(SQLException e) {
    e.printStackTrace();
}
```
We catch and print any `SQLException` that occurs during the database operations.

## Full Code
```java
package com.jsp.jdbc.JDBC_Demo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

    public static void main(String[] args) {

        try {

            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");

            Statement st1 = conn.createStatement();
            Statement st2 = conn.createStatement(); 

            int rowInserted = st1.executeUpdate("insert into student values(103,'vivek')");
            int rowUpdated = st2.executeUpdate("update student set name='rohit' where id=101");

            if(rowInserted > 0) {
                System.out.println("Data inserted into DB");
            } else {
                System.out.println("Data not inserted into DB");
            }

            if(rowUpdated > 0) {
                System.out.println("Data Updated");
            } else {
                System.out.println("Data not Updated");
            }
            conn.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
