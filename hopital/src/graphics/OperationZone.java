package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import hospital.Hospital;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import config.GameConfiguration;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperationZone extends JPanel {
	private Hospital hospital;
	private final static Dimension SizeOperationZone = new Dimension(GameConfiguration.OPERATIONZONE_WIDTH, GameConfiguration.OPERATIONZONE_HEIGHT);
	private Font font1 = new Font(Font.MONOSPACED, Font.BOLD,17);
	private Font font2 = new Font(Font.MONOSPACED, Font.BOLD,25);
	private	AddNewDepartemnt addNewDepartemnt;
	private	AddStaff addStaff;
	private AddEquipments addEquipments;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OperationZone(Hospital hospital){
		this.hospital=hospital;
	}
	public void operation(){
		OperationZone instance = this;
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(instance);
		instance.setPreferredSize(SizeOperationZone);
		instance.setBackground(Color.gray);
		instance.setLayout(new GridLayout(5,1) );
		
		Button btnaddDepartments = new Button("Add Departements");
		btnaddDepartments.setFont(font1);
		instance.add(btnaddDepartments);
		btnaddDepartments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewDepartemnt = new AddNewDepartemnt(topFrame,"Add a new Departement for your hospital",true);
				addNewDepartemnt.addDepartemnt();
			}
		});
		
		Button btnaddStaff = new Button("Add Staff");
		btnaddStaff.setFont(font1);
		instance.add(btnaddStaff);
		btnaddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStaff = new AddStaff(topFrame,"Staffing Shop",true);
				addStaff.addstaff();
			}
		});
		
		
		
		Button btnaddEquipments= new Button("Add Equipments");
		btnaddEquipments.setFont(font1);
		instance.add(btnaddEquipments);
		btnaddEquipments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEquipments = new AddEquipments(topFrame,"Equipment Shop",true);
				addEquipments.addequipments();
			}
		});
		
		Button btnSave = new Button("Save");
		btnSave.setFont(font2);
		instance.add(btnSave);
		
		Button btnlogout = new Button("Logout");
		btnlogout.setFont(font2);
		instance.add(btnlogout);
		
	}
}
