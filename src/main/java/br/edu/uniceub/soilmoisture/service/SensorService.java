package br.edu.uniceub.soilmoisture.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.uniceub.soilmoisture.dtos.PointInTimeDTO;

@Service
public interface SensorService {

	UUID addNewEntry(PointInTimeDTO dto);

	/**
	 * Finds all entries in the database given the time period.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	List<PointInTimeDTO> findAll(String from, String to);

}
