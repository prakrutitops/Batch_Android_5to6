package tops.tech.retrofitregisterlogin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

class RegisterModel
{
    @Expose
    @SerializedName("mobile")
    var mobile=""

    @Expose
    @SerializedName("password")
    var password=""
}