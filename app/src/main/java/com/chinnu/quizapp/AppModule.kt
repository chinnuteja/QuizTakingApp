package com.chinnu.quizapp




import androidx.test.espresso.core.internal.deps.dagger.Module
import androidx.test.espresso.core.internal.deps.dagger.Provides
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.text.Typography.dagger

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQuizApi(): QuizApi {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080") // Emulator localhost
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuizApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: QuizApi): QuizRepository {
        return QuizRepository(api)
    }
}
