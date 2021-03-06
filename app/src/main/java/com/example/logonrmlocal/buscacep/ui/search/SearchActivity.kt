package com.example.logonrmlocal.buscacep.ui.search

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.logonrmlocal.buscacep.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_search.*



class SearchActivity : AppCompatActivity() {

    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        Picasso.get()
                .load("https://png.pngtree.com/svg/20161013/geographical_position_134408.png")
                .into(ivLogo)

        searchViewModel = ViewModelProviders.of(this)
                .get(SearchViewModel::class.java)

        btPesquisar.setOnClickListener {
            searchViewModel.search(etCEP.text.toString())
        }

        searchViewModel.address.observe(this, Observer {
            tvResultado.text = it?.street
        })

        searchViewModel.errorMessage.observe(this, Observer {
            if (!it.equals("")) {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

        searchViewModel.isLoading.observe(this, Observer {
            isLoading -> if (isLoading == true) {
                loading.visibility = View.VISIBLE
            } else {
                loading.visibility = View.GONE
            }
        })
    }
}
