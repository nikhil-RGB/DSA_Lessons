package greedy_problems;
import java.util.*;

public class ActivitySelectionProblem {
	public static void main(String[] args) 
	{
		Activity ac1=new Activity(1,600,720);
		Activity ac2=new Activity(2,1200,1380);
		Activity ac3=new Activity(3,1020,1140);
		Activity ac4=new Activity(4,600,630);
		ArrayList<Activity> acs=new ArrayList<Activity>(0);
		acs.add(ac1);
		acs.add(ac2);
		acs.add(ac3);
		acs.add(ac4);
		ArrayList<Activity> result=select(acs);
		for(Activity s:result)
		{
		    System.out.println(s.id);
		    }
		
	}
	static class Activity 
	{
	 int id;
	 int start;
	 int finish;
	 public Activity(int id,int start,int finish)
	 {
	  this.id=id;
	  this.start=start;
	  this.finish=finish;    
	 }
	}
	 public static ArrayList<Activity> select(ArrayList<Activity> activities){
	 ArrayList<Activity> selected=new ArrayList<>(0);    
	 Collections.sort(activities,(a1,a2)->Integer.signum(a1.finish-a2.finish));
	 if(activities.size()>0)
	 {
	  selected.add(activities.get(0));
	  activities.remove(0);  
	 }
	 for(int i=0;i<activities.size();++i)
	 {
	     Activity current=activities.get(i);
	     Activity previous=selected.get(selected.size()-1);
	     if(current.start>=previous.finish)
	     {
	      //activity is compatible and can be added to the list
	      selected.add(current);    
	     }
	     
	 }
	 return selected;
	 }
	}
