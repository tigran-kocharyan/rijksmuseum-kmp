package com.totowka.kmp.ui.screens.list

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.totowka.kmp.domain.MuseumInteractor
import com.totowka.kmp.domain.model.PaintingDomain
import kotlinx.coroutines.launch

class ListScreenModel(
    private val museumInteractor: MuseumInteractor,
) : StateScreenModel<ListScreenModel.State>(State.Init) {

    sealed class State {
        data object Init : State()
        data object Loading : State()
        data object Error : State()
        class Data(val paintings: List<PaintingDomain>) : State()
    }

    fun getPaintings() {
        screenModelScope.launch {
            mutableState.value = State.Loading
            mutableState.value = try {
                val paintings = museumInteractor.getPaintings()
                State.Data(paintings = paintings)
            } catch (throwable: Throwable) {
                State.Error
            }
        }
    }

    fun refreshPaintings() {
        screenModelScope.launch {
            mutableState.value = State.Loading
            mutableState.value = try {
                val paintings = museumInteractor.refreshPaintings()
                State.Data(paintings = paintings)
            } catch (throwable: Throwable) {
                State.Error
            }
        }
    }
}
