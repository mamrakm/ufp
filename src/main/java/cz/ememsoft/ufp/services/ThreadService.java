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
import cz.ememsoft.ufp.repository.ThreadEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class ThreadService {

    private final ThreadEntityRepository threadEntityRepository;
    private final ThreadMapper threadMapper;

    public void save(final ThreadEntityDto threadEntityDto) {
        final ThreadEntity thread = threadMapper.toEntity(threadEntityDto);
        threadEntityRepository.save(thread);
    }

    public void delete(final ThreadEntityDto threadEntityDto) {
        final ThreadEntity thread = threadMapper.toEntity(threadEntityDto);
        threadEntityRepository.delete(thread);
    }

    public void findById(final Long id) {
        threadEntityRepository.findById(id);
    }

    public void findAll() {
        threadEntityRepository.findAll();
    }
}
