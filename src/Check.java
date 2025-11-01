import java.sql.*; 

public class Check {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb",
                "root",
                "YOUR_PASSWORD"
            );

            // Create a SQL statement to send to MySQL
            Statement statement = connection.createStatement();

            // Execute SELECT query
            ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM designation"
            );

            // Read and print each row from the result
            while (resultSet.next()) {
                int code = resultSet.getInt("code");
                String title = resultSet.getString("title").trim();
                System.out.println("Code: " + code + " | Title: " + title);
            }

            // Close everything
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
