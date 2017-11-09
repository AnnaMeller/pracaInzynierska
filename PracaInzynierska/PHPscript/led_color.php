<?php

$int = 'ffac5600';
$value = $_POST['value'];

echo shell_exec("cd /home/pi && sudo ./led_color.py $value 2>&1")



?>
