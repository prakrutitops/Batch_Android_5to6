package tops.tech.retrofitcrudex

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("productinsert.php")
    fun insertdata(
       @Field("product_name") name:String,
       @Field("product_price") price:String,
       @Field("product_description") des:String): Call<Void>



    @GET("productview.php")
    fun viewdata(): Call<List<Model>>

    @FormUrlEncoded
    @POST("productdelete.php")
    fun deletedata(@Field("product_id") id:Int): Call<Void>

    @FormUrlEncoded
    @POST("productupdate.php")
    fun updatedata(
        @Field("product_id") id:Int,
        @Field("product_name") name:String,
        @Field("product_price") price:String,
        @Field("product_description") des:String): Call<Void>

}