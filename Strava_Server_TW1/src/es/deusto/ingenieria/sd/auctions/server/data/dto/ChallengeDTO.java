package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;
import java.util.Date;

public class ChallengeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int IDChallenge;
	private String name;
	private Date startDate;
	private Date endDate;
	private boolean targetType;
	private int targetTime;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean getTargetType() {
		return targetType;
	}

	public void setTargetType(boolean targetType) {
		this.targetType = targetType;
	}

	public int getTargetTime() {
		return targetTime;
	}

	public void setTargetTime(int target) {
		this.targetTime = target;
	}
	
	@Override
	public String toString() {
		return "ChallengeDTO [name=" + name + "id=" + IDChallenge + ", startDate=" + startDate + ", endDate=" + endDate + ", targetType="
				+ targetType + ", target=" + targetTime + "]";
	}

	public int getID() {
		return IDChallenge;
	}

	public void setID(int ID) {
		this.IDChallenge = ID;
	}
}
