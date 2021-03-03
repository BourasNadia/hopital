package hospital.staff;

public class Patient {
	private String numberAlpha;
	private String patology;
	/**
	 * @return the numberAlpha
	 */
	public String getNumberAlpha() {
		return numberAlpha;
	}
	/**
	 * @param numberAlpha the numberAlpha to set
	 */
	public void setNumberAlpha(String numberAlpha) {
		this.numberAlpha = numberAlpha;
	}
	/**
	 * @return the patology
	 */
	public String getPatology() {
		return patology;
	}
	/**
	 * @param patology the patology to set
	 */
	public void setPatology(String patology) {
		this.patology = patology;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Patient [numberAlpha=" + numberAlpha + ", patology=" + patology
				+ "]";
	}
	
}
