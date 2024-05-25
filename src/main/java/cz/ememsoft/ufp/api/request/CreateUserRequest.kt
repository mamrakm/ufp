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
package cz.ememsoft.ufp.api.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.aspectj.lang.annotation.RequiredTypes
import java.time.LocalDate
import java.time.LocalDateTime

@RequiredTypes
data class CreateUserRequest(
    @field:NotBlank
    val userAccountName: String? = null,

    @field:NotBlank
    val userDisplayName: String? = null,

    @field:NotBlank
    val password: String? = null,

    @field:NotBlank
    @field:Email
    val email: String? = null,

    val city: String? = null,

    val country: String? = null,

    val role: String? = null,

    val status: String? = null,

    val creationDate: LocalDate? = null,

    val creationTimestamp: LocalDateTime? = null,

    val lastUpdatedTimestamp: LocalDateTime? = null
)

