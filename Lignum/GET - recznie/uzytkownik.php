<?php
	
	class User{
		
		private $polaczenie;		
		public $id;
		public $login;
		public $password;
		
			public function __construct($Dbclass){
				$this->polaczenie = $Dbclass;				
			}
			
			public function read(){
				$query = "SELECT id, login, password FROM users ";
				$stmt = $this->polaczenie->prepare($query);
				$stmt->execute();
			return $stmt;
			}
			
			public function create(){// query to insert record
				$query = "INSERT INTO users SET
                id=:id, login=:login, password=:password";
 
    // prepare query
    $stmt = $this->polaczenie->prepare($query);
 
    // sanitize
    $this->id=htmlspecialchars(strip_tags($this->id));
    $this->login=htmlspecialchars(strip_tags($this->login));
    $this->password=htmlspecialchars(strip_tags($this->password));
  
    // bind values
    $stmt->bindParam(":id", $this->id);
    $stmt->bindParam(":login", $this->login);
    $stmt->bindParam(":password", $this->password);

    // execute query
			if($stmt->execute()){
				return true;
			}else
				return false; 
}
			
			function update(){
 
    // update query
    $query = "UPDATE
                users
            SET
                id = :id,
                login = :login,
                password = :password
            WHERE
                login = :login";
 
    // prepare query statement
    $stmt = $this->polaczenie->prepare($query);
 
    // sanitize
    $this->id=htmlspecialchars(strip_tags($this->id));
    $this->login=htmlspecialchars(strip_tags($this->login));
    $this->password=htmlspecialchars(strip_tags($this->password));
 
    // bind new values
    $stmt->bindParam(':id', $this->id);
    $stmt->bindParam(':login', $this->login);
    $stmt->bindParam(':password', $this->password);

 
    // execute the query
    if($stmt->execute()){
        return true;
    }
 
    return false;
}
	}
?>