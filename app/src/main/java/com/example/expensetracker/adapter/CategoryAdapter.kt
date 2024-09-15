package com.example.expensetracker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.expensetracker.databinding.CategorySpinnerItemBinding
import com.example.expensetracker.model.category.CategoryResponseItem


class CategoryAdapter(context: Context?, categoryList: List<CategoryResponseItem?>?) :
    ArrayAdapter<CategoryResponseItem?>(context!!, 0, categoryList!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view=convertView
        if (convertView == null) {
            val binding=CategorySpinnerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            view = binding.root

            val currentCategory: CategoryResponseItem? = getItem(position)

            if (currentCategory != null) {
                binding.textView.text = currentCategory.name
            }
        }

        return view!!
    }
}