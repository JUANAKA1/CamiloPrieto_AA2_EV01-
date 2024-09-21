package com.tcna.primeraweb.repository;


import com.tcna.primeraweb.entities.Zapato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZapatoRepository extends JpaRepository<Zapato, Long> {
}