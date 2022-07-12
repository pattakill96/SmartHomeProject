package SmartHomeSafety.smart.home.safety;

public class Analyzer {
	SensorValues db = new SensorValues();
	Planner planner = new Planner();
	Utils u = new Utils();
	float preValue= 0 ;
	
	public void GasSensorArrived() {
		planner.gasSignalArrived();
	}
	
	public void GasSensorPercArrived() {
		planner.gasSignalPercArrived();
		
	}
	
	public void FireSensorArrived(String room) {
		planner.fireSignalArrived(room);
	}
	
	public void WindowSensorArrived(String room) {
		planner.windowSignalArrived(room);
	}
	
	public void SprinklerSensorArrived(String room) {
		planner.sprinklerSignalArrived(room);
	}
	
	public void WaterSensorArrived(String room, String state) {
		if(state=="normal")
			planner.waterSignalArrived(room);
		else {
			planner.waterDetectionArrived(room,state);
		//System.out.println(state);
		}
	}
	
	public void PresenceSensorArrived(String room) {
		planner.presenceSignalArrived(room);
	}

	private void ACSensorArrived(String room, Boolean out) {
		if(!out)
		planner.ACSignalArrived(room);
		
	}

	private void HeaterSensorArrived(String room, Boolean out) {
		if(!out)
		planner.heaterSignalArrived(room);
		
	}

	private void DoorSensorArrived(String room) {
		planner.doorSignalArrived(room);
		
	}
	
	private void tempSensorActivated(String room, Boolean out) {
		if(!out)
			planner.tempSignalArrived(room);
	}
	
