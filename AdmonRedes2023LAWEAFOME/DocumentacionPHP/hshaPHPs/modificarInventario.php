<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $id_Articulo = $_REQUEST["id_Articulo"];
    $nombre= $_REQUEST['nombre'];
    $descripcion= $_REQUEST['descripcion'];
    $cantidad= $_REQUEST['cantidad'];
    
    $registros=array();
    
    $sql="UPDATE inventario SET nombre='$nombre', descripcion='$descripcion', cantidad='$cantidad' WHERE id_Articulo='$id_Articulo'";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="articulo modificado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>