#! /usr/bin/python

def hex2rgb(hexcode):
    rgb = tuple(map(ord,hexcode[2:].decode('hex')))
    return rgb

import RPi.GPIO as GPIO
import time
import pigpio
import sys

pi = pigpio.pi()

#start pigpio deamon
pi = pigpio.pi() #connect to Pi

RedPin = 17
GreenPin = 22
BluePin = 24

#turnOn relay
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()
GPIO.setwarnings(False)
GPIO.setup(23, GPIO.OUT)
GPIO.output(23, GPIO.LOW)

#HEXtoRGB
hexcode = sys.argv[1]
rgbvalue = hex2rgb(hexcode)

RedColor = rgbvalue[0]
GreenColor = rgbvalue[1]
BlueColor = rgbvalue[2]

#set color pin from app

pi.set_PWM_dutycycle(RedPin, RedColor)
pi.set_PWM_dutycycle(GreenPin, GreenColor)
pi.set_PWM_dutycycle(BluePin, BlueColor)

#stop pigpio

pi.stop() #disconnect with Pi


def rgb2hex(r,g,b):
    hex = "#{:02x}{:02x}{:02x}".format(r,g,b)
    return hex

def hex2rgb(hexcode):
    rgb = tuple(map(ord,hexcode[2:].decode('hex')))
    return rgb

def rgb2hex(r,g,b):
    hex = "#{:02x}{:02x}{:02x}".format(r,g,b)
    return hex



