<?PHP

    require_once "conex.php";
        $conexion=conex();
        
        $json=array();
        
        if(isset($_GET["id_Articulo"])){
            $id_Articulo=$_GET["id_Articulo"];
            
            $sql="DELETE FROM inventario WHERE id_Articulo='{$id_Articulo}'";
            $stm=$conexion->prepare($sql);
            
            if($stm->execute()){
                echo "elimina";
            }else{
                echo "noElimina";
            }
            
            mysqli_close($conexion);
        }
        else{
            echo "noExiste";
        }
?>