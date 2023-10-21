package tops.tech.firebasecrudapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasecrudapp.Model
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions


class MyAdapter(options: FirebaseRecyclerOptions<Model>) : FirebaseRecyclerAdapter<Model, myviewholder>(options)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder
    {
        val view: View = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int, model: Model)
    {
        holder.name.setText(model.myname)
        holder.email.setText(model.myemail)
        holder.pass.setText(model.mypass)

    }

}
class myviewholder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView
    var pass: TextView
    var email: TextView


    init
    {

        name = itemView.findViewById(R.id.txt1)
        email = itemView.findViewById(R.id.txt2)
        pass = itemView.findViewById(R.id.txt3)


    }
}