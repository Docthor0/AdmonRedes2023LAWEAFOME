<?PHP

    require_once "conex.php";
        $conexion=conex();
        
        $json=array();
        
        if(isset($_GET["id_Plan"])){
            $id_Plan=$_GET["id_Plan"];
            
            $sql="DELETE FROM plan WHERE id_Plan='{$id_Plan}'";
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