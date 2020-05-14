package tn.odc.mynba.model


import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Email")
    val email: String,
    @SerializedName("FName")
    val fName: String,
    @SerializedName("LName")
    val lName: String,
    @SerializedName("PhoneNumber")
    val phoneNumber: String,
    @SerializedName("Age")
    val age: String,
    @SerializedName("Country")
    val country: String
)

object UserDiffCallback : DiffUtil.ItemCallback<UserModel>(){
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
       return oldItem.fName == newItem.fName
    }

}