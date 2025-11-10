package com.buildtrack.backend.buildtrack.domain

import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "projects")
data class Project(
    @Id
    @GeneratedValue
    val id: UUID? = null,

    val name: String,
    val address: String,
    val area: Double,

    @Column(name = "start_date")
    val startDate: LocalDate,

    @Column(name = "end_date")
    val endDate: LocalDate
)