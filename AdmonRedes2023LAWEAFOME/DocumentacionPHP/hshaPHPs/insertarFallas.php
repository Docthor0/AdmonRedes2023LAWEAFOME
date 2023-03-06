<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $nombre= $_REQUEST['nombre'];
    $descripcion= $_REQUEST['descripcion'];
    $riesgo= $_REQUEST['riesgo'];
    
    $registros=array();
    
    $sql="INSERT INTO fallas (nombre,descripcion,riesgo) VALUES('$nombre','$descripcion','$riesgo')";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="servicio creado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>