package com.example.binapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.binapp.adapter.Adapter
import com.example.binapp.api.BinApp
//import com.example.binapp.database.BinDataBase
import com.example.binapp.json.BinInfoItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private lateinit var recycler: RecyclerView
    private val adapter = Adapter()

    //    private val db = BinDataBase.getInstance(application)
//    private val binList = db.binInfoDao().getBinList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.listOfBins)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)


        val button: Button = findViewById(R.id.searchButton)
        val input: EditText = findViewById(R.id.inputField)
        button.setOnClickListener {

            val inputText = input.text.toString()
            loadBin(inputText)
        }
    }


    private fun loadBin(input: String) {
        val disposable = (application as BinApp).binApi.getId(input)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { onBinsLoaded(it) },
                { onError(it) })
        compositeDisposable.add(disposable)
    }

    private fun onBinsLoaded(it: BinInfoItem) {
        adapter.setBins(it)
    }

    private fun onError(it: Throwable) {
        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
    }

}

