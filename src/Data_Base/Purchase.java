package Data_Base;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;

public class Purchase {
	
	
	// attributes
	int purchase_id ;
	LocalDate purchase_date ;
	LocalTime purchase_time;
	public String purchase_state ;
	int client_id ;
	
	
	// constructor
	public Purchase(LocalDate purchase_date,LocalTime purchase_time,int client_id) {
		
		this.purchase_date = purchase_date ;
		this.purchase_time = purchase_time ;
		this.client_id = client_id ;}
	
	
	
	
	
    // method modify
	public void modify() {};
		
		
		
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
        
        return id;}
	
	
	
	
	
	
	
	
	
	// ----------------------------------------------------------------------------------
	
	
	
	
	
	
	// method to get all purchases
	public static ArrayList<Object[]> get_purchases_infos (){
		
		// an array to store infos
		ArrayList<Object[]> infos = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			
			// the select statement
			String select_query = "SELECT * FROM commande";
			
			// prepare the selection query
			prepared_selection = connection.prepareStatement(select_query);
			
			
			// execute selsection query
			resultSet = prepared_selection.executeQuery();
			
	

			// Iterate through the ResultSet and populate the infos array
			while (resultSet.next()) {
			    
				// get and store infos
			    String id_purchase = resultSet.getString("numerocommande");
			    String purchase_date = resultSet.getString("date_commande");
			    String purchase_time = resultSet.getString("temps_commande");
			    String purchase_state = resultSet.getString("etat_commande");
			    String client_id = resultSet.getString("numeroclient");
			    
			    
			    // anarray to store the data for this row
			    Object[] row_data = new Object[5];
			    // Set the values in the rowData array
			    row_data[0] = id_purchase;
			    row_data[1] = purchase_date;
			    row_data[2] = purchase_time;
			    row_data[3] = purchase_state;
			    row_data[4] = client_id;
			    
			    
			    // add the row data array to the infos ArrayList
			    infos.add(row_data);}}
			
		catch(SQLException e) {e.printStackTrace();}
        finally {
            
			try {
                
				  if (resultSet != null) resultSet.close();
                  if (prepared_selection != null) prepared_selection.close();
                  if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		
		return infos; }
	
	
	
	
	
	
	
	
	
	
	
	
	
	// -------------------------------------------------------------------------------
	
	
	
	// method to get sepecific client purchases
    public  ArrayList<Object[]> get_client_purchases_infos (){
		
		// an array to store infos
		ArrayList<Object[]> infos = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			
			// the select statement
			String select_query = "SELECT * FROM commande WHERE numeroclient = ?";
			
			// prepare the selection query
			prepared_selection = connection.prepareStatement(select_query);
			
			// Set the parameter value
            
            prepared_selection.setInt(1, client_id);
			
			
			// execute selsection query
			resultSet = prepared_selection.executeQuery();
			
	

			// Iterate through the ResultSet and populate the infos array
			while (resultSet.next()) {
			    
				// get and store infos
			    String id_purchase = resultSet.getString("numerocommande");
			    String purchase_date = resultSet.getString("date_commande");
			    String purchase_time = resultSet.getString("temps_commande");
			    String purchase_state = resultSet.getString("etat_commande");
			    
			    
			    // anarray to store the data for this row
			    Object[] row_data = new Object[4];
			    // Set the values in the rowData array
			    row_data[0] = id_purchase;
			    row_data[1] = purchase_date;
			    row_data[2] = purchase_time;
			    row_data[3] = purchase_state;
			    
			    
			    // add the row data array to the infos ArrayList
			    infos.add(row_data);}}
			
		catch(SQLException e) {e.printStackTrace();}
        finally {
            
			try {
                
				  if (resultSet != null) resultSet.close();
                  if (prepared_selection != null) prepared_selection.close();
                  if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		
		return infos; }
    
    
    
    
    
    
    
    
    // -------------------------------------------------------------------
    
    
    
    
    
    
	
	// method delete
	public void delete() {
		
		
		Connection connection = null;
	    PreparedStatement prepared_deletion = null;
		
		try {
	        // Get the connection
	        connection = Database_Connector.getConnection();
	        
	        // The query
	        String delete_query = "DELETE FROM commande WHERE date_commande = ? AND temps_commande = ? AND etat_commande = ? AND numeroclient = ?";
	        
	        // Prepare the query
	        prepared_deletion = connection.prepareStatement(delete_query);
	        
	        // Set parameter values
	        prepared_deletion.setDate(1, Date.valueOf(purchase_date));
	        prepared_deletion.setTime(2, Time.valueOf(purchase_time));
	        prepared_deletion.setString(3, purchase_state);
	        prepared_deletion.setInt(4, client_id);
	        
	        // Execute the query
	        prepared_deletion.executeUpdate();}
		
		catch (SQLException e) {e.printStackTrace();} 
		
		finally {
	        
			// Close resources
	        try {
	            if (prepared_deletion != null) {
	                prepared_deletion.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }}}
    
    
    
	
	

}
