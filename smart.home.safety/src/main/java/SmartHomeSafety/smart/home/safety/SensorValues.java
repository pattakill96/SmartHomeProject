package SmartHomeSafety.smart.home.safety;



public class SensorValues {
	
	public static int gas_sensor_value;
	public static float  gas_sensor_perc; 
	
	public static int gas_timer = 5;
	
	
	public static int kitchen_fire_sensor_value;
	public static int livingroom_fire_sensor_value;
	public static int bedroom_fire_sensor_value;
	public static int bathroom_fire_sensor_value;
	
	public static int kitchen_sprink_sensor_value;
	public static int livingroom_sprink_sensor_value;
	public static int bedroom_sprink_sensor_value;
	public static int bathroom_sprink_sensor_value;
	
	public static float kitchen_temp_sensor_value;
	public static float livingroom_temp_sensor_value;
	public static float bedroom_temp_sensor_value;
	public static float bathroom_temp_sensor_value;
	
	public static int kitchen_water_sensor_value;
	public static int bathroom_water_sensor_value;

	
	public static int kitchen_window_sensor_value;
	public static int livingroom_window_sensor_value;
	public static int bedroom_window_sensor_value;
	public static int bathroom_window_sensor_value;
	
	public static int kitchen_door_sensor_value;
	public static int livingroom_door_sensor_value;
	public static int bedroom_door_sensor_value;
	public static int bathroom_door_sensor_value;
	
	public static int kitchen_presence_value;
	public static int livingroom_presence_value;
	public static int bedroom_presence_value;
	public static int bathroom_presence_value;

	
	public void updateGasSensorValue (int state) {
		gas_sensor_value = state;
	}
	
	public void updateGasTimer (int state) {
		gas_timer = state;
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



}
