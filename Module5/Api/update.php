<?php

include('connect.php');//1

$id=$_POST["id"];
$fname=$_POST["fname"];
$email=$_POST["email"];


$sql="Update mybatch set fname='$fname',email='$email'where id='$id'";


//$ex=mysqli_query($con,$sql);

if(mysqli_query($con,$sql))
{
    echo 'Record Updated Succesfully';
}
else
{
    echo 'Something went Wrong';
}


?>