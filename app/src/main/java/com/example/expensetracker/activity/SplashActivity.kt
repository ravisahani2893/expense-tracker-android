package com.example.expensetracker.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.expensetracker.R
import com.example.expensetracker.viewmodel.SplashScreenViewModel

class SplashActivity : AppCompatActivity() {


    var handler: Handler = Handler()

    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViewModel()
        handler.postDelayed(mUpdateTimeTask, 1500)
    }

    fun initViewModel(){
        viewModel = ViewModelProvider(this).get(SplashScreenViewModel::class.java)
    }

    private val mUpdateTimeTask = Runnable {
       if(!viewModel.isUserLoggedIn()){
          val intent = Intent(this,LoginActivity::class.java)
           startActivity(intent)
           finish()
       }else{
           val intent = Intent(this,HomeActivity::class.java)
           startActivity(intent)
           finish()
       }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(handler != null){
            handler.removeCallbacks(mUpdateTimeTask)
        }
    }


}