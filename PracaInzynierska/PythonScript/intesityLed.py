#! /usr/bin/python

import RPi.GPIO as GPIO
import time
import sys

GPIO.setmode(GPIO.BCM)
GPIO.setup (22, GPIO.OUT)

pwm_led = GPIO.PWM(22, 50)
pwm_led.start(0)

duty_s = sys.argv[1]
duty = int(duty_s)
pwm_led.ChangeDutyCycle(duty)
time.sleep(0.5)

time.sleep(10)
#GPIO.output(22,GPIO.HIGH)
#GPIO.cleanup()
