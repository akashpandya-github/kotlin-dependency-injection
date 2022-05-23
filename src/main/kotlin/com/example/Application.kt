package com.example

import com.example.plugins.configureRouting
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import org.koin.core.module.Module

fun main(args: Array<String>): Unit =
//    io.ktor.server.netty.EngineMain.main(args)
    io.ktor.server.cio.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.startApp() {
    install(ContentNegotiation) {
        gson {  }
    }
    configureRouting()
}
