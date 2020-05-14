package tn.odc.mynba.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.odc.mynba.BuildConfig

class RetrofitInstance {

    companion object {

        val client = OkHttpClient()
            .newBuilder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()


        fun create() :UserService{
            val retrofitInstance = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofitInstance.create(UserService::class.java)
        }
    }


}