package com.example.hilt.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HiltEntity (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val name : String
)