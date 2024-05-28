package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Random;






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
	
	ArrayList<Object[]> infos;
	ArrayList<Object[]> search_result;
	   
	


	
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
	

			
			
	    // the method check existance
		public boolean check_existance(int parameter_number) {return true;}
			
		

		// the method get informations
		public Object [] get_informations() { return new Object[3];}
	
	
	
	
	
	// ----------------------------------------------------------------------------------------
	
	
		
	// product_id setter
	public void setId(int product_id) {this.product_id = product_id ; }	
	
	
	
	
	// -----------------------------------------------------------------------------------------
	
	
	
	
	
	
	// the method add to insert a new product 
	public void add() {
		

		// establish a connection to the database server
		Connection connection = Database_Connector.getConnection();

		try {
			
			// the insertion statement for the table client
	        String insert_query = "INSERT INTO produit (categorie_produit,nom_produit,quantite,prix,"
	        		            + "photo_1,photo_2,photo_3,description_produit,fournisseur) "
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
		    	
		    	try {prepared_insertion.setBinaryStream(5, new FileInputStream(photo_1));}
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
		
		
	
	
	
	// ----------------------------------------------------------------------------------------
	
	
	
	
	
	
	// the method modify to update an existing product
	public void modify() {
		
		Connection connection = null;
		PreparedStatement prepared_update = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			 
			
			// the update statement
			String update_query = "UPDATE produit SET nom_produit = ? , quantite = ? , prix = ? WHERE numeroproduit = ?" ;
					               
			
			// prepare the update query
			prepared_update = connection.prepareStatement(update_query);
			
			// set paremeters values
			prepared_update.setString(1, product_name);
			prepared_update.setDouble(2, quantity);
			prepared_update.setDouble(3, price);
			prepared_update.setInt(4, product_id);
			
			// update data 
			prepared_update.executeUpdate(); }
		
		catch (SQLException e) {e.printStackTrace();}
        
		finally {
            
			try {
                
                if (prepared_update != null) prepared_update.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
	}
		
	
	
	
	
	
	
	// ----------------------------------------------------------------------------------------
	
	
	
	
	
	// the method get informations
	public ArrayList<Object[]> get_similar_products() {
		
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			
			// the select statement
			String select_query = "SELECT * FROM produit WHERE categorie_produit = ?";
			
			// prepare the selection query
			prepared_selection = connection.prepareStatement(select_query);
			
			// set paremeters values
			prepared_selection.setString(1, product_category);
			
			// execute selsection query
			resultSet = prepared_selection.executeQuery();
			
			// an array to store infos
		    infos = new ArrayList<>();

			// Iterate through the ResultSet and populate the infos array
			while (resultSet.next()) {
			    // get and store infos
			    int id_product = resultSet.getInt("numeroproduit");
			    String product_category = resultSet.getString("categorie_produit");
			    String product_name = resultSet.getString("nom_produit");
			    double quantity = resultSet.getDouble("quantite");
			    double price = resultSet.getDouble("prix");
			    InputStream photo_1 = resultSet.getBinaryStream("photo_1");
			    InputStream photo_2 = resultSet.getBinaryStream("photo_2");
			    InputStream photo_3 = resultSet.getBinaryStream("photo_3");
			    String product_description = resultSet.getString("description_produit");
			    String supplier = resultSet.getString("fournisseur");
			    
			    // anarray to store the data for this row
			    Object[] row_data = new Object[10];
			    // Set the values in the rowData array
			    row_data[0] = id_product;
			    row_data[1] = product_category;
			    row_data[2] = product_name;
			    row_data[3] = quantity;
			    row_data[4] = price;
			    row_data[5] = photo_1;
			    row_data[6] = photo_2;
			    row_data[7] = photo_3;
			    row_data[8] = product_description;
			    row_data[9] = supplier;
			    
			    // add the row data array to the infos ArrayList
			    infos.add(row_data);}}
			
		catch(SQLException e) {e.printStackTrace();}
        finally {
            
			try {
                
				  if (resultSet != null) resultSet.close();
                  if (prepared_selection != null) prepared_selection.close();
                  if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		
		return infos;
		
		
	}
	


	
	
	// --------------------------------------------------------------------------------------------------
	
	
	
	
	
	// the method delete to remove a product
    public void delete() {
    	
    	Connection connection = null;
		PreparedStatement prepared_update = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			 
			
			// the delete statement
			String delete_query = "DELETE FROM produit WHERE numeroproduit = ?";

			
			// prepare the delete query
			prepared_update = connection.prepareStatement(delete_query);
			
			// set paremeters values
			prepared_update.setInt(1, product_id);
		

			// delete data 
			prepared_update.executeUpdate(); }
		
		catch (SQLException e) {e.printStackTrace();}
        
		finally {
            
			try {
                  if (prepared_update != null) prepared_update.close();
                  if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
	
    }



    // --------------------------------------------------------------------------------
    
    
    
    
    // a method to search a product
    public ArrayList<Object[]> search_product() {
        
    	Connection connection = null;
        PreparedStatement prepared_search = null;
        ResultSet resultSet = null;
        ArrayList<Object[]> search_result = new ArrayList<>();
        
        try {
            // establish a connection with the database server
            connection = Database_Connector.getConnection();
            
            // the select statement
            String select_search = "SELECT * FROM produit WHERE nom_produit LIKE ?";
            
            // prepare the selection query
            prepared_search = connection.prepareStatement(select_search);
            
            // set parameter value with wildcard for partial matching
            prepared_search.setString(1, "%" + product_name + "%");
            
            // execute selection query
            resultSet = prepared_search.executeQuery();
            
            // Iterate through the ResultSet and populate the search_result array
            while (resultSet.next()) {
                int id_product = resultSet.getInt("numeroproduit");
                String product_name_result = resultSet.getString("nom_produit");
                double quantity = resultSet.getDouble("quantite");
                double price = resultSet.getDouble("prix");
                String supplier = resultSet.getString("fournisseur");
                
                // create an array to store the data for this row
                Object[] row_data = new Object[5];
                row_data[0] = id_product;
                row_data[1] = product_name_result;
                row_data[2] = price;
                row_data[3] = quantity;
                row_data[4] = supplier;
                
                // add the row data array to the search_result ArrayList
                search_result.add(row_data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (prepared_search != null) prepared_search.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return search_result;
    }

    
    
    
    
    
    // ------------------------------------------------------------------------- 
    
    
    
    
    
    // a method to get a specific product infos
    public Object[] get_details() {
    	
    	
    	Connection connection = null;
        PreparedStatement prepared_selection = null;
        ResultSet resultSet = null;
        Object [] selection_result = new Object [10];
        
        
        try {
            // establish a connection with the database server
            connection = Database_Connector.getConnection();
            
            // the select statement
            String select_query = "SELECT * FROM produit WHERE numeroproduit = ?";
            
            // prepare the selection query
            prepared_selection = connection.prepareStatement(select_query);
            
            // set parameter value 
            prepared_selection.setInt(1, product_id);
            
            // execute selection query
            resultSet = prepared_selection.executeQuery();
            
            // Iterate through the ResultSet and populate the selection_result array
            while (resultSet.next()) {
            	
            	// get and store infos
			    int id_product = resultSet.getInt("numeroproduit");
			    String product_category = resultSet.getString("categorie_produit");
			    String product_name = resultSet.getString("nom_produit");
			    double quantity = resultSet.getDouble("quantite");
			    double price = resultSet.getDouble("prix");
			    InputStream photo_1 = resultSet.getBinaryStream("photo_1");
			    InputStream photo_2 = resultSet.getBinaryStream("photo_2");
			    InputStream photo_3 = resultSet.getBinaryStream("photo_3");
			    String product_description = resultSet.getString("description_produit");
			    String supplier = resultSet.getString("fournisseur");
                
			    // popolate the array
			    selection_result[0] = id_product;
			    selection_result[1] = product_category;
			    selection_result[2] = product_name;
			    selection_result[3] = quantity;
			    selection_result[4] = price;
			    selection_result[5] = photo_1;
			    selection_result[6] = photo_2;
			    selection_result[7] = photo_3;
			    selection_result[8] = product_description;
			    selection_result[9] = supplier;
                
                
            }
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
        
        return selection_result;
    	
    	
    }
    
    
    
    
    
    
    
    
    

    // ------------------------------------------------------------------------------------------------
    
    
    
    // method to count the total number of products
    public int products_total_number() {
    	
    	
    	Connection connection = null;
        PreparedStatement prepared_selection = null;
        ResultSet resultSet = null;
        int products_total_number = 0;
        
        
        try {
            // establish a connection with the database server
            connection = Database_Connector.getConnection();
            
            // the select statement
            String select_query = "SELECT COUNT(*) AS total_number FROM produit";
            
            // prepare the selection query
            prepared_selection = connection.prepareStatement(select_query);
             
            // execute selection query
            resultSet = prepared_selection.executeQuery();
            
            // Iterate through the ResultSet 
            if (resultSet.next()) {
            	
            	products_total_number = resultSet.getInt("total_number"); }
       
        
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
        
        return products_total_number;
    	
    	
    	
    	
    	
    }
    
    
    
    
    
    // -----------------------------------------------------------------------------
    
    
    
    // a method to get the names and the first photos of 4 random products
    public ArrayList<Object[]> get_4_random_products(){
    	
    	
    	// generate 5 random numbers between 0 and products total number
        Random random = new Random();
        int index_1 = random.nextInt(this.products_total_number());
        int index_2 = random.nextInt(this.products_total_number());
        int index_3 = random.nextInt(this.products_total_number());
        int index_4 = random.nextInt(this.products_total_number());
        
        
        // ensure index_2 and index_3 are different from index_1
        while (index_2 == index_1) {
            
        	index_2 = random.nextInt(this.products_total_number());}
        
    
        while (index_3 == index_1 || index_3 == index_2) {
            
        	index_3 = random.nextInt(this.products_total_number());}
        
        while (index_4 == index_1 || index_4 == index_2|| index_4 == index_3) {
            
        	index_4 = random.nextInt(this.products_total_number());}

        
    	Connection connection = null;
        PreparedStatement prepared_selection = null;
        ResultSet resultSet = null;
        ArrayList<Object[]> selection_result = new ArrayList<>();        
        
        try {
            
        	// establish a connection with the database server
            connection = Database_Connector.getConnection();
            
            // the select statement
            String select_query = "(SELECT * FROM produit ORDER BY numeroproduit LIMIT 1 OFFSET " + (index_1) + ") " +
                                   "UNION ALL " +
                                   "(SELECT * FROM produit ORDER BY numeroproduit LIMIT 1 OFFSET " + (index_2) + ") " +
                                   "UNION ALL " +
                                   "(SELECT * FROM produit ORDER BY numeroproduit LIMIT 1 OFFSET " + (index_3) + ")"+
                                   "UNION ALL " +
                                   "(SELECT * FROM produit ORDER BY numeroproduit LIMIT 1 OFFSET " + (index_4) + ")";
                                   
            
            // prepare the selection query
            prepared_selection = connection.prepareStatement(select_query);
             
            // execute selection query
            resultSet = prepared_selection.executeQuery();
            
            // Iterate through the ResultSet 
            while (resultSet.next()) {
            	
            	// get and store infos
			    
			    String product_name = resultSet.getString("nom_produit");
			    InputStream photo_1 = resultSet.getBinaryStream("photo_1");
			    
			    
			    // anarray to store the data for this row
			    Object[] row_data = new Object[2];
			    
			    // Set the values in the rowData arra
			    row_data[0] = product_name; 
			    row_data[1] = photo_1;
			    
			    
			    // add the row data array to the infos ArrayList
			    selection_result.add(row_data);
            	
            	 }
       
        
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
        
        return selection_result;
    	
  	
    }
    
    	
    	
    	
    	
    	
    	
    	
    
    
    
    
    
    
    
    
    
    








}
	
	