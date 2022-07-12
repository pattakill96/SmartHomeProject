package SmartHomeSafety.smart.home.safety;

public class Populator {
	Utils u= new Utils();
	public void Populate() {
		
		
		for (MqttTopicTempSetter topic : MqttTopicTempSetter.values()) {
			if(topic.getTopic().contains("min")) {
				u.publishData(topic.getTopic(),"17");
			}
			if(topic.getTopic().contains("max")) {

				u.publishData(topic.getTopic(),"20");
			}
			if(topic.getTopic().contains("time")) {
				u.publishData(topic.getTopic(),"15");
			}
			if(topic.getTopic().contains("temperature")) {
				u.publishData(topic.getTopic(),"18");
			}
			
			if(topic.getTopic().contains("gasP")) {
				u.publishData(topic.getTopic(),"0.0");
			}
			
			if(topic.getTopic().contains("mode")) {
				u.publishData(topic.getTopic(),"0");
			}
		
		}
		
		for (MqttTopic topic : MqttTopic.values()) {
			if(topic.getTopic().contains("door") || topic.getTopic().contains("pipe")) {
				u.publishData(topic.getTopic(),"1");
			}
			else {
			if(topic.getTopic().contains("Detector"))
				u.publishData(topic.getTopic(),"0.0");
			else {

				u.publishData(topic.getTopic(),"0");
			}
			}
		
		}
	}
	
	public void updateTempSettings() {
		
		u.publishRawData(MqttTopicTempSetter.KITCHEN_TEMP_DAY_MIN.getTopic(),SensorValues.kitchen_day_min_value);
		u.publishRawData(MqttTopicTempSetter.KITCHEN_TEMP_DAY_MAX.getTopic(),SensorValues.kitchen_day_max_value);
		u.publishRawData(MqttTopicTempSetter.KITCHEN_TEMP_NIGHT_MIN.getTopic(),SensorValues.kitchen_night_min_value);
		u.publishRawData(MqttTopicTempSetter.KITCHEN_TEMP_NIGHT_MAX.getTopic(),SensorValues.kitchen_night_max_value);
		u.publishRawData(MqttTopicTempSetter.LIVINGROOM_TEMP_DAY_MIN.getTopic(),SensorValues.livingroom_day_min_value);
		u.publishRawData(MqttTopicTempSetter.LIVINGROOM_TEMP_DAY_MAX.getTopic(),SensorValues.livingroom_day_max_value);
		u.publishRawData(MqttTopicTempSetter.LIVINGROOM_TEMP_NIGHT_MIN.getTopic(),SensorValues.livingroom_night_min_value);
		u.publishRawData(MqttTopicTempSetter.LIVINGROOM_TEMP_NIGHT_MAX.getTopic(),SensorValues.livingroom_night_max_value);
		u.publishRawData(MqttTopicTempSetter.BEDROOM_TEMP_DAY_MIN.getTopic(),SensorValues.bedroom_day_min_value);
		u.publishRawData(MqttTopicTempSetter.BEDROOM_TEMP_DAY_MAX.getTopic(),SensorValues.bedroom_day_max_value);
		u.publishRawData(MqttTopicTempSetter.BEDROOM_TEMP_NIGHT_MIN.getTopic(),SensorValues.bedroom_night_min_value);
		u.publishRawData(MqttTopicTempSetter.BEDROOM_TEMP_NIGHT_MAX.getTopic(),SensorValues.bedroom_night_max_value);
		u.publishRawData(MqttTopicTempSetter.BATHROOM_TEMP_DAY_MIN.getTopic(),SensorValues.bathroom_day_min_value);
		u.publishRawData(MqttTopicTempSetter.BATHROOM_TEMP_DAY_MAX.getTopic(),SensorValues.bathroom_day_max_value);
		u.publishRawData(MqttTopicTempSetter.BATHROOM_TEMP_NIGHT_MIN.getTopic(),SensorValues.bathroom_night_min_value);
		u.publishRawData(MqttTopicTempSetter.BATHROOM_TEMP_NIGHT_MAX.getTopic(),SensorValues.bathroom_night_max_value);
		u.publishRawData(MqttTopicTempSetter.KITCHEN_TEMP_PRESENCE_MIN.getTopic(),SensorValues.kitchen_presence_min_value);
		u.publishRawData(MqttTopicTempSetter.KITCHEN_TEMP_PRESENCE_MIN.getTopic(),SensorValues.kitchen_presence_max_value);
		u.publishRawData(MqttTopicTempSetter.LIVINGROOM_TEMP_PRESENCE_MIN.getTopic(),SensorValues.kitchen_presence_min_value);
		u.publishRawData(MqttTopicTempSetter.LIVINGROOM_TEMP_PRESENCE_MIN.getTopic(),SensorValues.kitchen_presence_max_value);
		u.publishRawData(MqttTopicTempSetter.BEDROOM_TEMP_PRESENCE_MIN.getTopic(),SensorValues.kitchen_presence_min_value);
		u.publishRawData(MqttTopicTempSetter.BEDROOM_TEMP_PRESENCE_MIN.getTopic(),SensorValues.kitchen_presence_min_value);
		u.publishRawData(MqttTopicTempSetter.BATHROOM_TEMP_PRESENCE_MIN.getTopic(),SensorValues.kitchen_presence_min_value);
		u.publishRawData(MqttTopicTempSetter.BATHROOM_TEMP_PRESENCE_MIN.getTopic(),SensorValues.kitchen_presence_min_value);
		
	}
}

	

