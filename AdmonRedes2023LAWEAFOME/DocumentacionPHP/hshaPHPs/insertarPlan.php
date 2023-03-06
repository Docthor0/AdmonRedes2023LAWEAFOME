<?PHP
    require_once "conex.php";
    $conexion = conex();
    
    $nombre = $_REQUEST["nombre"];
    $descripcion = $_REQUEST["descripcion"];
    
    $plan = array();
    
    $sql = "INSERT INTO plan (nombre, descripcion) VALUES ( '$nombre', '$descripcion')";
    
    $resultado_insert = mysqli_query($conexion, $sql);
    
    if($resultado_insert){
       $plan["creado"] ="1";
       $plan["plan"]="plan creado";
       $json["resultado"][]=$plan;
       echo json_encode($json);
    }
    else{
        echo "error al registrar el plan";
    }
   
    
?>