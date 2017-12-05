#! /usr/bin/python
import RPi.GPIO as GPIO
import time
import pigpio
import sys
import os

pi = pigpio.pi()
GPIO.cleanup()

RedPin = 17
GreenPin = 22
BluePin = 24


#redOff
pi.set_PWM_dutycycle(RedPin, 0)
	
#greenOff
pi.set_PWM_dutycycle(GreenPin, 0)

#blueOff
pi.set_PWM_dutycycle(BluePin, 0)

#turnOff realy
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()
GPIO.setwarnings(False)
GPIO.setup(23, GPIO.OUT)
GPIO.output(23, GPIO.HIGH)

GPIO.cleanup();

os.system(" ps aux  |  grep -i python  |  awk '{print $2}'  |  xargs sudo kill -9")


