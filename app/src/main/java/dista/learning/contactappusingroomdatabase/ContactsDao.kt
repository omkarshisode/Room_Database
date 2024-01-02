package dista.learning.contactappusingroomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import java.util.concurrent.Flow

//
@Dao
interface ContactsDao {
    // implement the function that we can use again and again to change in the data

    // To insert the data if already existed then it terminate the process
    @Upsert
    suspend fun upsertContact(contacts: Contacts)

    // Delete contacts from the data base
    @Delete
    suspend fun deleteContact(contacts: Contacts)

    @Query("SELECT * From contacts ORDER BY firstName ASC")
    fun getContactsByFirstName(): LiveData<List<Contacts>>

    @Query("SELECT * From contacts ORDER BY lastName ASC")
    fun getContactsByLastName(): LiveData<List<Contacts>>

    @Query("SELECT * From contacts ORDER BY phoneNumber ASC")
    fun getContactsByPhoneNumber(): LiveData<List<Contacts>>


}