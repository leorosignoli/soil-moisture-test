package br.edu.uniceub.soilmoisture.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uniceub.soilmoisture.dtos.PointInTimeDTO;
import br.edu.uniceub.soilmoisture.service.SensorService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sensor")
public class SensorController {

	@Autowired
	private SensorService service;

	private Logger logger = LoggerFactory.logger(getClass());

	@PostMapping
	public ResponseEntity<UUID> saveNewEntry(@RequestBody PointInTimeDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewEntry(dto));
	}

	@GetMapping
	@ApiOperation(notes = "Date formate: yyyy-MM-dd HH:mm", value = "Find All entries, if date is value, returns all of the data.")
	public ResponseEntity<List<PointInTimeDTO>> findAll(@RequestParam(required = false) String from,
			@RequestParam(required = false) String to) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(from, to));
	}

	@PostMapping("/withoutTime")
	public ResponseEntity<UUID> saveNewEntryNoTime(@RequestParam(name = "id") String sensorId,
			@RequestParam(name = "value") String value) {
		PointInTimeDTO dto = new PointInTimeDTO();

		dto.setDateTime(new Date());

		dto.setSensorId(sensorId);
		dto.setValue(Float.parseFloat(value));
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewEntry(dto));
	}

}
