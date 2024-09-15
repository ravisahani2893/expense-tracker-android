package  com.example.expensetracker.network;

import android.net.Uri

object UrlProvider {

    fun getLoginUrl() : String{

        val uri = Uri.parse(UrlConstant.BASE_URL)
            .buildUpon()
            .appendPath("api")
            .appendPath("auth")
            .appendPath("signin")
            .build()
        return uri.toString()

    }

    fun getExpenseUrl() : String{

        val uri = Uri.parse(UrlConstant.BASE_URL)
            .buildUpon()
            .appendPath("api")
            .appendPath("expense")
            .build()
        return uri.toString()

    }

    fun getCategoryUrl() : String{

        val uri = Uri.parse(UrlConstant.BASE_URL)
            .buildUpon()
            .appendPath("api")
            .appendPath("category")
            .build()
        return uri.toString()

    }

    fun getSubCategoryCategoryUrl(category : Int) : String{

        val uri = Uri.parse(UrlConstant.BASE_URL)
            .buildUpon()
            .appendPath("api")
            .appendPath("subcategory")
            .appendQueryParameter("categoryId",category.toString())
            .build()
        return uri.toString()

    }

    fun getCreateExpenseUrl() : String{

        val uri = Uri.parse(UrlConstant.BASE_URL)
            .buildUpon()
            .appendPath("api")
            .appendPath("expense")
            .build()
        return uri.toString()

    }

    fun getPaymentTypeUrl() : String{

        val uri = Uri.parse(UrlConstant.BASE_URL)
            .buildUpon()
            .appendPath("api")
            .appendPath("paymenttype")
            .build()
        return uri.toString()

    }

}