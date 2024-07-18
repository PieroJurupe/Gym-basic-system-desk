
package com.jc.gymbasicsystemfront.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jc.gymbasicsystemfront.api.ApiManager;
import com.jc.gymbasicsystemfront.api.GymBasicSystemApi;
import com.jc.gymbasicsystemfront.dto.employees.CreateEmployeeDto;
import com.jc.gymbasicsystemfront.models.EmployeeDto;
import java.io.IOException;
import java.util.List;
import com.jc.gymbasicsystemfront.exceptions.CustomServiceException;

public class EmployeeService {
   private final ApiManager apiManager = ApiManager.getInstance();
    private final String relativeUri = "/employees";

    public List<EmployeeDto> getAll() throws CustomServiceException {
        try {
            GymBasicSystemApi gymApi = apiManager.getGymApi();
            java.lang.reflect.Type employeesListType = new TypeToken<List<EmployeeDto>>() {
            }.getType();
            return gymApi.get(relativeUri, employeesListType, true);
        } catch (IOException e) {
            throw new CustomServiceException("Error al obtener empleados", e);
        }
    }

    public void create(CreateEmployeeDto createEmployeeDto)
            throws CustomServiceException {
        try {
            GymBasicSystemApi gymApi = apiManager.getGymApi();
            java.lang.reflect.Type employeeType = new TypeToken<EmployeeDto>() {
            }.getType();
            
            Gson gson = new Gson();
            String json = gson.toJson(createEmployeeDto);
            EmployeeDto employeeDto = gymApi.post(
                    relativeUri + "/create",
                    json,
                    employeeType,
                    true
            );
            System.out.println("Create" + employeeDto);
        } catch (IOException e) {
              throw new CustomServiceException("Error al obtener empleados", e);
        }
     
    }
}
