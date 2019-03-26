<?php

class DBclass {
	
	private $host = '127.0.0.1';
	private $username = 'root';
	private $password = '';
	private $database = 'lignum';
	
	public $connection;
	
		public function GetConnection(){
			try{
				$this->connection = null;
					
				$this->connection = new PDO('mysql:host='.$this->host.';dbname='.$this->database,$this->username, $this->password);
				$this->connection->exec("set names utf8");
        }catch(PDOException $exception){
            echo "Error: " . $exception->getMessage();
        }
		return $this->connection;
		}	
};
		
?>		
	