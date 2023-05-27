package com.example.menudemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.mymenu,menu)
        val m = menu as MenuBuilder
        //noinspection RestrictedApi
        m.setOptionalIconsVisible(true)

        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       // return super.onOptionsItemSelected(item)
        when(item.itemId)
        {
            R.id.open->Toast.makeText(this,
                "Open Selected",Toast.LENGTH_LONG).show()

            R.id.share->Toast.makeText(this,
                "Share Selected",Toast.LENGTH_LONG).show()
            R.id.close->finish();
            R.id.show->{

                var b= AlertDialog.Builder(this)
                b.setTitle("Confirm?")
                b.setMessage("Are you realy want to submit?")
                b.setIcon(R.drawable.cocsitlogo)
                b.setPositiveButton("Yes"){
                        dialoginterface,
                        which->Toast.makeText(applicationContext,"You Selected Yes",
                    Toast.LENGTH_LONG).show()
                   // var i= Intent(applicationContext,MainActivity2::class.java)
                   // startActivity(i)
                }
                b.setNegativeButton("No"){
                        dialoginterface,
                        which->Toast.makeText(applicationContext,"You Selected No",
                    Toast.LENGTH_LONG).show()
                }
                var d=b.create()
                d.show()

            }
        }
        return true;
    }
}