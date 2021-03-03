package hospital;


import hospital.elements.Reception;
import hospital.map.Block;
import hospital.map.Map;
import hospital.timer.Timer;
import hospital.Hospital;
import config.GameConfiguration;

public class Building {
	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}
	public static Hospital buildInitMobile(Map map,Timer timer) {
		Hospital hospital = new Hospital(map,timer);
		
		intializeReception(map,hospital);
		
		return hospital;
	}
	
	private static void intializeReception(Map map, Hospital hospital) {
		Block block = map.getBlock((GameConfiguration.LINE_COUNT-14)/2,(GameConfiguration.COLUMN_COUNT-10)/2);
		Reception reception	= new Reception(block);
		
		hospital.set(reception);
	}
}
