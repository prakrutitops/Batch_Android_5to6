<?php

include('connect.php');
$id=$_POST["id"];


$sql="Delete from mybatch where id ='$id'";


//$ex=mysqli_query($con,$sql);

if(mysqli_query($con,$sql))
{
    echo 'Record Deleted Succesfully';
}
else
{
    echo 'Something went Wrong';
}


?>