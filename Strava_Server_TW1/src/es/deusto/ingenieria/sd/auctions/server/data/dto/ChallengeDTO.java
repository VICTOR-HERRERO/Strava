package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;
import java.util.Date;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Sport;

public class ChallengeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Date startDate;
	private Date endDate;
	private boolean targetType;
	private int targetTime;
	private Sport sport;
	
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
	
	public Sport getSport() {
		return sport;
	}
	
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.name);
		result.append(" - ");
		result.append(this.startDate);
		result.append(" - ");
		result.append(this.endDate);
		result.append(" - ");
		result.append(this.targetTime);
		result.append(" - ");
		result.append(this.targetType);
		result.append(" - ");
		result.append(this.sport);
		
		return result.toString();		
	}



}
