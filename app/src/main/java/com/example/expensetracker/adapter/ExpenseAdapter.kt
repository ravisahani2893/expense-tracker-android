package com.example.expensetracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expensetracker.databinding.LayoutExpenseDetailBinding
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.viewholder.ExpenseViewHolder

class ExpenseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

   private var expenseList : List<ExpenseResponseItem>? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LayoutExpenseDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return expenseList!!.size
    }

    public fun setExpenseData(expenseList:List<ExpenseResponseItem>){
        this.expenseList=expenseList
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as ExpenseViewHolder
        holder.bind(expenseList!![position])
    }
}