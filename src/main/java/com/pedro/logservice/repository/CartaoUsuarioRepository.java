package com.pedro.logservice.repository;

import com.pedro.logservice.model.CartaoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoUsuarioRepository extends JpaRepository<CartaoUsuario, Integer> {
}
