package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class Client implements Table_Management{
	
	// attributes
	int client_id;
	String first_name;
	String second_name;
	String city;
	String adress;
	String phone_number;
	String mail;
	String password;
	
	// constructor
	public Client(String first_name,String second_name,String city,String adress,
			      String phone_number,String mail,String password) {
		
		
		this.first_name = first_name;
		this.second_name = second_name;
		this.city = city;
		this.adress = adress;
		this.phone_number = phone_number;
		this.mail = mail;
		this.password = password;
		
		
        
  
		
	}
	
	
	// override the method add to insert new client
	@Override
	public void add() {
		        
		        // establish a connection to the database server
				Connection connection = Database_Connector.getConnection();
		
				try {
					
					// the insertion statement for the table client
			        String insert_query = "INSERT INTO client (prenom,nom,ville,adresse,telephone,mail,mot_de_passe) "
			        		               + "VALUES (?,?,?,?,?,?,?)";
				    
			        // prepare the insertion query for execution
				    PreparedStatement prepared_insertion = connection.prepareStatement(insert_query);
				    
				    // Set parameter values
				    prepared_insertion.setString(1, first_name);
				    prepared_insertion.setString(2, second_name);
				    prepared_insertion.setString(3, city);
				    prepared_insertion.setString(4, adress);
				    prepared_insertion.setString(5, phone_number);
				    prepared_insertion.setString(6, mail);
				    prepared_insertion.setString(7, password);
				
				    // Execute the the prepared insertion
				    prepared_insertion.executeUpdate();
				}
				
				catch(SQLException e) {
		            e.printStackTrace(); 
		        
				}
			   
				finally {
		        
					try { if (connection != null) connection.close();}
		            catch (SQLException e) {e.printStackTrace();}}
		
		
	}
	
	// override the method modify
	@Override
	public void modify() {}
	
	
	
	// override the method delete
	@Override
	public void delete() {}
	
	
	
	
	
	
	// override the method check_existance to see if a client already exists 
	@Override
	public boolean check_existance() {
		
		boolean exist = false;
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		try {
            // establish a connection with the database server
			connection = Database_Connector.getConnection();
            
			// the select statement
			String select_query = "SELECT * FROM client WHERE mail = ?";
					
            
			// prepare the selection query
			prepared_selection = connection.prepareStatement(select_query);
            
			// set paremeter value
			prepared_selection.setString(1, mail);
            
			// execute selsection query
			resultSet = prepared_selection.executeQuery(); // resultSet stores rows
            
			// Initially the cursor is positioned before the first row of the resultSet
			// next() moves the cursor to the next row if there is one and returns true
            if (resultSet.next()) {exist = true;}}
                
		catch (SQLException e) {
            e.printStackTrace();}
         
		finally {
            
			try {
                
				if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {
                e.printStackTrace();}}
		
		return exist;}
	
            
  

}
