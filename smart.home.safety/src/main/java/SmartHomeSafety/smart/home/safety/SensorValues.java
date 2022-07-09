package SmartHomeSafety.smart.home.safety;



public class SensorValues {
	
	public static int gas_sensor_value=0;
	public static float  gas_sensor_perc=0; 
	
	public static int gas_timer =15;
	public static int water_timer =15;
	
	
	public static int kitchen_fire_sensor_value=0;
	public static int livingroom_fire_sensor_value=0;
	public static int bedroom_fire_sensor_value=0;
	public static int bathroom_fire_sensor_value=0;
	
	public static int kitchen_sprink_sensor_value=0;
	public static int livingroom_sprink_sensor_value=0;
	public static int bedroom_sprink_sensor_value=0;
	public static int bathroom_sprink_sensor_value=0;
	
	public static float kitchen_temp_sensor_value=18;
	public static float livingroom_temp_sensor_value=18;
	public static float bedroom_temp_sensor_value=18;
	public static float bathroom_temp_sensor_value=18;
	
	public static int kitchen_water_sensor_value=0;
	public static int bathroom_water_sensor_value=0;

	
	public static int kitchen_window_sensor_value=0;
	public static int livingroom_window_sensor_value=0;
	public static int bedroom_window_sensor_value=0;
	public static int bathroom_window_sensor_value=0;
	
	public static int kitchen_door_sensor_value=1;
	public static int livingroom_door_sensor_value=1;
	public static int bedroom_door_sensor_value=1;
	public static int bathroom_door_sensor_value=1;
	
	public static int kitchen_presence_value=0;
	public static int livingroom_presence_value=0;
	public static int bedroom_presence_value=0;
	public static int bathroom_presence_value=0;
	
	public static int kitchen_heater_sensor_value=0;
	public static int bathroom_heater_sensor_value=0;
	public static int livingroom_heater_sensor_value=0;
	public static int bedroom_heater_sensor_value=0;

	public static int kitchen_ac_sensor_value=0;
	public static int bathroom_ac_sensor_value=0;
	public static int livingroom_ac_sensor_value=0;
	public static int bedroom_ac_sensor_value=0;
	
	
	public static float kitchen_day_min_value=17;
	public static float kitchen_day_max_value=20;
	public static float kitchen_night_min_value=17;
	public static float kitchen_night_max_value=20;
	
	public static float livingroom_day_min_value=17;
	public static float livingroom_day_max_value=20;
	public static float livingroom_night_min_value=17;
	public static float livingroom_night_max_value=20;
	
	public static float bedroom_day_min_value=17;
	public static float bedroom_day_max_value=20;
	public static float bedroom_night_min_value=17;
	public static float bedroom_night_max_value=20;
	
	public static float bathroom_day_min_value=17;
	public static float bathroom_day_max_value=20;
	public static float bathroom_night_min_value=17;
	public static float bathroom_night_max_value=20;
	
	public static float kitchen_presence_min_value=17;
	public static float kitchen_presence_max_value=20;
	
	public static float bedroom_presence_min_value=17;
	public static float bedroom_presence_max_value=20;
	
	public static float bathroom_presence_min_value=17;
	public static float bathroom_presence_max_value=20;
	
	public static float livingroom_presence_min_value=17;
	public static float livingroom_presence_max_value=20;
	
	public static int presence_mode=0;
	
	public void updateGasSensorValue (int state) {
		gas_sensor_value = state;
	}
	
	public void updateGasTimer (int state) {
		gas_timer = state;
	}
	
	public void updateWaterTimer (int state) {
		water_timer = state;
	}
	
	public void updateGasSensorPercValue (float value) {
		gas_sensor_perc = value;
	}
	
	public void updateKitchenfireSensorValue (int state) {
		kitchen_fire_sensor_value = state;
	}
	
	public void updateKitchenWindowSensorValue (int state) {
		kitchen_window_sensor_value = state;
	}
	
	public void updateLivingroomFireSensorValue (int state) {
		livingroom_fire_sensor_value = state;
	}
	
	public void updateBedroomfireSensorValue (int state) {
		bedroom_fire_sensor_value = state;
	}
	
	public void updateKitchenSprinkSensorValue (int state) {
		kitchen_sprink_sensor_value=state;
	}
	
	public void updateLivingroomSprinkSensorValue (int state) {
		livingroom_sprink_sensor_value=state;
	}
	
	public void updateKitchenDoorSensorValue (int state) {
		kitchen_door_sensor_value=state;
	}
	
	public void updateLivingroomDoorSensorValue (int state) {
		livingroom_door_sensor_value=state;
	}
	
	public void updateBathroomDoorSensorValue (int state) {
		bathroom_door_sensor_value=state;
	}
	
	public void updateBedroomDoorSensorValue (int state) {
		bedroom_door_sensor_value=state;
	}
	
	public void updateKitchenPresenceValue (int state) {
		kitchen_presence_value=state;
	}
	
	public void updateLivingroomPresenceValue (int state) {
		livingroom_presence_value=state;
	}
	
	public void updateBathroomPresenceValue (int state) {
		bathroom_presence_value=state;
	}
	
