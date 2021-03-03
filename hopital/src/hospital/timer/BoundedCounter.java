package hospital.timer;

public class BoundedCounter extends Counter {
	
	private int max ;
	private int min ;
	
	public BoundedCounter(int value , int max ,int min) {
		super(value);
		this.max = max;
		this.min = min ;
	}
	
	public void inc(){
		if(getValue() < max){
			super.inc();
		}
	}
	
	public void dic(){
		if(getValue() < max ){
			super.dic();
		}
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
}
