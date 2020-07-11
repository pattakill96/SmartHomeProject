import paho.mqtt.client as mqtt
import time
import random

#this sensor simulation code provides two types of data to the MQTT Broker. The first is the temperature for all the rooms and the second is the GasPercentage for the kitchen
#for each sensor we have two mode
#the first getMessage() that provides normal data just to show them in the openhab console
#the second getRaiseMessage() that provides anormal data to trigger the system
class MqttClient:
    client = mqtt.Client()
    def __init__(self):
        self.host = "localhost"
        self.port = 1883
        self.keepalive = 10
        self.reconnect = 1000
        self.timeout = 3000

    def start(self):
        self.client.connect(self.host, self.port, self.keepalive)
        self.client.reconnect_delay_set(self.reconnect,self.timeout)
        self.client.loop_start()

    def publish(self, topic="",message=""):
        self.client.publish(topic, message)


class TempSensor:
    temp=20.0
    def __init__(self, room="",sensor=""):
        self.home="home"
        self.room=room
        self.sensor=sensor

    def getTopic(self):
        return self.home+'/'+self.room+'/'+self.sensor

    def getTemp(self):
        return str(round(self.temp,2))

    def setTemp(self):
        if(random.randint(1,50)<25):
            self.temp+=0.10
        else:
            self.temp-=0.10

    def raiseTemp(self):
            if self.temp<32:
                self.temp+=0.50


    def getMessage(self):
        self.setTemp()
        return "{"+self.home+": {"+self.room+": {"+self.sensor+": "+self.getTemp()+"}}}"

    def getRaiseMessage(self):
        self.raiseTemp()
        return "{" + self.home + ": {" + self.room + ": {" + self.sensor + ": " + self.getTemp() + "}}}"

class GasSensor:
    perc=0.7
    def __init__(self, room="",sensor=""):
        self.home="home"
        self.room=room
        self.sensor=sensor

    def getTopic(self):
        return self.home+'/'+self.room+'/'+self.sensor

    def getSens(self):
        return str(round(self.perc,2))

    def setSens(self):
        if(random.randint(1,50)<25):
            self.perc+=0.01
        else:
            self.perc-=0.01

    def raiseSens(self):
            if self.perc<1:
                self.perc+=0.01


    def getMessage(self):
        self.setSens()
        return "{"+self.home+": {"+self.room+": {"+self.sensor+": "+self.getSens()+"}}}"

    def getRaiseMessage(self):
        self.raiseSens()
        return "{" + self.home + ": {" + self.room + ": {" + self.sensor + ": " + self.getSens() + "}}}"

c = MqttClient()
kitchen = TempSensor("kitchen","temperature")
kitchenGas = GasSensor("kitchen","gasPerc")
bathroom = TempSensor("bathroom","temperature")
livingroom = TempSensor("livingroom","temperature")
bedroom = TempSensor("bedroom","temperature")
c.start()
k=1
while(k):
    c.publish(kitchen.getTopic(),kitchen.getRaiseMessage())
    #c.publish(kitchen.getTopic(), kitchen.getRaiseMessage())
    c.publish(kitchenGas.getTopic(),kitchenGas.getMessage())
    #c.publish(kitchenGas.getTopic(), kitchenGas.getRaiseMessage())
    c.publish(bathroom.getTopic(), bathroom.getMessage())
    c.publish(livingroom.getTopic(), livingroom.getMessage())
    c.publish(bedroom.getTopic(), bedroom.getMessage())
    time.sleep(1)








