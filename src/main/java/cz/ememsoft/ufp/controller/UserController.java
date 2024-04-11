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

import cz.ememsoft.ufp.api.request.CreateUserRequest;
import cz.ememsoft.ufp.api.response.ResponseCreateUser;
import cz.ememsoft.ufp.dto.UserDto;
import cz.ememsoft.ufp.exceptions.InternalException;
import cz.ememsoft.ufp.mapper.UserMapper;
import cz.ememsoft.ufp.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController(value = "/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(value = "/{id}", produces = "application/json")
    public static ResponseEntity<ResponseCreateUser> getUserById(@PathVariable final Long id) {
        log.trace("entering getUserById");
        if (null == id) {
            log.error("Id is null", new InternalException());
            return ResponseEntity.badRequest().build();
        }
        log.info("User found");
        log.trace("User found: {}", UserService.getUserById(id));
        log.trace("exiting getUserById");
        return ResponseEntity.ok(UserService.getUserById(id));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public static ResponseEntity<ResponseCreateUser> putUserById(@PathVariable final Long id) {
        return ResponseEntity.ok(UserService.getUserById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseCreateUser> addUser(@Valid @RequestBody final CreateUserRequest createUserRequest) {
        log.trace("entering addUser");
        if (null == createUserRequest) {
            log.error("CreateUserRequest is null", new InternalException());
            return ResponseEntity.badRequest().build();
        } else {
            final UserDto userDto = userService.addUser(userMapper.requestToDto(createUserRequest));
            log.info("User added");
            final var userResponse = new ResponseCreateUser();
            userResponse.setId(userDto.getId());
            userResponse.setRole(userDto.getRole());
            userResponse.setMessage("");
            return ResponseEntity.ok().body(userResponse);
        }
    }
}
