package tn.odc.mynba.networking

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest = chain.request()
        Timber.e("MESSAGE")
        val request = oldRequest.newBuilder()
            .addHeader("Authorization", "TOKEN")
            .addHeader("Content-Type", "application/json")
            .build()

        return chain.proceed(request)
    }

}