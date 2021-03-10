package graphics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddEquipments extends JDialog{
	private final static Dimension SizeDepartemntShop = new Dimension(430,300);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AddEquipments(JFrame topFrame, String string,Boolean b) {
		super(topFrame,string,b);
	}

	public void addequipments(){
		AddEquipments instance=this;
		instance.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,30	,30));
		instance.setPreferredSize(SizeDepartemntShop);
		
		JLabel label = new JLabel("Select a Departemet:");
		label.setFont(font);
		instance.add(label);
		String[] choices = {"Cardiology", "Emergency", "General medicine", "Neurology",
                "Pediatrics", "Radiology","Surgery" };
		JComboBox<String> menuDepartement = new JComboBox<String>(choices);
		menuDepartement.setFont(font);
		instance.add(menuDepartement);
		
		
		
		JLabel labelUpdate = new JLabel("Update the departement:");
		labelUpdate.setFont(font);
		instance.add(labelUpdate);
		String[] choices1 = { "Level 1", "Level 2", "Level 3" };
		JComboBox<String>menuTypeStaff = new JComboBox<String>(choices1);
		menuDepartement.setFont(font);
		menuTypeStaff.setFont(font);
		instance.add(menuTypeStaff);
		

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
