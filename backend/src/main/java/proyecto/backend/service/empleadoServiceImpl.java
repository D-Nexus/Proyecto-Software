package proyecto.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.backend.DTO.empleadoDTO;
import proyecto.backend.repository.empleadoRepository;
import proyecto.backend.entity.empleado;
import proyecto.backend.repository.registroRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class empleadoServiceImpl implements IempleadoService{

    @Autowired
    private empleadoRepository EmpleadoRepository;

    @Autowired
    private registroRepository RegistroRepository;



    public List<empleadoDTO> findAll() {
        List<empleado> TodosLosEmpleados = (List<empleado>) EmpleadoRepository.findAll();
        List<empleadoDTO> listDto = new ArrayList<empleadoDTO>();
        for (empleado l : TodosLosEmpleados) {
            listDto.add(l.toDTO());
        }
        return listDto;
    }

    public Optional<empleadoDTO> findById(Long id) {
        Optional<empleado> BuscarPorID = EmpleadoRepository.findById(id);
        empleado DevolverEmpleado = BuscarPorID.get();
        empleadoDTO dto = DevolverEmpleado.toDTO();
        return Optional.ofNullable(dto);
    }

    public empleadoDTO save(empleadoDTO Empleadodto) {
        if (containsNumber(Empleadodto.getNombre()) || containsNumber(Empleadodto.getApellidoMaterno()) || containsNumber(Empleadodto.getApellidoPaterno()) || containsNumber(Empleadodto.getTipoCargo()) || containsNumber(Empleadodto.getTipoContrato())) {
            throw new IllegalArgumentException("No puede contener números.");
        }
        empleado GuardarEmpleado = EmpleadoRepository.save(Empleadodto.toEntity()); //Convertir empleadoDTO a empleado con el metodo toEntity
        return GuardarEmpleado.toDTO(); // Se devuelve convirtiendo el empleado a DTO
    }

    public void deleteById(Long Id) {
        Long Registro_a_eliminar = RegistroRepository.findRegistroIdByEmpleadoId(Id);
        if (Registro_a_eliminar != null){
            RegistroRepository.deleteById(Registro_a_eliminar);
        }
        EmpleadoRepository.deleteById(Id);
    }

    private boolean containsNumber(String str) {
        return str != null && str.matches(".*\\d.*");
    }
}
