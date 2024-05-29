package org.mathieu.sandbox.domain.repositories

import org.mathieu.sandbox.domain.models.Episode

interface IEpisodeRepository {
    fun getAllEpisodes(): List<Episode>
    fun getEpisodeById(id: Int): Episode?
}

