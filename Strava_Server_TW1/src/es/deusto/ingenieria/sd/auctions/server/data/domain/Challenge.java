package es.deusto.ingenieria.sd.auctions.server.data.domain;


import java.util.Date;
import java.io.Serializable;

public class Challenge implements Serializable {

    private String name;
    private Date startDate;
    private Date endDate;
    private boolean targetType;
    private int targetTime;
    private Sport sport;

    public Challenge(String name, Date startDate, Date endDate, boolean targetType, int targetTime, Sport sport) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.targetType = targetType;
		this.targetTime = targetTime;
		this.sport = sport;
	}
    
    public Challenge() {
    	
    }
    
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

    public String toString() {
        return "Challenge [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", targetType=" + targetType + ", target=" + targetTime + "]";
    }

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}
