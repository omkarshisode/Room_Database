package dista.learning.contactappusingroomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("contactDB")
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val phoneNumber:Long


)
