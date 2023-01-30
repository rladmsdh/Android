package presention.module

import data.api.ApiClient
import data.api.LoginInterface
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val apiModule : Module = module {
    single<LoginInterface> { get<Retrofit>().create(LoginInterface::class.java) }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}