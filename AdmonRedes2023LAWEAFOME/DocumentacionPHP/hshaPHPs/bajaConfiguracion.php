<?PHP

    require_once "conex.php";
        $conexion=conex();
        
        $json=array();
        
        if(isset($_GET["id_Configuracion"])){
            $id_Configuracion=$_GET["id_Configuracion"];
            
            $sql="DELETE FROM configuracion WHERE id_Configuracion='{$id_Configuracion}'";
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