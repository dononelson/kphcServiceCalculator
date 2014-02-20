package org.sc.mvc.model;

import java.util.Date;

public class CalcResponse {

	private String startDate;
	private String endDate;
	private String region;
	private String envType;
	private String envNum;
	private String title;
	private Double hours;
	private Date date;
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEnvType() {
		return envType;
	}

	public void setEnvType(String envType) {
		this.envType = envType;
	}

	public String getEnvNum() {
		return envNum;
	}

	public void setEnvNum(String envNum) {
		this.envNum = envNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
