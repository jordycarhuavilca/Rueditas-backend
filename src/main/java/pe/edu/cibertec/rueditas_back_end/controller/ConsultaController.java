package pe.edu.cibertec.rueditas_back_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas_back_end.dto.ConsultaRequestDTO;
import pe.edu.cibertec.rueditas_back_end.dto.ConsultaResponseDTO;
import pe.edu.cibertec.rueditas_back_end.service.FileRequest;

@RestController
@RequestMapping("")
public class ConsultaController {
    @Autowired
    FileRequest fileRequest;

    @PostMapping("/getCars")
    public ConsultaResponseDTO login(@RequestBody() ConsultaRequestDTO consultaRequestDTO){
        try {
            System.out.println("request: " + consultaRequestDTO);
            String[] cars = fileRequest.GetCar(consultaRequestDTO);
            if (cars == null){
                return new ConsultaResponseDTO("404","error: Not Found Car","","","","","");
            }
            return new ConsultaResponseDTO("200","ok",cars[2],cars[3],cars[4],cars[5],cars[6]);
        } catch (Exception e) {
            return new ConsultaResponseDTO("500","error: Something is wrong","","","","","");
        }
    }
}