	public void updateData(String room, String msg, String sensor, Boolean out) throws NumberFormatException{
		switch(room) { 
			case "kitchen": {
				switch(sensor) {
				
				case "temperature": {
					db.updateKitchenTemperatureSensorValue(Float.parseFloat(msg));
					this.tempSensorActivated(room, out);
					break;
				}
				
				case "gasPerc": {
					db.updateGasSensorPercValue(Float.parseFloat(msg));
					this.GasSensorArrived();
					break;
				}
				
				case "water": {
					db.updateKitchenWaterSensorValue(Integer.parseInt(msg));
					this.WaterSensorArrived(room,"normal");
					break;
				}
				
				case "waterDetector": {
					this.preValue = SensorValues.kitchen_water_detected_value;
					db.updateKitchenWaterDetectedValue(Float.parseFloat(msg));
					if(SensorValues.kitchen_water_detected_value > this.preValue && this.preValue > 0)
						this.WaterSensorArrived(room,"procedure");
					else {
						this.WaterSensorArrived(room,"detection");
					}
					break;
				}
				
				case "sprink": {
					db.updateKitchenSprinkSensorValue(Integer.parseInt(msg));
					this.SprinklerSensorArrived(room);
					break;
				}
				
				case "window": {
					db.updateKitchenWindowSensorValue(Integer.parseInt(msg));
					this.WindowSensorArrived(room);
					break;
				}
				
				case "gasknob": {
					db.updateGasSensorValue(Integer.parseInt(msg));
					this.GasSensorArrived();
					break;
				}
				
				case "fire": {
					db.updateKitchenfireSensorValue(Integer.parseInt(msg));
					this.FireSensorArrived(room);
					break;
				}
				
				case "door": {
					db.updateKitchenDoorSensorValue(Integer.parseInt(msg));
					this.DoorSensorArrived(room);
					break;
				}
				
				case "heater": {
					db.updateKitchenHeaterSensorValue(Integer.parseInt(msg));
					this.HeaterSensorArrived(room,out);
					break;
				}
				
				case "AC": {
					db.updateKitchenACSensorValue(Integer.parseInt(msg));
					this.ACSensorArrived(room,out);
					break;
				}
				
				case "roompresence": {
					db.updateKitchenPresenceValue(Integer.parseInt(msg));
					this.PresenceSensorArrived(room);
					break;
				}
			}
				break;
			}
			
			
			case "bathroom": {
				switch(sensor) {
				
				case "temperature": {
					db.updateBathroomTemperatureSensorValue(Float.parseFloat(msg));
					this.tempSensorActivated(room, out);
					break;
				}
				
				case "water": {
					db.updateBathroomWaterSensorValue(Integer.parseInt(msg));
					this.WaterSensorArrived(room,"normal");
					break;
				}
				
				case "waterDetector": {
					this.preValue = SensorValues.bathroom_water_detected_value;
					db.updateBathroomWaterDetectedValue(Float.parseFloat(msg));
					if(SensorValues.bathroom_water_detected_value > this.preValue && this.preValue > 0)
						this.WaterSensorArrived(room,"procedure");
					else {
						this.WaterSensorArrived(room,"detection");
					}
					break;
				}
				
				case "sprink": {
					db.updateBathroomSprinkSensorValue(Integer.parseInt(msg));
					planner.sprinklerSignalArrived(room);
					break;
				}
				
				case "window": {
					db.updateBathroomWindowSensorValue(Integer.parseInt(msg));
					planner.windowSignalArrived(room);
					break;
				}
				
				case "fire": {
					db.updateBathroomfireSensorValue(Integer.parseInt(msg));
					planner.fireSignalArrived(room);
					break;
				}
				
				case "door": {
					db.updateBathroomDoorSensorValue(Integer.parseInt(msg));
					planner.doorSignalArrived(room);
					break;
				}
				
				case "heater": {
					db.updateBathroomHeaterSensorValue(Integer.parseInt(msg));
					this.HeaterSensorArrived(room, out);
					break;
				}
				
				case "AC": {
					db.updateBathroomACSensorValue(Integer.parseInt(msg));
					this.ACSensorArrived(room, out);
					break;
				}
				
				case "roompresence": {
					db.updateBathroomPresenceValue(Integer.parseInt(msg));
					planner.presenceSignalArrived(room);
					break;
				}
				}
				break;
			}
			
			case "bedroom": {
				switch(sensor) {
				
				
				case "temperature": {
					db.updatebedroomTemperatureSensorValue(Float.parseFloat(msg));
					this.tempSensorActivated(room, out);
					break;
				}
				
				case "sprink": {
					db.updateBedroomSprinkSensorValue(Integer.parseInt(msg));
					planner.sprinklerSignalArrived(room);
					break;
				}
				
				case "window": {
					db.updateBedroomWindowSensorValue(Integer.parseInt(msg));
					planner.windowSignalArrived(room);
					break;
				}
				
				case "fire": {
					db.updateBedroomfireSensorValue(Integer.parseInt(msg));
					planner.fireSignalArrived(room);
					break;
				}
				
				case "door": {
					db.updateBedroomDoorSensorValue(Integer.parseInt(msg));
					planner.doorSignalArrived(room);
					break;
				}
				
				case "heater": {
					db.updateBedroomHeaterSensorValue(Integer.parseInt(msg));
					this.HeaterSensorArrived(room, out);
					break;
				}
				
				case "AC": {
					db.updateBedroomACSensorValue(Integer.parseInt(msg));
					this.ACSensorArrived(room, out);
					break;
				}
				
				case "roompresence": {
					db.updateBedroomPresenceValue(Integer.parseInt(msg));
					planner.presenceSignalArrived(room);
					break;
				}
				}
				break;
			}
			
			case "livingroom": {
				switch(sensor) {
				
				
				case "temperature": {
					db.updatelivingroomTemperatureSensorValue(Float.parseFloat(msg));
					this.tempSensorActivated(room, out);
					break;
				}
				
				case "sprink": {
					db.updateLivingroomSprinkSensorValue(Integer.parseInt(msg));
					planner.sprinklerSignalArrived(room);
					break;
				}
				
				case "window": {
					db.updateLivingRoomWindowSensorValue(Integer.parseInt(msg));
					planner.windowSignalArrived(room);
					break;
				}
				
				case "fire": {
					db.updateLivingroomFireSensorValue(Integer.parseInt(msg));
					planner.fireSignalArrived(room);
					break;
				}
				
				case "door": {
					db.updateLivingroomDoorSensorValue(Integer.parseInt(msg));
					planner.doorSignalArrived(room);
					break;
				}
				
				case "heater": {
					db.updateLivingroomHeaterSensorValue(Integer.parseInt(msg));
					this.HeaterSensorArrived(room, out);
					break;
				}
				
				case "AC": {
					db.updateLivingroomACSensorValue(Integer.parseInt(msg));
					this.ACSensorArrived(room, out);
					break;
				}
				
				case "roompresence": {
					db.updateLivingroomPresenceValue(Integer.parseInt(msg));
					planner.presenceSignalArrived(room);
					break;
				}
				}
				break;
			}
			case "setter":{
				switch(sensor) {
					 
				case "gastime":{
					db.updateGasTimer(Integer.parseInt(msg));
					break;
				}
				
				case "watertime":{
					db.updateWaterTimer(Integer.parseInt(msg));
					break;
				}
				
				case "kdmin":{
					db.updateKitchenDayMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("kitchen", out);
					break;
				}
				case "kdmax":{
					db.updateKitchenDayMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("kitchen", out);
					break;
				}
				case "knmin":{
					db.updateKitchenNightMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("kitchen", out);
					break;
				}
				case "knmax":{
					db.updateKitchenNightMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("kitchen", out);
					break;
				}
				case "ldmin":{
					db.updateLivingroomDayMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("livingroom", out);
					break;
				}
				case "ldmax":{
					db.updateLivingroomDayMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("livingroom", out);
					break;
				}
				case "lnmin":{
					db.updateLivingroomNightMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("livingroom", out);
					break;
				}
				case "lnmax":{
					db.updateLivingroomNightMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("livingroom", out);
					break;
				}
				case "bdmin":{
					db.updateBedroomDayMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("bedroom", out);
					break;
				}
				case "bdmax":{
					db.updateBedroomDayMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("bedroom", out);
					break;
				}
				case "bnmin":{
					db.updateBedroomNightMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("bedroom", out);
					break;
				}
				case "bnmax":{
					db.updateBedroomNightMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("bedroom", out);
					break;
				}
				case "btdmin":{
					db.updateBathroomDayMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("bathroom", out);
					break;
				}
				case "btdmax":{
					db.updateBathroomDayMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("bathroom", out);
					break;
				}
				case "btnmin":{
					db.updateBathroomNightMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("bathroom", out);
					break;
				}
				case "btnmax":{
					db.updateBathroomNightMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("bathroom", out);
					break;
				}
				case "importmode":{
					if(msg.equals("1"))
						planner.importdata();
					break;
				}
				case "savemode":{
					if(msg.equals("1"))
						planner.savedata();
					break;
				}
				
				}
				break;
			}
			
			case "presence":{
				switch(sensor) {
				 
				case "mode":{
					db.updatePresenceMode(Integer.parseInt(msg));
					planner.presenceModeArrived("all");;
					break;
				}
				case "kmin":{
					db.updateKitchenPresenceMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("kitchen", out);
					break;
				}
				case "kmax":{
					db.updateKitchenPresenceMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("kitchen", out);
					break;
				}
				case "lmin":{
					db.updateLivingroomPresenceMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("livingroom", out);
					break;
				}
				case "lmax":{
					db.updateLivingroomPresenceMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("livingroom", out);
					break;
				}
				case "bmin":{
					db.updateBedroomPresenceMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("bedroom", out);
					break;
				}
				case "bmax":{
					db.updateBedroomPresenceMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("bedroom", out);
					break;
				}
				case "btmin":{
					db.updateBathroomPresenceMinValue(Float.parseFloat(msg));
					this.tempSensorActivated("bathroom", out);
					break;
				}
				case "btmax":{
					db.updateBathroomPresenceMaxValue(Float.parseFloat(msg));
					this.tempSensorActivated("bathroom", out);
					break;
				}
				
				}
				break;
			}
		
		}
	}
}

	

