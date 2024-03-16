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

import cz.ememsoft.ufp.services.DatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/threads")
public class ThreadController {
    
    private DatabaseService databaseService;

    @GetMapping("/{id}")
    public void getThreads(@PathVariable final int id) {
        //Db.find(threadId.equals(id)
    }

    @PostMapping("/{id}")
    public void postThread(@PathVariable final int id) {
        //Db.save(threadId.equals(id)
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
