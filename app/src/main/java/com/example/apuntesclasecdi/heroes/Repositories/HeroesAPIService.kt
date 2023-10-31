package com.example.apuntesclasecdi.heroes.Repositories

import com.example.apuntesclasecdi.heroes.HeroData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Time
import java.sql.Timestamp

class HeroesAPIService : HeroRepository {

    companion object{
        const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
        const val API_KEY = "334438961f833a8354f77e3c8db057aa"
        const val PRIVATE_KEY = "894efb540be5c36c6c1a54f45ebbb09c4da8693b"

        val Timestamp: String get() = Timestamp(System.currentTimeMillis()).time.toString()

        val Hash: String get() {
            val input = "$Timestamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        val ApiService: RetrofitHeroApiService by lazy{
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitHeroApiService::class.java)
        }
    }

    interface RetrofitHeroApiService{
        @GET("characters")
        suspend fun GetHeroes(
            @Query("ts") timestamp: String = Timestamp,
            @Query("apikey") apiKey : String = API_KEY,
            @Query("hash") hash : String = Hash,
            @Query("offset") offset: Int,
            @Query("limit") limit: Int
        ) : Response<CharactersResponse>

    }

    override suspend fun GetHeroes(offset: Int, limit: Int): MutableList<HeroData> {

        val response = ApiService.GetHeroes(offset = offset, limit = limit)

        if(response.isSuccessful){

            response.body()?.charactersData?.heroList?.let { heroes ->
                return heroes
            } ?: kotlin.run {

                return mutableListOf()
            }

        }else{
            return mutableListOf()
        }
    }
}