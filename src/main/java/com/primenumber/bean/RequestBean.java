package com.primenumber.bean;

import io.swagger.annotations.ApiModelProperty;

public class RequestBean {
	@ApiModelProperty(
			  value = "starting value of range",
			  dataType = "int64",
			  example = "10")
	private Long startValue;
	@ApiModelProperty(
			  value = "ending value of range",
			  dataType = "int64",
			  example = "10")
	private Long endValue;
	
	private String algorithmName;
	
	
	public String getAlgorithmName() {
		return algorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	public Long getStartValue(){
		return startValue;
	}
	public void setStartValue(Long startValue) {
		this.startValue = startValue;
	}
	public Long getEndValue() {
		return endValue;
	}
	public void setEndValue(Long endValue) {
		this.endValue = endValue;
	}
	
	
}
