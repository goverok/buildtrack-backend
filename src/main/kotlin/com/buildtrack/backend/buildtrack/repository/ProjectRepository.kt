package com.buildtrack.backend.buildtrack.repository


import com.buildtrack.backend.buildtrack.domain.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProjectRepository : JpaRepository<Project, UUID>