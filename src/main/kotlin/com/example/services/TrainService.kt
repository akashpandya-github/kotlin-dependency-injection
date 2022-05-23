package com.example.services

import com.example.controllers.trains.TrainRequest
import com.example.repositories.TrainsRepository

class TrainService: TrainsRepository {

    private val tData: MutableList<TrainRequest> = mutableListOf()

    override fun storeData(trains: TrainRequest): TrainRequest {
        tData.add(trains)
        return trains
    }

    override fun getData(): MutableList<TrainRequest> {
        return tData
    }
}