package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;





public class Product implements Table_Management{
	
	
	// attributes
	int product_id;
	String product_category;
	String product_name;
	double quantity;
	double price;
	File photo_1;
	File photo_2;
	File photo_3;
	String product_description;
	String supplier;


	
	
	
	// constructor
	public Product (String product_category,String product_name,double quantity,double price,
			        File photo_1,File photo_2,File photo_3,String product_description,String supplier) {
		
		
		this.product_category = product_category;
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
		this.photo_1 = photo_1;
		this.photo_2 = photo_2;
		this.photo_3 = photo_3;
		this.product_description = product_description;
		this.supplier = supplier;
		
		
	}
	
	

	
	
	
	
	
	// the method add to insert a new product 
	public void add() {
		

		// establish a connection to the database server
		Connection connection = Database_Connector.getConnection();

		try {
			
			// the insertion statement for the table client
	        String insert_query = "INSERT INTO produit (categorie_produit,nom_produit,quantite,prix,"
	        		            + "photo_1,photo_2,photo_3,description_produit) "
	        		            + "VALUES (?,?,?,?,?,?,?,?,?)";
		    
	        // prepare the insertion query for execution
		    PreparedStatement prepared_insertion = connection.prepareStatement(insert_query);
		    
		    
		    // Set parameter values
		    prepared_insertion.setString(1, product_category);
		    prepared_insertion.setString(2, product_name);
		    prepared_insertion.setDouble(3, quantity);
		    prepared_insertion.setDouble(4, price);
		    prepared_insertion.setString(8, product_description);
		    prepared_insertion.setString(9, supplier);
		    
		    // set the photo_1 parameter value
            if(!(photo_1 == null)) {
		    	
		    	try {prepared_insertion.setBinaryStream(6, new FileInputStream(photo_1));}
			    catch (FileNotFoundException e) {e.printStackTrace();}}
		    
		    // set the photo_2 parameter value
		    if(!(photo_2 == null)) {
		    	
		    	try {prepared_insertion.setBinaryStream(6, new FileInputStream(photo_2));}
			    catch (FileNotFoundException e) {e.printStackTrace();}}
		    
		    else {prepared_insertion.setBinaryStream(6, null);}
		 
		    // set the photo_3 parameter value
		    if(!(photo_3 == null)) {
		    	
		    	try {prepared_insertion.setBinaryStream(7, new FileInputStream(photo_3));}
			    catch (FileNotFoundException e) {e.printStackTrace();}}
		    else {prepared_insertion.setBinaryStream(7, null);}
		   
	      
		   
		
		    // Execute the the prepared insertion
		    prepared_insertion.executeUpdate();
		}
		
		catch(SQLException e) {
            e.printStackTrace(); 
        
		}
	   
		finally {
        
			try { if (connection != null) connection.close();}
            catch (SQLException e) {e.printStackTrace();}}}
		
		
	
	
	
	
	
	
	
	
	
	
	
	// the method modify
	public void modify() {}
		
		
	// the method delete
	public void delete() {}
		
		
    // the method check existance
	public boolean check_existance(int parameter_number) {return true;}
		
		
	// the method get informations
	public String [] get_informations() {return new String[3];}

}
