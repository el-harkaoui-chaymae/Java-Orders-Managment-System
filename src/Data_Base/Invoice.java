package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Invoice implements Table_Management {
	
	
	// attributes
	int invoice_id;
	double total_cost;
	int purchase_id ;
	
	
	
	// constructor
	public Invoice(double total_cost,int purchase_id) {
		
		this.total_cost = total_cost ;
		this.purchase_id = purchase_id ;
		
	}
	
	
	
	
	
	

    // method modify
	public void modify() {};
		
		
	// method delete
	public void delete() {};
		
		
	// method to check the existance of a delivery
	public boolean check_existance(int parameter_number) {return true ;};
		
		
	// abstarct method to get an element attributes
	public Object [] get_informations() {return new Object[2];};
	
	
	
	
	
	
	// ------------------------------------
	
	
	//  method add to insert a new invoice
	public void add() {
		
		

		// establish a connection to the database server
		Connection connection = Database_Connector.getConnection();

		try {
			
			// the insertion statement for the table client
	        String insert_query = "INSERT INTO facture (montant_total,numerocommande) VALUES (?,?)";
		    
	        // prepare the insertion query for execution
		    PreparedStatement prepared_insertion = connection.prepareStatement(insert_query);
		    
		    // Set parameter values
            prepared_insertion.setDouble(1, total_cost);
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
	
	
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	

}
