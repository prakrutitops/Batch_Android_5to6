package tops.tech.retrofitcrudex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdapter(var context:Context,var list:MutableList<Model>) :RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.design,parent,false)
        return MyView(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.txt1.setText(list.get(position).product_name)
        holder.txt2.setText(list.get(position).product_price)
        holder.txt3.setText(list.get(position).product_description)
    }

}
class MyView(itemview: View) :RecyclerView.ViewHolder(itemview)
{

    var txt1:TextView = itemview.findViewById(R.id.txt1)
    var txt2:TextView = itemview.findViewById(R.id.txt2)
    var txt3:TextView = itemview.findViewById(R.id.txt3)

}