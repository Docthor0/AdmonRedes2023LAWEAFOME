<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $modelo= $_REQUEST['modelo'];
    $marca= $_REQUEST['marca'];
    $cantidad= $_REQUEST['cantidad'];
    
    $registros=array();
    
    $sql="INSERT INTO dispositivo (modelo,marca,cantidad) VALUES('$modelo','$marca','$cantidad')";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="servicio creado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>