package Interface;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import function.Activity;
import function.Association1;
import function.Manager;

public class UserInterface implements ActionListener {
	JFrame userFrame;
	JTextField messageText;
	JButton query;
	private ArrayList<Association1> associationArray;
	private ArrayList<Activity> activityArray;
	JPanel associationList,activityList,upper,lower;
	JButton associationLabel,activityLabel;
	public UserInterface() {
		userFrame=new JFrame("用户界面");
		Container theContainer=userFrame.getContentPane();
		theContainer.setLayout(new GridLayout(2,1));
		upper=new JPanel(new GridLayout(2,2));
		lower=new JPanel(new GridLayout(1,2));
		messageText=new JTextField(10);
		query=new JButton("查询");
		query.addActionListener(this);
		associationLabel=new JButton("社团列表");
		activityLabel=new JButton("活动列表");
		associationList=new JPanel(new GridLayout(10,1));
		activityList=new JPanel(new GridLayout(12,1));
		associationArray=new ArrayList<Association1>(10);
		activityArray=new ArrayList<Activity>(12);
		try {
			FileReader in=new FileReader("src/source/association.txt");
			Scanner theReader=new Scanner(in);
			String name,activity,introduction,foundTime,member;
			String managerName,managerConnection,managerPhone;
			Manager theManager;
			Association1 theAssociation;
			Activity theActivity;
			int memberNum,activityNum;
			while(theReader.hasNext()) {
				name=theReader.next();
				foundTime=theReader.next();
				managerName=theReader.next();
				managerPhone=theReader.next();
				managerConnection=theReader.next();
				member=theReader.next();
				activity=theReader.next();
				introduction=theReader.next();
				memberNum=Integer.parseInt(theReader.next());
				activityNum=Integer.parseInt(theReader.next()); 
				theManager=new Manager(managerName,managerPhone,managerConnection);
				theAssociation=new Association1(name,foundTime,introduction,member,activity,
						theManager,memberNum,activityNum); 
				associationArray.add(theAssociation);
				associationList.add(theAssociation.getButton());
				theAssociation.getButton().addActionListener(this);
			}
			
			theReader.close();
			in=new FileReader("src/source/activity.txt");
			theReader=new Scanner(in);
			String location,heldTime,holdingAssociation,PS;
			while(theReader.hasNext()) {
				name=theReader.next();
				heldTime=theReader.next();
				location=theReader.next();
				holdingAssociation=theReader.next();
				introduction=theReader.next();
				PS=theReader.next();
				theActivity=new Activity(name,heldTime,location,holdingAssociation,
						introduction,PS);
				activityArray.add(theActivity);
				activityList.add(theActivity.getButton());
				theActivity.getButton().addActionListener(this);
				
			}
			theReader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		upper.add(messageText);
		upper.add(query);
		upper.add(associationLabel);
		upper.add(activityLabel);
		lower.add(associationList);
		lower.add(activityList);
		theContainer.add(upper);
		theContainer.add(lower);
		userFrame.setSize(500, 500);
		userFrame.setVisible(true);	
		userFrame.setLocation(800,300);
	}
	public void showAssociation(Association1 theAssociation) {
		JFrame associationInfo=new JFrame(theAssociation.getName()+"基本信息");
		Container theContainer=associationInfo.getContentPane();
		JTextArea theInfo=new JTextArea(theAssociation.getBasicInfo());
		theContainer.add(theInfo);
		associationInfo.setSize(500, 300);
		associationInfo.setVisible(true);
		associationInfo.setLocation(800,300);
	}
	public void showActivity(Activity theActivity) {
		JFrame activityInfo=new JFrame(theActivity.getName()+"基本信息");
		Container theContainer=activityInfo.getContentPane();
		JTextArea theInfo=new JTextArea(theActivity.getBasicInfo());
		theContainer.add(theInfo);
		activityInfo.setSize(500, 300);
		activityInfo.setVisible(true);
		activityInfo.setLocation(800, 300);
	}
	public void query(String message) {
		for(int i=0;i<associationArray.size();++i)
			if(message==associationArray.get(i).getName())showAssociation(associationArray.get(i));
		for(int i=0;i<activityArray.size();++i)
			if(message==activityArray.get(i).getName())showActivity(activityArray.get(i));
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==query)query(messageText.getText()); 
		for(int i=0;i<associationArray.size();++i) 
			if(e.getSource()==associationArray.get(i).getButton())showAssociation(associationArray.get(i));
		for(int i=0;i<activityArray.size();++i)
			if(e.getSource()==activityArray.get(i).getButton())showActivity(activityArray.get(i));
				}
}

