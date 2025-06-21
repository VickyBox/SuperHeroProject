package com.example.superheroapp.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/example/superheroapp/ui/viewmodel/HeroDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/superheroapp/data/repository/SuperHeroRepository;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/example/superheroapp/data/repository/SuperHeroRepository;Landroidx/lifecycle/SavedStateHandle;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/superheroapp/ui/state/HeroDetailState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadHero", "", "heroId", "", "retry", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class HeroDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.superheroapp.data.repository.SuperHeroRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.superheroapp.ui.state.HeroDetailState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.superheroapp.ui.state.HeroDetailState> state = null;
    
    @javax.inject.Inject
    public HeroDetailViewModel(@org.jetbrains.annotations.NotNull
    com.example.superheroapp.data.repository.SuperHeroRepository repository, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.superheroapp.ui.state.HeroDetailState> getState() {
        return null;
    }
    
    private final void loadHero(java.lang.String heroId) {
    }
    
    public final void retry() {
    }
}