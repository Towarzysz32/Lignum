<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
 
 

include_once './polaczenie.php';
include_once './uzytkownik.php';
	
	$Dbclass = new DBclass();
	$polaczenie = $Dbclass->GetConnection();
	$user = new User($polaczenie);
	
		

$data = json_decode(file_get_contents("php://input"));
 
// make sure data is not empty
if(
    !empty($data->id) &&
    !empty($data->login) &&
    !empty($data->password))
{
 
    // set product property values
    $user->id = $data->id;
    $user->login = $data->login;
    $user->password = $data->password;
    $user->created = date('Y-m-d H:i:s');
 
    // create the product
    if($user->create()){
 
        // set response code - 201 created
        http_response_code(201);
 
        // tell the user
        echo json_encode(array("message" => "Product was created."));
    }
 
    // if unable to create the product, tell the user
    else{
 
        // set response code - 503 service unavailable
        http_response_code(503);
 
        // tell the user
        echo json_encode(array("message" => "Unable to create product."));
    }
}
 
// tell the user data is incomplete
else{
 
    // set response code - 400 bad request
    http_response_code(400);
 
    // tell the user
    echo json_encode(array("message" => "Unable to create product. Data is incomplete."));
}
?>