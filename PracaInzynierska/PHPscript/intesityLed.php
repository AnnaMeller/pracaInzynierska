<?php

$int = 90;
$value = $_POST['value'];
echo shell_exec("cd /home/pi && sudo ./led.py $value 2>&1")



?> 
