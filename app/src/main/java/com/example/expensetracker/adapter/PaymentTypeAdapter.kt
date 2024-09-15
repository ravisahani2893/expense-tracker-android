package com.example.expensetracker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.expensetracker.databinding.CategorySpinnerItemBinding
import com.example.expensetracker.databinding.PaymentTypeSpinnerItemBinding
import com.example.expensetracker.model.category.CategoryResponseItem
import com.example.expensetracker.model.paymenttype.PaymentTypeResponseItem
import com.example.expensetracker.model.subcategory.SubCategoryResponseItem


class PaymentTypeAdapter(context: Context?, categoryList: List<PaymentTypeResponseItem?>?) :
    ArrayAdapter<PaymentTypeResponseItem?>(context!!, 0, categoryList!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view=convertView
        if (convertView == null) {
            val binding=PaymentTypeSpinnerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            view = binding.root

            val subCategory: PaymentTypeResponseItem? = getItem(position)

            if (subCategory != null) {
                binding.textView.text = subCategory.type
            }
        }

        return view!!
    }
}