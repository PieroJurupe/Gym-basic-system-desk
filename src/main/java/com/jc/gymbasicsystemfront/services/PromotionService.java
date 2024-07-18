/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jc.gymbasicsystemfront.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jc.gymbasicsystemfront.api.ApiManager;
import com.jc.gymbasicsystemfront.api.GymBasicSystemApi;
import com.jc.gymbasicsystemfront.dto.plan.CreatePlanDto;
import com.jc.gymbasicsystemfront.dto.promotion.CreatePromotionDto;
import com.jc.gymbasicsystemfront.exceptions.CustomServiceException;
import com.jc.gymbasicsystemfront.models.PlanDto;
import com.jc.gymbasicsystemfront.models.PromotionDto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jcaritam
 */
public class PromotionService {
     private final ApiManager apiManager = ApiManager.getInstance();
    private final String relativeUri = "/promotions";
    
    public List<PromotionDto> getAll() throws CustomServiceException {
        try {
            GymBasicSystemApi gymApi = apiManager.getGymApi();
            java.lang.reflect.Type promotionListType = new TypeToken<List<PromotionDto>>() {
            }.getType();
            return gymApi.get(relativeUri, promotionListType, true);
        } catch (IOException e) {
            throw new CustomServiceException("Error al obtener promotion", e);
        }
    }
        
    public void createMember(CreatePromotionDto createPromotionDto) 
            throws CustomServiceException
    {
        try {
            GymBasicSystemApi gymApi = apiManager.getGymApi();
            java.lang.reflect.Type promotionType = new TypeToken<PromotionDto>() {
            }.getType();
            
            Gson gson = new Gson();
            String json = gson.toJson(createPromotionDto);
            PlanDto employeeDto = gymApi.post(
                    relativeUri + "/create",
                    json,
                    promotionType,
                    true
            );
            System.out.println("Create" + employeeDto);
        } catch (IOException e) {
            throw new CustomServiceException("Error al crear promocion", e);
        }
    }
}
