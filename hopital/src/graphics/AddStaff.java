package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;





import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class AddStaff extends JDialog{
	private final static Dimension SizeDepartemntShop = new Dimension(270,540);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AddStaff(JFrame topFrame, String string,Boolean b) {
		super(topFrame,string,b);
	}

	public void addstaff(){
		AddStaff instance=this;
		instance.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,30	,30));
		instance.setPreferredSize(SizeDepartemntShop);
		
		JLabel label = new JLabel("Select a Department:");
		label.setFont(font);
		instance.add(label);
		String[] choices = { "Cardiology", "Emergency", "General medicine", "Neurology",
                 "Pediatrics", "Radiology","Surgery" };
		JComboBox<String> menuDepartement = new JComboBox<String>(choices);
		menuDepartement.setFont(font);
		instance.add(menuDepartement);
		
		
		
		JLabel labelStaffType = new JLabel("Select a type of Staff:");
		labelStaffType.setFont(font);
		instance.add(labelStaffType);
		String[] choices1 = { "Doctor", "Nursing Team" };
		JComboBox<String>menuTypeStaff = new JComboBox<String>(choices1);
		menuDepartement.setFont(font);
		menuTypeStaff.setFont(font);
		instance.add(menuTypeStaff);
		
		
		
		
		JLabel labelStaff = new JLabel("Available Staff:");
		labelStaff.setFont(font);
		instance.add(labelStaff);
		String[] choices2 = { "Grade 1", "Grade 2", "Grade 3" };
		JComboBox<String>menuStaff = new JComboBox<String>(choices2);
		menuStaff.setFont(font);
		instance.add(menuStaff);
		
		
		
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(font);
		instance.add(btnFinish);
		

		JButton btnCancel= new JButton("Cancel");
		btnCancel.setFont(font);
		instance.add(btnCancel);
		pack();
		instance.setVisible(true);
	}

}
