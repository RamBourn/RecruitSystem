package Interface;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyTask extends TimerTask implements MouseListener{
	ArrayList<ImageIcon> picture;
	JFrame show;
	JLabel pictureLabel;
	Container theContainer;
	JPanel thePanel;
	Random dice;
	public MyTask() {
		picture=new ArrayList<ImageIcon>(5);
		picture.add(new ImageIcon("src/source/association1.jpg"));
		picture.add(new ImageIcon("src/source/association2.jpg"));
		picture.add(new ImageIcon("src/source/association3.jpg"));
		picture.add(new ImageIcon("src/source/association4.jpg"));
		picture.add(new ImageIcon("src/source/association5.jpg"));
		show=new JFrame("…ÁÕ≈Õº∆¨«Ω");
        show.setVisible(true);	
        show.addMouseListener(this);
        show.setBounds(600,200,500,500);
        theContainer=show.getContentPane();
        thePanel=new JPanel();
        pictureLabel=new JLabel();
	}
	public void run() {
		dice=new Random();
		ImageIcon thePicture=picture.get(dice.nextInt(5));
		pictureLabel.setIcon(thePicture);
        thePanel.add(pictureLabel);
        theContainer.add(thePanel);
        show.repaint();
	}
	public void mouseClicked(MouseEvent e) {
		new MainInterface();
		show.setVisible(false);
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	
}