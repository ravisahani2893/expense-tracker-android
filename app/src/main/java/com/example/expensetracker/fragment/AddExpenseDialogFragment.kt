package com.example.expensetracker.fragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.expensetracker.R
import com.example.expensetracker.activity.HomeActivity
import com.example.expensetracker.adapter.CategoryAdapter
import com.example.expensetracker.adapter.PaymentTypeAdapter
import com.example.expensetracker.adapter.SubCategoryAdapter
import com.example.expensetracker.databinding.FragmentAddExpenseDialogBinding
import com.example.expensetracker.listener.OnDateSelectListener
import com.example.expensetracker.listener.OnExpenseAddListener
import com.example.expensetracker.listener.OnTimeSelectListener
import com.example.expensetracker.model.category.CategoryResponseItem
import com.example.expensetracker.model.paymenttype.PaymentTypeResponseItem
import com.example.expensetracker.model.subcategory.SubCategoryResponseItem
import com.example.expensetracker.network.model.DataResponse
import com.example.expensetracker.utils.AppUtils
import com.example.expensetracker.utils.DateUtils
import com.example.expensetracker.viewmodel.ExpenseViewModel


class AddExpenseDialogFragment : DialogFragment(), View.OnClickListener, OnTimeSelectListener,
    OnDateSelectListener {

    private var view: View? = null

    private lateinit var expenseViewModel: ExpenseViewModel
    private lateinit var binding: FragmentAddExpenseDialogBinding

    private var category: CategoryResponseItem? = null
    private var subCategory: SubCategoryResponseItem? = null
    private var paymentType: PaymentTypeResponseItem? = null

    private var expenseDate: String? = null
    private var expenseTime: String? = null


    private lateinit var expenseAddListener: OnExpenseAddListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HomeActivity) {
            expenseAddListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (view == null) {
            binding = FragmentAddExpenseDialogBinding.inflate(layoutInflater, container, false)
            view = binding!!.root
            initResources()
        }
        return view
    }

    private fun initResources() {
        expenseViewModel = ViewModelProvider(this).get(ExpenseViewModel::class.java)
        setClickListener()
        getCategory()
        getPaymentType()
    }

    private fun setClickListener() {
        binding.pickDate.setOnClickListener(this)
        binding.pickTime.setOnClickListener(this)
        binding.tvCategory.setOnClickListener(this)
        binding.tvSubcategory.setOnClickListener(this)
        binding.tvPayment.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
    }

    private fun getCategory() {
        expenseViewModel.getCategory().observe(viewLifecycleOwner) {

            when (it.status) {

                DataResponse.Status.LOADING -> {
//                    AppUtils.showProgressDialog(context, false)
                }

                DataResponse.Status.ERROR -> {
                    AppUtils.hideProgressDialog()
                }

                DataResponse.Status.SUCCESS -> {
                    AppUtils.hideProgressDialog()
                    if (it.data != null) {
                        setCategoryAdapter(it.data)
                    }

                }

                else -> {

                }
            }

        }

    }

    private fun getSubCategory(categoryId: Int) {
        expenseViewModel.getSubCategory(categoryId).observe(this) {

            when (it.status) {

                DataResponse.Status.LOADING -> {
                    AppUtils.showProgressDialog(context, false)
                }

                DataResponse.Status.ERROR -> {
                    AppUtils.hideProgressDialog()
                }

                DataResponse.Status.SUCCESS -> {
                    AppUtils.hideProgressDialog()
                    if (it.data != null) {
                        if (it.data.isEmpty()) {
                            binding.tvSubcategory.text = "Select Sub Category"
                            subCategory=null
                            setSubCategoryAdapter(emptyList())
                        } else {
                            setSubCategoryAdapter(it.data)
                        }

                    }

                }

                else -> {

                }
            }

        }

    }

    private fun getPaymentType() {
        expenseViewModel.getPaymentType().observe(this) {

            when (it.status) {

                DataResponse.Status.LOADING -> {
//                    AppUtils.showProgressDialog(context, false)
                }

                DataResponse.Status.ERROR -> {
                    AppUtils.hideProgressDialog()
                }

                DataResponse.Status.SUCCESS -> {
                    AppUtils.hideProgressDialog()
                    if (it.data != null) {
                        setPaymentTypeAdapter(it.data)
                    }

                }

                else -> {

                }
            }

        }

    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            // Set full width
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    private fun setCategoryAdapter(categoryItemList: List<CategoryResponseItem>) {
        val categoryAdapter = CategoryAdapter(context, categoryItemList)
        binding.spinnerCategory.adapter = categoryAdapter

        binding.spinnerCategory.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedCategory: CategoryResponseItem = categoryItemList[position]
                    category = selectedCategory
                    binding.tvCategory.text = category?.name
                    getSubCategory(category?.id!!)

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
    }

    private fun setSubCategoryAdapter(subCategoryList: List<SubCategoryResponseItem>) {
        val adapter = SubCategoryAdapter(context, subCategoryList)
        binding.spinnerSubcategory.adapter = adapter

        binding.spinnerSubcategory.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    subCategory = subCategoryList[position]
                    binding.tvSubcategory.text = subCategory?.name
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
    }

    private fun setPaymentTypeAdapter(paymentTypeList: List<PaymentTypeResponseItem>) {
        val adapter = PaymentTypeAdapter(context, paymentTypeList)
        binding.spinnerPaymentType.adapter = adapter

        binding.spinnerPaymentType.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    paymentType = paymentTypeList[position]
                    binding.tvPayment.text = paymentType?.type
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.pick_time -> {
                val newFragment = TimePickerFragment()
                newFragment.setTimeSelectListener(this)
                newFragment.show(childFragmentManager, "datePicker")
            }

            R.id.pick_date -> {
                val newFragment = DatePickerFragment()
                newFragment.setDateSelectListener(this)
                newFragment.show(childFragmentManager, "datePicker")
            }

            R.id.tv_category -> {
                binding.spinnerCategory.performClick()
            }

            R.id.tv_subcategory -> {
                binding.spinnerSubcategory.performClick()
            }

            R.id.tv_payment -> {
                binding.spinnerPaymentType.performClick()
            }

            R.id.btn_submit -> {
                if (isValid()) {
                    createExpense()
                }
            }
        }
    }

    private fun isValid(): Boolean {

        if (category == null) {
            AppUtils.showToastMessage(context, "Please select category")
            return false
        } else if (subCategory == null) {
            AppUtils.showToastMessage(context, "Please select sub-category")
            return false
        } else if (paymentType == null) {
            AppUtils.showToastMessage(context, "Please select payment type")
            return false
        } else if (TextUtils.isEmpty(binding.etAmount.text)) {
            AppUtils.showToastMessage(context, "Please enter amount")
            return false
        } else if (TextUtils.isEmpty(expenseDate)) {
            AppUtils.showToastMessage(context, "Please select date")
            return false
        } else if (TextUtils.isEmpty(expenseTime)) {
            AppUtils.showToastMessage(context, "Please select time")
            return false
        }
        return true

    }

    fun createExpense() {
        val categoryId = category?.id
        val subCategoryId = subCategory?.id
        val paymentTypeId = paymentType?.id
        val amount = binding.etAmount.text.toString()
        val description = binding.etDescription.text.toString()
        val expenseDateTime = expenseDate.plus(" ").plus(expenseTime)
        val dateTime = DateUtils.formatDateTime(expenseDateTime)

        val expenseRequest = expenseViewModel.createExpenseRequest(
            categoryId!!,
            subCategoryId!!,
            paymentTypeId!!,
            amount,
            dateTime,
            description
        )

        expenseViewModel.createExpense(expenseRequest).observe(this) {

            when (it.status) {

                DataResponse.Status.LOADING -> {
                    AppUtils.showProgressDialog(context, false)
                }

                DataResponse.Status.ERROR -> {
                    AppUtils.hideProgressDialog()
                }

                DataResponse.Status.SUCCESS -> {
                    AppUtils.hideProgressDialog()
                    if (it.data != null && it.data.id != null) {
                        AppUtils.showToastMessage(context, "Expense created successfully!")
                        expenseAddListener.onExpenseAdded()
                        dismiss()
                    }

                }

                else -> {

                }
            }

        }


    }


    override fun onTimeSelected(time: String) {
        expenseTime = DateUtils.formatExpenseTime(time)
        binding.pickTime.text = expenseTime


    }

    override fun onDateSelected(date: String) {
        expenseDate = DateUtils.formatExpenseDate(date)
        binding.pickDate.text = expenseDate
    }
}