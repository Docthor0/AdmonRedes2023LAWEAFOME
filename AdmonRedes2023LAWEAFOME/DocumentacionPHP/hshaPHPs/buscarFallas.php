<?php
    require_once "conex.php";
    $conexion=conex();
    
    $id_Fallas=$_GET['id_Fallas'];
    
    $consulta = "select * from fallas where id_Fallas= '$id_Fallas'";
    $resultado= $conexion -> query($consulta);
    
    while($fila=$resultado -> fetch_array()){
        $fallas[] = array_map('utf8_encode', $fila);
    }
    
    echo json_encode($fallas);
    $resultado -> close();
    
    ?>
    
 ?>