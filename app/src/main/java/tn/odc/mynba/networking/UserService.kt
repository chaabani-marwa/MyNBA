package tn.odc.mynba.networking

import retrofit2.Call
import retrofit2.http.*
import tn.odc.mynba.USER_END_POINT
import tn.odc.mynba.model.UserModel

interface UserService {

    @GET(USER_END_POINT)
    fun getAllUser(): Call<List<UserModel>>

    @GET("${USER_END_POINT}/{id}")
    fun getUserByID(@Path("id") id: Int): Call<UserModel>

    @POST(USER_END_POINT)
    fun createUser(@Body userModel: UserModel): Call<UserModel>

    @DELETE("$USER_END_POINT/{id}")
    fun deleteUserById(@Path("id") id: Int)
}