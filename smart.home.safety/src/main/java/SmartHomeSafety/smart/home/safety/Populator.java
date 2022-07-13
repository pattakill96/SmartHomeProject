package SmartHomeSafety.smart.home.safety;

public class Populator {
	public void Populate() {
		
		
		for (MqttTopicTempSetter topic : MqttTopicTempSetter.values()) {
			
			if(topic.getTopic().contains("min")) {
				this.publishData(topic.getTopic(),"17");
			}
			
			if(topic.getTopic().contains("max")) {
				this.publishData(topic.getTopic(),"20");
			}
			
			if(topic.getTopic().contains("time")) {
				this.publishData(topic.getTopic(),"15");
			}
			
			if(topic.getTopic().contains("temperature")) {
				this.publishData(topic.getTopic(),"18");
			}
			
			if(topic.getTopic().contains("gasP")) {
				this.publishData(topic.getTopic(),"0.0");
			}
			
			if(topic.getTopic().contains("mode")) {
				this.publishData(topic.getTopic(),"0");
			}
		
		}
		
		for (MqttTopic topic : MqttTopic.values()) {
			
			if(topic.getTopic().contains("door") || topic.getTopic().contains("pipe")) {
				this.publishData(topic.getTopic(),"1");
			}
			
			else {
				if(topic.getTopic().contains("Detector"))
					this.publishData(topic.getTopic(),"0.0");
				else {
					this.publishData(topic.getTopic(),"0");
				}
			}
		
		}
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
	
}

	

