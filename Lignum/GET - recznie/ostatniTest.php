<?php

header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

	include_once './polaczenie.php';
	include_once './uzytkownik.php';

$Dbclass = new DBclass();
$polaczenie = $Dbclass->GetConnection();
$user = new User($polaczenie);

$data = json_decode(file_get_contents('./input.js', FILE_USE_INCLUDE_PATH));

$user->login = $data->login;
$user->password = $data->password;
$user->created = date('Y-m-d H:i:s');

if($user->create()){
    echo '{';
        echo '"message": "Product was created."';
    echo '}';
}
else{
    echo '{';
        echo '"message": "Unable to create product."';
    echo '}';
}
?>

// jak pobrac zdjecia drzew?
// polaczyc pobieranie z aplikacja
// tworzenie json do bazy danych? - volley?