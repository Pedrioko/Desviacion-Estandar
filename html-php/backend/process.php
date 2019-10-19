<?php
$datos = $_POST["datos"];
$avg  = average($datos);

$squareDiffs = array_map("map", $datos);


echo sqrt(average($squareDiffs));

function map($v)
{
    global $avg;
    $diff = $v - $avg;
    $sqrDiff = $diff * $diff;
    return $sqrDiff;
}

function suma($carry, $item)
{
    $carry += $item;
    return $carry;
}

function average($data)
{
    global $datos;
    return array_reduce($data, "suma") / count($datos);
}
