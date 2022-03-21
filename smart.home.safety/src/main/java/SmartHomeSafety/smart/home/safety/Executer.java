package SmartHomeSafety.smart.home.safety;


import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Executer implements MqttCallback {
	
	int windowflag = 0;
	SensorValues obj = new SensorValues();
	public void openWindow (String room) {
		try {
				MqttClient client = new MqttClient("tcp://localhost:1883","Executer");
				client.setCallback(this);
				MqttConnectOptions mqOptions=new MqttConnectOptions();
				mqOptions.setCleanSession(true);
				client.connect(mqOptions);	
				String command = "{home: {"+room+": { window: 1}}}";
				MqttMessage message = new MqttMessage(command.getBytes());
				message.setQos(1);
				client.publish("home/"+room+"/window/ON", message);			

		} catch (MqttException e) {
			e.printStackTrace();
		} 
	}


	public void closeGasKnobs() {
		try {
			MqttClient client = new MqttClient("tcp://localhost:1883","Executer");
			client.setCallback(this);
			MqttConnectOptions mqOptions=new MqttConnectOptions();
			mqOptions.setCleanSession(true);
			client.connect(mqOptions);     


			String command = "{home: {kitchen: { gasknob: 0}}}";
			MqttMessage message = new MqttMessage(command.getBytes());
			message.setQos(1);
			client.publish("home/kitchen/gasknob/ON", message);

		} catch (MqttException  e) {
			e.printStackTrace();
		} 

	}
	
	public void closeDoor(String room) {
		try {
			MqttClient client = new MqttClient("tcp://localhost:1883","Executer");
			client.setCallback(this);
			MqttConnectOptions mqOptions=new MqttConnectOptions();
			mqOptions.setCleanSession(true);
			client.connect(mqOptions);     
			String command = "{home: {"+room+": { door: 0}}}";
			MqttMessage message = new MqttMessage(command.getBytes());
			message.setQos(1);
			client.publish("home/"+room+"/door/ON", message);

		} catch (MqttException  e) {
			e.printStackTrace();
		} 

	}
	
	public void startWaterSprinkler(String room) {
		try {
			MqttClient client = new MqttClient("tcp://localhost:1883","Executer");
			client.setCallback(this);
			MqttConnectOptions mqOptions=new MqttConnectOptions();
			mqOptions.setCleanSession(true);
			client.connect(mqOptions);     
			String command = "{home: {"+room+": { sprink: 1}}}";
			MqttMessage message = new MqttMessage(command.getBytes());
			message.setQos(1);
			client.publish("home/"+room+"/sprink/ON", message);

		} catch (MqttException e) {
			e.printStackTrace();
		} 
	}
	
	public void stopWaterSprinkler(String room) {
		try {
			MqttClient client = new MqttClient("tcp://localhost:1883","Executer");
			client.setCallback(this);
			MqttConnectOptions mqOptions=new MqttConnectOptions();
			mqOptions.setCleanSession(true);
			client.connect(mqOptions);     
			String command = "{home: {"+room+": { sprink: 0}}}";
			MqttMessage message = new MqttMessage(command.getBytes());
			message.setQos(1);
			client.publish("home/"+room+"/sprink/ON", message);

		} catch (MqttException e) {
			e.printStackTrace();
		} 
	}
		
		public void closeWaterTaps(String room) {
			try {
				MqttClient client = new MqttClient("tcp://localhost:1883","Executer");
				client.setCallback(this);
				MqttConnectOptions mqOptions=new MqttConnectOptions();
				mqOptions.setCleanSession(true);
				client.connect(mqOptions);     

				String command = "{home: {"+room+": { water: 0}}}";
				MqttMessage message = new MqttMessage(command.getBytes());
				message.setQos(1);
				client.publish("home/"+room+"/water/ON", message);


			} catch (MqttException e) {
				e.printStackTrace();
			} 
		
		
	}

	public void stopFire(String room) {
		try {
			MqttClient client = new MqttClient("tcp://localhost:1883","Executer");
			client.setCallback(this);
			MqttConnectOptions mqOptions=new MqttConnectOptions();
			mqOptions.setCleanSession(true);
			client.connect(mqOptions);     
			String command = "{home: {"+room+": { fire: 0}}}";
			MqttMessage message = new MqttMessage(command.getBytes());
			message.setQos(1);
			client.publish("home/"+room+"/fire/ON", message);

		} catch (MqttException e) {
			e.printStackTrace();
		} 
			
		}
	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub

	}


	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub

	}


	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub

	}


	


}
