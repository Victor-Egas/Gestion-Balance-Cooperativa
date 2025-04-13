package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.model.entity.UsuarioPrueba;
import com.cooperativa.gestion.service.UsuarioPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner/prueba")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UsuarioPruebaController {

    private final UsuarioPruebaService service;

    @PostMapping("/save")
    public ResponseEntity<UsuarioPrueba> savePartner(@RequestBody UsuarioPrueba usuarioPrueba) {
        System.out.println("### Usuario : " + usuarioPrueba.getNombre());
        UsuarioPrueba usuario = service.guardarUsuario(usuarioPrueba);
        return ResponseEntity.ok(usuario);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<UsuarioPrueba>> getPartners() {
        List<UsuarioPrueba> usuarios = service.obtenerUsuariosPrueba();
        HttpHeaders headers = new HttpHeaders();
        headers.add("opn-number", "2");
        headers.add("region", "Lima");
        return ResponseEntity.ok()
                .headers(headers)
                .body(usuarios);
    }
}
