package com.example.superheroapp.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/superheroapp/data/remote/SuperHeroApi;", "", "getHeroAppearance", "Lcom/example/superheroapp/data/model/SuperHero;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHeroBiography", "getHeroById", "getHeroConnections", "getHeroImage", "getHeroPowerStats", "getHeroWork", "searchHeroes", "Lcom/example/superheroapp/data/model/SearchResponse;", "name", "app_debug"})
public abstract interface SuperHeroApi {
    
    @retrofit2.http.GET(value = "search/{name}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object searchHeroes(@retrofit2.http.Path(value = "name")
    @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.superheroapp.data.model.SearchResponse> $completion);
    
    @retrofit2.http.GET(value = "{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroById(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.superheroapp.data.model.SuperHero> $completion);
    
    @retrofit2.http.GET(value = "{id}/powerstats")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroPowerStats(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.superheroapp.data.model.SuperHero> $completion);
    
    @retrofit2.http.GET(value = "{id}/biography")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroBiography(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.superheroapp.data.model.SuperHero> $completion);
    
    @retrofit2.http.GET(value = "{id}/appearance")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroAppearance(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.superheroapp.data.model.SuperHero> $completion);
    
    @retrofit2.http.GET(value = "{id}/work")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroWork(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.superheroapp.data.model.SuperHero> $completion);
    
    @retrofit2.http.GET(value = "{id}/connections")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroConnections(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.superheroapp.data.model.SuperHero> $completion);
    
    @retrofit2.http.GET(value = "{id}/image")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroImage(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.superheroapp.data.model.SuperHero> $completion);
}