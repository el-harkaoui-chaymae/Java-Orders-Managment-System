package Data_Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Purchase_Product implements Table_Management {
	
	
	// attributes
	int purchase_id;
	int product_id;
	double purchased_prodcut_quantity ;
	
	
	//constructor
	public Purchase_Product(int purchase_id, int product_id, double purchased_prodcut_quantity) {
		
		this.purchase_id = purchase_id;
		this.product_id = product_id;
		this.purchased_prodcut_quantity = purchased_prodcut_quantity;
	}
	
	
	
	
	
	
	
	// ------------------------------------------------------------------------
	
	
	
	// the method add to insert a new purchase_product element
	public void add() {

		// establish a connection to the database server
		Connection connection = Database_Connector.getConnection();

		try {

			// the insertion statement for the table client
			String insert_query = "INSERT INTO commande_produit (numerocommande,numeroproduit,quantite_commandee) VALUES (?,?,?)";

			// prepare the insertion query for execution
			PreparedStatement prepared_insertion = connection.prepareStatement(insert_query);

			// Set parameter values
			prepared_insertion.setInt(1, purchase_id);
			prepared_insertion.setInt(2, product_id);
			prepared_insertion.setDouble(3, purchased_prodcut_quantity);

			// Execute the the prepared insertion
			prepared_insertion.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();

		}

		finally {

			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	};
			
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// method modify
	public void modify() {};
			
			
	// method delete
	public void delete() {};
			
			
	// method to check the existance of a delivery
	public boolean check_existance(int parameter_number) {return true ;};
			
			
	// method to get an element attributes
	public Object [] get_informations() {return new Object[2];};

}
