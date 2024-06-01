package Data_Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connector {
	
	// attributes 
	private static Connection connection;
	
	// method to establish the connection
    public static Connection getConnection() {
        
    	try {
            
    		// set the connection details
    		String url = "jdbc:mysql://localhost:3306/vertex_db";
            String user = "Vertex Group";
            String password = "vertex-197";
            
            // establish a network connection to the database server
            connection = DriverManager.getConnection(url, user, password);
            
            // returns a reference to the actual connection established with the database server
            return connection;
        
    	} 
    	
    	catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}


 