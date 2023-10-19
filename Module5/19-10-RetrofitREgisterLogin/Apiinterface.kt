package tops.tech.retrofitregisterlogin

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("login.php")
    fun logincheck(@Field("mobile") mobile:String, @Field("password") password:String):Call<RegisterModel>

}