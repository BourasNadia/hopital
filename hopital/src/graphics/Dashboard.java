package graphics;

import java.awt.Graphics;





import hospital.Hospital;
import hospital.elements.Cardiology;
import hospital.elements.GeneralMedcine;
import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Reception;
import hospital.map.Map;

import javax.swing.JPanel;


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

		element.paint(map, g);

		Neurology neurology = hospital.getNeurology();
		element.paint(neurology, g);
		
		GeneralMedcine generalMedcine= hospital.getGeneralMedcine();
		element.paint(generalMedcine, g);
		
		Pediatrics pediatrics = hospital.getPediatrics();
		element.paint(pediatrics, g);
		
		Reception reception = hospital.getReception();
		element.paint(reception,g);

		
	}
	
	
}