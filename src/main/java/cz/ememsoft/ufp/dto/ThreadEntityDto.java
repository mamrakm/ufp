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

package cz.ememsoft.ufp.dto;

import cz.ememsoft.ufp.entity.PostEntity;
import cz.ememsoft.ufp.entity.ThreadEntity;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * DTO for {@link ThreadEntity}
 */
public record ThreadEntityDto(@NotNull @Digits(integer = 0, fraction = 0) @Positive Long threadId,
                              @NotNull @Digits(integer = 0, fraction = 0) @NotEmpty @NotBlank String threadName,
                              @NotNull String threadDescription,
                              @NotNull @Digits(integer = 0, fraction = 0) @Positive Long id, Long threadID,
                              String title, Long creatorUserID,
                              LocalDate creationTimestamp, LocalDate lastUpdatedTimestamp, String content,
                              List<PostEntityDto> replies, Boolean stickyFlag, Boolean lockedFlag, Boolean archiveFlag,
                              Integer viewCount, @NotNull @Digits(integer = 0, fraction = 0) @Positive Long boardID,
                              Set<cz.ememsoft.ufp.dto.PostEntityDto> postEntities) implements Serializable {
    /**
     * DTO for {@link PostEntity}
     */

}
