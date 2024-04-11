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

import cz.ememsoft.ufp.dto.ThreadEntityDto;
import cz.ememsoft.ufp.entity.ThreadEntity;
import cz.ememsoft.ufp.mapper.ThreadMapper;
import cz.ememsoft.ufp.repository.ThreadRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ThreadService implements IService<ThreadEntity, ThreadEntityDto> {

    private final ThreadRepository threadEntityRepository;
    private final ThreadMapper threadMapper;

    @Override
    public ThreadEntity save(@NonNull final ThreadEntityDto threadEntityDto) {
        final ThreadEntity thread = threadMapper.toEntity(threadEntityDto);
        return threadEntityRepository.save(thread);
    }

    public void delete(@NonNull final ThreadEntityDto threadEntityDto) {
        final ThreadEntity thread = threadMapper.toEntity(threadEntityDto);
        threadEntityRepository.delete(thread);
    }

    public ThreadEntityDto findById(@NonNull final Long id) {
        final Optional<ThreadEntity> threadEntity = threadEntityRepository.findById(id);
        final var threadDto = threadEntity.map(threadMapper::toDto);
        return threadDto.orElse(null);
    }

    public void findAll() {
        threadEntityRepository.findAll();
    }
}
