<?PHP
    require_once "conex.php";
    $conexion = conex();
    
    $nombre = $_REQUEST["nombre"];
    $descripcion = $_REQUEST["descripcion"];
    
    $plan = array();
    
    $sql = "INSERT INTO configuracion (nombre, descripcion) VALUES ( '$nombre', '$descripcion')";
    
    $resultado_insert = mysqli_query($conexion, $sql);
    
    if($resultado_insert){
       $configuracion["creado"] ="1";
       $configuracion["configuracion"]="plan creado";
       $json["resultado"][]=$configuracion;
       echo json_encode($json);
    }
    else{
        echo "error al registrar la configuracion";
    }
   
    
?>