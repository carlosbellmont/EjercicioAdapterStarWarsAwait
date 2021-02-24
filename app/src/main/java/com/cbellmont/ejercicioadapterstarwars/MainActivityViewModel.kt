package com.cbellmont.ejercicioadapterstarwars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*


class MainActivityViewModel  : ViewModel() {

    suspend fun getFilms(): MutableList<Film> {
        val deferredList = viewModelScope.async {
            delay(5000)
            mutableListOf(
                Film(1, "La Amenaza Fantasma", "aaaa"),
                Film(2, "El Ataque de los Clones", "aaaa"),
                Film(3, "La Venganza de los Sith", "aaaa"),
                Film(4, "Una Nueva Esperanza", "aaaa"),
                Film(5, "El Imperio Contraataca", "aaaa"),
                Film(6, "El Retorno del Jedi", "aaaa"),
                Film(7, "El Despertar de la Fuerza", "aaaa"),
                Film(8, "Los Útimos Jedi", "aaaa"),
                Film(9, "El Ascenso de Skywalker", "aaaa")
            )
        }

        return deferredList.await()
    }

}