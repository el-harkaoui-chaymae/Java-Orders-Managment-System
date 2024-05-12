package Staff_Pages;

import java.awt.Color;

import Graphical_Interface.Custom_Frame;
import Graphical_Interface.Custom_Panel;

public class Staff_Reports_Page {

	

	// constructor
	public Staff_Reports_Page(Custom_Frame frame) {

		// create the staff space elements
		Staff_Space staff_space = new Staff_Space(frame);

		
		// change report button background to show that it's clicked
		staff_space.report.setBackground(Color.decode("#2F5597"));
		staff_space.labre.setBackground(Color.decode("#2F5597"));
		staff_space.report.change_style("#b39700", "#b39700");
		staff_space.report.change_color_background("#2F5597", "#2F5597", staff_space.labre);

		
		// center page panel
		int pn1_x = (int) ((140 * frame.getWidth()) / 900);
		int pn1_y = (int) ((70 * frame.getHeight()) / 600);
		int pn1_width = (int) ((800 * frame.getWidth()) / 900);
		int pn1_height = (int) ((580 * frame.getHeight()) / 600);
		Custom_Panel center_panel = new Custom_Panel(pn1_x, pn1_y, pn1_width, pn1_height, "#FFFFFF");
		staff_space.space.add(center_panel);

	}	
}
