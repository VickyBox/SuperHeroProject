package com.example.superheroapp.data.remote

import com.example.superheroapp.data.model.SearchResponse
import com.example.superheroapp.data.model.SuperHero
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroApi {
    
    @GET("search/{name}")
    suspend fun searchHeroes(@Path("name") name: String): SearchResponse
    
    @GET("{id}")
    suspend fun getHeroById(@Path("id") id: String): SuperHero
    
    @GET("{id}/powerstats")
    suspend fun getHeroPowerStats(@Path("id") id: String): SuperHero
    
    @GET("{id}/biography")
    suspend fun getHeroBiography(@Path("id") id: String): SuperHero
    
    @GET("{id}/appearance")
    suspend fun getHeroAppearance(@Path("id") id: String): SuperHero
    
    @GET("{id}/work")
    suspend fun getHeroWork(@Path("id") id: String): SuperHero
    
    @GET("{id}/connections")
    suspend fun getHeroConnections(@Path("id") id: String): SuperHero
    
    @GET("{id}/image")
    suspend fun getHeroImage(@Path("id") id: String): SuperHero
} 