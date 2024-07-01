package proyecto.frontend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import proyecto.frontend.DTO.proyectoDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class proyectoServiceImpl implements IproyectoService {

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

    @Override
    public ByteArrayInputStream generateExcelReport(String reportType) {
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Reporte de Proyecto");

            // Definir los encabezados de las columnas
            String[] columnHeaders = {
                    "ID", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO",
                    "TIPO DE CARGO", "PORCENTAJE", "MONTO DE BONO",
                    "FECHA DE PAGO", "NOMBRE PROYECTO", "COMUNA"
            };

            // Crear la fila de encabezados
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columnHeaders.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnHeaders[i]);
            }

            // Datos ficticios para el ejemplo
            List<Object[]> datos = obtenerDatosFicticios(); // Supongamos que esta función devuelve los datos

            // Crear las filas de datos
            int rowIndex = 1;
            for (Object[] rowData : datos) {
                Row row = sheet.createRow(rowIndex++);
                for (int i = 0; i < rowData.length; i++) {
                    Cell cell = row.createCell(i);
                    if (rowData[i] instanceof String) {
                        cell.setCellValue((String) rowData[i]);
                    } else if (rowData[i] instanceof Integer) {
                        cell.setCellValue((Integer) rowData[i]);
                    } else if (rowData[i] instanceof Double) {
                        cell.setCellValue((Double) rowData[i]);
                    }
                    // Añadir más tipos según sea necesario
                }
            }

            // Autoajustar todas las columnas
            for (int i = 0; i < columnHeaders.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            System.err.println("Error al generar el informe Excel: " + e.getMessage());
            return new ByteArrayInputStream(new byte[0]);
        }
    }

    private List<Object[]> obtenerDatosFicticios() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{1, "Juan", "Pérez", "González", "Gerente", 50.0, 3000.0, "2022-01-01", "Proyecto X", "Santiago"});
        list.add(new Object[]{2, "Ana", "Martínez", "Díaz", "Analista", 75.0, 4500.0, "2022-01-02", "Proyecto Y", "Valparaíso"});
        return list;
    }
}




