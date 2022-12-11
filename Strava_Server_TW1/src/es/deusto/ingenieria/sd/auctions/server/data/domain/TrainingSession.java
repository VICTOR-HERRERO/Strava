package es.deusto.ingenieria.sd.auctions.server.data.domain;


import java.util.Date;
import java.io.Serializable;


public class TrainingSession implements Serializable {
	private String title;
    private float distance;
    private Date startDate;
    private Date startTime;
    private float duration;
    private Sport sport;
     
    public TrainingSession(String title, Sport sport, float distance, Date startDate, Date startTime, float duration) {
		super();
		
		this.title = title;
		this.sport = sport;
		this.distance = distance;
		this.startDate = startDate;
		this.startTime = startTime;
		this.duration = duration;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String toString() {
        return "TrainingSession [title=" + title + ", distance=" + distance + ", startDate=" + startDate + ", startTime=" + startTime + ", duration=" + duration + "]";
    }

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}