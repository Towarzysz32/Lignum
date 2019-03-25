<?php

namespace App\Http\Controllers;

use App\Tree;
use Illuminate\Http\Request;

class TreeController extends Controller
{

    public function showAllTree()
    {
        return response()->json(Tree::all());
    }

    public function showOneTree($name_polish)
    {
        return response()->json(Tree::find($name_polish));
    }

    public function create(Request $request)
    {
        $tree = Tree::create($request->all());

        return response()->json($tree, 201);
    }

    public function update($name_polish, Request $request)
    {
        $tree = Tree::findOrFail($name_polish);
        $tree->update($request->all());

        return response()->json($tree, 200);
    }

    public function delete($name_polish)
    {
        Tree::findOrFail($name_polish)->delete();
        return response('Deleted Successfully', 200);
    }
}