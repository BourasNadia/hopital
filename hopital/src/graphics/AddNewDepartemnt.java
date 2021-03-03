package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import config.GameConfiguration;

import javax.swing.JButton;


public class AddNewDepartemnt extends JDialog{
	
	private final static Dimension SizeDepartemntShop = new Dimension(GameConfiguration.DEPPARTEMENT_SHOP_WIDTH, GameConfiguration.DEPPARTEMENT_SHOP_HEIGHT);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD,17);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AddNewDepartemnt(JFrame topFrame, String string,Boolean b) {
		super(topFrame,string,b);
	}

	public void addDepartemnt(){
		AddNewDepartemnt instance=this;
		instance.getContentPane().setLayout(new GridLayout(5,2));
		instance.setPreferredSize(SizeDepartemntShop);

		
		Button btnSurgery = new Button("Surgery");
		btnSurgery.setFont(font);
		instance.add(btnSurgery);
		
		Button btnEmergency = new Button("Emergency");
		btnEmergency.setFont(font);
		instance.add(btnEmergency);
		
		Button btnRadiology = new Button("Radiology");
		btnRadiology.setFont(font);
		instance.add(btnRadiology);
		
		Button btnNeurology= new Button("Neurology");
		btnNeurology.setFont(font);
		instance.add(btnNeurology);
		
		Button btnGeneralMedcine = new Button("General Medcine");
		btnGeneralMedcine.setFont(font);
		instance.add(btnGeneralMedcine);
		
		Button btnPediatrics = new Button("Pediatrics");
		btnPediatrics.setFont(font);
		instance.add(btnPediatrics);
		
		Button btnCardilogy = new Button("Cardilogy");
		btnCardilogy .setFont(font);
		instance.add(btnCardilogy);
		
		instance.add(new JLabel(""));
		
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
