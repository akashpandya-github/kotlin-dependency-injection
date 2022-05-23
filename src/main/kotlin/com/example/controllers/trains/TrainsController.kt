package com.example.controllers.trains

import com.example.services.TrainService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*

class TrainsController(private val trainService: TrainService) {

    suspend fun addTrains(call: ApplicationCall) {

        val inputData = call.receiveOrNull<TrainRequest>() ?: throw BadRequestException("Invalid request parameters.")
        val trainData =  trainService.storeData(inputData)

        call.respond(
            HttpStatusCode.OK,
            ResponseData(
                "OK",
                "Trains added successfully.",
                mapOf(
                    "data" to trainData
                )
            ),
        )
    }

    suspend fun getTrains(call: ApplicationCall) {

        val trainData = trainService.getData()
        call.respond(
            HttpStatusCode.OK,
            ResponseData(
                "OK",
                "Trains retrieved successfully.",
                mapOf(
                    "trains" to trainData
                )
            )
        )
    }
}

data class TrainRequest(
    val name: String?,
    val source: String?,
    val destination: String?,
    val departureTime: String?
    )

data class ResponseData(
    val code: String?,
    val message: String?,
    val data: Any?
    )