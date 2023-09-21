package tops.tech.roomdbex.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import tops.tech.roomdbex.Database.DatabaseClass
import tops.tech.roomdbex.Entity.User

import tops.tech.roomdbex.R

class UserAdapter(var context:Context,var userList: MutableList<User>) :RecyclerView.Adapter<MyView>()
{
    var db: DatabaseClass? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var layout = LayoutInflater.from(parent.getContext())
       var view = layout.inflate(R.layout.design,parent,false)
        db = Room.databaseBuilder(context, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
       return MyView(view)
    }

    override fun getItemCount(): Int
    {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.name.setText(userList.get(position).username)
        holder.email.setText(userList.get(position).useremail)

        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("Select Operation?")
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->





            })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

                deleteuser(userList.get(position).id)
                userList.removeAt(position)
                //refresh
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, userList.size)





            })

            alert.show()

        }
    }

    private fun deleteuser(id:Int)
    {
        var u = User()
        u.id = id
        db!!.daoClass().deletedata(u)


    }


}
class MyView(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val name: TextView
    val email: TextView

    init
    {
        name = itemView.findViewById<TextView>(R.id.name)
        email = itemView.findViewById<TextView>(R.id.email)
    }
}