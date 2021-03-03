package hospital.staff;
import java.util.*;;
public class Doctor extends Staff {
	
	
	private String name;
	private HashMap<String,Patient> patiens;
	private String speciality ;


	public Doctor(int salary, int experience, String name,
			HashMap<String, Patient> patiens, String speciality) {
		super(salary, experience);
		this.name = name;
		this.patiens = patiens;
		this.speciality = speciality;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the patiens
	 */
	public HashMap<String, Patient> getPatiens() {
		return patiens;
	}

	/**
	 * @param patiens the patiens to set
	 */
	public void setPatiens(HashMap<String, Patient> patiens) {
		this.patiens = patiens;
	}

	/**
	 * @return the speciality
	 */
	public String getSpeciality() {
		return speciality;
	}

	/**
	 * @param speciality the speciality to set
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Doctor [name=" + name + ", patiens=" + patiens
				+ ", speciality=" + speciality + "]";
	}
}
