package graphics;

import hospital.Hospital;
import hospital.elements.Cardiology;
import hospital.elements.Credit;
import hospital.elements.Department;
import hospital.elements.Emergency;
import hospital.elements.GeneralMedcine;
import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Radiology;
import hospital.map.Block;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import config.GameConfiguration;

import javax.swing.JButton;


public class AddNewDepartemnt extends JDialog{
	private Hospital hospital ;
	private final static Dimension SizeDepartemntShop = new Dimension(GameConfiguration.DEPPARTEMENT_SHOP_WIDTH, GameConfiguration.DEPPARTEMENT_SHOP_HEIGHT);
	private final static Dimension SizeFooteur = new Dimension(400, 100);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AddNewDepartemnt(JFrame topFrame, String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
		this.hospital=hospital;
	}

	public void addDepartemnt(){
		AddNewDepartemnt instance=this;
		instance.getContentPane().setLayout(new GridLayout(5,2));
		instance.setPreferredSize(SizeDepartemntShop);

		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
		
		
		
		Button btnSurgery = new Button("Surgery");
		btnSurgery.setFont(font);
		instance.add(btnSurgery);
		btnSurgery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_SRGERY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_SRGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int rep = JOptionPane.showConfirmDialog(instance, "the price of the SRGERY department is : "
							+GameConfiguration.DEP_PRICE_SRGERY+"\n"
							+ "his sizes : 13x17 \n"
							+ "number of patients per day : "
							+GameConfiguration.NUMBER_PATIENTS_SRGERY+"\n"
							+ "consultation price : "
							+GameConfiguration.CONSULTATION_PRICE_SRGERY +"\n"
							+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (rep==JOptionPane.YES_OPTION){
						credit.dicCredit(GameConfiguration.DEP_PRICE_SRGERY);
						hospital.setCredit(credit);
					}
				}
			}
		});
		
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/	
		
		
		Button btnEmergency = new Button("Emergency");
		btnEmergency.setFont(font);
		instance.add(btnEmergency);
		btnEmergency.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_EMERGENCY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "
							+credit.getValue()+"$\nEMERGENCY Price : "
							+GameConfiguration.DEP_PRICE_EMERGENCY+
							"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int rep = JOptionPane.showConfirmDialog(instance, "the price of the EMERGENCY department is : "
							+GameConfiguration.DEP_PRICE_EMERGENCY+"\n"
							+ "his sizes : 15x11 \n"
							+ "number of patients per day : "
							+GameConfiguration.NUMBER_PATIENTS_EMERGENCY+"\n"
							+ "consultation price : "
							+GameConfiguration.CONSULTATION_PRICE_EMERGENCY +"\n"
							+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (rep==JOptionPane.YES_OPTION){
						credit.dicCredit(GameConfiguration.DEP_PRICE_EMERGENCY);
						hospital.setCredit(credit);
						Emergency emergency = new Emergency(new Block(5,5)) ;
						hospital.set(emergency);
						hospital.addDep(emergency);
					}
				}
			}
		});
		
		
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
		
		Button btnRadiology = new Button("Radiology");
		btnRadiology.setFont(font);
		instance.add(btnRadiology);
		btnRadiology.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_RADIOLOGY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nRADIOLOGY Price : "+GameConfiguration.DEP_PRICE_RADIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int rep = JOptionPane.showConfirmDialog(instance, "the price of the RADIOLOGY department is : "
							+GameConfiguration.DEP_PRICE_RADIOLOGY+"\n"
							+ "his sizes : 15x15 \n"
							+ "number of patients per day : "
							+GameConfiguration.NUMBER_PATIENTS_RADIOLOGY+"\n"
							+ "consultation price : "
							+GameConfiguration.CONSULTATION_PRICE_RADIOLOGY +"\n"
							+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (rep==JOptionPane.YES_OPTION){
					credit.dicCredit(GameConfiguration.DEP_PRICE_RADIOLOGY);
					hospital.setCredit(credit);
					Radiology radiology = new Radiology(new Block(5,5)) ;
					hospital.set(radiology);
					hospital.addDep(radiology);
					}
				}
			}
		});
		
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
		Button btnNeurology= new Button("Neurology");
		btnNeurology.setFont(font);
		instance.add(btnNeurology);
		btnNeurology.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_NEUROLOGY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nNEUROLOGY Price : "+GameConfiguration.DEP_PRICE_NEUROLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
					int tmp =0;
					for (int i = 0; i < departements.size(); i++) {
						if(departements.get(i).equals(hospital.getNeurology())){
							JOptionPane.showMessageDialog(instance,"you alredy have a neurology departements","Warning", JOptionPane.WARNING_MESSAGE);
							tmp=1;
						}
					}
					if(tmp==0){					
						int rep = JOptionPane.showConfirmDialog(instance, "the price of the NEUROLOGY department is : "
								+GameConfiguration.DEP_PRICE_NEUROLOGY+"\n"
								+ "his sizes : 10x13 \n"
								+ "number of patients per day : "
								+GameConfiguration.NUMBER_PATIENTS_NEUROLOGY+"\n"
								+ "consultation price : "
								+GameConfiguration.CONSULTATION_PRICE_NEUROLOGY +"\n"
								+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if (rep==JOptionPane.YES_OPTION){
							credit.dicCredit(GameConfiguration.DEP_PRICE_NEUROLOGY);
							hospital.setCredit(credit);
							Neurology neurology = new Neurology(new Block(5,5)) ;
							hospital.set(neurology);
							hospital.addDep(neurology);
						}
					}
				}
			}
		});
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
		
		
		
		Button btnGeneralMedcine = new Button("General Medcine");
		btnGeneralMedcine.setFont(font);
		instance.add(btnGeneralMedcine);
		btnGeneralMedcine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_GENERALMEDECINE<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nGeneral Medcine Price : "+GameConfiguration.DEP_PRICE_GENERALMEDECINE+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
			int rep=		JOptionPane.showConfirmDialog(instance, "the price of the GENERAL MEDECINE department is : "
							+GameConfiguration.DEP_PRICE_GENERALMEDECINE+"\n"
							+ "his sizes : 13x10 \n"
							+ "number of patients per day : "
							+GameConfiguration.NUMBER_PATIENTS_GENERALMEDECINE+"\n"
							+ "consultation price : "
							+GameConfiguration.CONSULTATION_PRICE_GENERALMEDECINE +"\n"
							+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (rep==JOptionPane.YES_OPTION){		
					if(hospital.getGeneralMedcine().equals(null)){
						credit.dicCredit(GameConfiguration.DEP_PRICE_GENERALMEDECINE);
						hospital.setCredit(credit);
						GeneralMedcine generalMedcine = new GeneralMedcine(new Block(5,5)) ;
						hospital.set(generalMedcine);
						hospital.addDep(generalMedcine);
					}
					
				}	
			}
			}
		});
		
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/	
		
		Button btnPediatrics = new Button("Pediatrics");
		btnPediatrics.setFont(font);
		instance.add(btnPediatrics);
		btnPediatrics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_PEDIATRICS<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n"
							+ " You credit : "
							+credit.getValue()
							+"$\nPediatrics Price : "
							+GameConfiguration.DEP_PRICE_PEDIATRICS
							+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
						int rep=JOptionPane.showConfirmDialog(instance, "the price of the PEDIATRICS department is : "
							+GameConfiguration.DEP_PRICE_PEDIATRICS+"\n"
							+ "his sizes : 13x10 \n"
							+ "number of patients per day : "
							+GameConfiguration.NUMBER_PATIENTS_PEDIATRICS+"\n"
							+ "consultation price : "
							+GameConfiguration.CONSULTATION_PRICE_PEDIATRICS +"\n"
							+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (rep==JOptionPane.YES_OPTION){		
			credit.dicCredit(GameConfiguration.DEP_PRICE_PEDIATRICS);
					hospital.setCredit(credit);
					Pediatrics pediatrics = new Pediatrics(new Block(5,5)) ;
					hospital.set(pediatrics);
					hospital.addDep(pediatrics);
				}
			}
			}
		});
		
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
		
		Button btnCardilogy = new Button("Cardiology");
		btnCardilogy .setFont(font);
		instance.add(btnCardilogy);
		btnCardilogy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_CARDIOLOGY<0) {
					JOptionPane.showMessageDialog(instance,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_CARDIOLOGY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
			int rep =		JOptionPane.showConfirmDialog(instance, "the price of the CARDIOLOGY department is : "
							+GameConfiguration.DEP_PRICE_CARDIOLOGY+"\n"
							+ "his sizes : 13x10 \n"
							+ "number of patients per day : "
							+GameConfiguration.NUMBER_PATIENTS_CARDIOLOGY+"\n"
							+ "consultation price : "
							+GameConfiguration.CONSULTATION_PRICE_CARDIOLOGY +"\n"
							+ "do you want to confirm your purchase ?\n", "confirm the purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (rep==JOptionPane.YES_OPTION){		
			credit.dicCredit(GameConfiguration.DEP_PRICE_CARDIOLOGY);
					hospital.setCredit(credit);
					Cardiology cardiology = new Cardiology(new Block(5,5)) ;
					hospital.set(cardiology);
					hospital.addDep(cardiology);
				}}
			}
		});
		
/*-----------------------------------------------------------------------------------------------*/		
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/		
		instance.add(new JLabel(""));
		instance.add(new JLabel(""));
		
		JPanel footer = new JPanel();
		footer.setPreferredSize(SizeFooteur);
		footer.setLayout(null);
		
		
		
		JButton btnFinish = new JButton("Finish");

		btnFinish.setBounds(0, 60, 85, 40);
		btnFinish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				
			}
		});
		footer.add(btnFinish,BorderLayout.EAST);
		

		JButton btnCancel= new JButton("Cancel");
		btnCancel.setBounds(95, 60,85,40);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				
			}
		});
		footer.add(btnCancel,BorderLayout.WEST);
		
		instance.add(footer);
		pack();
		instance.setVisible(true);
	}
}
