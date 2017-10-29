<?php

$int = 100;
$value = $_POST['value'];
echo shell_exec("cd /home/pi && sudo ./led_green.py $value 2>&1")



?> 
