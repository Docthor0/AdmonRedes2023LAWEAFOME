<?php
    function conex(){
        $server="localhost";
        $user="id20372311_balls";
        $pass="B[aQXBnairWjoW8w";
        $dbName="id20372311_admredes";
        
        
        $conexion= new mysqli($server,$user,$pass,$dbName);
        
        return $conexion;
    }
?>