#! /usr/bin/python
import RPi.GPIO as GPIO
import time
import pigpio
pi = pigpio.pi()

RedPin = 17
GreenPin = 22
BluePin = 24

#start pigpiod deamon

pi = pigpio.pi() #connect to Pi

#turnOn relay
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()
GPIO.setwarnings(False)
GPIO.setup(23, GPIO.OUT)
GPIO.output(23, GPIO.LOW)

#redOn
pi.set_PWM_dutycycle(RedPin, 255)

#greenOn
pi.set_PWM_dutycycle(GreenPin, 255)

#blueOn
pi.set_PWM_dutycycle(BluePin, 255)

#stop pigpio

pi.stop() #disconnect with Pi
