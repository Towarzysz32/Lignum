<?php

include_once './configuracja.php';
try{

	$Dbclass = new DBclass();
	$polaczenie = $Dbclass->GetConnection();
}
catch(Exception $e){
	
	echo "< polaczenie.php -> blad > ";
}
?>