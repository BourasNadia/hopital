package hospital;

import java.io.File;

import javafx.scene.media.AudioClip;

public class Audio {
	private AudioClip aCClic = new AudioClip( new File("./src/config/clic.wav").toURI().toString());
	private AudioClip aCHosto = new AudioClip( new File("./src/config/main-sond.mp3").toURI().toString());
	
	public Audio(){
		aCHosto.setVolume(0.1);
	}
	/**
	 * @return the aCClic
	 */
	public AudioClip getaCClic() {
		return aCClic;
	}

	/**
	 * @param aCClic the aCClic to set
	 */
	public void setaCClic(AudioClip aCClic) {
		this.aCClic = aCClic;
	}

	/**
	 * @return the aCHosto
	 */
	public AudioClip getaCHosto() {
		return aCHosto;
	}

	/**
	 * @param aCHosto the aCHosto to set
	 */
	public void setaCHosto(AudioClip aCHosto) {
		this.aCHosto = aCHosto;
	}

	

}
