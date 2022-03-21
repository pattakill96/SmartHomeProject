package SmartHomeSafety.smart.home.safety;

public class Analyzer {
	SensorValues db = new SensorValues();
	Planner planner = new Planner();
	
	public void GasSensorArrived(String room, int state) {
		this.updateData(room, state, 999, "gasknob");
		planner.gasSignalArrived();
	}
	
	public void GasSensorPercArrived(String room, float value) {
		this.updateData(room, 999, value, "gasPerc");
		planner.gasSignalPercArrived();
		
	}
	
	public void FireSensorArrived(String room, int state) {
		this.updateData(room, state, 999, "fire");
		planner.fireSignalArrived(room);
	}
	
	public void TempSensorArrived(String room, float value) {
		this.updateData(room, 999, value, "temperature");
		planner.tempSignalArrived(room);
	}
	
	public void WindowSensorArrived(String room, int state) {
		this.updateData(room, state, 999, "window");
		planner.windowSignalArrived(room);
	}
	
	public void SprinklerSensorArrived(String room, int state) {
		this.updateData(room, state, 999, "sprink");
		planner.sprinklerSignalArrived(room);
	}
	
	public void WaterSensorArrived(String room, int state) {
		int time_lapse = 20;
		this.updateData(room, state, 999, "water");
		planner.waterSignalArrived(room, time_lapse);
	}
	
	public void PresenceSensorArrived(String room, int state) {
		this.updateData(room, state, 999, "presence");
		planner.presenceSignalArrived(room);
	}

	public void setGasTimer(String topic, int state) {
		db.updateGasTimer(state);
	}
	public void updateData(String room, int state, float value, String sensor) {
		if(value != 999){
			switch(room) {
			
			case "kitchen": {
				switch(sensor) {
				
				case "temperature": {
					db.updateKitchenTemperatureSensorValue(value);
					break;
				}
				
				case "gasPerc": {
					db.updateGasSensorPercValue(value);
					break;
				}
			}}
			
			case "bathroom": {
				db.updateBathroomTemperatureSensorValue(value);
				break;
			}
			
			case "bedroom": {
				db.updatebedroomTemperatureSensorValue(value);
				break;
			}
			
			case "livingroom": {
				db.updatebedroomTemperatureSensorValue(value);
				break;
			}

			}
		}
		
		if(state != 999) {
			switch(room) {
			case "kitchen": {
				switch(sensor) {
				
				case "water": {
					db.updateKitchenWaterSensorValue(state);
					break;
				}
				
				case "sprink": {
					db.updateKitchenSprinkSensorValue(state);
					break;
				}
				
				case "window": {
					db.updateKitchenWindowSensorValue(state);
					break;
				}
				
				case "gasknob": {
					db.updateGasSensorValue(state);
					break;
				}
				
				case "fire": {
					db.updateKitchenfireSensorValue(state);
					break;
				}
				
				case "presence": {
					db.updateKitchenPresenceValue(state);
					break;
				}
				}
			}
			
			case "bathroom": {
				switch(sensor) {
				
				case "water": {
					db.updateBathroomWaterSensorValue(state);
					break;
				}
				
				case "sprink": {
					db.updateBathroomSprinkSensorValue(state);
					break;
				}
				
				case "window": {
					db.updateBathroomWindowSensorValue(state);
					break;
				}
				
				case "fire": {
					db.updateBathroomfireSensorValue(state);
					break;
				}
				case "presence": {
					db.updateBathroomPresenceValue(state);
					break;
				}
				}
			}
			
			case "bedroom": {
				switch(sensor) {
				
				
				case "sprink": {
					db.updateBedroomSprinkSensorValue(state);
					break;
				}
				
				case "window": {
					db.updateBedroomWindowSensorValue(state);
					break;
				}
				
				
				case "fire": {
					db.updateBedroomfireSensorValue(state);
					break;
				}
				case "presence": {
					db.updateBedroomPresenceValue(state);
					break;
				}
				}
			}
			
			case "livingroom": {
				switch(sensor) {
				
				
				case "sprink": {
					db.updateLivingroomSprinkSensorValue(state);
					break;
				}
				
				case "window": {
					db.updateLivingRoomWindowSensorValue(state);
					break;
				}
				
				
				case "fire": {
					db.updateLivingroomFireSensorValue(state);
					break;
				}
				case "presence": {
					db.updateLivingroomPresenceValue(state);
					break;
				}
				}
			}
			}
		}
	}

	
}
