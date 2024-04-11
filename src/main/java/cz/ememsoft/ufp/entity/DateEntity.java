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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "date")
public class DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "date_sequence")
    @SequenceGenerator(name = "date_sequence", sequenceName = "date_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "creation-date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "creation-timestamp", nullable = false)
    private LocalDate creationTimestamp;

    @Column(name = "last-updated-date", nullable = false)
    private LocalDate lastUpdatedTimestamp;
}
