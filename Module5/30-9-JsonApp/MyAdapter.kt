package tops.tech.signupsigninex

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MyAdapter(var context:Context,var list:MutableList<Model>) :RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var layout = LayoutInflater.from(parent.context)
        var view = layout.inflate(R.layout.design,parent,false)
        return MyView(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, @SuppressLint("RecyclerView") position: Int)
    {
        holder.txt1.setText(list.get(position).pname)
        holder.txt2.setText(list.get(position).pprice)
        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("Select Operations?")
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int -> })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->


                var stringRequest: StringRequest = object : StringRequest(
                    Request.Method.POST,
                    "https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productdelete.php",
                    Response.Listener {

                        Toast.makeText(context, "Product Deleted", Toast.LENGTH_LONG).show()
                        var i = Intent(context,DashboardActivity::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(i)
                    },
                    Response.ErrorListener {

                        Toast.makeText(context, "No Internet", Toast.LENGTH_LONG).show()

                    }) {
                    override fun getParams(): MutableMap<String, String>? {
                        var map = HashMap<String, String>()
                        map["product_id"] = list.get(position).pid.toString()


                        return map
                    }
                }

                var queue: RequestQueue = Volley.newRequestQueue(context)
                queue.add(stringRequest)

            })
            alert.show()

        }
    }

}
class MyView(itemview: View):RecyclerView.ViewHolder(itemview)
{

    var txt1:TextView = itemview.findViewById(R.id.txt1)
    var txt2:TextView = itemview.findViewById(R.id.txt2)

}