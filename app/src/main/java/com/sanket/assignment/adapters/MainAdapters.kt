package com.sanket.assignment.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sanket.assignment.R
import com.sanket.assignment.activities.UserDetailActivity
import com.sanket.assignment.interfaces.ItemClickListener
import com.sanket.assignment.models.response.UserResponse

class MainAdapters(var context: Context, var itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<MainAdapters.MainHolder>() {
    var list: List<UserResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.row_user_items, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, pos: Int) {
        list?.let {
            holder.txt_username.text = list?.get(pos).name
            holder.txt_email.text = list?.get(pos).email
            holder.txt_city.text = list?.get(pos).address?.city
            holder.txt_company.text = list?.get(pos).company?.name
            holder.llmain.setOnClickListener({
                itemClickListener.onItemClicked(list?.get(pos))
            })
        }
    }

    override fun getItemCount(): Int {
        return list?.size
    }

    fun setData(data: List<UserResponse>) {
        list = data
        notifyDataSetChanged()
    }

    class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_username: TextView
        var txt_company: TextView
        var txt_email: TextView
        var txt_city: TextView
        var llmain: LinearLayout

        init {
            txt_username = itemView.findViewById(R.id.txt_username)
            txt_city = itemView.findViewById(R.id.txt_city)
            txt_email = itemView.findViewById(R.id.txt_email)
            txt_company = itemView.findViewById(R.id.txt_company)
            llmain = itemView.findViewById(R.id.llmain)
        }
    }
}