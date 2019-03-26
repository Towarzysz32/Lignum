<?php
	header("Content-Type: application/json; charset=UTF-8");
	include_once './polaczenie.php';
	include_once './uzytkownik.php';
	
	


	
	
	$Dbclass = new DBclass();
	$polaczenie = $Dbclass->GetConnection();
	$user = new User($polaczenie);
	
		$stmt = $user->read();
		$count = $stmt->rowCount();
		
		$name;
		$user_one = "Marysia";

	if($count > 0){
	
		
		$user = array();
		$user["user"] = array();
		
			while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
				
						extract($row);	
						$all = array(
								"id" => $id,
								"login" => $login,
								"password" => $password
								"<p>";
								);
							if($user_one == null)
													array_push($user["user"], $all);
							if($login == $user_one){
								$one = array(
								"id" => $id,
								"login" => $login,
								"password" => $password
								);
							 break;					
							}
					}
					if($user_one == null)
				echo json_encode($user["user"]);
			else
				echo json_encode($one);
				




			}
			else{

				echo json_encode(array("user" => array(), "count" => 0));
			}
	
?>