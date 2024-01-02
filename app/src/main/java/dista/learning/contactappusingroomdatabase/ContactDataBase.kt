package dista.learning.contactappusingroomdatabase

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Contacts::class],
    version = 1
)

abstract class ContactDataBase : RoomDatabase() {

    // Instance of the dao interface
    abstract val dao: ContactsDao

    companion object {
        @Volatile
        var instance: ContactDataBase? = null
        fun getDatabase(context: Context): ContactDataBase {
         if (instance == null){
             synchronized(this){
                 instance = Room.databaseBuilder(context.applicationContext,
                     ContactDataBase::class.java,
                     "ContactDB").build()
             }
         }
            return instance!!
        }

    }
}