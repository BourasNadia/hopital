package hospital.timer;

public class CyclicCounter extends BoundedCounter{
	public CyclicCounter(int value,int max , int min){
		super(value,max,min);
	}
	public void inc(){
		if(getValue()<getMax()){
			super.inc();
		}else{
			setValue(getMin());
		}
	}
	public void dic(){
		if (getValue()>getMin()){
			super.dic();
		}else{
			setValue(getMax());
		}
	}
	@Override
	public String toString() {
		return Timer.transorm(getValue());
	}
	
}
