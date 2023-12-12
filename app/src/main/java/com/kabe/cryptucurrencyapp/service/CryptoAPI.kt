package com.kabe.cryptucurrencyapp.service

import com.kabe.cryptucurrencyapp.model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //GET,POST,UPDATE,DELETE
    //https://raw.githubusercontent.com/ 'URL Bazı Retrofit kuralları gereği bu baz içine'
    // atilsamancioglu/K21-JSONDataSet/master/crypto.json geri 'extention Galan kısım ise burada @GET("") içine yazılır'

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData():Observable<List<CryptoModel>>
    //fun getData():Call<List<CryptoModel>>
}