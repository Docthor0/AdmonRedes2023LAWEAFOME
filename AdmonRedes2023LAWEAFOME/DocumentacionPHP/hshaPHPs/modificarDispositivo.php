<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $modelo= $_REQUEST['modelo'];
    $marca= $_REQUEST['marca'];
    $cantidad= $_REQUEST['cantidad'];
    
    $registros=array();
    
    $sql="UPDATE dispositivo SET modelo='$modelo', marca='$marca', cantidad='$cantidad' WHERE id_Dispositivo='$id_Dispositivo'";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="dispositivo modificado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>