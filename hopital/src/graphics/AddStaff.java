package graphics;

import hospital.Hospital;
import hospital.elements.Department;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;





import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import config.GameConfiguration;


public class AddStaff extends JDialog{
	private Hospital hospital ;
	private final static Dimension SizeDepartemntShop = new Dimension(270,540);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AddStaff(JFrame topFrame,String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
		this.hospital = hospital;
	}

	public void addstaff(){
		AddStaff instance=this;
		instance.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,30	,30));
		instance.setPreferredSize(SizeDepartemntShop);
		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		
		JLabel label = new JLabel("Select a Department:");
		label.setFont(font);
		instance.add(label);
		

		List<String> choicesArray =new ArrayList<String>();
		

		for (int i = 0; i < departements.size(); i++) {
			//System.out.println(departements.get(i).toString());
			if(departements.get(i).equals(hospital.getNeurology())){
				choicesArray.add("Neurology");
			}
			if(departements.get(i).equals(hospital.getPediatrics())){
				choicesArray.add("Pediatrics");
			}
			
		}
		
		
		
		
		String[] choices =  choicesArray.toArray(new String[0]);
		
		JComboBox<String> menuDepartement = new JComboBox<String>( choices);
		
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
		
		if(choicesArray.isEmpty()){
			JOptionPane.showMessageDialog(instance,"you shoud have a depertement to add staff in","Warning", JOptionPane.WARNING_MESSAGE);
			instance.setVisible(false);
		}else{
			instance.setVisible(true);
		}
	}

}
