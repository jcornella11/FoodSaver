package com.example.foodsaver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pantryList = arrayListOf<String>()
        var adapter = ArrayAdapter<String> (this, android.R.layout.simple_list_item_multiple_choice,
        pantryList)

        val addButton = findViewById<Button>(R.id.addButton)
        val editTextName = findViewById<TextView>(R.id.editTextItemName)

        /**
        val editTextUPC = findViewById<TextView>(R.id.editTextUPC)
        val editTextPrice = findViewById<TextView>(R.id.editTextPrice)
        **/

        val listView = findViewById<ListView>(R.id.listView)
        val clear = findViewById<Button>(R.id.clearButton)
        val delete = findViewById<Button>(R.id.deleteButton)

        addButton.setOnClickListener() {

            /*
            var newItem = Item(editTextName.text.toString(), editTextUPC.text.toString(),
                editTextPrice.toString()
            )

             */

            pantryList.add(editTextName.text.toString())
            listView.adapter = adapter
            adapter.notifyDataSetChanged()
        }

        clear.setOnClickListener ()
        {
            pantryList.clear()
            adapter.notifyDataSetChanged()
        }

        listView.setOnItemClickListener()
        {
                adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "You Selected the item --> " +
                    ""+pantryList.get(i), android.widget.Toast.LENGTH_SHORT).show()

        }

        delete.setOnClickListener()
        {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1

            while (item >= 0)
            {
                if (position.get(item))
                {
                    adapter.remove(pantryList.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }



    }
}