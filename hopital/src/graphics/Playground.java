package graphics;

import hospital.Hospital;
import hospital.elements.Credit;
import hospital.elements.Department;
import hospital.elements.Neurology;
import hospital.map.Block;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import config.GameConfiguration;

public class Playground extends JDialog{
	private final static Dimension SizeDepartemntShop = new Dimension(430,300);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	private Hospital hospital;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Playground(JFrame topFrame, String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
		this.hospital = hospital;
	}

	public void addequipments(){
		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		Playground instance=this;
		instance.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,30	,30));
		instance.setPreferredSize(SizeDepartemntShop);
		
		JLabel label = new JLabel("Select a Departemet:");
		label.setFont(font);
		instance.add(label);
		

		List<String> choicesArray =new ArrayList<String>();
		//List<String> LevelArray =new ArrayList<String>();

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
		btnFinish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(menuDepartement.getSelectedItem());
				String y = String.valueOf(menuTypeStaff.getSelectedItem());
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				
				if(x=="Neurology"){
					int level = hospital.getNeurology().getLevel();
					
					switch(y){
					case "Level 1":
						JOptionPane.showMessageDialog(instance,"you can't do this operation","Warning", JOptionPane.WARNING_MESSAGE);
						
						break;
					case "Level 2":
						
						if (level==1 ) {
							if ((credit.getValue())-GameConfiguration.UPDATE_PRICE_NEUROLOGY<0) {
								JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nPrice this update  : "+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
							}else {
								int rep = JOptionPane.showConfirmDialog(instance, "the price of the selected update is : "
										+GameConfiguration.UPDATE_PRICE_NEUROLOGY+"\n"
						
										+ "augmentation of patients nubmer per day : "
										+5+"\n"
										+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
								if (rep==JOptionPane.YES_OPTION){
									credit.dicCredit(GameConfiguration.DEP_PRICE_NEUROLOGY);
									hospital.setCredit(credit);
									
									hospital.getNeurology().setNb_Patient(GameConfiguration.NUMBER_PATIENTS_NEUROLOGY+5);

									hospital.getNeurology().setLevel(2);
								}
							}
							
							
							
						}
						break;
					case "Level 3":
						if (level==1 ||level==2 ) {
							hospital.getNeurology().setLevel(3);
						}else{
							JOptionPane.showMessageDialog(instance,"you can not update this department","Warning", JOptionPane.WARNING_MESSAGE);
							
						}
						break;
					}
				}else{
					JOptionPane.showMessageDialog(instance,y,"Warning", JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		instance.add(btnFinish);
		

		JButton btnCancel= new JButton("Cancel");
		btnCancel.setFont(font);
		instance.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int level = hospital.getNeurology().getLevel();
				JOptionPane.showMessageDialog(instance,level,"Warning", JOptionPane.WARNING_MESSAGE);
				
				
			}
		});
		pack();
		if(choicesArray.isEmpty()){
			JOptionPane.showMessageDialog(instance,"you shoud have a depertement to add Equipments in","Warning", JOptionPane.WARNING_MESSAGE);
			instance.setVisible(false);
		}else{
			instance.setVisible(true);
		}
	}
}
