package br.edu.uniceub.soilmoisture.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class PointInTimeDTO {

	private String sensorId;
	private Date dateTime;
	private Float value;

}
