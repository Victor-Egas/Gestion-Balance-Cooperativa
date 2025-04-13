package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.UsuarioPrueba;

import java.util.List;

public interface UsuarioPruebaService {

    List<UsuarioPrueba> obtenerUsuariosPrueba();

    UsuarioPrueba guardarUsuario(UsuarioPrueba usuario);
}
