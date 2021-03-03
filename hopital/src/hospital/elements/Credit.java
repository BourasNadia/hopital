package hospital.elements;

import hospital.map.Block;

public class Credit {
	private int value ;
	private Block possision;
	
	public Credit (Block possison ,int value){
		this.setPossision(possison);
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Block getPossision() {
		return possision;
	}

	public void setPossision(Block possision) {
		this.possision = possision;
	}
	
}
