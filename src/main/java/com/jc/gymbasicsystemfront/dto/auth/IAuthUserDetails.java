/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jc.gymbasicsystemfront.dto.auth;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jcaritam
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IAuthUserDetails {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String userId;
    private String username;
    private String password;
    private String role;
    private boolean enabled;
    private Object[] authorities;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private boolean active;
}
