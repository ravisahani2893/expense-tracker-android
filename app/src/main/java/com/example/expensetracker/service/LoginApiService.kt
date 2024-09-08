package  com.example.expensetracker.service


import androidx.lifecycle.LiveData
import com.example.expensetracker.model.login.LoginRequest
import com.example.expensetracker.model.login.LoginResponse
import com.example.expensetracker.network.model.DataResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface LoginApiService {

    @POST
    fun login(@Url url : String,@Body request: LoginRequest): LiveData<DataResponse<LoginResponse>>


}