/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jc.gymbasicsystemfront.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jc.gymbasicsystemfront.api.ApiManager;
import com.jc.gymbasicsystemfront.api.GymBasicSystemApi;
import com.jc.gymbasicsystemfront.dto.member.CreateMemberDto;
import com.jc.gymbasicsystemfront.exceptions.CustomServiceException;
import com.jc.gymbasicsystemfront.models.MemberDto;
import java.io.IOException;
import java.util.List;
import java.lang.reflect.Type;

/**
 *
 * @author jcaritam
 */
public class MemberService {
    private final ApiManager apiManager = ApiManager.getInstance();
    private final String relativeUri = "/members";

    public List<MemberDto> getAll() throws CustomServiceException {
        try {
            GymBasicSystemApi gymApi = apiManager.getGymApi();
            Type memberListType = new TypeToken<List<MemberDto>>() {
            }.getType();
            return gymApi.get(relativeUri, memberListType, true);
        } catch (IOException e) {
            throw new CustomServiceException("Error al obtener empleados", e);
        }
    }

    public MemberDto getMemberById(String dni) throws CustomServiceException {
        try {
            GymBasicSystemApi gymApi = apiManager.getGymApi();
            Type memberType = new TypeToken<MemberDto>(){}.getType();
            
            return gymApi.get(relativeUri + "/dni/" + dni, memberType, true);
        } catch(IOException e) {
            throw new CustomServiceException("Error al obtener miembro", e);
        }
    } 
        
    public void createMember(CreateMemberDto createMemberDto) 
            throws CustomServiceException
    {
        try {
            GymBasicSystemApi gymApi = apiManager.getGymApi();
            Type memberType = new TypeToken<MemberDto>() {
            }.getType();
            
            Gson gson = new Gson();
            String json = gson.toJson(createMemberDto);
            MemberDto employeeDto = gymApi.post(
                    relativeUri + "/create",
                    json,
                    memberType,
                    true
            );
            System.out.println("Create" + employeeDto);
        } catch (IOException e) {
            throw new CustomServiceException("Error al crear miembro", e);
        }
    }
    
}
