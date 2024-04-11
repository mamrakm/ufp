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

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "user_entity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    long id;

    @Column(name = "user-account-name", nullable = false)
    private String userAccountName;

    @Column(name = "user-display-name", nullable = false)
    private String userDisplayName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "creation-date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "creation-timestamp", nullable = false)
    private LocalDate creationTimestamp;

    @Column(name = "last-updated-date", nullable = false)
    private LocalDate lastUpdatedTimestamp;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "city")
    private String city;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "country")
    private String country;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "role", nullable = false)
    private String role;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "status")
    private String status;



}
