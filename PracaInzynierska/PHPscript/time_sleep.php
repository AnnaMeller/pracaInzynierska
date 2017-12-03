<?php

$int = "23:29";
$value = $_POST['value'];
echo shell_exec("cd /home/pi && sudo ./time_sleep.py $value 2>&1")



?>

