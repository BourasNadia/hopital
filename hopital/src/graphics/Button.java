package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;

import javax.swing.JButton;

import java.awt.geom.Ellipse2D;

public class Button extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Button(String label){
		super(label);
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
	}
	public void paintComponent(Graphics g) {
	     if (getModel().isArmed()) {
	           g.setColor(Color.lightGray);
	     } else {
	          g.setColor(getBackground());
	     }
	     g.fillOval(0, 0, getSize().width-1, getSize().height-1);
	     super.paintComponent(g);
	}
	
	public void paintBorder(Graphics g) {
	     g.setColor(getForeground());
	     g.drawOval(0, 0, getSize().width-1, getSize().height-1);
	}
	Shape shape;
	public boolean contains(int x, int y) {
	     if (shape == null || !shape.getBounds().equals(getBounds())) {
	          shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
	     }
	     return shape.contains(x, y);
	}
}