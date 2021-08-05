package com.dahal.phoneDemo;

public abstract class Phone {
	private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;

    public Phone(String versionNumberInput, int batteryPercentageInput, String carrierInput, String ringtoneInput) {
    	this.versionNumber = versionNumberInput;
    	this.batteryPercentage = batteryPercentageInput;
    	this.carrier = carrierInput;
    	this.ringTone = ringtoneInput;
    }
    
 // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();

    
    
    
    
    
    
    //getters and setters, not removed for brevity
	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getBatteryPercentage() {
		return batteryPercentage;
	}

	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getRingTone() {
		return ringTone;
	}

	public void setRingTone(String ringTone) {
		this.ringTone = ringTone;
	}
    
    
    
}
