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

package cz.ememsoft.ufp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "thread")
public final class ThreadEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "thread_sequence")
    @SequenceGenerator(name = "thread_sequence", sequenceName = "thread_sequence", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(nullable = false)
    private String threadName;

    @Column(nullable = false)
    private Long threadID;

    @Column(nullable = false)
    private String title;

    // Assuming the user's identity is stored in a User entity
    @Column(nullable = false)
    private Long creatorUserID;

    private LocalDate creationTimestamp;

    private LocalDate lastUpdatedTimestamp;

    @Lob
    private String content;

    @OneToMany(mappedBy = "threadEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<PostEntity> replies;

    private Boolean stickyFlag = false;

    private Boolean lockedFlag = false;

    private Boolean archiveFlag = false;

    private Integer viewCount = 0;

    private Integer replyCount;

    private Long boardID;

    @OneToMany(mappedBy = "threadEntity", orphanRemoval = true)
    private Set<PostEntity> postEntities = new LinkedHashSet<>();
}
