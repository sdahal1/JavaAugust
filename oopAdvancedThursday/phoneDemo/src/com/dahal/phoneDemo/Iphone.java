package com.dahal.phoneDemo;

public class Iphone extends Phone implements Ringable{
	
	//constructor
	public Iphone(String versionNumberInput, int batteryPercentageInput, String carrierInput, String ringtoneInput) {
//		this.versionNumber = versionNumberInput;
//    	this.batteryPercentage = batteryPercentageInput;
//    	this.carrier = carrierInput;
//    	this.ringTone = ringtoneInput;
		super(versionNumberInput, batteryPercentageInput, carrierInput, ringtoneInput );
	}
	
	
	@Override
    public void displayInfo() {
        // your code here 
		System.out.println("Siri said this Iphone is the best of its kind, here are its details");
		
		String info = String.format("Ihpone Details: \n Version Number: %s, \n Battery Percentage: %s, \n Carrier: %s, \n Ringtone: %s", this.getVersionNumber(), this.getBatteryPercentage(), this.getCarrier(), this.getRingTone());
		
		System.out.println(info);
    }
	
	
	@Override
	public String ring() {
		return "Ding dong siri style";
	}
	
	@Override
	public String unlock() {
		return "Unlocking using facial recognition!";
	}
	
	
	
	
	

}
