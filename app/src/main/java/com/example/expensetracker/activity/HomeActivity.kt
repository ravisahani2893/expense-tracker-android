package com.example.expensetracker.activity

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expensetracker.adapter.ExpenseAdapter
import com.example.expensetracker.databinding.ActivityHomeScreenBinding
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.network.model.DataResponse
import com.example.expensetracker.utils.AppUtils
import com.example.expensetracker.viewmodel.MainActivityViewModel


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    private lateinit var expenseAdapter  : ExpenseAdapter

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initializeResources()
        initListener()
        initViewModel()
        getExpenseList()
    }

    private fun initListener(){
        onBackPressedDispatcher.addCallback(this,onBackPressedCallback)
    }

    private fun initViewModel(){
        viewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun initializeResources(){
       val toggle = ActionBarDrawerToggle(
            this,
           binding.drawerLayout,
            binding.mainToolbar,
            com.example.expensetracker.R.string.navigation_drawer_open,
            com.example.expensetracker.R.string.navigation_drawer_close
        )

        binding.drawerLayout.addDrawerListener(toggle)
        binding.drawerLayout.addDrawerListener(object : SimpleDrawerListener() {
            override fun onDrawerSlide(drawer: View, slideOffset: Float) {
                binding.layoutMain.setX(binding.navView.getWidth() * slideOffset)
            }

            override fun onDrawerClosed(drawerView: View) {
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }
        })

        toggle.syncState()

        binding.txtCommonToolbar.text="Home"

    }


    private fun setExpenseAdapter(expenseResponse: List<ExpenseResponseItem>){
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvExpense.setLayoutManager(layoutManager)
        expenseAdapter = ExpenseAdapter()
        expenseAdapter.setExpenseData(expenseResponse)
        binding.rvExpense.adapter=expenseAdapter
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                finish();
            }
        }
    }

    fun getExpenseList(){
        viewModel.getExpenseList().observe(this) {

            when (it.status) {

                DataResponse.Status.LOADING -> {
                    AppUtils.showProgressDialog(this, false)
                }

                DataResponse.Status.ERROR -> {
                    AppUtils.hideProgressDialog()
                }

                DataResponse.Status.SUCCESS -> {
                    AppUtils.hideProgressDialog()
                    if(it.data != null){
                        setExpenseAdapter(it.data)
                    }

                }

                else -> {

                }

            }
        }
    }

}