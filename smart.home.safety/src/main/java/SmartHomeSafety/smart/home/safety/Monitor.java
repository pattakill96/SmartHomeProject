package SmartHomeSafety.smart.home.safety;

import org.eclipse.paho.client.mqttv3.*;
import com.google.gson.*;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Monitor implements MqttCallback{
	Analyzer analyzer = new Analyzer();

	public Monitor() throws MqttException {

		MqttClient client = new MqttClient("tcp://localhost:1883","Monitor");
		client.setCallback(this);
		MqttConnectOptions mqOptions=new MqttConnectOptions();
		mqOptions.setCleanSession(true);
		client.connect(mqOptions);
	
		
		//for (MqttTopic topic : MqttTopic.values()) {
			//System.out.println("aaa");
			client.subscribe("#");
		//}
	}


	//Override methods from MqttCallback interface
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		String b[] = topic.split("/");
		String msg = message.toString();
		String s= "OPEN";
		String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		if(msg.equals("0"))
			s="CLOSE";
		if(!msg.equals("0") && !msg.equals("1"))
			s=msg;
		if(!topic.contains("ON"))
            System.out.println("["+timestamp+"] System received message (" + topic + "): " + s);
		//System.out.println(b[1]+" "+b[2]+" "+msg);
		try {
		analyzer.updateData(b[1], msg, b[2],topic.contains("ON"));
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}
		/*switch(b[2]) {				
			case "temperature": {
				
				//analyzer.TempSensorArrived(b[1], msg);
				break;
			}
			
			case "window": {
				System.out.println(topic+" "+msg);
				//analyzer.WindowSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "water": {
				System.out.println(topic+" "+msg);
				//analyzer.WaterSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "fire": {
				System.out.println(topic+" "+msg);
				//analyzer.FireSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "gasknob": {
				System.out.println(topic+" "+msg);
				//analyzer.GasSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "gasPerc": {
				System.out.println(topic+" "+msg);
				//analyzer.GasSensorPercArrived(b[1], Float.parseFloat(msg));
				break;
			}
			
			case "sprink": {
				System.out.println(topic+" "+msg);
				//analyzer.SprinklerSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "roompresence": {
				System.out.println(topic+" "+msg);
				//analyzer.PresenceSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "heater": {
				System.out.println(topic+" "+msg);
				//analyzer.HeaterSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "door": {
				System.out.println(topic+" "+msg);
				//analyzer.DoorSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "AC": {
				System.out.println(topic+" "+msg);
				//analyzer.ACSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "setter": {
				System.out.println(topic+" "+msg);
				//analyzer.ACSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
			
			case "presence": {
				System.out.println(topic+" "+msg);
				//analyzer.ACSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
		
			case "presenceMode": {
				System.out.println(topic+" "+msg);
				//analyzer.ACSensorArrived(b[1], Integer.parseInt(msg));
				break;
			}
		}*/

	}


	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub

	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub

	}


}


