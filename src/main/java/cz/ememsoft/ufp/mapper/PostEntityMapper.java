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

import cz.ememsoft.ufp.dto.PostEntityDto;
import cz.ememsoft.ufp.entity.PostEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostEntityMapper {
    PostEntity toEntity(PostEntityDto postEntityDto);

    PostEntityDto toDto(PostEntity postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostEntityDto postEntityDto, @MappingTarget PostEntity postEntity);
}
