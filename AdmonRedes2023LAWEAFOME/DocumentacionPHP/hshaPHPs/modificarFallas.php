<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $id_Fallas = $_REQUEST["id_Fallas"];
    $nombre= $_REQUEST['nombre'];
    $descripcion= $_REQUEST['descripcion'];
    $riesgo = $_REQUEST["riesgo"];
    
    $registros=array();
    
    $sql="UPDATE fallas SET nombre='$nombre', descripcion='$descripcion', riesgo='$riesgo' WHERE id_Fallas='$id_Fallas'";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="falla modificada";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>