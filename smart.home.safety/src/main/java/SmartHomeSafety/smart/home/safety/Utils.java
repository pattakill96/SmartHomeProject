package SmartHomeSafety.smart.home.safety;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.Integer;
import java.lang.Float;

public class Utils {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
	LocalDateTime now = LocalDateTime.now();
	
	public String dayShift() {
		LocalDateTime now = LocalDateTime.now();
		if(Integer.parseInt(now.format(dtf))>7 && Integer.parseInt(now.format(dtf))<21) {
			return "day";
		}
		else {
			return "night";
		}
	}
	
	public Float gasToFloat(String s) {
		System.out.println(s);
		Double f= Double.parseDouble(s);
		System.out.println(f.floatValue());
		return f.floatValue();
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
	
	public void publishRawData(String topic, Float message) {
		MQTTBroker conn = null;
		try {
			conn = new MQTTBroker();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		conn.send(topic, message.toString());

	}
}
