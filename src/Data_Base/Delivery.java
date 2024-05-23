package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delivery implements Table_Management{
	
	// attributes
	int delivery_id;
	int delivery_destination_id;
	public int purchase_id;
	
	
	
	
	// constructor
	public Delivery(int delivery_destination_id) {
		
		
		this.delivery_destination_id = delivery_destination_id ;
		
	}
	
	
	
	
	
		
    // method modify
	public void modify() {};
		
		
	// method delete
	public void delete() {};
		
		
	// method to check the existance of a delivery
	public boolean check_existance(int parameter_number) {return true ;};
		
		
	// abstarct method to get an element attributes
	public Object [] get_informations() {return new Object[2];};
	
	
	
	
	
	
	// -------------------------------------------------------------
	
	

	// method add to insert a new delivery
	public void add() {
		
		
		// establish a connection to the database server
		Connection connection = Database_Connector.getConnection();

		try {
			
			// the insertion statement for the table client
	        String insert_query = "INSERT INTO livraison (numerodestination,numerocommande) VALUES (?,?)";
		    
	        // prepare the insertion query for execution
		    PreparedStatement prepared_insertion = connection.prepareStatement(insert_query);
		    
		    // Set parameter values
		    prepared_insertion.setInt(1, delivery_destination_id);
		    prepared_insertion.setInt(2, purchase_id);
		    
		
		    // Execute the the prepared insertion
		    prepared_insertion.executeUpdate();
		}
		
		catch(SQLException e) {
            e.printStackTrace(); 
        
		}
	   
		finally {
        
			try { if (connection != null) connection.close();}
            catch (SQLException e) {e.printStackTrace();}}

	};
	
	
	
	
	
	
	
	
	// -----------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
