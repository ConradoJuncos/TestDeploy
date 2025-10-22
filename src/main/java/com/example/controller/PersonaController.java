package com.example.controller;

import com.example.dto.PersonaDTO;
import com.example.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO personaDTO) {
        PersonaDTO personaCreada = personaService.crearPersona(personaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaCreada);
    }

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> obtenerPersonas() {
        List<PersonaDTO> personas = personaService.obtenerTodasLasPersonas();
        return ResponseEntity.ok(personas);
    }
}

