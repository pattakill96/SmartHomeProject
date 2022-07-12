package SmartHomeSafety.smart.home.safety;

public class Executer {
	
	int windowflag = 0;
	SensorValues obj = new SensorValues();
	
	
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
	
	public void publishData(String topic, String message) {
		MQTTBroker conn = null;
		try {
			conn = new MQTTBroker();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		conn.send(topic, message);

	}

	public void importdatafromDB() {
		DBConnector d = new DBConnector();
		try {
		d.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Populator p = new Populator();
		p.updateTempSettings();
		publishData("home/setter/importmode/ON", "0");
	}
		
	

	public void savedatafromDB() {
		DBConnector d = new DBConnector();
		try {
		d.saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		publishData("home/setter/savemode/ON", "0");
	}

	
	
}
