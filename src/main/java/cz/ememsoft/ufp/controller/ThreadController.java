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

package cz.ememsoft.ufp.controller;

import cz.ememsoft.ufp.dto.ThreadEntityDto;
import cz.ememsoft.ufp.services.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/thread")
public class ThreadController {
    private final ThreadService threadService;

    @GetMapping("/{id}")
    public void getThreads(@PathVariable final long id) {
        final ThreadEntityDto threadEntityDto = threadService.findById(id);

    }

    @PostMapping("/add")
    public ResponseEntity<ThreadEntityDto> postThread(@RequestBody final ThreadEntityDto threadEntityDto) {
        final var threadEntity = threadService.save(threadEntityDto);
        System.out.println(threadEntity.toString());
        return ResponseEntity
                .ok(threadEntityDto);
    }

    @PutMapping("/{id}")
    public void putMapping(@PathVariable final int id) {
        //Db.update(threadId.equals(id)
    }

    @PatchMapping("/{id}")
    public void patchMapping(@PathVariable final int id) {
        //Db.update(threadId.equals(id)
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable final int id) {
        //Db.delete(threadId.equals(id)
    }

}
