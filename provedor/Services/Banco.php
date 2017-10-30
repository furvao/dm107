<?php 
class Banco {
    protected static $db;
    //Aqui contrutor privado, iremos instancia essa classe apenas internamente
    private function __construct(){
        try{
            //dados da conexão a partir de config.php
            $host = HOST;
            $dbName = BANCO;
            $user = USER;
            $pass = PASS;
            
            self::$db = new PDO("mysql:host=$host;dbname=$dbName", $user, $pass);
            self::$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch(PDOException $e) {
            print "Error ao conectar no banco de dados! " . $e->getMessage();
            die();
        }
    }
    public static function getConnection(){
        
        //Iremos garantir uma única instancia, caso ainda não exista criaremos uma
        /* O $this se refere ao objeto (instancia propriamente dita)
        ** O self se refere a classe, iremos utilizá-lo para acessar membros estáticos (static)
        */
        if (!self::$db)
        {
            new Banco();
        }
        //Retorna a conexão
        return self::$db;
    }
}
?>