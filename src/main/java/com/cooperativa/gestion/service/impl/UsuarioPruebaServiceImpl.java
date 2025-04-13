package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.model.entity.UsuarioPrueba;
import com.cooperativa.gestion.repository.UsuarioPruebaRepositorio;
import com.cooperativa.gestion.service.UsuarioPruebaService;
import com.cooperativa.gestion.util.EncryptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsuarioPruebaServiceImpl implements UsuarioPruebaService {

    private final UsuarioPruebaRepositorio repositorio;

    @Override
    public List<UsuarioPrueba> obtenerUsuariosPrueba() {

        return repositorio.findAll().stream()
                .map(usuario -> {
                    System.out.println("### Usuario : "+usuario.getNombre());
                    if (usuario != null && !usuario.getNombre().equals("")) {
                        try {
                            // Descifrar la contraseña antes de devolverla al cliente
                            String decryptedPassword = EncryptionUtil.decrypt(usuario.getNombre());
                            usuario.setNombre(decryptedPassword);
                            return usuario;
                        } catch (Exception e) {
                            return new UsuarioPrueba();
                        }
                    } else {
                        System.out.println("### Usuario : "+usuario.getCodigo());
                        return new UsuarioPrueba();
                    }
                }).collect(Collectors.toList());
    }

    @Override
    public UsuarioPrueba guardarUsuario(UsuarioPrueba usuario) {
        // Cifrar el campo "password" del usuario antes de almacenarlo en la base de datos
        String encryptedUsuario = null;
        try {
            encryptedUsuario = EncryptionUtil.encrypt(usuario.getNombre());
        } catch (Exception e) {
            System.out.println("### ERROR AL ENCRIPTAR : "+e.getMessage());
            throw new RuntimeException(e);
        }
        usuario.setNombre(encryptedUsuario);
        return repositorio.save(usuario);
    }
}
