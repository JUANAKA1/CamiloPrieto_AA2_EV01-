package com.tcna.primeraweb.service.impl;


import com.tcna.primeraweb.entities.Zapato;
import com.tcna.primeraweb.repository.ZapatoRepository;
import com.tcna.primeraweb.service.ZapatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZapatoServiceImpl implements ZapatoService {

    @Autowired
    private ZapatoRepository zapatoRepository;

    @Override
    public List<Zapato> obtenerTodos() {
        return zapatoRepository.findAll();
    }

    @Override
    public Zapato obtenerPorId(Long id) {
        return zapatoRepository.findById(id).orElse(null);
    }

    @Override
    public Zapato crearZapato(Zapato zapato) {
        return zapatoRepository.save(zapato);
    }

    @Override
    public Zapato actualizarZapato(Long id, Zapato zapato) {
        Zapato zapatoBBDD = zapatoRepository.findById(id).orElse(null);

        if (zapatoBBDD != null) {
            zapatoBBDD.setNombre(zapato.getNombre());
            zapatoBBDD.setMarca(zapato.getMarca());
            zapatoBBDD.setPrecio(zapato.getPrecio());
            return zapatoRepository.save(zapatoBBDD);
        }
        return null;
    }

    @Override
    public void eliminarZapato(Long id) {
        zapatoRepository.deleteById(id);
    }

    @Override
    public long contarZapatos() {
        return zapatoRepository.count();
    }
}
