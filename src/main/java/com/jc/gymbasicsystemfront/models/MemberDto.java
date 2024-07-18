/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jc.gymbasicsystemfront.models;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Usuario
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private String memberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dni;
    private LocalDateTime dateOfBirth;
    private Object[] dailyIncomeEntities;
    private Object[] memberPlanEntities;
    private Object[] attendanceEntities;
    private Object[] groupClassRegistrationEntities;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;
}
