package hospital;
import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import hospital.map.Map;
import hospital.elements.Cardiology;
import hospital.elements.Credit;
import hospital.elements.Department;
import hospital.elements.Emergency;
import hospital.elements.GeneralMedcine;
import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Radiology;
import hospital.elements.Reception;
import hospital.elements.Surgery;
import hospital.timer.Timer;
/**
 * cette Classe de traitement elle sera implemanter completement plus tard
 * @author A.Ghezil
 * */
public class Hospital {
	

	private Map map;
	private List<Department> departements = new ArrayList<Department>();
	private Credit credit = new Credit (GameConfiguration.INIT_CREDIT);
	private Timer time;
	private Cardiology cardiology;
	private Reception reception;
	private GeneralMedcine generalMedcine;
	private Pediatrics pediatrics;
	private Surgery surgery;
	private Neurology neurology;
	private Radiology radiology;
	private Emergency emergency;
	public List<Department> getDepartements() {
		return departements;
	}
	public Hospital(Map map,Timer time/*Credit credit*/){
		this.map = map;
		this.time = time;
		/*this.credit = credit;*/
	}
	public Cardiology getCardiology(){
		return cardiology;
	}
	public Reception getReception(){
		return reception;
	}
	public void addDep(Cardiology dep){
		departements.add(dep);
	}
	public void addDep(GeneralMedcine dep){
		departements.add(dep);
	}
	public void addDep(Pediatrics dep){
		departements.add(dep);
	}
	public void addDep(Surgery dep){
		departements.add(dep);
	}
	public void addDep(Neurology dep){
		departements.add(dep);
	}
	public void addDep(Radiology dep) {
		departements.add(dep);
	}
	public void addDep(Emergency dep) {
		departements.add(dep);
	}
		/**
	 * @return the generalMedcine
	 */
	public GeneralMedcine getGeneralMedcine() {
		return generalMedcine;
	}
	/**
	 * @return the pediatrics
	 */
	public Pediatrics getPediatrics() {
		return pediatrics;
	}
	/**
	 * @return the surgery
	 */
	public Surgery getSurgery() {
		return surgery;
	}
	/**
	 * @return the neurology
	 */
	public Neurology getNeurology() {
		return neurology;
	}
	
	public void setDepartements(List<Department> departements) {
		this.departements = departements;
	}
	public void set(Emergency emergency) {
		this.emergency = emergency;
	}
	public void set(Radiology radiology) {
		this.radiology = radiology;
	}
	public void set(GeneralMedcine generalMedcine) {
		this.generalMedcine = generalMedcine;
	}
	public void set(Pediatrics pediatrics) {
		this.pediatrics = pediatrics;
	}
	public void set(Surgery surgery) {
		this.surgery = surgery;
	}
	public void set(Neurology neurology) {
		this.neurology = neurology;
	}
	public void set(Reception reception) {
		this.reception = reception;
	}
	public void set(Cardiology cardiology) {
		this.cardiology = cardiology;
	}
	
	public Credit getCredit() {
		return credit;
	}
	
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	
	public Timer getTime() {
		return time;
	}

	public void setTime(Timer time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "hospital [departements=" + departements + ", credit=" + credit
				+ ", time=" + time + "]";
	}
	

	
	
	
}
