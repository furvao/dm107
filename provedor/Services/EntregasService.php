<?php
class EntregasService {
    private $db;
    
    public function __construct(){
        $this->db = Banco::getConnection();
    }

    function atualizarEntrega($db, $entregas){
        $statementHandle = $db->prepare("UPDATE entregas SET numeroPedido=?, idCliente=?, nomeRecebedor=?, cpfRecebedor=?, dataEntrega=? where id=?");
        $statementHandle->bindParam(1, $entregas["numeroPedido"]);
        $statementHandle->bindParam(2, $entregas["idCliente"]);
        $statementHandle->bindParam(3, $entregas["nomeRecebedor"]);
        $statementHandle->bindParam(3, $entregas["cpfRecebedor"]);
        $statementHandle->bindParam(3, $entregas["dataEntrega"]);
        $statementHandle->bindParam(3, $entregas["id"]);
        $statementHandle->execute();
    }
    function deletarEntrega($db, $id) {
        $statementHandle = $db->prepare("DELETE FROM entregas WHERE id=?");
        
        $statementHandle->bindParam(1, $entregas["id"]);

        $statementHandle->execute();
    }
}
?>