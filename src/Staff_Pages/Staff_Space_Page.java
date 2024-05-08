package Staff_Pages;

import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Label;
import Graphical_Interface.Custom_Resizing_Manager;
import Client_Pages.Client_Space;

public class Staff_Space_Page {

	public Staff_Space_Page(Custom_Frame frame) {
		
		// create the staff space elements
		Staff_Space staff_space = new Staff_Space(frame);
		
		
		// label 3 - hello
	    int lb3_x = (int) ((440*frame.getWidth())/900);
	    int lb3_y = (int) ((150*frame.getHeight())/600);
	    int lb3_width = (int) ((200*frame.getWidth())/900);
	    int lb3_height = (int) ((110*frame.getHeight())/600);
	    int lb3_font_size = (int) ((22*frame.getWidth())/900);
        Custom_Label lab3 = new Custom_Label(lb3_x, lb3_y, lb3_width, lb3_height,"Area 55","Consolas",lb3_font_size,"#C00000");
        staff_space.space.add(lab3);
        
        
        
        
        // handle resizing
        Custom_Resizing_Manager resize_1 = new Custom_Resizing_Manager(frame);
        Custom_Resizing_Manager resize_2 = new Custom_Resizing_Manager(staff_space.space);
        
		
	}

}
