<?php

namespace App\Http\Controllers;

use App\Users;
use Illuminate\Http\Request;

class UsersController extends Controller
{

    public function showAllUsers()
    {
        return response()->json(Users::all());
    }

    public function showOneUsers($login)
    {
        return response()->json(Users::find($login));
    }

    public function create(Request $request)
    {
        $users = Users::create($request->all());

        return response()->json($users, 201);
    }

    public function update($login, Request $request)
    {
        $users = Users::findOrFail($login);
        $users->update($request->all());

        return response()->json($users, 200);
    }

    public function delete($login)
    {
        Users::findOrFail($login)->delete();
        return response('Deleted Successfully', 200);
    }
}