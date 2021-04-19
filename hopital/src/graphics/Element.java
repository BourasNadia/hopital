package graphics;

import hospital.Hospital;
import hospital.elements.Credit;
import hospital.elements.Department;
import hospital.elements.GeneralMedcine;
import hospital.elements.Homme;
import hospital.elements.Money;
import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Reception;
import hospital.map.Block;
import hospital.map.Map;
import hospital.timer.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import config.GameConfiguration;

public class Element {
	private Pediatrics pediatrics = null;
	private BufferedImage img ;
	//private Hospital hospital;
	
	
	
	public void paint(Map map, Graphics graphics ,Hospital hospital) {
		int height = hospital.getHeight();
		int width = hospital.getWidth();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int x = ((60 - width)/2)*blockSize;
		int y = ((40 - height)/2)*blockSize;
		Block[][] blocks = map.getBlocks();
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if ((lineIndex + columnIndex) % 2 == 0) {
					graphics.setColor(new Color(200, 200,200));
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
					graphics.setColor(Color.RED);
					graphics.drawRect(x, y,width*blockSize, height*blockSize);
				}
			}
		}
	}

	public void paint(Reception reception,Graphics graphics) {
		Block position = reception.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLine();
		int x = position.getColumn()+2;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/logo_hopital.png") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*14,blockSize*11, null);
	}
	
	public void paint(Credit credit,Graphics graphics){
		int y = 40;
		int x = 650;
		graphics.setColor(Color.WHITE);
		graphics.fillRoundRect(x, y, 300, 30, 10, 10);
		graphics.setColor(Color.green);
		//int width = *(50/600);
		graphics.fillRoundRect(x, y, credit.getValue()/10, 30, 10, 10);
	}
	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}
	public void paint(Timer timer,Graphics graphics){
		int y = 35;
		int x = 3;
		graphics.setColor(Color.RED);
		graphics.fillRoundRect(x, y, 300, 35, 10, 10);
		
	}

	
	
	
	public void paint(Homme homme, Graphics graphics,Timer timer) {
		
		Block position = homme.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		
		int y = position.getLine();
		int x = position.getColumn();
		int rand =getRandomNumber(0,1);
		
		
		
		try {
			if(rand==0){
				img = ImageIO.read(getClass().getResourceAsStream("/config/homme.png") );	
			}else{
				img = ImageIO.read(getClass().getResourceAsStream("/config/homme1.png") );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*4,blockSize*3, null);
		
		//graphics.setColor(Color.RED);
		
	}
	
/*	public void paint(Money money, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block position = money.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/neurology.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*10,blockSize*13, null);
	}
	
	*/
	
	public void paint(Neurology neurology, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block position = neurology.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/neurology.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*10,blockSize*13, null);
	}
	
	public void paint(Pediatrics pediatrics, Graphics graphics) {
		Block position = pediatrics.getPosition();
		int y =position.getLine();
		int x = position.getColumn();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/Pediatry.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*10,blockSize*13, null);
	}

	
	
	public void paint(GeneralMedcine generalMedcine, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = 24;
		int x = 18;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/GeneralMedcine.jpg") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*22,blockSize*15, null);
	}

	public void paint(Department department, Graphics g) {
		
	}

	

	
}
