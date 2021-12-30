package com.example.shg_clone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shg_clone.DataAboutUs
import com.example.shg_clone.PostItem
import com.example.shg_clone.R
import kotlinx.android.synthetic.main.about_item_view.view.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*

class AboutUsRecylearAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mList: List<DataAboutUs> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.about_item_view, parent, false)

        return ViewHolder(view)
    }
    fun setData(list: List<DataAboutUs>){
        mList = list
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).textView.text = mList[position].title
        holder.description.text = HtmlCompat.fromHtml(mList[position].description?:"", HtmlCompat.FROM_HTML_MODE_COMPACT)
        //holder.imageView.image= Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);
    }


    override fun getItemCount(): Int {
      return mList.size
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView
        val description: TextView
        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.title)
            imageView = view.findViewById(R.id.image)
            description = view.findViewById(R.id.description)

        }
    }
}

