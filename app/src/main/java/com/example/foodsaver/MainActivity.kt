package com.example.foodsaver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.*
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pantryList = arrayListOf<Item>()
        var itemsAdapter = ItemAdapter (this,
            pantryList)

        /*
        var adapter = ArrayAdapter<Item> (this, android.R.layout.simple_list_item_multiple_choice,
        pantryList)
         */

        val addButton = findViewById<Button>(R.id.addButton)
        val editTextName = findViewById<TextView>(R.id.editTextItemName)

        val editTextUPC = findViewById<TextView>(R.id.editTextUPC)
        val editTextPrice = findViewById<TextView>(R.id.editTextPrice)
        val datePicker = findViewById<DatePicker>(R.id.expirationDate)

        val listView = findViewById<ListView>(R.id.listView)
        val clear = findViewById<Button>(R.id.clearButton)
        val delete = findViewById<Button>(R.id.deleteButton)

        val selectedDate = Calendar.getInstance()

        datePicker.init(selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            val msg = "Expiration Date: $day/$month/$year"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }


        addButton.setOnClickListener() {


            var newItem = Item(editTextName.text.toString(), editTextUPC.text.toString(),
                editTextPrice.text.toString(), datePicker.year.toString(), datePicker.month.toString(),
                datePicker.dayOfMonth.toString()
            )

            pantryList.add(newItem)
            listView.adapter = itemsAdapter
            itemsAdapter.notifyDataSetChanged()
        }

        clear.setOnClickListener ()
        {
            pantryList.clear()
            itemsAdapter.notifyDataSetChanged()
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
                    itemsAdapter.remove(pantryList.get(item))
                }
                item--
            }
            position.clear()
            itemsAdapter.notifyDataSetChanged()
        }

    }
}