	public void updateBedroomPresenceValue (int state) {
		bedroom_presence_value=state;
	}
	
	public void updateBedroomSprinkSensorValue (int state) {
		bedroom_sprink_sensor_value=state;
	}
	
	public void updateBathroomfireSensorValue (int state) {
		bathroom_fire_sensor_value = state;
	}
	
	public void updateKitchenTemperatureSensorValue (float value) {
		kitchen_temp_sensor_value = value;
	}
	
	public void updatelivingroomTemperatureSensorValue (float value) {
		livingroom_temp_sensor_value = value;
	}
	
	public void updatebedroomTemperatureSensorValue (float value) {
		bedroom_temp_sensor_value = value;
	}
	
	public void updateBathroomTemperatureSensorValue (float value) {
		bathroom_temp_sensor_value = value;
	}
	
	public void updateKitchenWaterSensorValue (int state) {
		kitchen_water_sensor_value = state;
	}
	
	public void updateBathroomWaterSensorValue (int state) {
		bathroom_water_sensor_value = state;
	}

	public void updateBathroomSprinkSensorValue(int state) {
		bathroom_sprink_sensor_value=state;
	}

	public void updateBathroomWindowSensorValue(int state) {
		bathroom_window_sensor_value=state;		
	}

	public void updateBedroomWindowSensorValue(int state) {
		bedroom_window_sensor_value=state;		
	}

	public void updateLivingRoomWindowSensorValue(int state) {
		livingroom_window_sensor_value=state;		
	}

	public void updateKitchenHeaterSensorValue(int state) {
		kitchen_heater_sensor_value=state;
	}

	public void updateBathroomHeaterSensorValue(int state) {
		bathroom_heater_sensor_value=state;
	}
	
	public void updateBedroomHeaterSensorValue(int state) {
		bedroom_heater_sensor_value=state;
	}
	
	public void updateLivingroomHeaterSensorValue(int state) {
		livingroom_heater_sensor_value=state;
	}
	
	public void updateKitchenACSensorValue(int state) {
		kitchen_ac_sensor_value=state;
	}

	public void updateBathroomACSensorValue(int state) {
		bathroom_ac_sensor_value=state;
	}
	
	public void updateBedroomACSensorValue(int state) {
		bedroom_ac_sensor_value=state;
	}
	
	public void updateLivingroomACSensorValue(int state) {
		livingroom_ac_sensor_value=state;
	}
	
	public void updateKitchenDayMinValue(float value) {
		kitchen_day_min_value=value;
		
	}

	public void updateKitchenDayMaxValue(float value) {
		kitchen_day_max_value=value;
		
	}

	public void updateKitchenNightMinValue(float value) {
		kitchen_night_min_value=value;
		
	}

	public void updateKitchenNightMaxValue(float value) {
		kitchen_night_max_value=value;
		
	}

	public void updateLivingroomDayMinValue(float value) {
		livingroom_day_min_value=value;
		
	}

	public void updateLivingroomDayMaxValue(float value) {
		livingroom_day_max_value=value;
		
	}

	public void updateLivingroomNightMinValue(float value) {
		livingroom_night_min_value=value;
		
	}

	public void updateLivingroomNightMaxValue(float value) {
		livingroom_night_max_value=value;
		
	}

	public void updateBedroomDayMinValue(float value) {
		bedroom_day_min_value=value;
		
	}

	public void updateBedroomDayMaxValue(float value) {
		bedroom_day_max_value=value;
		
	}

	public void updateBedroomNightMinValue(float value) {
		bedroom_night_min_value=value;
		
	}

	public void updateBedroomNightMaxValue(float value) {
		bedroom_night_max_value=value;
		
	}

	public void updateBathroomDayMinValue(float value) {
		bathroom_day_min_value=value;
		
	}

	public void updateBathroomDayMaxValue(float value) {
		bathroom_day_max_value=value;
		
	}

	public void updateBathroomNightMinValue(float value) {
		bathroom_night_min_value=value;
		
	}

	public void updateBathroomNightMaxValue(float value) {
		bathroom_night_max_value=value;
		
	}

	public void updateKitchenPresenceMinValue(float value) {
		kitchen_presence_min_value=value;
		
	}

	public void updateKitchenPresenceMaxValue(float value) {
		kitchen_presence_max_value=value;
		
	}

	public void updateLivingroomPresenceMinValue(float value) {
		livingroom_presence_min_value=value;
		
	}

	public void updateLivingroomPresenceMaxValue(float value) {
		livingroom_presence_max_value=value;
		
	}

	public void updateBedroomPresenceMinValue(float value) {
		bedroom_presence_min_value=value;
		
	}

	public void updateBedroomPresenceMaxValue(float value) {
		kitchen_presence_max_value=value;
		
	}

	public void updateBathroomPresenceMinValue(float value) {
		bathroom_presence_min_value=value;
		
	}

	public void updateBathroomPresenceMaxValue(float value) {
		bathroom_presence_max_value=value;
		
	}

	public void updatePresenceMode(int value) {
		presence_mode=value;
	}
	

}
