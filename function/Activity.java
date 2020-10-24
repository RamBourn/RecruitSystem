package function;

import javax.swing.JButton;

public class Activity {
	private String name;
	private String heldTime;
	private String location;
	private String holdingAssociation;
	private String introduction;
	private String PS;
	private JButton theButton;
	public Activity(String name,String heldTime,String location,
			String holdingAssociation,String introduction,String PS) {
		setName(name);
		setHeldTime(heldTime);
		setLocation(location);
		setHoldingAssociation(holdingAssociation);
		setIntroduction(introduction);
		setPS(PS);
		theButton=new JButton(name);
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setHeldTime(String heldTime) {
		this.heldTime=heldTime;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	public void setIntroduction(String introduction) {
		this.introduction=introduction;
	}
	public void setPS(String PS) {
		this.PS=PS;
	}
	public void setHoldingAssociation(String holdingAssociation) {
		this.holdingAssociation=holdingAssociation;
	}
	public String getName() {
		return name;
	}
	public String getHeldTime() {
		return heldTime;
	}
	public String getLocation() {
		return location;
	}
	public String getIntroduction() {
		return introduction;
	}
	public String getPS() {
		return PS;
	}
	public String getHoldingAssociation() {
		return holdingAssociation;
	}
	public JButton getButton() {
		return theButton;
	}
	public String getBasicInfo() {
		String theInfo="活动名称:  "+name+"\n"+
	                   "举办时间:  "+heldTime+"\n"+
				       "举办地点:  "+location+"\n"+
	                   "主办社团:  "+holdingAssociation+"\n"+
				       "活动简介:  "+introduction;
		return theInfo;
	}


}
