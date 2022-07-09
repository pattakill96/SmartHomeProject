package SmartHomeSafety.smart.home.safety;

public enum MqttTopicTempSetter {
	
	
	
	KITCHEN_TEMP_DAY_MIN("home/setter/kdmin/ON"),
	KITCHEN_TEMP_DAY_MAX("home/setter/kdmax/ON"),
	KITCHEN_TEMP_NIGHT_MIN("home/setter/knmin/ON"),
	KITCHEN_TEMP_NIGHT_MAX("home/setter/knmax/ON"),
	
	LIVINGROOM_TEMP_DAY_MIN("home/setter/ldmin/ON"),
	LIVINGROOM_TEMP_DAY_MAX("home/setter/ldmax/ON"),
	LIVINGROOM_TEMP_NIGHT_MIN("home/setter/lnmin/ON"),
	LIVINGROOM_TEMP_NIGHT_MAX("home/setter/lnmax/ON"),
	
	BEDROOM_TEMP_DAY_MIN("home/setter/bdmin/ON"),
	BEDROOM_TEMP_DAY_MAX("home/setter/bdmax/ON"),
	BEDROOM_TEMP_NIGHT_MIN("home/setter/bnmin/ON"),
	BEDROOM_TEMP_NIGHT_MAX("home/setter/bnmax/ON"),
	
	BATHROOM_TEMP_DAY_MIN("home/setter/btdmin/ON"),
	BATHROOM_TEMP_DAY_MAX("home/setter/btdmax/ON"),
	BATHROOM_TEMP_NIGHT_MIN("home/setter/btnmin/ON"),
	BATHROOM_TEMP_NIGHT_MAX("home/setter/btnmax/ON"),
	
	KITCHEN_TEMP_PRESENCE_MIN("home/presence/kmin/ON"),
	KITCHEN_TEMP_PRESENCE_MAX("home/presence/kmax/ON"),
	
	LIVINGROOM_TEMP_PRESENCE_MIN("home/presence/lmin/ON"),
	LIVINGROOM_TEMP_PRESENCE_MAX("home/presence/lmax/ON"),
	
	BEDROOM_TEMP_PRESENCE_MIN("home/presence/bmin/ON"),
	BEDROOM_TEMP_PRESENCE_MAX("home/presence/bmax/ON"),
	
	BATHROOM_TEMP_PRESENCE_MIN("home/presence/btmin/ON"),
	BATHROOM_TEMP_PRESENCE_MAX("home/presence/btmax/ON"),
	
	GAS_TIME("home/setter/gastime/ON"),
	WATER_TIME("home/setter/watertime/ON"),
	KITCHEN_TEMP("home/kitchen/temperature/ON"),
	BEDROOM_TEMP("home/bedroom/temperature/ON"),
	BATHROOM_TEMP("home/bathroom/temperature/ON"),
	LIVINGROOM_TEMP("home/livingroom/temperature/ON"),
	KITCHEN_GASSENSOR("home/kitchen/gasPerc/ON"),
	PRESENCE_MODE("home/presence/mode/ON");
	;

	private final String topic;

	private MqttTopicTempSetter(String topic) {
		this.topic = topic;
	}
	
	public String getTopic() {
		return topic;
	}

}
