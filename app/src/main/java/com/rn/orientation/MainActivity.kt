package com.rn.orientation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.rn.orientation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var names = arrayListOf<String>()
    var adapter:ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState != null){
            names = savedInstanceState.getStringArrayList("names_list") as ArrayList<String>
        }else{
            Toast.makeText(this, "O savedInstanceState não guardou nada:(", Toast.LENGTH_SHORT).show()
        }


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        binding.lstNames.adapter = adapter
    }


    fun addNames(view:View){
        names.add(binding.edtName.text.toString())
        binding.edtName.text.clear()
        adapter?.notifyDataSetChanged()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState?.putStringArrayList("names_list", names)


    }

}