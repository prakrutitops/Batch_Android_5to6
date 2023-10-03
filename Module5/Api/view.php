<?php
    
    include('connect.php');//1
    
    $sql="select * from mybatch";//2
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        //3
        $value["id"]=$row["id"];
        $value["fname"]=$row["fname"];
        $value["email"]=$row["email"];

          array_push($response, $value);
    }
    echo json_encode($response);
    mysqli_close($con);

?>