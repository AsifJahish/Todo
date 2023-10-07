package com.example.todo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todo.Adapter.TodoListAdapter
import com.example.todo.Database.Todo
import com.example.todo.R
import com.example.todo.databinding.FragmentAddBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.UUID


class AddFragment : BottomSheetDialogFragment() {
    private lateinit var todoListAdapter: TodoListAdapter
    private var binding: FragmentAddBinding? = null
    private var homeFragment: HomeFragment? = null
    private val bindingv get() = binding!!

    fun setHomeFragment(homeFragment: HomeFragment) {
        this.homeFragment = homeFragment
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =FragmentAddBinding.inflate(inflater, container, false)
        return bindingv.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView = binding?.todoTitleEditText
        val detail = binding?.todoDetailEditText
        val submitButton = binding?.addTodoButton
        var items1 = homeFragment?.items

        submitButton?.setOnClickListener {
            homeFragment?.let {
                val newItem = Todo(
                    id = UUID.randomUUID().toString(),
                    title = titleTextView?.text.toString(),
                    detial = detail?.text.toString(),
                    status = Todo.Status.PENDING
                )


                todoListAdapter?.addItem(newItem)
                dismiss()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}