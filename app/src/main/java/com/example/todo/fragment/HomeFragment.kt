package com.example.todo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.Adapter.TodoListAdapter
import com.example.todo.Database.Todo
import com.example.todo.R
import java.util.UUID


class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var todoListAdapter: TodoListAdapter
    private var items = listOf(
        Todo(
            id = UUID.randomUUID().toString(),
            title = "play foot ball",
            detial = "talk to your teamates!",
            status = Todo.Status.PENDING,
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "go to University",
            detial = "attend the Android adnave!",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "go to University",
            detial = "attend the Android adnave!",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "go to University",
            detial = "attend the Android adnave!",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "go to University",
            detial = "attend the Android adnave!",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "go to University",
            detial = "attend the Android adnave!",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "go to University",
            detial = "attend the Android adnave!",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "go to University",
            detial = "attend the Android adnave!",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "go to University",
            detial = "attend the Android adnave!",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "go to University",
            detial = "attend the Android adnave!",
            status = Todo.Status.COMPLETED,
        ),
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recycleView)

        // Set up the RecyclerView with the TodoListAdapter
        todoListAdapter = TodoListAdapter(requireContext(), ArrayList())
        todoListAdapter = TodoListAdapter(requireContext(), ArrayList())
        recyclerView.adapter = todoListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Call a method to populate the adapter with data
        populateAdapterWithData()

        return view
    }

    private fun populateAdapterWithData() {
        // Update the data in the adapter
        todoListAdapter.updateData(items)
    }

}