package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Episode

object EpisodeLocal {
    var episodes: MutableList<Episode> = mutableListOf(
        Episode(
            id = 1,
            date = "2024-01-01",
            name = "Le Commencement",
            description = "Dans ce premier épisode, nous rencontrons les personnages principaux et découvrons le monde fascinant dans lequel ils évoluent."
        ),
        Episode(
            id = 2,
            date = "2024-02-01",
            name = "L'Aventure Continue",
            description = "Les héros se lancent dans leur première mission dangereuse et rencontrent un nouvel allié surprenant."
        ),
        Episode(
            id = 3,
            date = "2024-03-01",
            name = "Les Ennemis de l'Ombre",
            description = "Un mystérieux ennemi fait son apparition, menaçant l'équilibre fragile que nos héros tentent de maintenir."
        ),
        Episode(
            id = 4,
            date = "2024-04-01",
            name = "La Trahison",
            description = "Un membre de l'équipe est suspecté de trahison, semant la discorde parmi les héros."
        ),
        Episode(
            id = 5,
            date = "2024-05-01",
            name = "La Bataille Finale",
            description = "La saison se termine par une bataille épique où nos héros doivent unir leurs forces pour vaincre leur ennemi commun."
        )
    )
}
