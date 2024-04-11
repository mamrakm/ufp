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

import cz.ememsoft.ufp.api.CreateUserRequest;
import cz.ememsoft.ufp.mapper.UserMapper;
import cz.ememsoft.ufp.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController(value = "/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping(value = "/add")
    ResponseEntity addUser(@Valid @RequestBody final CreateUserRequest createUserRequest) {
        if (null == createUserRequest) {
            log.error("CreateUserRequest is null");
            return ResponseEntity.badRequest().build();
        } else {
            userService.addUser(userMapper.toDto(createUserRequest));
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity getUserById(@PathVariable final Long id) {
        return ResponseEntity.ok(UserService.getUserById(id));
    }
}

