package SmartHomeSafety.smart.home.safety;

import org.eclipse.paho.client.mqttv3.*;
import com.google.gson.*;
import java.lang.String;


public class Monitor implements MqttCallback{
	Analyzer analyzer = new Analyzer();

	public Monitor() throws MqttException {

		MqttClient client = new MqttClient("tcp://localhost:1883","Monitor");
		client.setCallback(this);
		MqttConnectOptions mqOptions=new MqttConnectOptions();
		mqOptions.setCleanSession(true);
		client.connect(mqOptions);
		
		for (MqttTopic topic : MqttTopic.values()) {
			client.subscribe(topic.getTopic());
		}
	}


	//Override methods from MqttCallback interface
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		int state = 0;
		float value=0;
		String b[] = topic.split("/");
		String msg = message.toString();
		if(msg.length()==1)
			state = Integer.parseInt(msg);
		else {
		JsonObject command = new Gson().fromJson(msg, JsonObject.class);
		JsonObject home = (JsonObject) command.get(b[0]);
		JsonObject room = (JsonObject) home.get(b[1]);
		value = room.get(b[2]).getAsFloat();
		if(b.length==4) {
			state = room.get(b[2]).getAsInt();}}
		switch(b[2]) {				
			case "temperature": {
				analyzer.TempSensorArrived(b[1], value);
				break;
			}
			
			case "window": {
				analyzer.WindowSensorArrived(b[1], state);
				break;
			}
			
			case "water": {
				analyzer.WaterSensorArrived(b[1], state);
				break;
			}
			
			case "fire": {
				analyzer.FireSensorArrived(b[1], state);
				break;
			}
			
			case "gasknob": {
				analyzer.GasSensorArrived(b[1], state);
				break;
			}
			
			case "gasPerc": {
				analyzer.GasSensorPercArrived(b[1], value);
				break;
			}
			
			case "sprink": {
				analyzer.SprinklerSensorArrived(b[1], state);
				break;
			}
		
		
		}

	}


	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub

	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub

	}


}


