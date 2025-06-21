package com.example.superheroapp.ui.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/superheroapp/ui/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "HeroDetail", "HeroList", "Lcom/example/superheroapp/ui/navigation/Screen$HeroDetail;", "Lcom/example/superheroapp/ui/navigation/Screen$HeroList;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/example/superheroapp/ui/navigation/Screen$HeroDetail;", "Lcom/example/superheroapp/ui/navigation/Screen;", "()V", "createRoute", "", "heroId", "app_debug"})
    public static final class HeroDetail extends com.example.superheroapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.example.superheroapp.ui.navigation.Screen.HeroDetail INSTANCE = null;
        
        private HeroDetail() {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull
        java.lang.String heroId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/superheroapp/ui/navigation/Screen$HeroList;", "Lcom/example/superheroapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class HeroList extends com.example.superheroapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.example.superheroapp.ui.navigation.Screen.HeroList INSTANCE = null;
        
        private HeroList() {
        }
    }
}