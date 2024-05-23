package Data_Base;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.time.LocalDate;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Purchase {
	
	
	// attributes
	int purchase_id ;
	LocalDate purchase_date ;
	LocalTime purchase_time;
	String purchase_state ;
	int client_id ;
	
	
	// constructor
	public Purchase(LocalDate purchase_date,LocalTime purchase_time,int client_id) {
		
		this.purchase_date = purchase_date ;
		this.purchase_time = purchase_time ;
		this.client_id = client_id ;
		
		
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
	
	

	// method add to insert a new purchase
	public void add() {
		
		
		// establish a connection to the database server
		Connection connection = Database_Connector.getConnection();

		try {
			
			// the insertion statement for the table client
	        String insert_query = "INSERT INTO commande (date_commande,temps_commande,numeroclient) VALUES (?,?,?)";
		    
	        // prepare the insertion query for execution
		    PreparedStatement prepared_insertion = connection.prepareStatement(insert_query);
		    
		    
            
            // Set the parameter value
            prepared_insertion.setDate(1, Date.valueOf(purchase_date));
            prepared_insertion.setTime(2, Time.valueOf(purchase_time));
		    prepared_insertion.setInt(3, client_id);
		    
		
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
	
	
	
	
	
	// -------------------------------------------------------------------------
	

	// method to get purchase id from DB - 
	public int get_purchase_id() {
        int id = -1;
        Connection connection = null;
        PreparedStatement prepared_selection = null;
        ResultSet resultSet = null;
        
        try {
            // Establish a connection with the database server
            connection = Database_Connector.getConnection();
            
            // The select statement
            String select_query = "SELECT numerocommande FROM commande "
            		               + "WHERE date_commande = ? and temps_commande = ? and numeroclient = ?";
            
            // Prepare the selection query
            prepared_selection = connection.prepareStatement(select_query);
            
            
            // Set the parameter value
            prepared_selection.setDate(1, Date.valueOf(purchase_date));
            prepared_selection.setTime(2, Time.valueOf(purchase_time));
            prepared_selection.setInt(3, client_id);
            
            // Execute selection query
            resultSet = prepared_selection.executeQuery();
            
            if (resultSet.next()) {
                id = resultSet.getInt("numerocommande");
            }
        
        } catch(SQLException e) {
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
        
        return id;
    }
	

}
