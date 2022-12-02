package es.deusto.ingenieria.sd.auctions.server.data.domain;


import java.util.Date;

public class Challenge {

    private static int ChallengeCounter=1;
    private int IDChallenge;
    private String name;
    private Date startDate;
    private Date endDate;
    private boolean targetType;
    private int targetTime;
    private Sport sport;

    public Challenge(String name, Date startDate, Date endDate, boolean targetType, int targetTime) {
		super();
        this.IDChallenge = ChallengeCounter;
        ChallengeCounter++;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.targetType = targetType;
		this.targetTime = targetTime;
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

    public void setID(int ID){
        this.IDChallenge = ID;
    }

    public int getID(){
        return IDChallenge;
    }

    public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.name.equals(((Challenge) obj).getName());
		}
		
		return false;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}
