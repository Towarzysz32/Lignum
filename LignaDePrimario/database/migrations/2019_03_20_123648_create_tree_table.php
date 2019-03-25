<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateTreeTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('tree', function (Blueprint $table) {
			
					   $table->increments('idtree_objects');
					   $table->string('iddistricts');
					   $table->string('idusers');
					   $table->string('idspecial_place');
					   $table->string('name_polish');
					   $table->string('name_latin');
					   $table->string('location');
					   $table->string('street');
					   $table->string('city');
					   $table->double('location_longitude');
					   $table->double('location_latitude');
					   $table->string('description');
					   $table->string('blocked');
					   $table->int('adddate');
					   $table->string('is_pomnik');
					   $table->string('aktualizacja');
					   $table->string('in_greenhouse');
					   $table->string('icon');
					   $table->string('unknown_tree');
					   $table->string('nonexistent');
					   $table->string('view_count');
					   $table->string('post_on_fb');
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
        Schema::dropIfExists('tree');
    }
}