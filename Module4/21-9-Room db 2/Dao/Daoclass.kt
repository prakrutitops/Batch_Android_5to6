package tops.tech.roomdbex.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import tops.tech.roomdbex.Entity.User
@Dao
interface Daoclass
{
    @Insert
     fun insertdata(user:User?)

    @Query("select * from tops")
    fun getUsers(): MutableList<User>

    @Delete
    fun deletedata(user:User?)

    @Update
    fun updatedata(user:User?)
}