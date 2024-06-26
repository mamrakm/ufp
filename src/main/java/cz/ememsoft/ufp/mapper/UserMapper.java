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

package cz.ememsoft.ufp.mapper;

import cz.ememsoft.ufp.api.request.CreateUserRequest;
import cz.ememsoft.ufp.api.response.CreateUserResponse;
import cz.ememsoft.ufp.dto.UserEntityDto;
import cz.ememsoft.ufp.entity.UserEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    UserEntityDto userRequestToUserDto(CreateUserRequest userRequest);

    UserEntityDto toDto(UserEntity userEntity);

    UserEntity toEntity(UserEntityDto userEntityDto);

    CreateUserResponse userDtoToResponseCreateUser(UserEntityDto userEntityDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(UserEntityDto userEntityDto, @MappingTarget UserEntity userEntity);
}
