package graphics;

import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import hospital.Building;
import hospital.Hospital;
import hospital.map.Map;
import hospital.timer.Timer;
import javafx.geometry.Insets;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JTextField;





import javax.swing.border.Border;

import config.GameConfiguration;

public class Main extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map map;
	private Timer time;
	private Hospital hospital;
	private final static Dimension SizeDashboard = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH+200, GameConfiguration.WINDOW_HEIGHT+100);
	private Dashboard dashboard;
	private static InformationZone informationZone ;
	private OperationZone operationZone;
	

	public Main(String title){
		super(title);
		init();
	}
	
	
	private void init(){
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		
		map = Building.buildMap();
		time = new Timer();
		hospital = Building.buildInitMobile(map,time);
		
		dashboard = new Dashboard(map, hospital);
		informationZone = new InformationZone(hospital);
		operationZone = new OperationZone(hospital);

	
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
		}
	}
	public static void main(String[]args){
		Main main= new Main("Hospital Game");
		Thread gameThread = new Thread(main);
		Thread timer = new Thread(informationZone);
		gameThread.start();
		timer.start();
	}
}
