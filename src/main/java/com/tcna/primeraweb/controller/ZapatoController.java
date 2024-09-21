package com.tcna.primeraweb.controller;


import com.tcna.primeraweb.entities.Zapato;
import com.tcna.primeraweb.service.ZapatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/zapatos")
public class ZapatoController {

    @Autowired
    private ZapatoService zapatoService;

    @GetMapping
    public String listarZapatos(Model model) {
        List<Zapato> zapatos = zapatoService.obtenerTodos();
        model.addAttribute("listaZapatos", zapatos);
        return "listarZ";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoZapato(Model model) {
        model.addAttribute("zapato", new Zapato());
        model.addAttribute("accion", "/zapatos/nuevo");
        return "formularioZ";
    }

    @PostMapping("/nuevo")
    public String guardarNuevoZapato(@ModelAttribute Zapato zapato) {
        zapatoService.crearZapato(zapato);
        return "redirect:/zapatos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarZapato(@PathVariable Long id, Model model) {
        model.addAttribute("zapato", zapatoService.obtenerPorId(id));
        model.addAttribute("accion", "/zapatos/editar/" + id);
        return "formularioZ";
    }

    @PostMapping("/editar/{id}")
    public String actualizarZapato(@PathVariable Long id, @ModelAttribute Zapato zapato) {
        zapatoService.actualizarZapato(id, zapato);
        return "redirect:/zapatos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarZapato(@PathVariable Long id) {
        zapatoService.eliminarZapato(id);
        return "redirect:/zapatos";
    }
}
