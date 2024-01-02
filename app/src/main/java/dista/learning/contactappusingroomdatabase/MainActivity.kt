package dista.learning.contactappusingroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var dataBase: ContactDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Passing the context of this activity so we can get the that method from contact database
        dataBase = ContactDataBase.getDatabase(this)

        GlobalScope.launch {
            dataBase.dao.upsertContact(Contacts(0, "Omkar", "Shisode", 9075481121))
        }
        fun getDataBase(view:View){
            dataBase.dao.getContactsByFirstName().observe(this
            ) {
                Log.d("Data", it.toString())
            }
        }
    }
}