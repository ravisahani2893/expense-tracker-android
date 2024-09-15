package  com.example.expensetracker.service


import androidx.lifecycle.LiveData
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.model.expense.create.request.ExpenseRequest
import com.example.expensetracker.model.expense.create.response.ExpenseResponse
import com.example.expensetracker.network.model.DataResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface ExpenseApiService {

    @GET
    fun getExpenseList(@Url url : String): LiveData<DataResponse<List<ExpenseResponseItem>>>

    @POST
    fun createExpense(@Url url : String,@Body expenseRequest: ExpenseRequest): LiveData<DataResponse<ExpenseResponse>>



}