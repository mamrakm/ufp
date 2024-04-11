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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name", referencedColumnName = "id", nullable = false)
    private NameEntity name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "password", referencedColumnName = "id", nullable = false)
    private PasswordEntity password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", referencedColumnName = "id", nullable = false)
    private EmailEntity email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dates", referencedColumnName = "id", nullable = false)
    private DateEntity dates;
    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "city")
    private String city;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "country")
    private String country;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "role", nullable = false)
    private String role;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "status")
    private String status;



}
