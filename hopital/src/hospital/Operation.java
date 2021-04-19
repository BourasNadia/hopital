package hospital;

import hospital.elements.Credit;
import hospital.elements.Department;
import hospital.elements.Neurology;
import hospital.map.Block;
import hospital.map.Map;
import hospital.timer.Timer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import config.GameConfiguration;




public class Operation {
	private String SEPARATOR = GameConfiguration.SEPARETOR;
	private Hospital hospital;
	private Map map;
	private Timer time;
	
	public Operation(Hospital hospital,Map map,Timer time){
		this.hospital =hospital;
		this.map = map;
		this.time = time;
	}
	
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	public void textSaveDepartement(String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for (Department department  : hospital.getDepartements()) {
				writer.write(department.getName() + SEPARATOR + department.getLevel()+ SEPARATOR + department.getPosition());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	public void textSavenInformation(String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(""+hospital.getHeight()+SEPARATOR+hospital.getWidth()+SEPARATOR+hospital.getTime().getHh().toString()+SEPARATOR+hospital.getTime().getMm().toString()+SEPARATOR+hospital.getCredit().toString());
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	public void textReadDepartement(String fileName) {
		String line, fields[];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				
				fields = line.split(SEPARATOR);
				int l = Integer.parseInt(fields[2]);  
				int Colm= Integer.parseInt(fields[3]);  
				int level = Integer.parseInt(fields[1]);
				switch (fields[0]) {
				case "neurology":
					Neurology neurology = new Neurology(new Block(l,Colm)) ;
					neurology.setPrise(GameConfiguration.DEP_PRICE_NEUROLOGY);
					neurology.setLevel(level);
					neurology.setNb_Patient(GameConfiguration.NUMBER_PATIENTS_NEUROLOGY);
					neurology.setName("neurology");
					hospital.set(neurology);
					hospital.addDep(neurology);
					break;

				default:
					break;
				}
				//Department departement = new Department(fields[0], fields[1], fields[2]);
				//hospital.addDep(departement);
			}
			reader.close();
		//} catch (ContactAlreadyExistsException e) {
			//System.err.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	
	public Hospital textReadInformation(String fileName) {
		String line, fields[];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				
				fields = line.split(SEPARATOR);
				int height = Integer.parseInt(fields[0]);  
				int width= Integer.parseInt(fields[1]);  
				int hh = Integer.parseInt(fields[2]);
				int mm = Integer.parseInt(fields[3]);
				int credit = Integer.parseInt(fields[4]);
				time.setHh(hh);
				time.setMm(mm);
				
				hospital = Building.buildInitMobile(map,height,width,time,credit);
				
			}
			reader.close();
		//} catch (ContactAlreadyExistsException e) {
			//System.err.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return hospital;
	}

	
	
	
	
}
