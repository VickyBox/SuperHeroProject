package com.example.superheroapp.ui.viewmodel

import app.cash.turbine.test
import com.example.superheroapp.data.model.*
import com.example.superheroapp.data.repository.SuperHeroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class HeroListViewModelTest {
    
    private lateinit var viewModel: HeroListViewModel
    private lateinit var repository: SuperHeroRepository
    private val testDispatcher = StandardTestDispatcher()
    
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mock()
        viewModel = HeroListViewModel(repository)
    }
    
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    
    @Test
    fun `searchHeroes with empty query should clear heroes list`() = runTest {
        viewModel.state.test {
            val initialState = awaitItem()
            assertEquals(emptyList<SuperHero>(), initialState.heroes)
            
            viewModel.searchHeroes("")
            
            val updatedState = awaitItem()
            assertEquals(emptyList<SuperHero>(), updatedState.heroes)
            assertEquals("", updatedState.searchQuery)
        }
    }
    
    @Test
    fun `searchHeroes with valid query should update state correctly`() = runTest {
        val mockHeroes = listOf(
            createMockHero("1", "Spider-Man"),
            createMockHero("2", "Iron Man")
        )
        
        whenever(repository.searchHeroes("spider")).thenReturn(flowOf(Result.success(mockHeroes)))
        
        viewModel.state.test {
            val initialState = awaitItem()
            assertFalse(initialState.isLoading)
            
            viewModel.searchHeroes("spider")
            
            val loadingState = awaitItem()
            assertTrue(loadingState.isLoading)
            assertEquals("spider", loadingState.searchQuery)
            
            val successState = awaitItem()
            assertFalse(successState.isLoading)
            assertEquals(mockHeroes, successState.heroes)
            assertNull(successState.error)
        }
    }
    
    @Test
    fun `searchHeroes with error should update error state`() = runTest {
        val errorMessage = "Network error"
        whenever(repository.searchHeroes("invalid")).thenReturn(flowOf(Result.failure(Exception(errorMessage))))
        
        viewModel.state.test {
            val initialState = awaitItem()
            assertFalse(initialState.isLoading)
            
            viewModel.searchHeroes("invalid")
            
            val loadingState = awaitItem()
            assertTrue(loadingState.isLoading)
            
            val errorState = awaitItem()
            assertFalse(errorState.isLoading)
            assertEquals(errorMessage, errorState.error)
        }
    }
    
    @Test
    fun `loadPopularHeroes should load heroes successfully`() = runTest {
        val mockHeroes = listOf(
            createMockHero("644", "Superman"),
            createMockHero("149", "Batman")
        )
        
        whenever(repository.getHeroesByIds(any())).thenReturn(flowOf(Result.success(mockHeroes)))
        
        viewModel.state.test {
            val initialState = awaitItem()
            assertFalse(initialState.isLoading)
            
            viewModel.loadPopularHeroes()
            
            val loadingState = awaitItem()
            assertTrue(loadingState.isLoading)
            
            val successState = awaitItem()
            assertFalse(successState.isLoading)
            assertEquals(mockHeroes, successState.heroes)
            assertNull(successState.error)
        }
    }
    
    @Test
    fun `clearError should remove error from state`() = runTest {
        viewModel.state.test {
            val initialState = awaitItem()
            assertNull(initialState.error)
            
            // First set an error
            whenever(repository.searchHeroes("error")).thenReturn(flowOf(Result.failure(Exception("Test error"))))
            viewModel.searchHeroes("error")
            
            val errorState = awaitItem()
            assertEquals("Test error", errorState.error)
            
            // Then clear it
            viewModel.clearError()
            
            val clearedState = awaitItem()
            assertNull(clearedState.error)
        }
    }
    
    private fun createMockHero(id: String, name: String): SuperHero {
        return SuperHero(
            id = id,
            name = name,
            powerstats = PowerStats("80", "70", "60", "50", "90", "85"),
            biography = Biography(
                fullName = "Test Hero",
                alterEgos = "No alter egos",
                aliases = emptyList(),
                placeOfBirth = "Test City",
                firstAppearance = "Test Comic #1",
                publisher = "Test Publisher",
                alignment = "good"
            ),
            appearance = Appearance(
                gender = "Male",
                race = "Human",
                height = listOf("180 cm"),
                weight = listOf("80 kg"),
                eyeColor = "Blue",
                hairColor = "Brown"
            ),
            work = Work(
                occupation = "Hero",
                base = "Test Base"
            ),
            connections = Connections(
                groupAffiliation = "Test Group",
                relatives = "None"
            ),
            image = Image(url = "https://example.com/image.jpg")
        )
    }
} 