package graphics;

import hospital.Hospital;
import hospital.elements.Department;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddEquipments extends JDialog{
	private final static Dimension SizeDepartemntShop = new Dimension(430,300);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	private Hospital hospital;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AddEquipments(JFrame topFrame, String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
		this.hospital = hospital;
	}

	public void addequipments(){
		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		AddEquipments instance=this;
		instance.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,30	,30));
		instance.setPreferredSize(SizeDepartemntShop);
		
		JLabel label = new JLabel("Select a Departemet:");
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
		if(choicesArray.isEmpty()){
			JOptionPane.showMessageDialog(instance,"you shoud have a depertement to add Equipments in","Warning", JOptionPane.WARNING_MESSAGE);
			instance.setVisible(false);
		}else{
			instance.setVisible(true);
		}
	}
}
