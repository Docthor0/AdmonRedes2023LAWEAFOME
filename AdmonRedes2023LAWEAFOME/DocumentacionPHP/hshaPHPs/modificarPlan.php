<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $id_Plan = $_REQUEST["id_Plan"];
    $nombre= $_REQUEST['nombre'];
    $descripcion= $_REQUEST['descripcion'];
    
    $registros=array();
    
    $sql="UPDATE plan SET nombre='$nombre', descripcion='$descripcion'WHERE id_Plan='$id_Plan'";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="plan modificado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>