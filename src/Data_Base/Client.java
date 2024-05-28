package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.time.LocalDate;

import java.sql.Date;
import java.sql.Types;
 

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
	LocalDate birth_date; 
	String gender;
	String nationality; 
	String education_level;
	double low_income; 
	double high_income; 
	
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
	
	
	
	// method to set additional attribute
	public void set_additional_attributes(LocalDate birth_date,String gender,String nationality,
			                              String education_level,double low_income,double high_income) {
		
		this.birth_date = birth_date;
		this.gender = gender;
		this.nationality = nationality;
		this.education_level = education_level;
		this.low_income = low_income;
		this.high_income = high_income;}
		
		
	
	
	
	
	 
	
	
	
	// the method add to insert new client
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
	
	
	

	// --------------------------------------------------------------------------------------------------------------
	
	
	
	// method to get client id from DB - 
	public int get_client_id() {
		
		int id = -1;
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		try {
			
			// establish a connection with the database server
			 connection = Database_Connector.getConnection();
			
			// the select statement
			String select_query = "SELECT numeroclient FROM client WHERE mail = ?";
			
			// prepare the selection query
			prepared_selection = connection.prepareStatement(select_query);
			
			// set paremeters values
			prepared_selection.setString(1, mail);
			
			// execute selsection query
			resultSet = prepared_selection.executeQuery();
			
			if (resultSet.next()) { id = resultSet.getInt("numeroclient");}}
				
		catch(SQLException e) {e.printStackTrace();}
        finally {
            
			try {
                
				if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		return id;}
	
	
	
	
	//-----------------------------------------------------------------------------------------
	
	
	// setter for client id
	public void setClientId(int client_id) { this.client_id = client_id; }
		
	
		
	
	
	
	
	// ------------------------------------------------------------------------------------------
	
	
	// the method modify
	@Override
	public void modify() {
		
		Connection connection = null;
		PreparedStatement prepared_update = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			 
			
			// the update statement
			String update_query = "UPDATE client SET prenom = ?  , nom = ? , ville = ? , adresse = ? ,"
					               + " telephone = ? , mail = ? , mot_de_passe = ? , date_de_naissance = ? , "
					               + "genre = ? , nationalite = ? , niveau_education = ? , "
					               + "revenu_faible = ? , revenu_eleve = ? WHERE numeroclient = ?";
			
			// prepare the update query
			prepared_update = connection.prepareStatement(update_query);
			
			// set paremeters values
			prepared_update.setString(1, first_name);
			prepared_update.setString(2, second_name);
			prepared_update.setString(3, city);
			prepared_update.setString(4, adress);
			prepared_update.setString(5, phone_number);
			prepared_update.setString(6, mail);
		    prepared_update.setString(7, password);
		    
		    if(birth_date == null) {
		    	prepared_update.setNull(8, Types.DATE);}	
		    else {prepared_update.setDate(8, Date.valueOf(birth_date));}
		    
		    if(gender.equals("----")) {
		    	prepared_update.setString(9, null);}	
		    else {prepared_update.setString(9, gender);}
		    
		    if(nationality.equals("----")) {
		    	prepared_update.setString(10, null);}	
		    else { prepared_update.setString(10, nationality);}
		    
		    if(education_level.equals("----")) {
		    	prepared_update.setString(11, null);}	
		    else { prepared_update.setString(11, education_level);}
		    
		    if(low_income == 0) {
		    	prepared_update.setNull(12, Types.DOUBLE);}	
		    else { prepared_update.setDouble(12, low_income);}
		    
		    if(high_income == 0) {
		    	prepared_update.setNull(13, Types.DOUBLE);}	
		    else { prepared_update.setDouble(13, high_income);}
		    
		    prepared_update.setInt(14, client_id);
		    
		    
		    

			// update data 
			prepared_update.executeUpdate(); }
		
		catch (SQLException e) {e.printStackTrace();}
        
		finally {
            
			try {
                
                if (prepared_update != null) prepared_update.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		
	}
	
	
	
		
		
		
		
	// ---------------------------------------------------------------------------------
	
	

    // the method delete
	@Override
	public void delete() {}
	
	
	
	
	
	
	
	
	// ----------------------------------------------------------------------------------
	
	
	
	
	// the method check_existance to see if a client already exists 
	@Override
	public boolean check_existance(int parameter_number) {
		
		boolean exist = false;
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		try {
            // establish a connection with the database server
			connection = Database_Connector.getConnection();
            
			// the select statement
			String select_query = null;
			
			// checking using the mail only
			if(parameter_number == 1) {
				
				select_query = "SELECT * FROM client WHERE mail = ?";
				
				// prepare the selection query
				prepared_selection = connection.prepareStatement(select_query);
				
				// set paremeter value
				prepared_selection.setString(1, mail);}
				
		    // checking using both mail and password
			if(parameter_number == 2) {
				
				select_query = "SELECT * FROM client WHERE mail = ? AND mot_de_passe = ?";
				
				// prepare the selection query
				prepared_selection = connection.prepareStatement(select_query);
				
				// set paremeters values
				prepared_selection.setString(1, mail);
				prepared_selection.setString(2, password);}	
         
			// execute selsection query
			resultSet = prepared_selection.executeQuery(); // resultSet stores rows
            
			// Initially the cursor is positioned before the first row of the resultSet
			// next() moves the cursor to the next row if there is one and returns true
            if (resultSet.next()) {exist = true;}}
                
		catch (SQLException e) {e.printStackTrace();}
         
		finally {
            
			try {
                
				if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		return exist;}
	
	
	
	
	
	
	
	
	
	// ------------------------------------------------------------------------
	
	
	
	
	
	// the method get informations to get the client proprieties
	@Override
	public String[] get_informations() {
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		// an array to store infos
		String [] infos = new String[13];
		
		try {
			
			// establish a connection with the database server
			 connection = Database_Connector.getConnection();
			
			// the select statement
			String select_query = "SELECT * FROM client WHERE mail = ?";
			
			// prepare the selection query
			 prepared_selection = connection.prepareStatement(select_query);
			
			// set paremeters values
			prepared_selection.setString(1, mail);
			
			// execute selsection query
			 resultSet = prepared_selection.executeQuery();
			
			if (resultSet.next()) {
				
				// get and store infos
				String first_name = resultSet.getString("prenom");
				infos[0] = first_name;
				String second_name = resultSet.getString("nom");
				infos[1] = second_name;
				String city = resultSet.getString("ville");
				infos[2] = city;
				String adress = resultSet.getString("adresse");
				infos[3] = adress;
				String phone_number = resultSet.getString("telephone");
				infos[4] = phone_number;
				String mail_adress = resultSet.getString("mail");
				infos[5] = mail_adress;
				String password = resultSet.getString("mot_de_passe");
				infos[6] = password;
				String birth_date = resultSet.getString("date_de_naissance");
				infos[7] = birth_date;
				String gender = resultSet.getString("genre");
				infos[8] = gender;
				String nationality = resultSet.getString("nationalite");
				infos[9] = nationality;
				String education_level = resultSet.getString("niveau_education");
				infos[10] = education_level;
				String low_income = resultSet.getString("revenu_faible");
				infos[11] = low_income;
				String high_income = resultSet.getString("revenu_eleve");
				infos[12] = high_income;
				

			}}
			
			
		catch(SQLException e) {e.printStackTrace();}
        finally {
            
			try {
                
				if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		return infos;
		
		
		
		
		
		
	}
	
            
  

}
