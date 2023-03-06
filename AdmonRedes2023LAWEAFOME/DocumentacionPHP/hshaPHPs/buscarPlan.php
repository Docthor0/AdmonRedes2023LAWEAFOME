<?php
    require_once "conex.php";
    $conexion=conex();
    
    $id_Plan=$_GET['id_Plan'];
    
    $consulta = "select * from plan where id_Plan= '$id_Plan'";
    $resultado= $conexion -> query($consulta);
    
    while($fila=$resultado -> fetch_array()){
        $plan[] = array_map('utf8_encode', $fila);
    }
    
    echo json_encode($plan);
    $resultado -> close();
    
    ?>
    
 ?>