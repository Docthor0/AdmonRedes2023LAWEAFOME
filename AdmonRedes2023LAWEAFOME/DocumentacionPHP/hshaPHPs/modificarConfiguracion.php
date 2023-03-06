<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $id_Configuracion = $_REQUEST["id_Configuracion"];
    $nombre= $_REQUEST['nombre'];
    $descripcion= $_REQUEST['descripcion'];
    
    $registros=array();
    
    $sql="UPDATE configuracion SET nombre='$nombre', descripcion='$descripcion'WHERE id_Configuracion='$id_Configuracion'";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="configuracion modificada";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>