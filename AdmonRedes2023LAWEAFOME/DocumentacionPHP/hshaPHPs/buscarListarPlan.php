<?PHP
    require_once "conex.php";
    $conexion = conex();
    
    $resultado = array();
        
        $sql = "SELECT id_Plan, nombre, descripcion FROM plan";
        $llamada = mysqli_query($conexion, $sql);
        
        while($plan = mysqli_fetch_array($llamada)){
            $resultado["plan"][]= $plan;
        }
        echo json_encode($resultado);
        
    
    ?>
    