package com.example.movieapp.viewmodul

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.actor_respons.ActorByIdRespons
import com.example.movieapp.data.collectionsmovie.CollectionsMovieItem
import com.example.movieapp.data.moive.SingleMovieData
import com.example.movieapp.data.movie_creaters.Actors
import com.example.movieapp.data.releases.Release
import com.example.movieapp.repository.Repository
import com.example.movieapp.utils.FilmsTypes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val releasesList  = MutableLiveData<Result<List<Release>>>()
    private val collectionMovieTop = MutableLiveData<Result<List<CollectionsMovieItem>>>()
    private val collectionTvShowTop = MutableLiveData<Result<List<CollectionsMovieItem>>>()
    private val collectionKindTop = MutableLiveData<Result<List<CollectionsMovieItem>>>()
    private val collectionVampireTheme = MutableLiveData<Result<List<CollectionsMovieItem>>>()
    private val collectionComicTheme = MutableLiveData<Result<List<CollectionsMovieItem>>>()
    private val collectionFamily = MutableLiveData<Result<List<CollectionsMovieItem>>>()
    private val collectionZombieTheme = MutableLiveData<Result<List<CollectionsMovieItem>>>()
    private val collectionSingleMovieData =  MutableLiveData<Result<SingleMovieData>>()
    private val collectionActors  = MutableLiveData<Result<Actors>>()
    private val collectionActorData =MutableLiveData<Result<ActorByIdRespons>>()


    init {



        fetchFirstPageBackground()
    }
    fun getFirstPageBackground(): MutableLiveData<Result<List<Release>>> {
        return releasesList
    }

    fun fetchFirstPageBackground(){
        viewModelScope.launch {

            
            flow{emit(repository.getNetworkApi().getLastReleaseMovie(year = 2023, month = "DECEMBER"))}.catch {
                releasesList.postValue(Result.failure(it))
            }.collect{
                if(it.isSuccessful){

                    releasesList.postValue(Result.success(it.body()?.releases?: emptyList()))
                }
                else{
                    releasesList.postValue(Result.failure(Throwable("ERROR")))
                }

            }

        }
    }

    fun getListReleases(): MutableLiveData<Result<List<Release>>> {
        return releasesList
    }

    fun getTopMovieByType(): MutableLiveData<Result<List<CollectionsMovieItem>>> {
        viewModelScope.launch(Dispatchers.IO) {
            flow { emit(repository.getNetworkApi().getCollections(FilmsTypes.top_all,1)) }.catch {
                collectionMovieTop.postValue(Result.failure(it))
            }.collect{
                if(it.isSuccessful){
                    collectionMovieTop.postValue(Result.success(it.body()?.items?: emptyList()))
                }
                else{
                    collectionMovieTop.postValue(Result.failure(Throwable("Error")))
                }
            }
        }
        return collectionMovieTop
    }

    fun getTopTvShow(): MutableLiveData<Result<List<CollectionsMovieItem>>> {
        viewModelScope.launch {
            flow { emit(repository.getNetworkApi().getCollections(FilmsTypes.top_tvshow,1)) }.catch {
                collectionTvShowTop.postValue(Result.failure(it))
            }.collect{
                if(it.isSuccessful){
                    collectionTvShowTop.postValue(Result.success(it.body()?.items?: emptyList()))
                }
                else{
                    collectionTvShowTop.postValue(Result.failure(Throwable("Error")))
                }
            }


        }
        return collectionTvShowTop
    }

    fun getTopKindOfAnimation(): MutableLiveData<Result<List<CollectionsMovieItem>>> {
        viewModelScope.launch {
            flow { emit(repository.getNetworkApi().getCollections(FilmsTypes.top_kinds,1)) }.catch {
                collectionKindTop.postValue(Result.failure(it))
            }.collect{
                if(it.isSuccessful){
                    collectionKindTop.postValue(Result.success(it.body()?.items?: emptyList()))
                }
                else{
                    collectionKindTop.postValue(Result.failure(Throwable("Error")))
                }
            }


        }
        return collectionKindTop
    }

    fun getTopKindOfVampireTheme(): MutableLiveData<Result<List<CollectionsMovieItem>>> {
        viewModelScope.launch {
            flow { emit(repository.getNetworkApi().getCollections(FilmsTypes.vampire_theme,1)) }.catch {
                collectionVampireTheme.postValue(Result.failure(it))
            }.collect{
                if(it.isSuccessful){
                    collectionVampireTheme.postValue(Result.success(it.body()?.items?: emptyList()))
                }
                else{
                    collectionVampireTheme.postValue(Result.failure(Throwable("Error")))
                }
            }


        }
        return collectionVampireTheme
    }

    fun getTopKindOfComicTheme(): MutableLiveData<Result<List<CollectionsMovieItem>>> {
        viewModelScope.launch {
            flow { emit(repository.getNetworkApi().getCollections(FilmsTypes.COMICS_THEME,1)) }.catch {
                collectionComicTheme.postValue(Result.failure(it))
            }.collect{
                if(it.isSuccessful){
                    collectionComicTheme.postValue(Result.success(it.body()?.items?: emptyList()))
                }
                else{
                    collectionComicTheme.postValue(Result.failure(Throwable("Error")))
                }
            }


        }
        return collectionComicTheme
    }

    fun getTopKindOfFamilyTheme(): MutableLiveData<Result<List<CollectionsMovieItem>>> {
        viewModelScope.launch {
            flow { emit(repository.getNetworkApi().getCollections(FilmsTypes.FAMILY,1)) }.catch {
                collectionFamily.postValue(Result.failure(it))
            }.collect{
                if(it.isSuccessful){
                    collectionFamily.postValue(Result.success(it.body()?.items?: emptyList()))
                }
                else{
                    collectionFamily.postValue(Result.failure(Throwable("Error")))
                }
            }


        }
        return collectionFamily
    }

    fun getTopKindOfZombieTheme(): MutableLiveData<Result<List<CollectionsMovieItem>>> {
        viewModelScope.launch {
            flow { emit(repository.getNetworkApi().getCollections(FilmsTypes.ZOMBIE_THEME,1)) }.catch {
                collectionZombieTheme.postValue(Result.failure(it))
            }.collect{
                if(it.isSuccessful){
                    collectionZombieTheme.postValue(Result.success(it.body()?.items?: emptyList()))
                }
                else{
                    collectionZombieTheme.postValue(Result.failure(Throwable("Error")))
                }
            }


        }
        return collectionZombieTheme
    }

    fun fetchSingleMovieData(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            flow {emit(repository.getNetworkApi().getSingleFilmById(id))  }.catch {
                collectionSingleMovieData.postValue(Result.failure(it))
                Log.d("@@@@", "getSingleMovieData: ${it.message}")
            }.collect{
                if(it.isSuccessful){
                    collectionSingleMovieData.postValue(Result.success(it.body()!!))
                }
                else{
                    collectionSingleMovieData.postValue(Result.failure(Throwable()))
                }
            }
        }
    }

    fun getSingleMovieData(): MutableLiveData<Result<SingleMovieData>> {
        return collectionSingleMovieData
    }
    fun fetchActorsByFilmId(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            flow {emit(repository.getNetworkApi().getFilmActorsByFilmId(id))}.catch {
                collectionActors.postValue(Result.failure(it))
            }.collect{
                if (it.isSuccessful){
                    collectionActors.postValue(Result.success(it.body()!!))
                }else{
                    collectionActors.postValue(Result.failure(Throwable()))
                }
            }
        }
    }

    fun getActorsByFilmId(): MutableLiveData<Result<Actors>> {
        return collectionActors
    }

    fun getActorDataById(): MutableLiveData<Result<ActorByIdRespons>> {
        return collectionActorData
    }
    fun fetchActorDataById(id: Int){
        viewModelScope.launch (Dispatchers.IO){
            flow {emit(repository.getNetworkApi().getActors(id))  }.catch {
                collectionActorData.postValue(Result.failure(it))
            }.collect{
                if (it.isSuccessful){
                    collectionActorData.postValue(Result.success(it.body()!!))
                }else{
                    collectionActorData.postValue(Result.failure(Throwable()))
                }
            }
        }
    }





}