<?php
    require_once "conex.php";
    $conexion=conex();
    
    $id_Articulo=$_GET['id_Articulo'];
    
    $consulta = "select * from inventario where id_Articulo= '$id_Articulo'";
    $resultado= $conexion -> query($consulta);
    
    while($fila=$resultado -> fetch_array()){
        $inventario[] = array_map('utf8_encode', $fila);
    }
    
    echo json_encode($inventario);
    $resultado -> close();
    
    ?>