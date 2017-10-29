#! /usr/bin/python

import RPi.GPIO as GPIO
import time
import pigpio
import sys

pi = pigpio.pi()

RedPin = 17

#start pigpiod deamon

pi = pigpio.pi() #connect to Pi

#turnOn relay 
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()
GPIO.setwarnings(False)
GPIO.setup(23, GPIO.OUT)
GPIO.output(23, GPIO.LOW)

duty_s = sys.argv[1]
duty = int(duty_s)
duty_red = duty*2.55

pi.set_PWM_dutycycle(RedPin, duty_red)


#stop pigpio

pi.stop() #disconnect with Pi
