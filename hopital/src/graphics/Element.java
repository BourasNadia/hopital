package graphics;

import hospital.elements.Credit;
import hospital.elements.Department;
import hospital.elements.GeneralMedcine;
import hospital.elements.Neurology;
import hospital.elements.Pediatrics;
import hospital.elements.Reception;
import hospital.map.Block;
import hospital.map.Map;
import hospital.timer.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import config.GameConfiguration;


public class Element {
	private Pediatrics pediatrics = null;
	private BufferedImage img ;
	
	public void paint(Map map, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if ((lineIndex + columnIndex) % 2 == 0) {
					graphics.setColor(Color.GRAY);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
				}
			}
		}
	}

	public void paint(Reception reception,Graphics graphics) {
		Block position = reception.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = position.getLine()-2;
		int x = position.getColumn();
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/logo_hopital.png") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*14,blockSize*11, Color.LIGHT_GRAY, null);
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
	public void paint(Timer timer,Graphics graphics){
		int y = 35;
		int x = 3;
		graphics.setColor(Color.RED);
		graphics.fillRoundRect(x, y, 300, 35, 10, 10);
		
	}
	public void paint(Neurology neurology, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = 0;
		int x = 0;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/neurology.jpg") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*10,blockSize*13, Color.LIGHT_GRAY, null);
	}
	
	public void paint(Pediatrics pediatrics, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int y = 15;
		int x = 0;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/config/Pediatry.jpg") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*10,blockSize*13, Color.LIGHT_GRAY, null);
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
		graphics.drawImage(img, x*blockSize, y*blockSize,blockSize*22,blockSize*15, Color.LIGHT_GRAY, null);
	}

	public void paint(Department department, Graphics g) {
		
	}

	

	
}
