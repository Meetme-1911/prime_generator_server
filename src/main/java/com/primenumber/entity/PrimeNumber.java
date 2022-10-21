package com.primenumber.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PrimeNumberTable")
public class PrimeNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Date startedAt;
	Date endedAt;
	Long startingValue;
	Long endingValue;
	Long timeElapsed;
	String algorithmChoosen;
	Long numberGenerated;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartedAt() {
		return startedAt;
	}
	public Date getEndedAt() {
		return endedAt;
	}
	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}
	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}
	public Long getStartingValue() {
		return startingValue;
	}
	public void setStartingValue(Long startingValue) {
		this.startingValue = startingValue;
	}
	public Long getEndingValue() {
		return endingValue;
	}
	public void setEndingValue(Long endingValue) {
		this.endingValue = endingValue;
	}
	public Long getTimeElapsed() {
		return timeElapsed;
	}
	public void setTimeElapsed(Long timeElapsed) {
		this.timeElapsed = timeElapsed;
	}
	public String getAlgorithmChoosen() {
		return algorithmChoosen;
	}
	public void setAlgorithmChoosen(String algorithmChoosen) {
		this.algorithmChoosen = algorithmChoosen;
	}
	public Long getNumberGenerated() {
		return numberGenerated;
	}
	public void setNumberGenerated(Long numberGenerated) {
		this.numberGenerated = numberGenerated;
	}
	
	
	
}
