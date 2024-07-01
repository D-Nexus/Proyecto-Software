package proyecto.frontend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import proyecto.frontend.DTO.proyectoDTO;
import proyecto.frontend.DTO.registroDTO;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class registroServiceImpl implements IregistroService{

    @Override
    public List<registroDTO> findAllREST() {
        try {
            ObjectMapper unMapper = new ObjectMapper();

            List<registroDTO> registros = Arrays
                    .asList(unMapper.readValue(new URL("http://localhost:8080/api/registros/getAll"), registroDTO[].class));
            return registros;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public registroDTO findByIdREST(Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<registroDTO> responseEntity = restTemplate
                    .getForEntity("http://localhost:8080/api/registros/SearchByID" + "/" + id, registroDTO.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                registroDTO dto = responseEntity.getBody();
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
    public registroDTO updateREST(Long id, registroDTO registroDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<registroDTO> requestEntity = new HttpEntity<>(registroDTO, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<registroDTO> responseEntity = restTemplate.exchange(
                    "http://localhost:8080/api/registros/update" + "/" + id,
                    HttpMethod.PUT,
                    requestEntity,
                    registroDTO.class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                registroDTO dto = responseEntity.getBody();
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
    public registroDTO deleteREST(Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<registroDTO> responseEntity = restTemplate
                    .getForEntity("http://localhost:8080/api/registros/SearchByID" + "/" + id, registroDTO.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                registroDTO dto = responseEntity.getBody();

                restTemplate.delete("http://localhost:8080/api/registros/delete" + "/" + id);

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
    public registroDTO CalcularBonoREST(registroDTO registroDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<registroDTO> requestEntity = new HttpEntity<>(registroDTO, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<registroDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/api/registros/calcularBono",
                    requestEntity, registroDTO.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                registroDTO dto = responseEntity.getBody();
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

