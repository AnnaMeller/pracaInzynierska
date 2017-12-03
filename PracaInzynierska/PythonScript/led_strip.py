#! /usr/bin/python

import RPi.GPIO as GPIO
import time
import pigpio
import sys

pi = pigpio.pi()

RedPin = 17
GreenPin = 22
BluePin = 24

dc = 230

#start pigpiod deamon

pi = pigpio.pi() #connect to Pi

#turnOn relay
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()
GPIO.setwarnings(False)
GPIO.setup(23, GPIO.OUT)
GPIO.output(23, GPIO.LOW)


try:
	while dc < 250:	
		pi.set_PWM_dutycycle(RedPin, dc)
		time.sleep(0.2)
		pi.set_PWM_dutycycle(RedPin, 0)
		time.sleep(0.2)
		pi.set_PWM_dutycycle(GreenPin, dc)
		time.sleep(0.2)
		pi.set_PWM_dutycycle(GreenPin, 0)
		time.sleep(0.2)
		pi.set_PWM_dutycycle(BluePin, dc)
		time.sleep(0.2)
		pi.set_PWM_dutycycle(BluePin, 0)
		time.sleep(0.2)
		dc = dc + 10
		
		while dc >= 250:
			pi.set_PWM_dutycycle(RedPin, dc)
                	time.sleep(0.2)
                	pi.set_PWM_dutycycle(RedPin, 0)
                	time.sleep(0.2)
                	pi.set_PWM_dutycycle(GreenPin, dc)
                	time.sleep(0.2)
                	pi.set_PWM_dutycycle(GreenPin, 0)
                	time.sleep(0.2)
                	pi.set_PWM_dutycycle(BluePin, dc)
                	time.sleep(0.2)
                	pi.set_PWM_dutycycle(BluePin, 0)
                	time.sleep(0.2)
                	dc = dc - 10


except KeyboardInterrupt:
	GPIO.cleanup()
pi.stop()
