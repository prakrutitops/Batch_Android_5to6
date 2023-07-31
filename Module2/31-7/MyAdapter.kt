package com.example.detail1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context:Context,var list: MutableList<Model>) :RecyclerView.Adapter<Tops>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tops
    {
       var layoutInflater = LayoutInflater.from(context)
       var view = layoutInflater.inflate(R.layout.design,parent,false)
        return Tops(view)
    }

    override fun onBindViewHolder(holder: Tops, position: Int) {
        holder.image.setImageResource(list.get(position).image)
        holder.text.setText(list.get(position).name)

        holder.itemView.setOnClickListener {

            Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show()

        }
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

}
class Tops(itemview: View) : RecyclerView.ViewHolder(itemview)
{
     var image:ImageView
     var text:TextView
   init
   {
       image = itemview.findViewById(R.id.img)
       text = itemview.findViewById(R.id.txt)
   }



}