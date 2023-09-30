package com.example.todo.Adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.Database.Todo
import com.example.todo.R
import com.example.todo.fragment.DetailFragment


class TodoListAdapter(private val context: Context, private var toDoList: ArrayList<Todo>) :
    RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = toDoList[position]

        // Bind data to the ViewHolder
        holder.title.text = currentItem.title
        holder.detail.text = currentItem.detial

        holder.status.visibility =
            if (currentItem.status == Todo.Status.COMPLETED) View.VISIBLE else View.INVISIBLE
        holder.status.setColorFilter(
            ContextCompat.getColor(
                context,
                if (currentItem.status == Todo.Status.COMPLETED) R.color.completedColor else R.color.incompleteColor
            )
        )

        // Set click listener for the status image
        holder.status.setOnClickListener {
            // Toggle the status
            currentItem.status = when (currentItem.status) {
                Todo.Status.COMPLETED -> Todo.Status.IN_PROGRESS
                Todo.Status.IN_PROGRESS -> Todo.Status.PENDING
                Todo.Status.PENDING -> Todo.Status.COMPLETED
            }

            // Update the visibility and color of the status image
            holder.status.visibility =
                if (currentItem.status == Todo.Status.COMPLETED) View.VISIBLE else View.INVISIBLE
            holder.status.setColorFilter(
                ContextCompat.getColor(
                    context,
                    if (currentItem.status == Todo.Status.COMPLETED) R.color.completedColor else R.color.incompleteColor
                )
            )

        }
        holder.itemView.setOnClickListener {
            // Handle item click, for example, navigate to another fragment
            navigateToAnotherFragment()
        }
    }
    private fun navigateToAnotherFragment() {

        val newFragment = DetailFragment()
        val bundle = Bundle()
        val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, newFragment)

        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    fun updateData(newList: List<Todo>) {
        toDoList.clear()
        toDoList.addAll(newList)
        notifyDataSetChanged()
        Log.d("TodoListAdapter", "Data updated. New size: ${toDoList.size}")
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val detail: TextView = itemView.findViewById(R.id.detial)
        val status: ImageView = itemView.findViewById(R.id.status)
    }
}



