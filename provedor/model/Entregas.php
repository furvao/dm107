<?php
class Entregas{
    private $id;
    private $numeroPedido;
    private $idCliente;
    private $nomeRecebedor;
    private $cpfRecebedor;
    private $dataEntrega;
    
    //consutrutor
    public function __construct(){
    }

    public function getId(){
        return $this->$id;
    }
    public function setId($id){
        $this->$id = $id;
    }


    public function getNumeroPedido(){
        return $this->$numeroPedido;
    }
    public function setNumeroPedido($numeroPedido){
        $this->$numeroPedido = $numeroPedido;
    }

    public function getIdCliente(){
        return $this->$idCliente;  
    }
    public function setIdCliente($idCliente){
        $this->$idCliente = $idCliente;
    }

    public function getNomeRecebedor(){
        return $this->$nomeRecebedor;
    }
    public function setNomeRecebedor($nomeRecebedor){
        $this->$nomeRecebedor = $nomeRecebedor;
    }

    public function getCpfRecebedor(){
        return $this->$cpfRecebedor;
    }
    public function setCpfRecebedor($cpfRecebedor){
        $this->$cpfRecebedor = $cpfRecebedor;
    }

    public function getDataEntrega(){
        return $this->$dataEntrega;
    }
    public function setDataEntrega($dataEntrega){
        $this->$dataEntrega = $dataEntrega;
    }
}
?>