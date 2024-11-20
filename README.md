# jdbc-PreStatementTask

1. Import necessary packages (java.sql and java.util).

2. Define database connection parameters (URL, username, password).

3. Create a Scanner object to read user input.

4. Prompt user to enter data (SalesID, Product, Amount).

5. Establish database connection using DriverManager.

6. Prepare an INSERT query using PreparedStatement.

7. Set query parameters using p.setInt(), p.setString(), etc.

8. Execute the query using s.executeUpdate().

9. Close database connection.
