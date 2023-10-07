    package com.example.todo.fragment

    import android.content.Context
    import android.content.SharedPreferences
    import android.os.Bundle
    import android.os.CountDownTimer
    import android.widget.Chronometer
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Button
    import android.os.SystemClock
    import android.widget.TextView
    import android.widget.Toast
    import com.example.todo.R
    import com.google.android.material.bottomsheet.BottomSheetDialogFragment




    class DetailFragment : BottomSheetDialogFragment() {
        private lateinit var startButton: Button
        private lateinit var timerTextView: TextView
        private var isTimerRunning = false

        private lateinit var title: TextView
        private lateinit var detail:TextView


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            val view = inflater.inflate(R.layout.fragment_detail, container, false)

            startButton = view.findViewById(R.id.startButton)
            timerTextView = view.findViewById(R.id.timerTextView)

            // Set initial time to 50 minutes
            val initialTimeMillis = 50 * 60 * 1000L
            updateTimerText(initialTimeMillis)

            startButton.setOnClickListener {
                if (isTimerRunning) {
                    // Stop the timer
                    timerTextView.text = "00:00"
                    isTimerRunning = false
                } else {
                    // Start the timer
                    startCountDown(initialTimeMillis)
                }
            }


            title= view.findViewById(R.id.titleTextView)
            detail= view.findViewById(R.id.detailTextView)

            val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val sharedPreferenceValue = sharedPreferences.getString("key", null)

            Toast.makeText(requireContext(), "$sharedPreferenceValue", Toast.LENGTH_SHORT).show()

            val homeFragment = HomeFragment()
            val items = homeFragment.items
            val foundTodo = items.find { it.id == sharedPreferenceValue }
            if (foundTodo != null) {
                title.text = foundTodo.title
                detail.text = foundTodo.detial
            }


            return view
        }

        private fun startCountDown(initialTimeMillis: Long) {
            object : CountDownTimer(initialTimeMillis, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    updateTimerText(millisUntilFinished)
                }

                override fun onFinish() {
                    updateTimerText(0)
                    isTimerRunning = false
                }
            }.start()

            isTimerRunning = true
        }

        private fun updateTimerText(millisUntilFinished: Long) {
            val seconds = (millisUntilFinished / 1000) % 60
            val minutes = (millisUntilFinished / (1000 * 60)) % 60
            timerTextView.text = String.format("%02d:%02d", minutes, seconds)
        }



    }