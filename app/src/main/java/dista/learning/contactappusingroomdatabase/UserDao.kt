package dista.learning.contactappusingroomdatabase

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll():List<UserInfo>

    @Query("SELECT * FROM user WHERE Abcd@123")
}