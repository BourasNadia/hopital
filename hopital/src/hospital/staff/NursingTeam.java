package hospital.staff;

public class NursingTeam extends Staff{

	private String teamName;

	public NursingTeam(int salary, int experience, String teamName) {
		super(salary, experience);
		this.teamName = teamName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NursingTeam [teamName=" + teamName + "]";
	}

}
