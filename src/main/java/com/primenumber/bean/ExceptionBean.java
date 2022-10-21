package com.primenumber.bean;

import java.util.Date;

public class ExceptionBean {


	int statusCode;
	String message;
	String controllerName;
	String methodName;
	String servicePath;
	Date logTime;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getControllerName() {
		return controllerName;
	}
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getServicePath() {
		return servicePath;
	}
	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	@Override
	public String toString() {
		return "ExceptionBean [statusCode=" + statusCode + ",\n\tmessage=" + message + ",\n\tcontrollerName=" + controllerName
				+ ",\n\tmethodName=" + methodName + ",\n\tservicePath=" + servicePath + ",\n\tlogTime=" + logTime + "]";
	}
	public ExceptionBean(int statusCode, String message, String controllerName, String methodName, String servicePath,
			Date logTime) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.controllerName = controllerName;
		this.methodName = methodName;
		this.servicePath = servicePath;
		this.logTime = logTime;
	}
	public ExceptionBean() {
		super();
	}

}
