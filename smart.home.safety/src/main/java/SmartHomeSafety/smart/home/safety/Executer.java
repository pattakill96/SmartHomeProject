package SmartHomeSafety.smart.home.safety;

public class Executer {
	
	
	public void openWindow (String room) {
		publishData("home/"+room+"/window/ON", "1");
	}

	public void closeWindow (String room) {
		publishData("home/"+room+"/window/ON", "0");
	}

	public void closeGasKnobs() { 
		publishData(MqttTopic.KITCHEN_GASKNOB_ON.getTopic(), "0");
	}
	
	public void startWaterSprinkler(String room) {
		publishData("home/"+room+"/sprink/ON", "1");
	}
	
	public void stopWaterSprinkler(String room) {
		publishData("home/"+room+"/sprink/ON", "0");
	}
		
	public void closeWaterTaps(String room) {
		publishData("home/"+room+"/water/ON", "0");
	}
	
	public void closeWaterPipe() {
		publishData(MqttTopic.HOME_WATER_PIPE.getTopic(), "0");
	}

	public void stopFire(String room) {
		publishData("home/"+room+"/fire/ON", "0");
	}
	
	public void turnHeaterON(String room) {
		publishData("home/"+room+"/heater/ON", "1");
	}
	
	public void turnHeaterOFF(String room) {
		publishData("home/"+room+"/heater/ON", "0");
	}
	
	public void turnACON(String room) {
		publishData("home/"+room+"/AC/ON", "1");
	}
	
	public void turnACOFF(String room) {
		publishData("home/"+room+"/AC/ON", "0");
	}
	
	public void closeDoor(String room) {
		publishData("home/"+room+"/door/ON", "0");
	}
	
	private void publishData(String topic, String message) {
		MQTTBroker conn = null;
		try {
			conn = new MQTTBroker();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		conn.send(topic, message);

	}

	public void importfromDB() {
		DBConnector d = new DBConnector();
		try {
		d.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.updateTempSettings();
		this.publishData("home/setter/importmode/ON", "0");
	}
		
	

	public void saveinDB() {
		DBConnector d = new DBConnector();
		try {
		d.saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.publishData("home/setter/savemode/ON", "0");
	}

	private void updateTempSettings() {
		this.publishData(MqttTopicTempSetter.KITCHEN_TEMP_DAY_MIN.getTopic(),String.valueOf(SensorValues.kitchen_day_min_value));
		this.publishData(MqttTopicTempSetter.KITCHEN_TEMP_DAY_MAX.getTopic(),String.valueOf(SensorValues.kitchen_day_max_value));
		this.publishData(MqttTopicTempSetter.KITCHEN_TEMP_NIGHT_MIN.getTopic(),String.valueOf(SensorValues.kitchen_night_min_value));
		this.publishData(MqttTopicTempSetter.KITCHEN_TEMP_NIGHT_MAX.getTopic(),String.valueOf(SensorValues.kitchen_night_max_value));
		this.publishData(MqttTopicTempSetter.LIVINGROOM_TEMP_DAY_MIN.getTopic(),String.valueOf(SensorValues.livingroom_day_min_value));
		this.publishData(MqttTopicTempSetter.LIVINGROOM_TEMP_DAY_MAX.getTopic(),String.valueOf(SensorValues.livingroom_day_max_value));
		this.publishData(MqttTopicTempSetter.LIVINGROOM_TEMP_NIGHT_MIN.getTopic(),String.valueOf(SensorValues.livingroom_night_min_value));
		this.publishData(MqttTopicTempSetter.LIVINGROOM_TEMP_NIGHT_MAX.getTopic(),String.valueOf(SensorValues.livingroom_night_max_value));
		this.publishData(MqttTopicTempSetter.BEDROOM_TEMP_DAY_MIN.getTopic(),String.valueOf(SensorValues.bedroom_day_min_value));
		this.publishData(MqttTopicTempSetter.BEDROOM_TEMP_DAY_MAX.getTopic(),String.valueOf(SensorValues.bedroom_day_max_value));
		this.publishData(MqttTopicTempSetter.BEDROOM_TEMP_NIGHT_MIN.getTopic(),String.valueOf(SensorValues.bedroom_night_min_value));
		this.publishData(MqttTopicTempSetter.BEDROOM_TEMP_NIGHT_MAX.getTopic(),String.valueOf(SensorValues.bedroom_night_max_value));
		this.publishData(MqttTopicTempSetter.BATHROOM_TEMP_DAY_MIN.getTopic(),String.valueOf(SensorValues.bathroom_day_min_value));
		this.publishData(MqttTopicTempSetter.BATHROOM_TEMP_DAY_MAX.getTopic(),String.valueOf(SensorValues.bathroom_day_max_value));
		this.publishData(MqttTopicTempSetter.BATHROOM_TEMP_NIGHT_MIN.getTopic(),String.valueOf(SensorValues.bathroom_night_min_value));
		this.publishData(MqttTopicTempSetter.BATHROOM_TEMP_NIGHT_MAX.getTopic(),String.valueOf(SensorValues.bathroom_night_max_value));
		this.publishData(MqttTopicTempSetter.KITCHEN_TEMP_PRESENCE_MIN.getTopic(),String.valueOf(SensorValues.kitchen_presence_min_value));
		this.publishData(MqttTopicTempSetter.KITCHEN_TEMP_PRESENCE_MIN.getTopic(),String.valueOf(SensorValues.kitchen_presence_max_value));
		this.publishData(MqttTopicTempSetter.LIVINGROOM_TEMP_PRESENCE_MIN.getTopic(),String.valueOf(SensorValues.kitchen_presence_min_value));
		this.publishData(MqttTopicTempSetter.LIVINGROOM_TEMP_PRESENCE_MIN.getTopic(),String.valueOf(SensorValues.kitchen_presence_max_value));
		this.publishData(MqttTopicTempSetter.BEDROOM_TEMP_PRESENCE_MIN.getTopic(),String.valueOf(SensorValues.kitchen_presence_min_value));
		this.publishData(MqttTopicTempSetter.BEDROOM_TEMP_PRESENCE_MIN.getTopic(),String.valueOf(SensorValues.kitchen_presence_min_value));
		this.publishData(MqttTopicTempSetter.BATHROOM_TEMP_PRESENCE_MIN.getTopic(),String.valueOf(SensorValues.kitchen_presence_min_value));
		this.publishData(MqttTopicTempSetter.BATHROOM_TEMP_PRESENCE_MIN.getTopic(),String.valueOf(SensorValues.kitchen_presence_min_value));
		
	}
	
}
