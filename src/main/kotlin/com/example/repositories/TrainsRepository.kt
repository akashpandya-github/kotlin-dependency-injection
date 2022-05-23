package com.example.repositories

import com.example.controllers.trains.TrainRequest

interface TrainsRepository {

    fun storeData(trains: TrainRequest): TrainRequest

    fun getData(): MutableList<TrainRequest>
}