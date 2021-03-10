package hospital.elements;

import java.util.List;

import hospital.staff.Doctor;
import hospital.staff.NursingTeam;
import hospital.map.Block;

public class Department {
	private Block position;
	private int level;
	private int prise;
	private int nb_Patient ;
	private int size;
	private List<Doctor> doctors ;
	private List<NursingTeam> nursingteams;

	/**
	 * @return the nursingteams
	 */
	public List<NursingTeam> getNursingteams() {
		return nursingteams;
	}

	/**
	 * @param nursingteam the nursingteams to set
	 */
	public void setNursingteams(List<NursingTeam> nursingteams) {
		this.nursingteams = nursingteams;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the prise
	 */
	public int getPrise() {
		return prise;
	}

	/**
	 * @param prise the prise to set
	 */
	public void setPrise(int prise) {
		this.prise = prise;
	}

	/**
	 * @return the nb_Patient
	 */
	public int getNb_Patient() {
		return nb_Patient;
	}

	/**
	 * @param nb_Patient the nb_Patient to set
	 */
	public void setNb_Patient(int nb_Patient) {
		this.nb_Patient = nb_Patient;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the doctors
	 */
	public List<Doctor> getDoctors() {
		return doctors;
	}

	/**
	 * @param doctors the doctors to set
	 */
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Department(Block position) {
		this.position = position;
	}


	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}
}
