package graphics;

import hospital.Hospital;
import hospital.elements.Credit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		
		
		Button btnSurgery = new Button("Surgery");
		btnSurgery.setFont(font);
		instance.add(btnSurgery);
		btnSurgery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_SRGERY<0) {
					JOptionPane.showMessageDialog(null,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_SRGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
				credit.dicCredit(GameConfiguration.DEP_PRICE_SRGERY);
				hospital.setCredit(credit);
				}
			}
		});
		
		Button btnEmergency = new Button("Emergency");
		btnEmergency.setFont(font);
		instance.add(btnEmergency);
		btnEmergency.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_SRGERY<0) {
					JOptionPane.showMessageDialog(null,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_SRGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
				credit.dicCredit(GameConfiguration.DEP_PRICE_SRGERY);
				hospital.setCredit(credit);
				}
			}
		});
		
		Button btnRadiology = new Button("Radiology");
		btnRadiology.setFont(font);
		instance.add(btnRadiology);
		btnRadiology.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_SRGERY<0) {
					JOptionPane.showMessageDialog(null,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_SRGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
				credit.dicCredit(GameConfiguration.DEP_PRICE_SRGERY);
				hospital.setCredit(credit);
				}
			}
		});
		
		Button btnNeurology= new Button("Neurology");
		btnNeurology.setFont(font);
		instance.add(btnNeurology);
		btnNeurology.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_SRGERY<0) {
					JOptionPane.showMessageDialog(null,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_SRGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
				credit.dicCredit(GameConfiguration.DEP_PRICE_SRGERY);
				hospital.setCredit(credit);
				}
			}
		});
		
		Button btnGeneralMedcine = new Button("General Medcine");
		btnGeneralMedcine.setFont(font);
		instance.add(btnGeneralMedcine);
		btnGeneralMedcine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_SRGERY<0) {
					JOptionPane.showMessageDialog(null,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_SRGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
				credit.dicCredit(GameConfiguration.DEP_PRICE_SRGERY);
				hospital.setCredit(credit);
				}
			}
		});
		
		Button btnPediatrics = new Button("Pediatrics");
		btnPediatrics.setFont(font);
		instance.add(btnPediatrics);
		btnPediatrics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_SRGERY<0) {
					JOptionPane.showMessageDialog(null,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_SRGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
				credit.dicCredit(GameConfiguration.DEP_PRICE_SRGERY);
				hospital.setCredit(credit);
				}
			}
		});
		
		Button btnCardilogy = new Button("Cardilogy");
		btnCardilogy .setFont(font);
		instance.add(btnCardilogy);
		btnCardilogy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Credit credit = new Credit(hospital.getCredit().getValue());
				if ((credit.getValue())-GameConfiguration.DEP_PRICE_SRGERY<0) {
					JOptionPane.showMessageDialog(null,"Sorry, You don't have enough money\n You credit : "+credit.getValue()+"$\nSurgery Price : "+GameConfiguration.DEP_PRICE_SRGERY+"$","Money...!",JOptionPane.WARNING_MESSAGE);
				}else{
				credit.dicCredit(GameConfiguration.DEP_PRICE_SRGERY);
				hospital.setCredit(credit);
				}
			}
		});
		
		instance.add(new JLabel(""));
		instance.add(new JLabel(""));
		
		JPanel footer = new JPanel();
		footer.setPreferredSize(SizeFooteur);
		footer.setLayout(null);
		
		
		
		JButton btnFinish = new JButton("Finish");

		btnFinish.setBounds(0, 60, 85, 40);
		footer.add(btnFinish,BorderLayout.EAST);
		

		JButton btnCancel= new JButton("Cancel");
		btnCancel.setBounds(95, 60,85,40);
		footer.add(btnCancel,BorderLayout.WEST);
		
		instance.add(footer);
		pack();
		instance.setVisible(true);
	}
}
