package Interface;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainInterface implements ActionListener {
	JFrame mainInterface;
	JButton user,administrator,exit;
	JButton welcom;
	JPanel mainPanel;
	public MainInterface() {
	user=new JButton("�û�");
	administrator=new JButton("����Ա");
	welcom=new JButton("��ӭ��������ϵͳ");
	mainInterface=new JFrame("��������ϵͳ");
	exit=new JButton("�˳�ϵͳ");
	mainPanel=new JPanel(new GridLayout(4,4));
	user.addActionListener(this);
	exit.addActionListener(this);
	administrator.addActionListener(this);
	Container mainContainer=mainInterface.getContentPane();
	mainPanel.add(welcom);
	mainPanel.add(user);
	mainPanel.add(administrator);
	mainPanel.add(exit);
	mainContainer.add(mainPanel);
	mainInterface.setSize(400,300);
	mainInterface.setVisible(true);
	mainInterface.setLocation(800, 300);
	}
	public void shutdown() {
		System.exit(0);
	}
	public void userInterface() {
		new UserInterface();
	}
	public void administratorInterface() {
		new AdministratorInterface();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==user) userInterface();
		if(e.getSource()==administrator) administratorInterface();
		if(e.getSource()==exit) shutdown();
	}
	
}
