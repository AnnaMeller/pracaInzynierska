#! /usr/bin/python
import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()
GPIO.setwarnings(False)
GPIO.setup(22,GPIO.OUT)
print "Lights on"
GPIO.output(22,GPIO.LOW)
