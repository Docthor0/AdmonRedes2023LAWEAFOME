<?php
    require_once "conex.php";
    $conexion=conex();
    
    $id_Dispositivo=$_GET['id_Dispositivo'];
    
    $consulta = "select * from dispositivo where id_Dispositivo= '$id_Dispositivo'";
    $resultado= $conexion -> query($consulta);
    
    while($fila=$resultado -> fetch_array()){
        $dispositivo[] = array_map('utf8_encode', $fila);
    }
    
    echo json_encode($dispositivo);
    $resultado -> close();
    
    ?>