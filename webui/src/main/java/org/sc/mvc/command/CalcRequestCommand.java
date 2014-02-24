package org.sc.mvc.command;

public class CalcRequestCommand {

	private String startDate;
	private String endDate;
	private String region;
	private String envType;
	private String envNum;
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
	
	
	
}
