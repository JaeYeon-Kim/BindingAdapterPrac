package com.example.bindingadapterprac.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bindingadapterprac.model.ProfileData

object MyBindingAdapter {


    // 바인딩 어댑터 설정
    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: ArrayList<ProfileData>) {

        // 어댑터 연결
        if(recyclerView.adapter == null) {
            val adapter = ProfileAdapter()
            recyclerView.adapter = adapter
        }

        val profileAdapter = recyclerView.adapter as ProfileAdapter

        // 갱신
        profileAdapter.submitList(items.toMutableList())
    }


    // 이미지 바인딩
    @BindingAdapter("image")
    @JvmStatic
    fun setImage(imageView: ImageView, imageUrl: Any) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .override(200, 200)
            .circleCrop().into(imageView)
    }
}