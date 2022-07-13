package SmartHomeSafety.smart.home.safety;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Planner{

	Executer executer = new Executer(); 

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
	LocalDateTime now = LocalDateTime.now();
	
	private String dayShift() {
		LocalDateTime now = LocalDateTime.now();
		if(Integer.parseInt(now.format(dtf))>7 && Integer.parseInt(now.format(dtf))<21) {
			return "day";
		}
		else {
			return "night";
		}
	}

	public void tempSignalArrived(String room) {
		switch(room) {
			case "kitchen" : {
					if(SensorValues.kitchen_presence_value==1 && SensorValues.presence_mode==1) {
						if(SensorValues.kitchen_temp_sensor_value > SensorValues.kitchen_presence_max_value) {
							if(SensorValues.kitchen_ac_sensor_value==0)
								executer.turnACON(room);
							if(SensorValues.kitchen_heater_sensor_value==1)
								executer.turnHeaterOFF(room);
							if(SensorValues.kitchen_window_sensor_value==1)
								executer.closeWindow(room);
						}
						if(SensorValues.kitchen_temp_sensor_value < SensorValues.kitchen_presence_min_value) {
							if(SensorValues.kitchen_heater_sensor_value==0)
								executer.turnHeaterON(room);
							if(SensorValues.kitchen_ac_sensor_value==1)
								executer.turnACOFF(room);
							if(SensorValues.kitchen_window_sensor_value==0)
								executer.closeWindow(room);
						}
						if(SensorValues.kitchen_temp_sensor_value <= SensorValues.kitchen_presence_max_value && SensorValues.kitchen_temp_sensor_value >= SensorValues.kitchen_presence_min_value ) {
							if(SensorValues.kitchen_heater_sensor_value==1)
								executer.turnHeaterOFF(room);
							if(SensorValues.kitchen_ac_sensor_value==1)
								executer.turnACOFF(room);
						}
					}
					else {
						switch(this.dayShift()) {
							case("day"):{
								//System.out.println("TEMP:"+SensorValues.kitchen_temp_sensor_value+"\nMIN:"+SensorValues.kitchen_day_min_value+"\nMAX:"+SensorValues.kitchen_day_max_value);
								if(SensorValues.kitchen_temp_sensor_value > SensorValues.kitchen_day_max_value) {
									if(SensorValues.kitchen_ac_sensor_value==0)
										executer.turnACON(room);
									if(SensorValues.kitchen_heater_sensor_value==1)
										executer.turnHeaterOFF(room);
									if(SensorValues.kitchen_window_sensor_value==1)
										executer.closeWindow(room);
								}
								if(SensorValues.kitchen_temp_sensor_value < SensorValues.kitchen_day_min_value) {
									if(SensorValues.kitchen_heater_sensor_value==0)
										executer.turnHeaterON(room);
									if(SensorValues.kitchen_ac_sensor_value==1)
										executer.turnACOFF(room);
									if(SensorValues.kitchen_window_sensor_value==0)
										executer.closeWindow(room);
								}
								if(SensorValues.kitchen_temp_sensor_value <= SensorValues.kitchen_day_max_value && SensorValues.kitchen_temp_sensor_value >= SensorValues.kitchen_day_min_value ) {
									if(SensorValues.kitchen_heater_sensor_value==1)
										executer.turnHeaterOFF(room);
									if(SensorValues.kitchen_ac_sensor_value==1)
										executer.turnACOFF(room);
								}
								break;
							}
							case("night"):{
								if(SensorValues.kitchen_temp_sensor_value > SensorValues.kitchen_night_max_value) {
									if(SensorValues.kitchen_ac_sensor_value==0)
										executer.turnACON(room);
									if(SensorValues.kitchen_heater_sensor_value==1)
										executer.turnHeaterOFF(room);
									if(SensorValues.kitchen_window_sensor_value==1)
										executer.closeWindow(room);
								}
								if(SensorValues.kitchen_temp_sensor_value < SensorValues.kitchen_night_min_value) {
									if(SensorValues.kitchen_heater_sensor_value==0)
										executer.turnHeaterON(room);
									if(SensorValues.kitchen_ac_sensor_value==1)
										executer.turnACOFF(room);
									if(SensorValues.kitchen_window_sensor_value==0)
										executer.closeWindow(room);
								}
								if(SensorValues.kitchen_temp_sensor_value <= SensorValues.kitchen_night_max_value && SensorValues.kitchen_temp_sensor_value >= SensorValues.kitchen_night_min_value ) {
									if(SensorValues.kitchen_heater_sensor_value==1)
										executer.turnHeaterOFF(room);
									if(SensorValues.kitchen_ac_sensor_value==1)
										executer.turnACOFF(room);
								}
								break;
							}
						}
					}
					break;
				}

			case "livingroom" : {
				if(SensorValues.livingroom_presence_value==1 && SensorValues.presence_mode==1) {
					if(SensorValues.livingroom_temp_sensor_value > SensorValues.livingroom_presence_max_value) {
						if(SensorValues.livingroom_ac_sensor_value==0)
							executer.turnACON(room);
						if(SensorValues.livingroom_heater_sensor_value==1)
							executer.turnHeaterOFF(room);
						if(SensorValues.livingroom_window_sensor_value==1)
							executer.closeWindow(room);
					}
					if(SensorValues.livingroom_temp_sensor_value < SensorValues.livingroom_presence_min_value) {
						if(SensorValues.livingroom_heater_sensor_value==0)
							executer.turnHeaterON(room);
						if(SensorValues.livingroom_ac_sensor_value==1)
							executer.turnACOFF(room);
						if(SensorValues.livingroom_window_sensor_value==1)
							executer.closeWindow(room);
					}
					if(SensorValues.livingroom_temp_sensor_value <= SensorValues.livingroom_presence_max_value && SensorValues.livingroom_temp_sensor_value >= SensorValues.livingroom_presence_min_value ) {
						if(SensorValues.livingroom_heater_sensor_value==1)
							executer.turnHeaterOFF(room);
						if(SensorValues.livingroom_ac_sensor_value==1)
							executer.turnACOFF(room);
					}
				}
				else {
					switch(this.dayShift()) {
						case("day"):{
							if(SensorValues.livingroom_temp_sensor_value > SensorValues.livingroom_day_max_value) {
								if(SensorValues.livingroom_ac_sensor_value==0)
									executer.turnACON(room);
								if(SensorValues.livingroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
								if(SensorValues.livingroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.livingroom_temp_sensor_value < SensorValues.livingroom_day_min_value) {
								if(SensorValues.livingroom_heater_sensor_value==0)
									executer.turnHeaterON(room);
								if(SensorValues.livingroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.livingroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.livingroom_temp_sensor_value <= SensorValues.livingroom_day_max_value && SensorValues.livingroom_temp_sensor_value >= SensorValues.livingroom_day_min_value ) {
								if(SensorValues.livingroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
								if(SensorValues.livingroom_ac_sensor_value==1)
									executer.turnACOFF(room);
							}
							break;
						}
						case("night"):{
							if(SensorValues.livingroom_temp_sensor_value > SensorValues.livingroom_night_max_value) {
								if(SensorValues.livingroom_ac_sensor_value==0)
									executer.turnACON(room);
								if(SensorValues.livingroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
								if(SensorValues.livingroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.livingroom_temp_sensor_value < SensorValues.livingroom_night_min_value) {
								if(SensorValues.livingroom_heater_sensor_value==0)
									executer.turnHeaterON(room);
								if(SensorValues.livingroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.livingroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.livingroom_temp_sensor_value <= SensorValues.livingroom_night_max_value && SensorValues.livingroom_temp_sensor_value >= SensorValues.livingroom_night_min_value ) {
								if(SensorValues.livingroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
								if(SensorValues.livingroom_ac_sensor_value==1)
									executer.turnACOFF(room);
							}
							break;
						}
					}
				}
				break;
			}
			
			case "bedroom" : {
				if(SensorValues.bedroom_presence_value==1 && SensorValues.presence_mode==1) {
					if(SensorValues.bedroom_temp_sensor_value > SensorValues.bedroom_presence_max_value) {
						if(SensorValues.bedroom_ac_sensor_value==0)
							executer.turnACON(room);
						if(SensorValues.bedroom_heater_sensor_value==1)
							executer.turnHeaterOFF(room);
						if(SensorValues.bedroom_window_sensor_value==1)
							executer.closeWindow(room);
					}
					if(SensorValues.bedroom_temp_sensor_value < SensorValues.bedroom_presence_min_value) {
						if(SensorValues.bedroom_ac_sensor_value==1)
							executer.turnACOFF(room);
						if(SensorValues.bedroom_heater_sensor_value==0)
							executer.turnHeaterON(room);
						if(SensorValues.bedroom_window_sensor_value==1)
							executer.closeWindow(room);
					}
					if(SensorValues.bedroom_temp_sensor_value <= SensorValues.bedroom_presence_max_value && SensorValues.bedroom_temp_sensor_value >= SensorValues.bedroom_presence_min_value ) {
						if(SensorValues.bedroom_ac_sensor_value==1)
							executer.turnACOFF(room);
						if(SensorValues.bedroom_heater_sensor_value==1)
							executer.turnHeaterOFF(room);
					}
				}
				else {
					switch(this.dayShift()) {
						case("day"):{
							if(SensorValues.bedroom_temp_sensor_value > SensorValues.bedroom_day_max_value) {
								if(SensorValues.bedroom_ac_sensor_value==0)
									executer.turnACON(room);
								if(SensorValues.bedroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
								if(SensorValues.bedroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.bedroom_temp_sensor_value < SensorValues.bedroom_day_min_value) {
								if(SensorValues.bedroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.bedroom_heater_sensor_value==0)
									executer.turnHeaterON(room);
								if(SensorValues.bedroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.bedroom_temp_sensor_value <= SensorValues.bedroom_day_max_value && SensorValues.bedroom_temp_sensor_value >= SensorValues.bedroom_day_min_value ) {
								if(SensorValues.bedroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.bedroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
							}
							break;
						}
						case("night"):{
							if(SensorValues.bedroom_temp_sensor_value > SensorValues.bedroom_night_max_value) {
								if(SensorValues.bedroom_ac_sensor_value==0)
									executer.turnACON(room);
								if(SensorValues.bedroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
								if(SensorValues.bedroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.bedroom_temp_sensor_value < SensorValues.bedroom_night_min_value) {
								if(SensorValues.bedroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.bedroom_heater_sensor_value==0)
									executer.turnHeaterON(room);
								if(SensorValues.bedroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.bedroom_temp_sensor_value <= SensorValues.bedroom_night_max_value && SensorValues.bedroom_temp_sensor_value >= SensorValues.bedroom_night_min_value ) {
								if(SensorValues.bedroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.bedroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
							}
							break;
						}
					}
				}
				break;
			}
			
			case "bathroom" : {
				if(SensorValues.bathroom_presence_value==1 && SensorValues.presence_mode==1) {
					if(SensorValues.bathroom_temp_sensor_value > SensorValues.bathroom_presence_max_value) {
						if(SensorValues.bathroom_ac_sensor_value==0)
							executer.turnACON(room);
						if(SensorValues.bathroom_heater_sensor_value==1)
							executer.turnHeaterOFF(room);
						if(SensorValues.bathroom_window_sensor_value==1)
							executer.closeWindow(room);
					}
					if(SensorValues.bathroom_temp_sensor_value < SensorValues.bathroom_presence_min_value) {
						if(SensorValues.bathroom_ac_sensor_value==1)
							executer.turnACOFF(room);
						if(SensorValues.bathroom_heater_sensor_value==0)
							executer.turnHeaterON(room);
						if(SensorValues.bathroom_window_sensor_value==1)
							executer.closeWindow(room);
					}
					if(SensorValues.bathroom_temp_sensor_value <= SensorValues.bathroom_presence_max_value && SensorValues.bathroom_temp_sensor_value >= SensorValues.bathroom_presence_min_value ) {
						if(SensorValues.bathroom_ac_sensor_value==1)
							executer.turnACOFF(room);
						if(SensorValues.bathroom_heater_sensor_value==1)
							executer.turnHeaterOFF(room);
					}
				}
				else {
					switch(this.dayShift()) {
						case("day"):{
							if(SensorValues.bathroom_temp_sensor_value > SensorValues.bathroom_day_max_value) {
								if(SensorValues.bathroom_ac_sensor_value==0)
									executer.turnACON(room);
								if(SensorValues.bathroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
								if(SensorValues.bathroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.bathroom_temp_sensor_value < SensorValues.bathroom_day_min_value) {
								if(SensorValues.bathroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.bathroom_heater_sensor_value==0)
									executer.turnHeaterON(room);
								if(SensorValues.bathroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.bathroom_temp_sensor_value <= SensorValues.bathroom_day_max_value && SensorValues.bathroom_temp_sensor_value >= SensorValues.bathroom_day_min_value ) {
								if(SensorValues.bathroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.bathroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
							}
							break;
						}
						case("night"):{
							if(SensorValues.bathroom_temp_sensor_value > SensorValues.bathroom_night_max_value) {
								if(SensorValues.bathroom_ac_sensor_value==0)
									executer.turnACON(room);
								if(SensorValues.bathroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
								if(SensorValues.bathroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.bathroom_temp_sensor_value < SensorValues.bathroom_night_min_value) {
								if(SensorValues.bathroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.bathroom_heater_sensor_value==0)
									executer.turnHeaterON(room);
								if(SensorValues.bathroom_window_sensor_value==1)
									executer.closeWindow(room);
							}
							if(SensorValues.bathroom_temp_sensor_value <= SensorValues.bathroom_night_max_value && SensorValues.bathroom_temp_sensor_value >= SensorValues.bathroom_night_min_value ) {
								if(SensorValues.bathroom_ac_sensor_value==1)
									executer.turnACOFF(room);
								if(SensorValues.bathroom_heater_sensor_value==1)
									executer.turnHeaterOFF(room);
							}
							break;
						}
					}
				}
				break;
			}
		}
	}
	
	public void fireSignalArrived(final String room) {
		int value=0, presence=0;
		switch(room) {
		case "kitchen" : {
			value = SensorValues.kitchen_fire_sensor_value;
			presence = SensorValues.kitchen_presence_value;
			break;
			}
		
		case "livingroom" : {
			value = SensorValues.livingroom_fire_sensor_value;
			presence = SensorValues.livingroom_presence_value;
			break;
		}
		
		case "bedroom" : {
			value = SensorValues.bedroom_fire_sensor_value;
			presence = SensorValues.bedroom_presence_value;
			break;
		}
		
		case "bathroom" : {
			value = SensorValues.bathroom_fire_sensor_value;
			presence = SensorValues.bathroom_presence_value;
			break;
		}}
		if (value == 1) {
			if(presence==0) {
				executer.closeDoor(room);}
			executer.startWaterSprinkler(room);
			executer.stopFire(room);
			executer.closeGasKnobs();
			
		}
		
		}



	
	public void waterSignalArrived(final String room) {
					new Thread(new Runnable() {
						int value1;
					    public void run() {
					    	try {
								Thread.sleep(SensorValues.water_timer*1000);
								switch(room) {
								case "kitchen":{
									value1 = SensorValues.kitchen_water_sensor_value;
									break;
								}
								case "bathroom":{
									value1 = SensorValues.bathroom_water_sensor_value;
									break;
								}
								}
								if (value1==1 && SensorValues.home_water_pipe==1)
									executer.closeWaterTaps(room);
					    	} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}			    }
					}).start();
		}

	
					
	public void gasSignalArrived() {
		new Thread(new Runnable() {
		    public void run() {
		    	try {
		    		Thread.sleep(SensorValues.gas_timer*1000);
					int value1 = SensorValues.gas_sensor_value;
					if (value1==1)
						
						executer.closeGasKnobs();
		    	} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			    }
		}).start();
}

	
	public void gasSignalPercArrived() {
		System.out.println(SensorValues.gas_sensor_value);
		if(SensorValues.gas_sensor_perc > 0.800 && SensorValues.gas_sensor_value==1) {
			if(SensorValues.kitchen_window_sensor_value!=1) {
				executer.openWindow("kitchen");}
			executer.closeGasKnobs();}
		
	}

	public void sprinklerSignalArrived(final String room) {
		new Thread(new Runnable() {
		    public void run() {
		    	try {
					switch(room) {
					case "kitchen" : {
						int value = SensorValues.kitchen_sprink_sensor_value;
						if (value == 1) {
							Thread.sleep(5*1000);
							executer.stopWaterSprinkler(room);
						}
						break;
						}
					
					case "livingroom" : {
						int value = SensorValues.livingroom_sprink_sensor_value;
						if (value == 1) {
							Thread.sleep(5*1000);
							executer.stopWaterSprinkler(room);
						}
						break;
					}
					
					case "bedroom" : {
						int value = SensorValues.bedroom_sprink_sensor_value;
						if (value == 1) {
							Thread.sleep(5*1000);
							executer.stopWaterSprinkler(room);
							
						}
						break;
					}
					
					case "bathroom" : {
						int value = SensorValues.bathroom_sprink_sensor_value;
						if (value == 1) {
							Thread.sleep(5*1000);
							executer.stopWaterSprinkler(room);
						}
					}
					break;
					
		    	}} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			    }
		}).start();
		}

		public void waterDetectionArrived(String room, String state) {
			if(state=="detection")
				executer.closeWaterTaps(room);
			else {
				executer.closeWaterPipe();
			}
			
		}
	
		public void doorSignalArrived(String room) {	
		}
	
		public void heaterSignalArrived(String room) {
			this.tempSignalArrived(room);
		}
	
		public void ACSignalArrived(String room) {
			this.tempSignalArrived(room);
		}
		
		public void windowSignalArrived(String room) {
		}
		
		public void presenceSignalArrived(String room) {
			this.tempSignalArrived(room);
		}
		
		public void presenceModeArrived() {
			this.tempSignalArrived("kitchen");
			this.tempSignalArrived("livingroom");
			this.tempSignalArrived("bedroom");
			this.tempSignalArrived("bathroom");
		}

		public void importdata() {
			executer.importfromDB();
			
		}

		public void savedata() {
			executer.saveinDB();
			
		}

		
}

