<?php
    require_once "conex.php";
    $conexion=conex();
    
    $id_Configuracion=$_GET['id_Configuracion'];
    
    $consulta = "select * from configuracion where id_Configuracion= '$id_Configuracion'";
    $resultado= $conexion -> query($consulta);
    
    while($fila=$resultado -> fetch_array()){
        $configuracion[] = array_map('utf8_encode', $fila);
    }
    
    echo json_encode($configuracion);
    $resultado -> close();
    
    ?>
    
 ?>