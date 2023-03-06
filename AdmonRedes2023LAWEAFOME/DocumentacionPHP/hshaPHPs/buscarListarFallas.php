<?PHP
    require_once "conex.php";
    $conexion = conex();
    
    $resultado = array();
        
        $sql = "SELECT id_Fallas, nombre, descripcion, riesgo FROM fallas";
        $llamada = mysqli_query($conexion, $sql);
        
        while($fallas = mysqli_fetch_array($llamada)){
            $resultado["fallas"][]= $fallas;
        }
        echo json_encode($resultado);
        
    
    ?>
    