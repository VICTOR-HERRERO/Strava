package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Sport;

public class TrainingSessionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String title;
	private float distance;
	private Date startDate;
	private Date startTime;
	private float duration;
	private Sport sport;
	
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

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	@Override
	public String toString() {
		return "TrainingSessionDTO [title=" + title + ", distance=" + distance + ", startDate=" + startDate + ", startTime="
				+ startTime + ", duration=" + duration + ", sport=" + sport + "]";
	}
}
