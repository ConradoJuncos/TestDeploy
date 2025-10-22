package com.example.service;

import com.example.dto.PersonaDTO;
import com.example.model.Persona;
import com.example.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaDTO crearPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setDni(personaDTO.getDni());
        persona.setNombre(personaDTO.getNombre());

        Persona personaGuardada = personaRepository.save(persona);

        return convertirADTO(personaGuardada);
    }

    public List<PersonaDTO> obtenerTodasLasPersonas() {
        return personaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private PersonaDTO convertirADTO(Persona persona) {
        return new PersonaDTO(
                persona.getId(),
                persona.getDni(),
                persona.getNombre()
        );
    }
}

