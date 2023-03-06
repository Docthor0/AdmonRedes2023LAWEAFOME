<?PHP
    require_once "conex.php";
    $conexion = conex();
    
    $resultado = array();
        
        $sql = "SELECT id_Configuracion, nombre, descripcion FROM configuracion";
        $llamada = mysqli_query($conexion, $sql);
        
        while($configuracion = mysqli_fetch_array($llamada)){
            $resultado["configuracion"][]= $configuracion;
        }
        echo json_encode($resultado);
        
    
    ?>
    