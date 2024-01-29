<?php
    header("Access-Control-Allow-Origin: *");
    header("Content-Type: application/json");

    $tasks = [
        ['id' => 1, 'title' => 'Do the dishes', 'completed' => false],
        ['id' => 2, 'title' => 'Do homework', 'completed' => true],
        ['id' => 3, 'title' => 'Go to the store', 'completed' => false],
    ];

    echo json_encode($tasks);
?>