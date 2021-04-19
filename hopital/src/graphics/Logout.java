package graphics;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import hospital.Hospital;
import hospital.elements.Cardiology;
import hospital.elements.Department;
import hospital.map.Map;
import hospital.timer.Timer;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hospital.*;
import config.GameConfiguration;

public class Logout extends JDialog{
	private Hospital hospital; 
	private Map map;
	private Timer time  ;
	
	public Logout(JFrame topFrame, String string,Boolean b,Hospital hospital) {
		super(topFrame,string,b);
		this.hospital=hospital;
	}
	public void logout() throws FileNotFoundException {
		Logout instance=this;
		Operation operation = new Operation(hospital,map,time);
		int rep = JOptionPane.showConfirmDialog(instance, "Do you want to exit the game ?\n youre session well be saved \n", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (rep==JOptionPane.YES_OPTION){
			operation.textSaveDepartement("DataDepartement.csv");
			operation.textSavenInformation("DataInformation.csv");
			System.exit(0) ;
		}
		
	}
	

}
