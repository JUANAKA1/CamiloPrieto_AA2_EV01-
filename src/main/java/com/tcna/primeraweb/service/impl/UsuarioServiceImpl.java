package com.tcna.primeraweb.service.impl;

import com.tcna.primeraweb.entities.Usuario;
import com.tcna.primeraweb.repository.UsuarioRepository;
import com.tcna.primeraweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioBBDD = usuarioRepository.findById(id).orElse(null);
        if (usuarioBBDD != null) {
            usuarioBBDD.setNombre(usuario.getNombre());
            usuarioBBDD.setCorreo(usuario.getCorreo());
            usuarioBBDD.setContrasena(usuario.getContrasena());
            return usuarioRepository.save(usuarioBBDD);
        }
        return null;
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
