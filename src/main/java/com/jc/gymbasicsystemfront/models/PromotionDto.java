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
 * @author jcaritam
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromotionDto {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String promotionID;
    private String name;
    private String description;
    private float discount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Object[] memberPlans;
    private boolean active;

}
