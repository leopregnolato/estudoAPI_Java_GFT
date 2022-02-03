package com.gft.loja.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.loja.entities.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {

}
