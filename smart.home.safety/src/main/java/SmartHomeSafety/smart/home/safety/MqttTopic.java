package SmartHomeSafety.smart.home.safety;

public enum MqttTopic {
	
	KITCHEN_TEMP("home/kitchen/temperature"),
	BEDROOM_TEMP("home/bedroom/temperature"),
	BATHROOM_TEMP("home/bathroom/temperature"),
	LIVINGROOM_TEMP("home/livingroom/temperature"),
	
	KITCHEN_WINDOW("home/kitchen/window"),
	BEDROOM_WINDOW("home/bedroom/window"),
	BATHROOM_WINDOW("home/bathroom/window"),
	LIVINGROOM_WINDOW("home/livingroom/window"),
	
	KITCHEN_WINDOW_ON("home/kitchen/window/ON"),
	BEDROOM_WINDOW_ON("home/bedroom/window/ON"),
	BATHROOM_WINDOW_ON("home/bathroom/window/ON"),
	LIVINGROOM_WINDOW_ON("home/livingroom/window/ON"),
	
	KITCHEN_FIRE("home/kitchen/fire"),
	BEDROOM_FIRE("home/bedroom/fire"),
	BATHROOM_FIRE("home/bathroom/fire"),
	LIVINGROOM_FIRE("home/livingroom/fire"),
	
	KITCHEN_FIRE_ON("home/kitchen/fire/ON"),
	BEDROOM_FIRE_ON("home/bedroom/fire/ON"),
	BATHROOM_FIRE_ON("home/bathroom/fire/ON"),
	LIVINGROOM_FIRE_ON("home/livingroom/fire/ON"),
	
	KITCHEN_SPRINKLER("home/kitchen/sprink"),
	BEDROOM_SPRINKLER("home/bedroom/sprink"),
	BATHROOM_SPRINKLER("home/bathroom/sprink"),
	LIVINGROOM_SPRINKLER("home/livingroom/sprink"),
	
	KITCHEN_SPRINKLER_ON("home/kitchen/sprink/ON"),
	BEDROOM_SPRINKLER_ON("home/bedroom/sprink/ON"),
	BATHROOM_SPRINKLER_ON("home/bathroom/sprink/ON"),
	LIVINGROOM_SPRINKLER_ON("home/livingroom/sprink/ON"),
	
	KITCHEN_GASKNOB_ON("home/kitchen/gasknob/ON"),
	KITCHEN_GASKNOB("home/kitchen/gasknob"),
	KITCHEN_GASSENSOR("home/kitchen/gasPerc"),
	
	KITCHEN_WATER_ON("home/kitchen/water/ON"),
	KITCHEN_WATER("home/kitchen/water"),
	BATHROOM_WATER_ON("home/bathroom/water/ON"),
	BATHROOM_WATER("home/bathroom/water"),

	;

	private final String topic;

	private MqttTopic(String topic) {
		this.topic = topic;
	}
	
	public String getTopic() {
		return topic;
	}

}
