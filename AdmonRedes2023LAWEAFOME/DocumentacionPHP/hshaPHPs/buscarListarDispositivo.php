<?PHP
    require_once "conex.php";
    $conexion = conex();
    
    $resultado = array();
        
        $sql = "SELECT id_Dispositivo, modelo, marca, cantidad FROM dispositivo";
        $llamada = mysqli_query($conexion, $sql);
        
        while($dispositivo = mysqli_fetch_array($llamada)){
            $resultado["dispositivo"][]= $dispositivo;
        }
        echo json_encode($resultado);
        
    
    ?>
    
    
    ?>
    