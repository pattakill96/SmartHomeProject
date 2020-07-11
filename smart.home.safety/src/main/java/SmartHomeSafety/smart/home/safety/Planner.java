package SmartHomeSafety.smart.home.safety;

public class Planner{

	Executer executor = new Executer(); 


	public void tempSignalArrived(String room) {
		
		switch(room) {
		
		case "kitchen" : {
				float tempval = SensorValues.kitchen_temp_sensor_value;
				int window = SensorValues.kitchen_window_sensor_value;
				if(tempval > 25 && window == 0) {					
					executor.openWindow(room);
				}
				break;
			}
		
		case "livingroom" : {
			float tempval = SensorValues.livingroom_temp_sensor_value;
			int window = SensorValues.livingroom_window_sensor_value;
			if(tempval > 25 && window == 0) {					
				executor.openWindow(room);
			}
			break;
		}
		
		case "bedroom" : {
			float tempval = SensorValues.bedroom_temp_sensor_value;
			int window = SensorValues.bedroom_window_sensor_value;
			if(tempval > 25 && window == 0) {					
				executor.openWindow(room);
			}
			break;
		}
		
		case "bathroom" : {
			float tempval = SensorValues.bathroom_temp_sensor_value;
			int window = SensorValues.bathroom_window_sensor_value;
			if(tempval > 25 && window == 0) {					
				executor.openWindow(room);
			}
			break;
		}
		
		}
	}
	
	public void fireSignalArrived(final String room) {
		int value=0;
		switch(room) {
		case "kitchen" : {
			value = SensorValues.kitchen_fire_sensor_value;
			break;
			}
		
		case "livingroom" : {
			value = SensorValues.livingroom_fire_sensor_value;
			break;
		}
		
		case "bedroom" : {
			value = SensorValues.bedroom_fire_sensor_value;
			break;
		}
		
		case "bathroom" : {
			value = SensorValues.bathroom_fire_sensor_value;
			break;
		}}
		if (value == 1) {
			executor.startWaterSprinkler(room);
			new Thread(new Runnable() {
			    public void run() {
			    	try {
						Thread.sleep(5*1000);
						executor.stopFire(room);
			    	} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			    }
			}).start();
			
		}
		
		}



	
	public void waterSignalArrived(final String room, final int time_lapse) {
					new Thread(new Runnable() {
						int value1;
					    public void run() {
					    	try {
								Thread.sleep(time_lapse*1000);
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
								if (value1==1)
									executor.closeWaterTaps(room);
					    	} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}			    }
					}).start();
		}
					
	public void gasSignalArrived(final int time_lapse) {
		new Thread(new Runnable() {
		    public void run() {
		    	try {
					Thread.sleep(time_lapse*1000);
						int value1 = SensorValues.gas_sensor_value;
					if (value1==1)
						executor.closeGasKnobs();
		    	} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			    }
		}).start();
}

	public void windowSignalArrived(String room) {
		// TODO Auto-generated method stub
		
	}
	
	public void gasSignalPercArrived() {
		if(SensorValues.gas_sensor_perc > 0.800 && SensorValues.gas_sensor_value==1)
			executor.closeGasKnobs();
		
	}

	public void sprinklerSignalArrived(final String room) {
		new Thread(new Runnable() {
		    public void run() {
		    	try {
					Thread.sleep(10*1000);
					switch(room) {
					case "kitchen" : {
						int value = SensorValues.kitchen_sprink_sensor_value;
						if (value == 1) {
							executor.stopWaterSprinkler(room);
						}
						break;
						}
					
					case "livingroom" : {
						int value = SensorValues.livingroom_sprink_sensor_value;
						if (value == 1) {
							executor.stopWaterSprinkler(room);
						}
						break;
					}
					
					case "bedroom" : {
						int value = SensorValues.bedroom_sprink_sensor_value;
						if (value == 1) {
							executor.stopWaterSprinkler(room);
							
						}
						break;
					}
					
					case "bathroom" : {
						int value = SensorValues.bathroom_sprink_sensor_value;
						if (value == 1) {
							executor.stopWaterSprinkler(room);
						}
					}
					break;
					
		    	}} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			    }
		}).start();
		}
	
	}

