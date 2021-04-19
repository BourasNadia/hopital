package hospital.timer;


public class Counter {
	public int value ;
	
	public Counter(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void inc(){
		value++;
	}
	public void dic(){
		value--;
	}
	

	@Override
	public String toString() {
		return "Counter [value=" + value + "]";
	}
	
}
