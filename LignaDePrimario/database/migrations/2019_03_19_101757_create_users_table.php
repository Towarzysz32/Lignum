<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUsersTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('users', function (Blueprint $table) {
				   $table->increments('idusers');
				   $table->string('idacl_users');
				   $table->string('login');
				   $table->string(' upassword');
				   $table->string('email');
				   $table->string('additional_info');
				   $table->string(' picture_signature');
				   $table->string('picture_signature_type');
				   $table->string('show_email');
				   $table->string('is_confirm');
				   $table->string('confirmation_number');
				   $table->string('adddate');
				   $table->string('wwwpage');
				   $table->string('sendemail');
				   $table->string('token');
				   $table->string('token_expire');
				   $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('users');
    }
}
