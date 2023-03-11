package com.example.bindingadapterprac

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.bindingadapterprac.adapter.ProfileAdapter
import com.example.bindingadapterprac.databinding.ActivityMainBinding
import com.example.bindingadapterprac.model.ProfileData
import com.example.bindingadapterprac.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
        }

    }

}