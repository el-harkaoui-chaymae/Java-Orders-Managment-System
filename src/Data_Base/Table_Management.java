package Data_Base;

interface Table_Management {
	
	// abstract method for adding a new element to a table
	void add();
	

	// abstract method for modifying an existed element in a table
	void modify();
	
	
	// abstract method to delete an element from a table
	void delete();
	
	
	// abstract method to check the existance of an element in a table
	boolean check_existance(int parameter_number);
	
	
	// abstarct method to get an element attributes
	Object [] get_informations();
	

}
