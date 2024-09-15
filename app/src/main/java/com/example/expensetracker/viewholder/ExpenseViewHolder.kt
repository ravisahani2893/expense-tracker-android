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
        if(data.expenseDate != null){
            val date = DateUtils.formatDateTime(data.expenseDate,DateUtils.PATTERN_DATE)
            binding.tvExpenseDate.text = date
        }

        if(data.expenseTime != null){
            binding.tvExpenseDateTime.text = data.expenseTime
        }
    }
}