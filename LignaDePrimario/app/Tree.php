<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Tree extends Model
{

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
	public $table = "tree";
	public $primaryKey = 'namePolish';
	public $incrementing = false;
    protected $fillable = [
					   'idtree_objects',
					   'iddistricts',
					   'idusers',
					   'idspecial_place',
					   'name_latin',
					   'location',
					   'street',
					   'city',
					   'location_longitude',
					   'location_latitude',
					   'description',
					   'blocked',
					   'adddate',
					   'is_pomnik',
					   'aktualizacja',
					   'in_greenhouse',
					   'icon',
					   'unknown_tree',
					   'nonexistent',
					   'view_count',
					   'post_on_fb'
    ];

    /**
     * The attributes excluded from the model's JSON form.
     *
     * @var array
     */
    protected $hidden = [];
}