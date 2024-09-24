package pe.edu.cibertec.rueditas_back_end.service;

import pe.edu.cibertec.rueditas_back_end.dto.ConsultaRequestDTO;

import java.io.IOException;

public interface FileRequest {
    String [] GetCar (ConsultaRequestDTO consultaRequestDTO) throws IOException;
}
