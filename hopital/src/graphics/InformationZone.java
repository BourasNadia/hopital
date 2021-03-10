package graphics;

import hospital.Hospital;
import hospital.elements.Credit;
import hospital.timer.Timer;
import hospital.timer.CyclicCounter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import config.GameConfiguration;



public class InformationZone extends JPanel implements Runnable{
	private Hospital hospital;
	private Timer time = new Timer();
	private Element element = new Element();
	private final static Dimension SizeInformationZone = new Dimension(GameConfiguration.INFORMATIONZONE_WIDTH, GameConfiguration.INFORMATIONZONE_HEIGHT);
	private JLabel hourLabel = new JLabel(" Hour: 00 ");
	private JLabel minuteLabel = new JLabel("Minute: 00");
	private Font font = new Font(Font.MONOSPACED, Font.ITALIC,25);
	public static int mapEvent = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InformationZone(Hospital hospital){
		this.hospital=hospital;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Timer timer = hospital.getTime();
		element.paint(timer, g);
		
		Credit credit = hospital.getCredit();
		element.paint(credit, g);
		
		
	}
	public void Information(){
		updateValues();
		InformationZone instance = this;
		instance.setLayout(new BorderLayout());
		instance.setBackground(Color.GRAY);
		instance.setPreferredSize(SizeInformationZone);
		hourLabel.setFont(font );
		minuteLabel.setFont(font );
		hourLabel.setForeground(Color.white);
		minuteLabel.setForeground(Color.white);
		instance.add(hourLabel,BorderLayout.WEST);
		instance.add(minuteLabel,BorderLayout.CENTER);
		Button btnmap = new Button("MAP");
		Dimension d = new Dimension(30,60);
		btnmap.setSize(d);
		btnmap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mapEvent = 1 ; 
			}
		});
		instance.add(btnmap,BorderLayout.EAST);
		
		instance.setVisible(true);
	}
	
	private void updateValues() {
		
		CyclicCounter hour = hospital.getTime().getHh();
		hourLabel.setText( " Hour:" +hour.toString()+ " ");
		CyclicCounter minute = hospital.getTime().getMm();
		minuteLabel.setText(" Minute:"+minute.toString() + " ");
	}
	public int getmapEvent(){
		return mapEvent;
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			updateValues();
		}
	}
	

}