package graphics;

import java.awt.Color;
import java.awt.Graphics;







import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hospital.Hospital;
import hospital.elements.Department;
import hospital.elements.GeneralMedcine;
import hospital.elements.Homme;
import hospital.elements.Money;
import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Reception;
import hospital.map.Block;
import hospital.map.Map;
import hospital.timer.Timer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import config.GameConfiguration;



public class Dashboard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map map;
	private Hospital hospital;
	
	private Element element = new Element();
	
	public Dashboard(Map map,Hospital hospital){
		this.map=map;
		this.hospital=hospital;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Neurology neurology = hospital.getNeurology();
		GeneralMedcine generalMedcine= hospital.getGeneralMedcine();
		Pediatrics pediatrics = hospital.getPediatrics();
		Reception reception = hospital.getReception();
		Timer timer = hospital.getTime();
		ArrayList<Department>departements = (ArrayList<Department>) hospital.getDepartements();
		List<Homme>hommes = (ArrayList<Homme>)hospital.getHommes();
	//	List<Money>moneys = (ArrayList<Money>)hospital.getMoneys();
		
		
		if(InformationZone.mapEvent == 1){
			element.paint(map, g);
		}
		
		if ( departements.size()>=1) {
			for (Homme homme : hommes) {	
				element.paint(homme, g,timer);
			}
		}
		
		
			

		
		
		for (int i = 0; i < departements.size(); i++) {
			//System.out.println(departements.get(i).toString());
			if(departements.get(i).equals(pediatrics)){
				element.paint(pediatrics, g);
				if(hospital.getTime().getHh().getValue()==17 && hospital.getTime().getMm().getValue()==30){
						hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_PEDIATRICS*hospital.getPediatrics().getNb_Patient());
				}
			}
			if(departements.get(i).equals(neurology)){
				element.paint(neurology, g);
				if(hospital.getTime().getHh().getValue()==17 && hospital.getTime().getMm().getValue()==30){
					//Money money = new Money(departements.get(i).getPosition());
					//hospital.add(money);
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_NEUROLOGY*hospital.getNeurology().getNb_Patient());
				}
				
			}
			if(departements.get(i).equals(generalMedcine)){
				element.paint(generalMedcine, g);
				if(hospital.getTime().getHh().getValue()==17 && hospital.getTime().getMm().getValue()==30){
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_GENERALMEDECINE);
			}
			}
			if(departements.get(i).equals(generalMedcine)){
				element.paint(generalMedcine, g);
				if(hospital.getTime().getHh().getValue()==17 && hospital.getTime().getMm().getValue()==30){
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_PEDIATRICS);
			}
			}
			if(departements.get(i).equals(generalMedcine)){
				element.paint(generalMedcine, g);
				if(hospital.getTime().getHh().getValue()==17 && hospital.getTime().getMm().getValue()==30){
					
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_PEDIATRICS);
			}
			}
			if(departements.get(i).equals(generalMedcine)){
				element.paint(generalMedcine, g);
				if(hospital.getTime().getHh().getValue()==17 && hospital.getTime().getMm().getValue()==30){
					hospital.setCredit(hospital.getCredit().getValue()+GameConfiguration.CONSULTATION_PRICE_PEDIATRICS);
			}
			}
			
		}
		Dashboard instance = this;
		instance.setBorder(BorderFactory.createLoweredBevelBorder());
		

		

		
		
		element.paint(reception,g);

		
	}
	
	
}