package sky.diogo.com.br.mobiletestsky.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private lateinit var retrofit: Retrofit

    fun getClient(): MoviesApi {

        val client = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(1, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val request = chain.request()
                    chain.proceed(request)
                }
                .build()

        retrofit = Retrofit.Builder()
                    .baseUrl("https://sky-exercise.herokuapp.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()

        return retrofit.create(MoviesApi::class.java)
    }
}