package SmartHomeSafety.smart.home.safety;


import org.eclipse.paho.client.mqttv3.MqttException;


public class MainFunction {

	public static void main(String[] args) throws MqttException {
		try {
				System.out.println("Started");
				new Monitor();
			} catch (MqttException e) {
				e.printStackTrace();
				main(null);
			}
			
		
		}
	}
