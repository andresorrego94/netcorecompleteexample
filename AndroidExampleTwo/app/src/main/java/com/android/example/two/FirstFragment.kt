package com.android.example.two

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import android.widget.Toast

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        view.findViewById<Button>(R.id.toast_button).setOnClickListener{
            //Create toast
            val myToast = Toast.makeText(context, "Hi", Toast.LENGTH_SHORT)
            //show toast
            myToast.show()
        }

        view.findViewById<Button>(R.id.toast_button).setOnClickListener{
            //Create toast
            val myToast = Toast.makeText(context, "Hi", Toast.LENGTH_SHORT)
            //show toast
            myToast.show()
        }
    }
}