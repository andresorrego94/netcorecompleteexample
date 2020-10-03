package com.android.example.courseonelinkedin.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.example.courseonelinkedin.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.main_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        swipeLayout = view.findViewById(R.id.swipeLayout)
        swipeLayout.setOnRefreshListener {
            viewModel.refreshData()
        }

        //SUBSCRIBE TO VIEWMODEL PROPERTY
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.monsterData.observe(viewLifecycleOwner, Observer {
            //ANTES PARA CONCATENAR EN EL TEXTVIEW
            //val monsterNames = StringBuilder()
            //for (monster in it){
                //monsterNames.append(monster.name).append("\n")
            //}
            //this.message.text = monsterNames

            //AHORA PARA MOSTRAR LA LISTA
            val adapter = MainRecyclerAdapter(requireContext(), it)
            recyclerView.adapter = adapter
            swipeLayout.isRefreshing = false
        })

        return view
    }
}