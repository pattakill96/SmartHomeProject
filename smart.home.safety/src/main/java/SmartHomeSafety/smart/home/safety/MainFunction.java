package SmartHomeSafety.smart.home.safety;


import org.eclipse.paho.client.mqttv3.MqttException;


public class MainFunction {

	public static void main(String[] args) throws MqttException {
		System.out.println("Started");
		Populator p = new Populator();
		p.Populate();
		//DBConnector d = new DBConnector();
			try {
			//d.readData();
			 new Monitor();	
			} catch (Exception e) {
				e.printStackTrace();
				//main(null);
			}
		}
	}
