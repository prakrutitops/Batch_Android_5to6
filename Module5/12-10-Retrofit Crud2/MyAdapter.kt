package tops.tech.retrofitcrudex

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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAdapter(var context:Context,var list:MutableList<Model>) :RecyclerView.Adapter<MyView>()
{
    lateinit var apiinterface: Apiinterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.design,parent,false)
        return MyView(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        holder.txt1.setText(list.get(position).product_name)
        holder.txt2.setText(list.get(position).product_price)
        holder.txt3.setText(list.get(position).product_description)
        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("Select Operation?")
            alert.setPositiveButton("Update",{
                    dialogInterface: DialogInterface, i: Int ->

                    var i = Intent(context,UpdateActivity::class.java)
                    i.putExtra("id",list.get(position).product_id)
                    i.putExtra("name",list.get(position).product_name)
                    i.putExtra("price",list.get(position).product_price)
                    i.putExtra("des",list.get(position).product_description)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(i)


            })
            alert.setNegativeButton("Delete",{
                    dialogInterface: DialogInterface, i: Int ->


             var call: Call<Void> = apiinterface.deletedata(list.get(position).product_id)

             call.enqueue(object :Callback<Void>{
                 override fun onResponse(call: Call<Void>, response: Response<Void>) {

                     Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show()
                     var i = Intent(context,ViewActivity::class.java)
                     i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                     context.startActivity(i)
                 }

                 override fun onFailure(call: Call<Void>, t: Throwable) {

                     Toast.makeText(context,"Fail",Toast.LENGTH_LONG).show()

                 }
             })


            })
            alert.show()

        }
    }

}
class MyView(itemview: View) :RecyclerView.ViewHolder(itemview)
{

    var txt1:TextView = itemview.findViewById(R.id.txt1)
    var txt2:TextView = itemview.findViewById(R.id.txt2)
    var txt3:TextView = itemview.findViewById(R.id.txt3)

}