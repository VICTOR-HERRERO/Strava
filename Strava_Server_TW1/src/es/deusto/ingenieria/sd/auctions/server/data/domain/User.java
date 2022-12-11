package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

public class User implements Serializable {	
	private String name;
	private String email;
    private Date birthDate;
    private float weight;
    private float height;
    private int maxRate;
    private int restRate;
	private Provider provider;
    private List<TrainingSession> trainingSessions = new ArrayList<>();
    private List<Challenge> challenges = new ArrayList<>();
    private List<Challenge> activeChallenge = new ArrayList<>();
    
	public User() {
		// TODO Auto-generated constructor stub
	}
    
    public User(String name, String email, Date birthDate, float weight, float height,
			int maxRate, int restRate, int provider) {
		
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.weight = weight;
		this.height = height;
		this.maxRate = maxRate;
		this.restRate = restRate;
		this.provider = Provider.values()[provider];
		this.challenges = new ArrayList<>();
		this.trainingSessions = new ArrayList<>();
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(int maxRate) {
        this.maxRate = maxRate;
    }

    public int getRestRate() {
        return restRate;
    }

    public void setRestRate(int restRate) {
        this.restRate = restRate;
    }
    
	public Provider getProvider() {
		return provider;
	}
	
	public void setProvider(int provider) {
		this.provider = Provider.values()[provider];
	}
	
	
    public List<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(List<TrainingSession> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

	public void addTrainingSesion(TrainingSession trainingSession) {
		if (trainingSession != null && !this.trainingSessions.contains(trainingSession)) {
			this.trainingSessions.add(trainingSession);
		}
	}

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public void addChallenge(Challenge challenge) {
		if (challenge != null && !this.challenges.contains(challenge)) {
			this.challenges.add(challenge);
		}
    }
    
    public List<Challenge> getActiveChallenge() {
		return activeChallenge;
	}
    
	public void setActiveChallenge(List<Challenge> activeChallenge) {
		this.activeChallenge = activeChallenge;
	}
	

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.name);
		result.append(" - ");
		result.append(this.email);
		result.append(" - (");
		result.append(this.activeChallenge.size());
		result.append(" retos) - (");
		result.append(this.trainingSessions.size());
		result.append(" sesiones)");
		
		return result.toString();
	}

    public boolean equals(Object obj) {
        if (this.getClass().getName().equals(obj.getClass().getName())){
            return this.email.equals(((User)obj).getName());
        }else{
            return false;
        }
    }


}
