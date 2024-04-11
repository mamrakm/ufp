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

package cz.ememsoft.ufp.services;

import cz.ememsoft.ufp.api.response.ResponseCreateUser;
import cz.ememsoft.ufp.dto.UserDto;
import cz.ememsoft.ufp.mapper.UserMapper;
import cz.ememsoft.ufp.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public static ResponseCreateUser getUserById(final long id) {
        return null;
    }

    public UserDto addUser(@NotNull final UserDto user) {
        log.trace("entering addUser");
        final var entity = userRepository.saveAndFlush(userMapper.toEntity(user));
        log.info("User added");
        log.trace("exiting addUser");
        return userMapper.toDto(entity);
    }

}
