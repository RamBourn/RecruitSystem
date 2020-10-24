package function;

import javax.swing.JButton;

public class Association1 {
	private String name;
	private String foundTime;
	private String introduction;
	private String activity;
	private String member;
    private Manager theManager;
    private JButton theButton;
    private int  memberNum;
    private int activityNum;
    public Association1(String name,String foundTime,String introduction,String member,
    		String activity,Manager theManager,int memberNum,int activityNum) {
    	setName(name);
    	setFoundTime(foundTime);
    	setIntroduction(introduction);
    	setActivity(activity);
    	setManager(theManager);
    	theButton=new JButton(name);
    	setMemberNum(memberNum);
    	setActivityNum(activityNum);
    	setMember(member);
    }
    public void setMember(String member) {
    	this.member=member;
    }
    public void setName(String name) {
    	this.name=name;
    }
    public void setFoundTime(String foundTime) {
    	this.foundTime=foundTime;
    }
    public void setIntroduction(String introduction) {
    	this.introduction=introduction;
    }
    public void setActivity(String activity) {
    	this.activity=activity;
    }
    public void setManager(Manager theManager) {
    	this.theManager=theManager;
    }
    public void setMemberNum(int memberNum) {
    	this.memberNum=memberNum;
    }
    public void setActivityNum(int activityNum) {
    	this.activityNum=activityNum;
    }
    public String getMember() {
    	return member;
    }
    public String getName() {
    	return name;
    }
    public String getFoundTime() {
    	return foundTime;
    }
    public String getIntroduction() {
    	return introduction;
    }
    public String getActivity() {
    	return activity;
    }
    public Manager getManager() {
    	return theManager;
    }
    public JButton getButton() {
    	return theButton;
    }
    public int getMemberNum() {
    	return memberNum;
    }
    public int getActivityNum() {
    	return activityNum;
    }
    public String getBasicInfo() {
    	String theInfo="社团名称:  "+name+"\n"+
                       "成立时间:  "+foundTime+"\n"+
    			       "负责人:  "+"\n"
                       +"    姓名:  "+theManager.getName()+"\n"+
    			        "    电话:  "+theManager.getPhone()+"\n"+
                        "    邮箱:  "+theManager.getConnection()+"\n"+
    			        "活动:  "+activity+"\n"+
                        "简介:  "+introduction;
        return theInfo;		        
    }
    
}



