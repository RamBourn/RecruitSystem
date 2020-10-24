package Interface;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import function.Activity;
import function.Association1;
import function.Manager;

public class AdministratorInterface implements ActionListener{
	JFrame administrator;
	JButton associationLabel,activityLabel;
	JPanel associationList,activityList,upperLeft,upperRight;
	ArrayList<Association1> associationArray;
	ArrayList<Activity>activityArray;
	JButton memberNumConsequence,activityNumConsequence;
	public AdministratorInterface() {
		administrator=new JFrame("管理员界面");
		Container theContainer=administrator.getContentPane();
		theContainer.setLayout(new GridLayout(2,2));
		upperLeft=new JPanel(new GridLayout(2,1));
		upperRight=new JPanel(new GridLayout(2,1));
		memberNumConsequence=new JButton("按活动规模排序");
		memberNumConsequence.addActionListener(this);
		activityNumConsequence=new JButton("按活动次数排序");
		activityNumConsequence.addActionListener(this);
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
		upperLeft.add(associationLabel);
		upperRight.add(activityLabel);
		upperLeft.add(memberNumConsequence);
		upperRight.add(activityNumConsequence);
		theContainer.add(upperLeft);
		theContainer.add(upperRight);
		theContainer.add(associationList);
		theContainer.add(activityList);
		administrator.setSize(500,500);
		administrator.setVisible(true);
		administrator.setLocation(800,300);
	}
	public void showAssociation(Association1 theAssociation) {
		JFrame associationInfo=new JFrame(theAssociation.getName()+"基本信息");
		Container theContainer=associationInfo.getContentPane();
		JTextArea theInfo=new JTextArea("社团成员:\n"+theAssociation.getMember());
		theContainer.add(theInfo);
		associationInfo.setSize(500, 200);
		associationInfo.setVisible(true);
		associationInfo.setLocation(800,300);
	}
	public void showActivity(Activity theActivity) {
		JFrame activityInfo=new JFrame(theActivity.getName()+"基本信息");
		Container theContainer=activityInfo.getContentPane();
		JTextArea theInfo=new JTextArea("活动附加信息\n"+theActivity.getPS());
		theContainer.add(theInfo);
		activityInfo.setSize(500, 200);
		activityInfo.setVisible(true);
		activityInfo.setLocation(800, 300);
	}
	public void showMemberConsequence() {
		JFrame consequenceList=new JFrame("社团排序列表");
		Container theContainer=consequenceList.getContentPane();
		JTextArea message=new JTextArea("社团按社团规模排序如下:\n");
	    for(int i=0;i<associationArray.size()-1;++i) {
			for(int j=i;j<associationArray.size()-1;++j) {
				if(associationArray.get(j).getMemberNum()>associationArray.get(j+1).getMemberNum()) {
					Association1 mid=associationArray.get(j+1);
					associationArray.set(j+1, associationArray.get(j));
					associationArray.set(j, mid);
				}
			}
		}
		for(int i=0;i<associationArray.size();++i)message.append(associationArray.get(i).getName()+"\n");
		theContainer.add(message);
		consequenceList.setBounds(800, 300, 500, 300);
		consequenceList.setVisible(true);
	}
	public void showActivityConsequence() {
		JFrame consequenceList=new JFrame("社团排序列表");
		Container theContainer=consequenceList.getContentPane();
		JTextArea message=new JTextArea("社团按活动次数排序如下:\n");
	    for(int i=0;i<associationArray.size()-1;++i) {
			for(int j=i;j<associationArray.size()-1;++j) {
				if(associationArray.get(j).getActivityNum()>associationArray.get(j+1).getActivityNum()) {
					Association1 mid=associationArray.get(j+1);
					associationArray.set(j+1, associationArray.get(j));
					associationArray.set(j, mid);
				}
			}
		}
		for(int i=0;i<associationArray.size();++i)message.append(associationArray.get(i).getName()+"\n");
		theContainer.add(message);
		consequenceList.setBounds(800, 300, 500, 300);;
		consequenceList.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==memberNumConsequence)showMemberConsequence();
		if(e.getSource()==activityNumConsequence)showActivityConsequence();
		for(int i=0;i<associationArray.size();++i)
			if(e.getSource()==associationArray.get(i).getButton())showAssociation(associationArray.get(i));
		for(int i=0;i<activityArray.size();++i)
			if(e.getSource()==activityArray.get(i).getButton())showActivity(activityArray.get(i));
				}
}
