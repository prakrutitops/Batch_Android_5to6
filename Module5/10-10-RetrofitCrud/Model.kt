package tops.tech.retrofitcrudex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model
{
    @Expose
    @SerializedName("product_id")
    var product_id=0

    @Expose
    @SerializedName("product_name")
    var product_name =""

    @Expose
    @SerializedName("product_price")
    var product_price=""

    @Expose
    @SerializedName("product_description")
    var product_description=""
}