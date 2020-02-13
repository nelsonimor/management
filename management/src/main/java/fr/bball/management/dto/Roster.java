package fr.bball.management.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Roster {
	
	private Team team;
	private Date start;
	private Date end;
	private List<RosterItem> rosterItems;
	

	public void addItem(RosterItem item) {
		if(rosterItems==null)rosterItems = new ArrayList<RosterItem>();
		rosterItems.add(item);
	}
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}

	public List<RosterItem> getRosterItems() {
		return rosterItems;
	}
	
	

}
