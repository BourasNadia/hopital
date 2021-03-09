package hospital.elements;

import hospital.map.Block;

public class Credit {
	private int value ;
	
	public Credit (int value){
		this.value = value;
	}


	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void incCredit(int price){
		value = value + price ; 
	}
	public void dicCredit(int price){
		value = value - price ; 
	}

	
}
