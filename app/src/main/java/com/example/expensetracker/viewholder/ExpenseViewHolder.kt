package com.example.expensetracker.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.expensetracker.R
import com.example.expensetracker.databinding.LayoutExpenseDetailBinding
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.utils.DateUtils

data class ExpenseViewHolder(val binding: LayoutExpenseDetailBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(data: ExpenseResponseItem){

        binding.tvExpenseCategory.text= data.categoryName
        binding.tvExpenseSubcategory.text = data.subCategoryName
        binding.tvExpenseAmount.text = binding.root.context.getString(R.string.rupee) + " "+data.expenseAmount
        binding.tvExpensePayment.text=data.paymentType
        binding.tvExpenseDesc.text=data.expenseDescription
//        val date = DateUtils.formatDate("E, dd MMM yyyy HH:mm:ss", data.expenseDate!!)
//        binding.tvExpenseDate.text = date
    }
}