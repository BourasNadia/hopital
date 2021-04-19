package graphics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import  java.awt.Image;
import java.io.File;
import java.net.URL;











import hospital.Audio;
import hospital.Building;
import hospital.Hospital;
import hospital.Operation;
import hospital.map.Map;
import hospital.timer.Timer;



import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import javax.swing.JTextField;





import javax.swing.JOptionPane;























import config.GameConfiguration;

public class Main extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map map;
	private Timer time;
	private static Image icon = Toolkit.getDefaultToolkit().getImage("./src/config/icon.png");  
	private ImageIcon icon2 = new ImageIcon("./src/config/icon.png"); 
	private Hospital hospital;
	private final static Dimension SizeDashboard = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH+200, GameConfiguration.WINDOW_HEIGHT+100);
	private Dashboard dashboard;
	private static InformationZone informationZone ;
	private OperationZone operationZone;
	private Audio audio = new Audio();
	//private static URL url = getClass().getResource("./src/config/main-title.mp3");
	private Main main= this;
	

	public Main(String title){
		super(title);
		init();
		
	}
	
	
	private void init(){
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		JFrame frame = new JFrame();
	    java.awt.Image icon = Toolkit.getDefaultToolkit().getImage("./GameConfiguration/icon.png");  
	    frame.setIconImage(icon);  
	    frame.setLayout(null);   
	    frame.setSize(200,200);   
	    frame.setVisible(true);*
	    */
	    
		
		map = Building.buildMap();
		time = new Timer();
		
		
		JOptionPane d = new JOptionPane(); 
		// les textes figurant // sur les boutons 
		String lesTextes[]={ "Create a new Session", "Continue on the last session"}; 
		// indice du bouton qui a été // cliqué ou CLOSED_OPTION
		int retour = d.showOptionDialog(this, "Welcom in Your Hospital Game\n"
				+ "Do you want to : Open the last session or ", "Session",  JOptionPane.DEFAULT_OPTION,  JOptionPane.CLOSED_OPTION, 
				 (Icon) icon2,
				lesTextes,lesTextes[0]); 
				if( retour!=JOptionPane.CLOSED_OPTION){
					if( retour == 0){
						hospital = Building.buildInitMobile(map,time);
					}else if(retour==1){
						Operation operation = new Operation(hospital,map,time);
						hospital = operation.textReadInformation("DataInformation.csv");
						operation.textReadDepartement("DataDepartement.csv");
					}
				} ;
		// un bouton cliqué
		//else // pas de bouton cliqué
		
		
		
		//d.showOptionDialog(parentComponent, message, title, JOptionPane.QUESTION_MESSAGE, JOptionPane.CLOSED_OPTION, icon, options, initialValue)
				try {
					//Group root = new Group();
					//Scene scene = new Scene(root,400,400);
					
					//MediaPlayer mP = new MediaPlayer(aC);
					//mP.setAutoPlay(true);
					//mP.play();
					audio.getaCHosto().play();
					//audio.getaCClic().play();
					
					//MediaView mV = new MediaView(mP);
					
					//root.getChildren().add(mV);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		dashboard = new Dashboard(map, hospital);
		informationZone = new InformationZone(hospital);
		operationZone = new OperationZone(hospital,this);

	
		informationZone.Information();
		contentPane.add(informationZone,BorderLayout.NORTH);
		
		dashboard.setPreferredSize(SizeDashboard);
		contentPane.add(dashboard, BorderLayout.CENTER);

		
		
		operationZone.operation();
		contentPane.add(operationZone,BorderLayout.EAST);
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}
	private Icon icon(URL resource) {
		// TODO Auto-generated method stub
		return null;
	}


	public Main getMain(){
		return main;
	}
	@Override
	public void run() {	
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED );
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			time.inc();
			informationZone.repaint();	
			dashboard.repaint();
			//hospital.generateHommes();
			hospital.nextRound();
		}
	}
	public static void main(String[]args){
		Main main= new Main("Hospital Game");
		
		main.setIconImage(icon);  
		main.setVisible(true);
		
		Thread gameThread = new Thread(main);
		Thread timer = new Thread(informationZone);
		gameThread.start();
		timer.start();
	}
}
