package com.example.android.codelabs.paging.viewpagerwithtablayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.codelabs.paging.R
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(val images: List<Int>): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)

    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = images[position]
        holder.itemView.image.setImageResource(curImage)

    }

    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}