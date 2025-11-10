package com.buildtrack.backend.buildtrack.controller

import com.buildtrack.backend.buildtrack.domain.Project
import com.buildtrack.backend.buildtrack.service.ProjectService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/projects")
class ProjectController(
    private val projectService: ProjectService,
) {

    @GetMapping
    fun getAllProjects(): List<Project> = projectService.getAllProjects()

    @GetMapping("/{id}")
    fun getProject(@PathVariable id: UUID): Project? = projectService.getProjectById(id)

    @PostMapping
    fun createProject(@RequestBody project: Project): Project = projectService.createProject(project)
}