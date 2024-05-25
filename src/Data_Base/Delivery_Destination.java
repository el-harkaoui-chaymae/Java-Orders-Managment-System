package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class Delivery_Destination implements Table_Management {
	
	// attributes
	public int destination_id;
	String city;
	double delivery_estimated_price;
	
	
	public Delivery_Destination(String city,double delivery_estimated_price ) {
		
		this.city = city ;
		this.delivery_estimated_price = delivery_estimated_price ;
	}

	
	
	// method check the exitance
	@Override
	public boolean check_existance(int parameter_number) {return true;}
	
	
	
	//  method to get an element attributes
	public Object [] get_informations() {return new Object[2];};
	
	
	// -----------------------------------------------------------------------------------------
	
	
	

	// method get infos
	public static ArrayList<Object[]> get_destinations() {
		
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		// an array to store destination and price
		ArrayList<Object[]> infos = new ArrayList();
		
		try {
			
			// establish a connection with the database server
			 connection = Database_Connector.getConnection();
			
			// the select statement
			String select_query = "SELECT ville,prix_livraison_estime FROM destination";
			
			// prepare the selection query
			 prepared_selection = connection.prepareStatement(select_query);
			
			
			// execute selsection query
			 resultSet = prepared_selection.executeQuery();
			
			while (resultSet.next()) {
				
				Object[] destination_infos = new Object[2];
				
				// get and store infos
				String City = resultSet.getString("ville");
				double Price = resultSet.getDouble("prix_livraison_estime");
				
				destination_infos[0] = City ;
				destination_infos[1] = Price ;
				
				infos.add(destination_infos);
				
			}}
			
			
		catch(SQLException e) {e.printStackTrace();}
        finally {
            
			try {
                
				if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		return infos;
		
		};
	
	
	
	
	
	
	// --------------------------------------------------------------------
	
	
		
		
	
	// method add
	public void add() {
		
		
		
		// establish a connection to the database server
		Connection connection = Database_Connector.getConnection();

		try {
			
			// the insertion statement for the table client
	        String insert_query = "INSERT INTO destination (ville,prix_livraison_estime) VALUES (?,?)";
		    
	        // prepare the insertion query for execution
		    PreparedStatement prepared_insertion = connection.prepareStatement(insert_query);
		    
		    // Set parameter values
		    prepared_insertion.setString(1, city);
		    prepared_insertion.setDouble(2, delivery_estimated_price);
		    
		
		    // Execute the the prepared insertion
		    prepared_insertion.executeUpdate();
		}
		
		catch(SQLException e) {
            e.printStackTrace(); 
        
		}
	   
		finally {
        
			try { if (connection != null) connection.close();}
            catch (SQLException e) {e.printStackTrace();}} }
	
	
	
	
	
	
	// -------------------------------------------------------------------------
	
	
	
	
	
	// method to get a destination id
	public int get_destination_id() {
		
		
        int id = -1;
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		try {
			
			// establish a connection with the database server
			 connection = Database_Connector.getConnection();
			
			// the select statement
			String select_query = "SELECT numerodestination FROM destination WHERE ville = ? and prix_livraison_estime = ?";
			
			// prepare the selection query
			prepared_selection = connection.prepareStatement(select_query);
			
			// set paremeters values
			prepared_selection.setString(1, city);
			prepared_selection.setDouble(2, delivery_estimated_price);
			
			// execute selsection query
			resultSet = prepared_selection.executeQuery();
			
			if (resultSet.next()) { id = resultSet.getInt("numerodestination");}}
				
		catch(SQLException e) {e.printStackTrace();}
        finally {
            
			try {
                
				if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		return id;}
	
	
	
	
	
	
	
	// ------------------------------------------------------------------------
	
	

	// method modify
	@Override
	public void modify() {
		
		Connection connection = null;
		PreparedStatement prepared_update = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			 
			
			// the update statement
			String update_query = "UPDATE destination SET ville = ? , prix_livraison_estime = ?  WHERE numerodestination = ?" ;
					               
			
			// prepare the update query
			prepared_update = connection.prepareStatement(update_query);
			
			// set paremeters values
			prepared_update.setString(1, city);
			prepared_update.setDouble(2, delivery_estimated_price);
			prepared_update.setInt(3, destination_id);
			
			// update data 
			prepared_update.executeUpdate(); }
		
		catch (SQLException e) {e.printStackTrace();}
        
		finally {
            
			try {
                
                if (prepared_update != null) prepared_update.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
	}
	
	
	
	
	
	
	
	// mehtod delete
    public void delete() {
    	
    	
    	
    	Connection connection = null;
		PreparedStatement prepared_update = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			 
			
			// the delete statement
			String delete_query = "DELETE FROM destination WHERE numerodestination = ?";

			
			// prepare the delete query
			prepared_update = connection.prepareStatement(delete_query);
			
			// set paremeters values
			prepared_update.setInt(1, destination_id);
		

			// delete data 
			prepared_update.executeUpdate(); }
		
		catch (SQLException e) {e.printStackTrace();}
        
		finally {
            
			try {
                  if (prepared_update != null) prepared_update.close();
                  if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    };
	
	
	
	
	
	
	
    
    
    // ------------------------------------------------------------
   
    
    
    
    
	
	
	
	
	
}
