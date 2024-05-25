/*
 * Copyright (c) 2024.
 *
 * This file is part of UFP project. UFP is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation either version 3 of the License, or (at your option) any later version.
 * UFP is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with UFP. If not, see <https://www.gnu.org/licenses/>.
 *
 */
package cz.ememsoft.ufp.controller

import cz.ememsoft.ufp.dto.ThreadEntityDto
import cz.ememsoft.ufp.services.ThreadService
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("/thread")
class ThreadController {
    private val threadService: ThreadService? = null

    @GetMapping("/{id}")
    fun getThreads(@PathVariable id: Long) {
        val threadEntityDto = threadService!!.findById(id)
    }

    @PostMapping("/{id}/post")
    fun createPost(@RequestBody threadEntityDto: ThreadEntityDto): ResponseEntity<ThreadEntityDto> {
        threadService!!.save(threadEntityDto)
        return ResponseEntity
            .ok(threadEntityDto)
    }

    @PutMapping("/{id}")
    fun putMapping(@PathVariable id: Int) {
        //Db.update(threadId.equals(id)
    }

    @PatchMapping("/{id}")
    fun patchMapping(@PathVariable id: Int) {
        //Db.update(threadId.equals(id)
    }

    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id: Int) {
        //Db.delete(threadId.equals(id)
    }
}
