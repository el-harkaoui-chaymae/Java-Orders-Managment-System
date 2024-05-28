package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
		
	
	
	
	
	
	
	// --------------------------------------------------------------------
	
	
	
	
	// method modify
	public void modify() {};
			
			
	// method delete
	public void delete() {};
			
			
	// method to check the existance of a delivery
	public boolean check_existance(int parameter_number) {return true ;};
			
			
	// method to get an element attributes
	public Object [] get_informations() {return new Object[2];};
		
		
		
	
	
	// ---------------------------------------------
	
	
	
	// method to get a specific invoice total cost
	public double get_total_cost() {
		
		double total_cost = 0 ;
		
		
		Connection connection = null;
        PreparedStatement prepared_selection = null;
        ResultSet resultSet = null;
        
        
        
        try {
            // establish a connection with the database server
            connection = Database_Connector.getConnection();
            
            // the select statement
            String select_query = "SELECT montant_total FROM facture WHERE numerocommande = ?" ;
            		
            
            // prepare the selection query
            prepared_selection = connection.prepareStatement(select_query);
            
            // set parameter value
            prepared_selection.setInt(1, purchase_id);
             
            // execute selection query
            resultSet = prepared_selection.executeQuery();
            
            // Iterate through the ResultSet 
            if (resultSet.next()) {
            	
            	total_cost = resultSet.getDouble("montant_total"); }
       
        
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return total_cost ;
		
	}
	
	
	
	
	
	
	
	
	

}
