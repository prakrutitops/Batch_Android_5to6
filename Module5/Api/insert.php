<?php

    include('connect.php');
    
    $fname = $_POST["fname"];
    $email = $_POST["email"];


    if($fname=="" && $email=="")
    {
        echo '0';
    }
    else
    {
        $sql ="insert into mybatch (fname,email) values ('$fname','$email')";
        mysqli_query($con,$sql);
        
    }

?>