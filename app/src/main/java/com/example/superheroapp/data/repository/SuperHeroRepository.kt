package com.example.superheroapp.data.repository

import com.example.superheroapp.data.model.SuperHero
import com.example.superheroapp.data.remote.SuperHeroApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SuperHeroRepository @Inject constructor(
    private val api: SuperHeroApi
) {
    
    fun searchHeroes(name: String): Flow<Result<List<SuperHero>>> = flow {
        try {
            val response = api.searchHeroes(name)
            if (response.response == "success") {
                emit(Result.success(response.results))
            } else {
                emit(Result.failure(Exception("未找到結果")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
    
    fun getHeroById(id: String): Flow<Result<SuperHero>> = flow {
        try {
            val hero = api.getHeroById(id)
            emit(Result.success(hero))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
    
    fun getHeroesByIds(ids: List<String>): Flow<Result<List<SuperHero>>> = flow {
        try {
            val heroes = mutableListOf<SuperHero>()
            ids.forEach { id ->
                try {
                    val hero = api.getHeroById(id)
                    heroes.add(hero)
                } catch (e: Exception) {
                    // 跳过失败的请求，继续处理其他
                }
            }
            emit(Result.success(heroes))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
} 