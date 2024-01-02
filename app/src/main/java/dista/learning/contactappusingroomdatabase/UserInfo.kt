package dista.learning.contactappusingroomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
// new table in app

@Entity
data class UserInfo(
@PrimaryKey
val uid:Int,
@ColumnInfo("first_name")
val firstName:String,
@ColumnInfo("last_name")
val lastName:String
)
