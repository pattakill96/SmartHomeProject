package SmartHomeSafety.smart.home.safety;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTTBroker {
	private final String broker = "tcp://localhost:1883";
	private final String clientId = "Executor";
	private final int qos = 2;
	private MqttClient sampleClient = null;
	private MemoryPersistence persistence;

	public MQTTBroker() throws MqttException{
		sampleClient = new MqttClient(broker, clientId,persistence);
		MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        sampleClient.connect(connOpts);
	}
	
	public void send(String topic, String content) {
		String s= "OPEN";
		String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		if(content.equals("0"))
			s="CLOSE";
		if(!content.equals("0") && !content.equals("1"))
			s=content;
        try {
            System.out.println("["+timestamp+"] System send message (" + topic + "): " + s);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
        } catch(MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
	}
	
	@Override
	public void finalize() throws MqttException {
		sampleClient.disconnect();
        System.out.println("Executor disconnected");
	}
}
