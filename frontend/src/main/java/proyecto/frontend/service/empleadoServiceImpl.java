package proyecto.frontend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import proyecto.frontend.DTO.empleadoDTO;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class empleadoServiceImpl implements IempleadoService{

    @Override
    public List<empleadoDTO> findAllREST() {
        try {
            ObjectMapper unMapper = new ObjectMapper();

            List<empleadoDTO> empleados = Arrays
                    .asList(unMapper.readValue(new URL("http://localhost:8080/api/empleados/getAll"), empleadoDTO[].class));
            return empleados;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public empleadoDTO findByIdREST(Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<empleadoDTO> responseEntity = restTemplate
                    .getForEntity("http://localhost:8080/api/empleados/SearchByID" + "/" + id, empleadoDTO.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                empleadoDTO dto = responseEntity.getBody();
                return dto;
            } else {
                System.out.println("A ocurrido un error");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public empleadoDTO saveREST(empleadoDTO EmpleadoDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<empleadoDTO> requestEntity = new HttpEntity<>(EmpleadoDTO, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<empleadoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/api/empleados/create",
                    requestEntity, empleadoDTO.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                empleadoDTO dto = responseEntity.getBody();
                return dto;
            } else {
                System.out.println("A ocurrido un error");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public empleadoDTO updateREST(Long id, empleadoDTO empleadoDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<empleadoDTO> requestEntity = new HttpEntity<>(empleadoDTO, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<empleadoDTO> responseEntity = restTemplate.exchange(
                    "http://localhost:8080/api/empleados/update" + "/" + id,
                    HttpMethod.PUT,
                    requestEntity,
                    empleadoDTO.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                empleadoDTO dto = responseEntity.getBody();
                return dto;
            } else {
                System.out.println("Ha ocurrido un error");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public empleadoDTO deleteREST(Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<empleadoDTO> responseEntity = restTemplate
                    .getForEntity("http://localhost:8080/api/empleados/SearchByID" + "/" + id, empleadoDTO.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                empleadoDTO dto = responseEntity.getBody();

                restTemplate.delete("http://localhost:8080/api/empleados/delete" + "/" + id);

                return dto;
            } else {
                System.out.println("A ocurrido un error");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
