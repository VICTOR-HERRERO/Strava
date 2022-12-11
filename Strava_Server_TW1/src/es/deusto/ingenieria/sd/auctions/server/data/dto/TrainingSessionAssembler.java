package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.TrainingSession;

public class TrainingSessionAssembler {
	private static TrainingSessionAssembler instance;

	private TrainingSessionAssembler() { }
	
	public static TrainingSessionAssembler getInstance() {
		if (instance == null) {
			instance = new TrainingSessionAssembler();
		}
		
		return instance;
	}

	public static TrainingSessionDTO trainingSessionToDTO(TrainingSession trainingSession) {
		TrainingSessionDTO dto = new TrainingSessionDTO();
		
		dto.setTitle(trainingSession.getTitle());
		dto.setStartDate(trainingSession.getStartDate());
		dto.setDistance(trainingSession.getDistance());
		dto.setStartTime(trainingSession.getStartTime());
		dto.setDuration(trainingSession.getDuration());
		dto.setSport(trainingSession.getSport());
		
		return dto;
	}
	
	public List<TrainingSessionDTO> trainingSessionToDTO(List<TrainingSession> trainingSessions) {		
		List<TrainingSessionDTO> dtos = new ArrayList<>();
		
		for (TrainingSession trainingSession : trainingSessions) {
			dtos.add(this.trainingSessionToDTO(trainingSession));
		}
		
		return dtos;
	}

}
