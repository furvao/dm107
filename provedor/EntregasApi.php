<?php
        include "Config.php";
        include "model/Entregas.php";
        include "services/Banco.php";
        include "services/EntregasService.php";

        
        $errosValidacao = array();
        $houveErros = false;
        $entregasService = new EntregasService();
        if (count($_PUT) > 0) {

            
                $entregas = new Entregas();
                $entregas->setIdCliente($_PUT["idCliente"]);
                $entregas->setCpfRecebedor($_PUT["cpfRecebedor"]);
                $entregas->setDataEntrega($_PUT["dataEntrega"]);
                $entregas->setNomeRecebedor($_PUT["nomeRecebedor"]);
                $entregas->setNumeroPedido($_PUT["numeroRecebedor"]);

                $entregasService->atualizarEntrega($entregas);
                die();
            
        }

        if(delete($_DELETE) > 0) {

            $id = $_DELETE["id"];

            $entregasService->deletarEntrega($entregas);
            die();

        }

        
        include "Template.php";
    ?>