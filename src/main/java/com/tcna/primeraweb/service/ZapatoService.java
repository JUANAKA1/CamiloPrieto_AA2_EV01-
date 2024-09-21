package com.tcna.primeraweb.service;

import com.tcna.primeraweb.entities.Zapato;

import java.util.List;

public interface ZapatoService {

    List<Zapato> obtenerTodos();

    Zapato obtenerPorId(Long id);

    Zapato crearZapato(Zapato zapato);

    Zapato actualizarZapato(Long id, Zapato zapato);

    void eliminarZapato(Long id);

    long contarZapatos();
}
