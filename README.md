# SmartHomeProject
 First of all start MQTT service in your machine.
 To run the application clone the repository in your computer and:
  - Open the **smart.home.safety** part in Eclipse and add in the **Build Path** the library that you can find in the **lib/** folder
	 > Once completed you can start the application running the **MainFunction.java**




  - Download the [OpenHab](https://www.openhab.org/download/) version siutable from your machine
   > Anfter unpacking replace the ***conf** folder in the openhab repository with the conf given in this project
   > Use **start.bat** or **start.sh** to start the UI and go to **localhost:8080** and select Basic-UI





  - Open the **SensorSimulator.py**
	 > Before starting add the **paho.mqtt.client** in your python environment with **pip install paho.mqtt.client**
   > Select the mode of the sensor by commenting or uncommenting the methods in the footer of the code
   > Start the program
 
  - Now you're ready to use the **Smart Home Security** system
 