package com.tcna.primeraweb.controller;

import com.tcna.primeraweb.entities.Usuario;
import com.tcna.primeraweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodos();
        model.addAttribute("listaUsuarios", usuarios);
        return "listarUsuarios"; // Asegúrate de tener una plantilla llamada listarUsuarios.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("accion", "/usuarios/nuevo");
        return "formularioUsuario"; // Asegúrate de tener una plantilla llamada formularioUsuario.html
    }

    @PostMapping("/nuevo")
    public String guardarNuevoUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.crearUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarUsuario(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.obtenerPorId(id));
        model.addAttribute("accion", "/usuarios/editar/" + id);
        return "formularioUsuario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        usuarioService.actualizarUsuario(id, usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}

