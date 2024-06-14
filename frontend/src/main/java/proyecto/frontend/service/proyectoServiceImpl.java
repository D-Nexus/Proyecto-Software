package proyecto.frontend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import proyecto.frontend.DTO.proyectoDTO;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class proyectoServiceImpl implements IproyectoService{

    @Override
    public List<proyectoDTO> findAllREST() {
        try {
            ObjectMapper unMapper = new ObjectMapper();

            List<proyectoDTO> proyectos = Arrays
                    .asList(unMapper.readValue(new URL("http://localhost:8080/api/proyectos/getAll"), proyectoDTO[].class));
            return proyectos;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public proyectoDTO findByIdREST(Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<proyectoDTO> responseEntity = restTemplate
                    .getForEntity("http://localhost:8080/api/proyectos/SearchByID" + "/" + id, proyectoDTO.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                proyectoDTO dto = responseEntity.getBody();
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
    public proyectoDTO saveREST(proyectoDTO proyectoDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<proyectoDTO> requestEntity = new HttpEntity<>(proyectoDTO, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<proyectoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/api/proyectos/create",
                    requestEntity, proyectoDTO.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                proyectoDTO dto = responseEntity.getBody();
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
    public proyectoDTO updateREST(Long id, proyectoDTO proyectoDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<proyectoDTO> requestEntity = new HttpEntity<>(proyectoDTO, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<proyectoDTO> responseEntity = restTemplate.exchange(
                    "http://localhost:8080/api/proyectos/update" + "/" + id,
                    HttpMethod.PUT,
                    requestEntity,
                    proyectoDTO.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                proyectoDTO dto = responseEntity.getBody();
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
    public proyectoDTO deleteREST(Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<proyectoDTO> responseEntity = restTemplate
                    .getForEntity("http://localhost:8080/api/proyectos/SearchByID" + "/" + id, proyectoDTO.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                proyectoDTO dto = responseEntity.getBody();

                restTemplate.delete("http://localhost:8080/api/proyectos/delete" + "/" + id);

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

