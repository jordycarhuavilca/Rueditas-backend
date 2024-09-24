package pe.edu.cibertec.rueditas_back_end.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_back_end.dto.ConsultaRequestDTO;
import pe.edu.cibertec.rueditas_back_end.service.FileRequest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FileRequestImpl implements FileRequest {
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] GetCar(ConsultaRequestDTO consultaRequestDTO) throws IOException {
        String[] cars = null;
        Resource resource = resourceLoader.getResource("classpath:cars.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while((linea = br.readLine()) != null){

                String[] datos = linea.split(";");
                if (consultaRequestDTO.placa().equals(datos[1])) {
                    cars = new String[7];
                    cars[0] = datos[0];
                    cars[1] = datos[1];
                    cars[2] = datos[2];
                    cars[3] = datos[3];
                    cars[4] = datos[4];
                    cars[5] = datos[5];
                    cars[6] = datos[6];

                    return cars;
                }
            }
        }catch (IOException e) {
            throw new IOException(e);
        } ;
        return cars;
    }
}
