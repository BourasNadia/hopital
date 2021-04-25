package test.unit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hospital.Building;
import hospital.Hospital;
import hospital.Operation;
import hospital.elements.Department;
import hospital.elements.Neurology;
import hospital.elements.Reception;
import hospital.elements.Surgery;
import hospital.map.Map;
import hospital.timer.Timer;

import org.junit.Before;
import org.junit.Test;



/**
 * Unit test of Bulding a Hospital from a csv file
 * Each department and each Operation is verified
 * @author Ghezil.A
 *
 */
public class testHospital {
	private Hospital hospital;
	private Map map;
	private Timer time;
	
	@Before
	public void prepareTree() throws NumberFormatException, IOException {
		map = Building.buildMap();
		time = new Timer();
		Operation operation = new Operation(hospital,map,time);
		hospital = operation.textReadInformation("src/test/unit/DataInformation2.csv");
		operation.textReadDepartement("src/test/unit/DataDepartement2.csv");
	}

	@Test
	public void testUpdatePlayground(){
		hospital.UpdatePlayground();
		assertEquals(500, hospital.getCredit().getValue());
		assertEquals(27,hospital.getWidth());
		assertEquals(37, hospital.getHeight());
	}
	/**
	 * test building departement from a .csv file 
	 */
	@Test
	public void testBuildingDepartement(){
		List<Department> departements = hospital.getDepartements();
		int numberOfDepartements = departements.size();
		assertEquals(8, numberOfDepartements);
		
		assertTrue(departements.get(0) instanceof Reception);
		assertTrue(departements.get(1) instanceof Neurology);
		assertTrue(departements.get(7) instanceof Surgery);
	}
	@Test
	public void AddingEquipment(){
		
	}

}
