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
package cz.ememsoft.ufp.entity

import jakarta.persistence.*
import lombok.Data
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Data
@Entity
@Table(name = "post")
class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
    @SequenceGenerator(name = "post_sequence", sequenceName = "post_sequence", allocationSize = 1, initialValue = 1)
    private val id: Long? = null

    @Column(name = "post_id", nullable = false)
    private var postId: Long? = null

    @ManyToOne
    @JoinColumn(name = "thread_entity_threadid")
    private val threadEntity: ThreadEntity? = null

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private lateinit var image: ByteArray
}
