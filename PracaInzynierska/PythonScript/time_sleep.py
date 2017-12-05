#! /usr/bin/python

import time
import RPi.GPIO as GPIO
import sys

time_to_off = sys.argv[1]
#s = time.strptime(time_to_off, "%I:%M")

hour_now = time.strftime("%H")
print (hour_now)
minute_now = time.strftime("%M")
if minute_now[:1] == 0:
    minute_now1 = minute_now[1:]
else:
    minute_now1 = minute_now

len = len(time_to_off)

if time_to_off[2] == ':':

	hour_next = int(time_to_off[:2])
	minute_next = int(time_to_off[3:])
else:
	hour_next = int(time_to_off[:1])
	minute_next = int(time_to_off[2:])

hour = hour_next - int(hour_now)
#print (hour)
minute = minute_next - int(minute_now1)

sleep_time = hour*3600+minute*60
#print (sleep_time)
time.sleep(sleep_time)
#print sleep_time

#pi = pigpio.pi()

#turnOn relay
GPIO.setmode(GPIO.BCM)
GPIO.setup(25, GPIO.IN)
GPIO.setup(25, GPIO.OUT)

input_value = GPIO.input(25)

if input_value == 1:
	GPIO.setmode(GPIO.BCM)
	GPIO.output(25, GPIO.LOW)	
else:

	GPIO.setmode(GPIO.BCM)
	GPIO.output(25, GPIO.HIGH)

#GPIO.cleanup()
#GPIO.setwarnings(False)
#GPIO.setup(25, GPIO.OUT)
	GPIO.output(25, GPIO.HIGH)

#pi.stop() #disconnect with Pi
