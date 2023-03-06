<?PHP

    require_once "conex.php";
        $conexion=conex();
        
        $json=array();
        
        if(isset($_GET["id_Dispositivo"])){
            $id_Dispositivo=$_GET["id_Dispositivo"];
            
            $sql="DELETE FROM dispositivo WHERE id_Dispositivo='{$id_Dispositivo}'";
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