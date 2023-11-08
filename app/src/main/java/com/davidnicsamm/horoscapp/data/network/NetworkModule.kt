package com.davidnicsamm.horoscapp.data.network



import android.util.Log
import com.davidnicsamm.horoscapp.BuildConfig.BASE_URL
import com.davidnicsamm.horoscapp.data.RepositoryImpl
import com.davidnicsamm.horoscapp.data.core.interceptors.AuthInterceptor
import com.davidnicsamm.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Alcance del módulo, en este caso, puede ser injectado sin restricciones
object NetworkModule {
    @Provides
    @Singleton // Crea por única vez el objeto providesRetrofit
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {

        Log.i("david", "$BASE_URL")
        // Devuelve un objeto retrofit
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient) // Usar Interceptor
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton fun provideOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{
        // Iterceptor: Se configura para ver la respuesta completa de HTTP
        val interceptor = HttpLoggingInterceptor().setLevel((HttpLoggingInterceptor.Level.BODY))
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRespository(apiService: HoroscopeApiService): Repository {
        return RepositoryImpl(apiService)
    }
}