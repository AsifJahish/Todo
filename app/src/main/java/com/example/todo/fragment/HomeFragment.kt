package com.example.todo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.Adapter.TodoListAdapter
import com.example.todo.Database.Todo
import com.example.todo.R
import java.util.UUID


class HomeFragment : Fragment(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var todoListAdapter: TodoListAdapter
    private lateinit var addButton:Button


   var items = listOf(
        Todo(
            id = "1",
            title = "go to University",
            detial = "Lists, when used correctly, can be a technical writer’s—and reader’s—best friend. Lists allow you to emphasize important ideas. They also increase the readability of text by simplifying long sentences or paragraphs and adding aesthetic passive space to make reading more pleasant. However, using the wrong kind of list or poorly formatting a list can create confusion rather than enhance readability. Therefore, it is important to understand the various types of lists and how and why to use them.\n" +
                    "\n",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id = "2",
            title = "go to University",
            detial = "Lists, when used correctly, can be a technical writer’s—and reader’s—best friend. Lists allow you to emphasize important ideas. They also increase the readability of text by simplifying long sentences or paragraphs and adding aesthetic passive space to make reading more pleasant. However, using the wrong kind of list or poorly formatting a list can create confusion rather than enhance readability. Therefore, it is important to understand the various types of lists and how and why to use them.\n" +
                    "\n",
            status = Todo.Status.COMPLETED,
        ),
        Todo(
            id ="3",
            title = "go to University",
            detial = "Lists, when used correctly, can be a technical writer’s—and reader’s—best friend. Lists allow you to emphasize important ideas. They also increase the readability of text by simplifying long sentences or paragraphs and adding aesthetic passive space to make reading more pleasant. However, using the wrong kind of list or poorly formatting a list can create confusion rather than enhance readability. Therefore, it is important to understand the various types of lists and how and why to use them.\n" +
                    "\n",
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


    private fun changeTodoStatus(todo: Todo) {

        val updatedItems = items.map {
            if (it.id == todo.id) {
                it.copy(status = if (it.status == Todo.Status.COMPLETED) Todo.Status.PENDING else Todo.Status.COMPLETED)
            } else {
                it
            }
        }

        // Update the data in the adapter
        todoListAdapter.updateData(updatedItems)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recycleView)

        todoListAdapter = TodoListAdapter(requireContext(), ArrayList())
        todoListAdapter = TodoListAdapter(requireContext(), ArrayList())
        recyclerView.adapter = todoListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        addButton= view.findViewById(R.id.addTodoButton)


        addButton.setOnClickListener {
           navigateToBottomSheetFragment()
        }
        val addFragment = AddFragment()
        addFragment.setHomeFragment(this)

        populateAdapterWithData()


        return view
    }



    private fun populateAdapterWithData() {
        // Update the data in the adapter
        todoListAdapter.updateData(items)
    }

    private fun navigateToBottomSheetFragment() {
        val addFragment = AddFragment()
        addFragment.show((context as AppCompatActivity).supportFragmentManager, addFragment.tag)
    }



}