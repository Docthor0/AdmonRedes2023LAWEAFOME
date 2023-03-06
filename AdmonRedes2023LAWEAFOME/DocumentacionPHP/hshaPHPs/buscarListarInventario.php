<?PHP
    require_once "conex.php";
    $conexion = conex();
    
    $resultado = array();
        
        $sql = "SELECT id_Articulo, nombre, descripcion, cantidad FROM inventario";
        $llamada = mysqli_query($conexion, $sql);
        
        while($articulo = mysqli_fetch_array($llamada)){
            $resultado["articulo"][]= $articulo;
        }
        echo json_encode($resultado);
        
    
    ?>
    