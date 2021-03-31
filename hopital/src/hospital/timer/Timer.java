package hospital.timer;

import hospital.timer.CyclicCounter;

public class Timer {

	private CyclicCounter mm = new CyclicCounter(35, 39, 30);
	private CyclicCounter hh = new CyclicCounter(17, 17, 17);
	
	public void inc() {
		mm.inc();
		if (mm.getValue() == 0) {
			hh.inc();
		}
	}
	
	
	

	public void dic() {
		mm.dic();
		if (mm.getValue()==0) {
			hh.dic();
		}
		
	}

	
	public CyclicCounter getMm() {
		return mm;
	}

	public CyclicCounter getHh() {
		return hh;
	}
	
	public String toString(){
		return hh.toString() + " : "+ mm.toString() ; 
	}
	
	public static String transorm(int value){
		String tmp = "";
		if (value<10){
			tmp = "0"+value ;
		}else{
			tmp = ""+value ;
		}
		return tmp ;
	}
	public void init(){
		hh.setValue(0);
		mm.setValue(0);
	}
}
