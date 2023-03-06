<?PHP
    include_once("conex.php");
    $conexion=conex();
    
    $email=$_REQUEST["email"];
    $contrasena=$_REQUEST["contrasena"];
    //$userName=$_REQUEST["userName"];
    
    $registros=array();
    
    $sql="INSERT INTO usuarios (email,contrasena) VALUES('$email','$contrasena')";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="usuario creado";
        
        echo json_encode($registros);
    }
    catch(Exception $e){ echo "error"; }
    echo $ejecutar;
?>