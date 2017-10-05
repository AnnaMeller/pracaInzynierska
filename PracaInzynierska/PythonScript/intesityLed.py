#! /usr/bin/python

import RPi.GPIO as GPIO
import time
import sys

GPIO.setmode(GPIO.BCM)
GPIO.setup (22, GPIO.OUT)

pwm_led = GPIO.PWM(22, 50)
pwm_led.start(0)

try:
	while True:
		duty_s = sys.argv[1]
		duty = int(duty_s)
		pwm_led.ChangeDutyCycle(duty)
		time.sleep(0.5)

except KeyboardInterrupt:
	print "Exiting Program"
except:
	print "Error Occurs, Exiting Program"
finally:
	GPIO.cleanup()
print sys.argv[0]
