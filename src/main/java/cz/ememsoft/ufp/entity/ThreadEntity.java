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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class ThreadEntity {
    private Long threadId;
    private String threadName;
    private String threadDescription;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long threadID;

    @Column(nullable = true)
    private String title;

    // Assuming the user's identity is stored in a User entity
    @Column(nullable = true)
    private Long creatorUserID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTimestamp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTimestamp;

    @Lob
    private String content;

    // This assumes you're storing image paths or identifiers in a separate table
    // and linking them with a OneToMany or ManyToMany relationship
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "thread_id")
    private List<ImageEntity> images;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> replies;

    private Boolean stickyFlag = false;

    private Boolean lockedFlag = false;

    private Boolean archiveFlag = false;

    private Integer viewCount = 0;

    @Transient // Not stored in DB directly, computed from replies size
    private Integer replyCount;

    private Long boardID;

    // Additional fields like tags, IP address, etc., can be added here

    // Constructors, getters, and setters go here

}
