<?PHP

    require_once "conex.php";
        $conexion=conex();
        
        $json=array();
        
        if(isset($_GET["id_Fallas"])){
            $id_Fallas=$_GET["id_Fallas"];
            
            $sql="DELETE FROM fallas WHERE id_Fallas='{$id_Fallas}'";
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