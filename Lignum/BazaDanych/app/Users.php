<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Users extends Model
{

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
	
	public $primaryKey = 'login';
	public $incrementing = false;
    protected $fillable = [
				'idacl_users',
				'password',
				'login',
				'email',
				'additional_info',
			    ' picture_signature',
			    'picture_signature_type',
			    'show_email',
			    'is_confirm',
			    'confirmation_number',
				'adddate',
			    'wwwpage',
			    'sendemail',
			    'token',
			    'token_expire'
				   
    ];

    /**
     * The attributes excluded from the model's JSON form.
     *
     * @var array
     */
    protected $hidden = [];
}