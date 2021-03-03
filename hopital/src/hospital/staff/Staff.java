package hospital.staff;

public abstract class Staff {
	private int salary;
	private int experience;
	
	public Staff(int salary,int experience){
		this.salary=salary;
		this.experience=experience;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Staff [Salary=" + salary + ", experience=" + experience + "]";
	}
	
	
}
