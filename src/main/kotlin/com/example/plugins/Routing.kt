package com.example.plugins

import com.example.controllers.trains.TrainsController
import com.example.repositories.TrainsRepository
import com.example.services.TrainService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.context.startKoin

fun Application.configureRouting() {

    val singleModule = org.koin.dsl.module {
        single { TrainService() }
        single { TrainsController(get()) }
    }

    val app = startKoin {
        modules(mutableListOf(singleModule))
    }
    // Starting point for a Ktor app:
    routing {

        get("/") {
            call.respondText("Hello World!")
        }
        route("api/v1/train") {
            post("add") {
                app.koin.get<TrainsController>().addTrains(this.context)
            }
            get("list") {
                app.koin.get<TrainsController>().getTrains(this.context)
            }
        }
    }
}
