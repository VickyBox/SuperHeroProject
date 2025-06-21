package com.example.superheroapp.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n\u00f8\u0001\u0000J)\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00070\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00f8\u0001\u0000J#\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u00070\u00062\u0006\u0010\u000f\u001a\u00020\n\u00f8\u0001\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/superheroapp/data/repository/SuperHeroRepository;", "", "api", "Lcom/example/superheroapp/data/remote/SuperHeroApi;", "(Lcom/example/superheroapp/data/remote/SuperHeroApi;)V", "getHeroById", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/example/superheroapp/data/model/SuperHero;", "id", "", "getHeroesByIds", "", "ids", "searchHeroes", "name", "app_debug"})
public final class SuperHeroRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.superheroapp.data.remote.SuperHeroApi api = null;
    
    @javax.inject.Inject
    public SuperHeroRepository(@org.jetbrains.annotations.NotNull
    com.example.superheroapp.data.remote.SuperHeroApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.example.superheroapp.data.model.SuperHero>>> searchHeroes(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.example.superheroapp.data.model.SuperHero>> getHeroById(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.example.superheroapp.data.model.SuperHero>>> getHeroesByIds(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> ids) {
        return null;
    }
}