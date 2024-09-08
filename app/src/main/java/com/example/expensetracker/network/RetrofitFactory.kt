package com.example.expensetracker.network;

import android.text.TextUtils
import androidx.annotation.NonNull
import com.example.expensetracker.BuildConfig
import com.example.expensetracker.preference.PreferenceManager
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit


internal object RetrofitFactory {

    private var retrofit: Retrofit? = null

    private val retrofitClient: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(UrlConstant.BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create(getObjectMapper()))
                    .build()
            }
            return retrofit!!
        }

    private fun getObjectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        return objectMapper
    }


    private val httpLoggingInterceptor: HttpLoggingInterceptor
        @NonNull
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            } else {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
            }
            return httpLoggingInterceptor
        }



    private val okHttpClient: OkHttpClient
        @NonNull
        get() {
            val builder = OkHttpClient.Builder()
            builder.addInterceptor(httpLoggingInterceptor)
            builder.connectTimeout(60, TimeUnit.SECONDS) // connect timeout
            builder.readTimeout(60, TimeUnit.SECONDS)    // socket timeout
            builder.addInterceptor(getHeaderInterceptor())
            builder.retryOnConnectionFailure(true)
            return builder.build()
        }


    private fun getHeaderInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val original: Request = chain.request()
            // Request customization: add request headers
            val requestBuilder: Request.Builder = original.newBuilder()
                .addHeader(
                    "App-Version",
                    BuildConfig.VERSION_CODE.toString().replace(".", "")
                )
                .addHeader("Client-Os", "android")

            if (!TextUtils.isEmpty(PreferenceManager.getSharedPreference().token)) {
                requestBuilder.addHeader("Authorization", "Bearer " + PreferenceManager.getSharedPreference().token)
            }

            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }


    fun <S> createService(serviceClass: Class<S>): S {
        return retrofitClient.create(serviceClass)
    }
}
