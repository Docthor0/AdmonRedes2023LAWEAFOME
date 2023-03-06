<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $nombre= $_REQUEST['nombre'];
    $descripcion= $_REQUEST['descripcion'];
    $cantidad= $_REQUEST['cantidad'];
    
    $registros=array();
    
    $sql="INSERT INTO inventario (nombre,descripcion,cantidad) VALUES('$nombre','$descripcion','$cantidad')";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="servicio creado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>