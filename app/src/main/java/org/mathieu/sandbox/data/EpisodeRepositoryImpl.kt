package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.domain.repositories.IEpisodeRepository

object EpisodeRepositoryImpl : IEpisodeRepository {
    override fun getAllEpisodes(): List<Episode> {
        return EpisodeLocal.episodes
    }

    override fun getEpisodeById(id: Int): Episode? {
        return EpisodeLocal.episodes.find { it.id == id }
    }
}
