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
import com.jc.gymbasicsystemfront.exceptions.CustomServiceException;
import com.jc.gymbasicsystemfront.models.PlanDto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jcaritam
 */
public class PlanService {
    private final ApiManager apiManager = ApiManager.getInstance();
    private final String relativeUri = "/plans";
    
    public List<PlanDto> getAll() throws CustomServiceException {
        try {
            GymBasicSystemApi gymApi = apiManager.getGymApi();
            java.lang.reflect.Type planListType = new TypeToken<List<PlanDto>>() {
            }.getType();
            return gymApi.get(relativeUri, planListType, true);
        } catch (IOException e) {
            throw new CustomServiceException("Error al obtener planes", e);
        }
    }
        
    public void createMember(CreatePlanDto createPlanDto) 
            throws CustomServiceException
    {
        try {
            GymBasicSystemApi gymApi = apiManager.getGymApi();
            java.lang.reflect.Type planType = new TypeToken<PlanDto>() {
            }.getType();
            
            Gson gson = new Gson();
            String json = gson.toJson(createPlanDto);
            PlanDto employeeDto = gymApi.post(
                    relativeUri + "/create",
                    json,
                    planType,
                    true
            );
            System.out.println("Create" + employeeDto);
        } catch (IOException e) {
            throw new CustomServiceException("Error al crear plan", e);
        }
    }
}
