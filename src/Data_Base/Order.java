package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

	
 
public class Order implements Table_Management{
	
	
	// attributes 
	int order_id;
	int client_id;
	int product_id;
	public int product_oredered_items ;
	
	
	// constructor
	public Order(int client_id,int product_id) {
		
		this.client_id = client_id;
		this.product_id = product_id;}
	
	
	
	
	 
	// method add
	@Override
	public void add() {
	    
		Connection connection = null;
	    PreparedStatement prepared_check = null;
	    PreparedStatement prepared_insertion = null;
	    ResultSet resultSet = null;

	    try {
	        
	    	// Establish a connection to the database server
	        connection = Database_Connector.getConnection();

	        // check to see if the client-product combination already exists
	        String check_query = "SELECT COUNT(*) FROM panier WHERE numeroclient = ? AND numeroproduit = ?";
	        
	        // prepare the check query for execution
	        prepared_check = connection.prepareStatement(check_query);
	        
	        // Set parameter values
	        prepared_check.setInt(1, client_id);
	        prepared_check.setInt(2, product_id);
	        
	        // Execute the check query
	        resultSet = prepared_check.executeQuery(); 
	        
	        // Check if the combination exists
	        if (resultSet.next() && resultSet.getInt(1) == 0) {
	            
	        	// the insertion statement
	            String insert_query = "INSERT INTO panier (numeroclient, numeroproduit) VALUES (?, ?)";
	            
	            // Prepare the insertion query for execution
	            prepared_insertion = connection.prepareStatement(insert_query);
	            
	            // Set parameter values
	            prepared_insertion.setInt(1, client_id);
	            prepared_insertion.setInt(2, product_id);
	            
	            // Execute the prepared insertion
	            prepared_insertion.executeUpdate();}}
	    
	    catch (SQLException e) {
	        e.printStackTrace();} 
	    
	    finally {
	        
	    	try {
	               if (resultSet != null) resultSet.close();
	               if (prepared_check != null) prepared_check.close();
	               if (prepared_insertion != null) prepared_insertion.close();
	               if (connection != null) connection.close();}
	        
	        catch (SQLException e) {
	            e.printStackTrace();
	        
	        
	        }}}

	
	
	
	
	// -------------------------------------------------------------------------------
	
	
	
	// method modify
	@Override
	public void modify() {}
	
	

	
	// method check the exitance
	@Override
	public boolean check_existance(int parameter_number) {return true;}
	
	
	

	// method get infos
	public Object [] get_informations() {return new Object[2];};
	
	
	
	
	
	// ---------------------------------------------------------------------
	
	
	
