<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$router->get('/', function () use ($router) {
    return $router->app->version();
});
///////////////////////////////////////////         USERS       ////////////////////////////////
  $router->group(['prefix' => 'lignum'], function () use ($router) {
  $router->get('users',  ['uses' => 'UsersController@showAllUsers']);

  $router->get('users/{login}', ['uses' => 'UsersController@showOneUsers']);

  $router->post('users', ['uses' => 'UsersController@create']);

  $router->delete('users/{login}', ['uses' => 'UsersController@delete']);

  $router->put('users/{login}', ['uses' => 'UsersController@update']); 
  
  
/////////////////////////////////////////////         TREE      /////////////////////////////////
  $router->get('tree',  ['uses' => 'TreeController@showAllTree']);

  $router->get('tree/{name_polish}', ['uses' => 'TreeController@showOneTree']);

  $router->post('tree', ['uses' => 'TreeController@create']);

  $router->delete('tree/{name_polish}', ['uses' => 'TreeController@delete']);

  $router->put('tree/{name_polish}', ['uses' => 'TreeController@update']);
});