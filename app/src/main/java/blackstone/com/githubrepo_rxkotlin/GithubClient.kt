package blackstone.com.githubrepo_rxkotlin

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://api.github.com"

class GithubClient {

    open fun getApi() : GithubApi {

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubApi::class.java)

    }

}