	// a method to get ordered (added to cart not purchased) products id 
	public static ArrayList<Integer> get_ordered_products_id(int client_id) {
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		// an array to store infos
		ArrayList<Integer> ids = new ArrayList<>();
		
		try {
			
			// establish a connection with the database server
			 connection = Database_Connector.getConnection();
			
			// the select statement
			String select_query = "SELECT numeroproduit FROM panier WHERE numeroclient = ?";
			
			// prepare the selection query
			 prepared_selection = connection.prepareStatement(select_query);
			
			// set paremeters values
			prepared_selection.setInt(1, client_id);
			
			// execute selsection query
			 resultSet = prepared_selection.executeQuery();
			
			 while (resultSet.next()) {
		            // get and store infos
		            int id = resultSet.getInt("numeroproduit");
		            ids.add(id);
		        }}
			
			
		catch(SQLException e) {e.printStackTrace();}
        finally {
            
			try {
                
				if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		return ids;
		
		
	}
	
	
	
	
	
	
	// --------------------------------------------------
	
	
	
	// a method to get the product ordered qantity
	public int get_product_ordered_quantity() {
		
        int ordered_Q = -1;
		
		Connection connection = null;
		PreparedStatement prepared_selection = null;
		ResultSet resultSet = null;
		
		try {
			
			// establish a connection with the database server
			 connection = Database_Connector.getConnection();
			
			// the select statement
			String select_query = "SELECT quantite_produit FROM panier WHERE numeroclient = ? AND numeroproduit = ?";
			
			// prepare the selection query
			prepared_selection = connection.prepareStatement(select_query);
			
			// set paremeters values
			prepared_selection.setInt(1, client_id);
			prepared_selection.setInt(2, product_id);
			
			// execute selsection query
			resultSet = prepared_selection.executeQuery();
			
			if (resultSet.next()) { ordered_Q = resultSet.getInt("quantite_produit");}}
				
		catch(SQLException e) {e.printStackTrace();}
        finally {
            
			try {
                
				if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
		
		return ordered_Q;
		
		}
	
	
	
	
	// ----------------------------------------------------
	
	
	
	// a mehtod to get the total ordered items by a client
	public int get_total_ordered_items() {
		
		int total_ordered_items = 0 ;
		
		Connection connection = null;
        PreparedStatement prepared_selection = null;
        ResultSet resultSet = null;
        
        try {
            // establish a connection with the database server
            connection = Database_Connector.getConnection();
            
            // the select statement
            String select_search = "SELECT quantite_produit FROM panier WHERE numeroclient = ?";
            
            // prepare the selection query
            prepared_selection = connection.prepareStatement(select_search);
            
            // set parameter values
            prepared_selection.setInt(1, client_id);
            
            // execute selection query
            resultSet = prepared_selection.executeQuery();
            
            // Iterate through the ResultSet 
            while (resultSet.next()) {
                
            	int Q = resultSet.getInt("quantite_produit");
                total_ordered_items += Q ;
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
        
        return total_ordered_items;
		
		
	}
	
	
	
	
	
	
	
	
	// ------------------------------------------------------------------
	
	
	
	
	// a method to increase the orderd quantity by 1
	public void change_product_ordered_quantity() {
		
		Connection connection = null;
		PreparedStatement prepared_update = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			 
			
			// the update statement
			String update_query = "UPDATE panier SET quantite_produit = ? WHERE numeroclient = ? AND numeroproduit = ?" ;
					               
			
			// prepare the update query
			prepared_update = connection.prepareStatement(update_query);
			
			// set paremeters values
			prepared_update.setInt(1, product_oredered_items);
			prepared_update.setInt(2, client_id);
			prepared_update.setInt(3, product_id);
			
			// update data 
			prepared_update.executeUpdate(); }
		
		catch (SQLException e) {e.printStackTrace();}
        
		finally {
            
			try {
                
                if (prepared_update != null) prepared_update.close();
                if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}}
	
	
	
	
	
	
	
	// -------------------------------------------------------------------------
	
	
	
	
	// a method to get the total price of ordered items
	
	public double get_total_orders_price() {
	    double total_price = 0;
	    Connection connection = null;
	    PreparedStatement prepared_selection = null;
	    PreparedStatement prepared_selection_2 = null;
	    ResultSet resultSet = null;
	    ResultSet resultSet_2 = null;

	    try {
	        // Establish a connection with the database server
	        connection = Database_Connector.getConnection();

	        // The select statement to get the products and their quantities for the given client
	        String select_query = "SELECT numeroproduit, quantite_produit FROM panier WHERE numeroclient = ?";
	        // The select statement to get the price of a product
	        String select_query_2 = "SELECT prix FROM produit WHERE numeroproduit = ?";

	        // Prepare the selection query for the panier table
	        prepared_selection = connection.prepareStatement(select_query);
	        // Set the parameter value for the client id
	        prepared_selection.setInt(1, client_id);

	        // Execute the selection query for the panier table
	        resultSet = prepared_selection.executeQuery();

	        // Prepare the selection query for the produit table
	        prepared_selection_2 = connection.prepareStatement(select_query_2);

	        // Loop through the result set from the panier table
	        while (resultSet.next()) {
	            int pr_id = resultSet.getInt("numeroproduit");
	            int ordered_Q = resultSet.getInt("quantite_produit");

	            // Set the parameter value for the product ID in the produit query
	            prepared_selection_2.setInt(1, pr_id);

	            // Execute the selection query for the produit table
	            resultSet_2 = prepared_selection_2.executeQuery();

	            // If there is a result, get the product price
	            if (resultSet_2.next()) {
	                double pr_price = resultSet_2.getDouble("prix");
	                // Add the total price for this product to the overall total
	                total_price += ordered_Q * pr_price;
	            }

	            // Close the result set for the produit query to avoid potential issues
	            resultSet_2.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (prepared_selection != null) prepared_selection.close();
	            if (prepared_selection_2 != null) prepared_selection_2.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return total_price;
	}

	
	
	
	
	
	
	
	
	
	
	// -----------------------------------------------------
	
	
	
	
	
	// mehtod to delete all orders related to a specific client after purchasing them
    public static void empty_orders_list(int client_id) {
    	
    	
    	Connection connection = null;
		PreparedStatement prepared_update = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			 
			
			// the delete statement
			String delete_query = "DELETE FROM panier WHERE numeroclient = ?";

			
			// prepare the delete query
			prepared_update = connection.prepareStatement(delete_query);
			
			// set paremeters values
			prepared_update.setInt(1, client_id);
		

			// delete data 
			prepared_update.executeUpdate(); }
		
		catch (SQLException e) {e.printStackTrace();}
        
		finally {
            
			try {
                  if (prepared_update != null) prepared_update.close();
                  if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
    };
	
	
	
	
	
	
	
	
	
	// ---------------------------------------------------
    
    
    
    

	// mehtod delete to remove a specific product from the orders list
    public void delete() {
    	
    	Connection connection = null;
		PreparedStatement prepared_update = null;
		
		try {
			
			// establish a connection with the database server
			connection = Database_Connector.getConnection();
			 
			
			// the delete statement
			String delete_query = "DELETE FROM panier WHERE numeroclient = ? and numeroproduit = ?";

			
			// prepare the delete query
			prepared_update = connection.prepareStatement(delete_query);
			
			// set paremeters values
			prepared_update.setInt(1, client_id);
			prepared_update.setInt(2, product_id);
		

			// delete data 
			prepared_update.executeUpdate(); }
		
		catch (SQLException e) {e.printStackTrace();}
        
		finally {
            
			try {
                  if (prepared_update != null) prepared_update.close();
                  if (connection != null) connection.close();}
            
			catch (SQLException e) {e.printStackTrace();}}
    	
    	
    	
    	
    	
    	
    	
    }
	
	
	
	
    
    
    
    // -------------------------------------------------------------------------------
    
    
    
    
    // a method to get a specific client purchased products and their quantities
    public ArrayList<Object[]> get_purchased_products_quantities(){
    	
    	ArrayList<Object[]> products_quantities = new ArrayList();
    	
    
	    Connection connection = null;
        PreparedStatement prepared_selection = null;
        ResultSet resultSet = null;
        
        try {
            // establish a connection with the database server
            connection = Database_Connector.getConnection();
            
            // the select statement
            String select_search = "SELECT numeroproduit,quantite_produit FROM panier WHERE numeroclient = ?";
            
            // prepare the selection query
            prepared_selection = connection.prepareStatement(select_search);
            
            // set parameter values
            prepared_selection.setInt(1, client_id);
            
            // execute selection query
            resultSet = prepared_selection.executeQuery();
            
            // Iterate through the ResultSet 
            while (resultSet.next()) {
                
            	int id_product = resultSet.getInt("numeroproduit");
            	double product_Q = resultSet.getDouble("quantite_produit");
            	Object[] pr_q = new Object[2];
            	pr_q[0] = id_product;
            	pr_q[1] = product_Q;
            	products_quantities.add(pr_q);
                
            }} 
        
        catch (SQLException e) {
            e.printStackTrace();} 
        
        finally {
            
        	try {
                
        		if (resultSet != null) resultSet.close();
                if (prepared_selection != null) prepared_selection.close();
                if (connection != null) connection.close();} 
        	
        	catch (SQLException e) {
                e.printStackTrace();
            }}
    	
    	
        return products_quantities;}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
