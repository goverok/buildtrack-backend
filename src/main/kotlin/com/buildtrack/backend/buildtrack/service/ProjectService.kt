package com.buildtrack.backend.buildtrack.service

import com.buildtrack.backend.buildtrack.domain.Project
import com.buildtrack.backend.buildtrack.repository.ProjectRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjectService(
    private val projectRepository: ProjectRepository
) {
    fun getAllProjects(): List<Project> = projectRepository.findAll()
    fun createProject(project: Project): Project = projectRepository.save(project)
    fun getProjectById(id: UUID): Project? = projectRepository.findById(id).orElse(null)
}