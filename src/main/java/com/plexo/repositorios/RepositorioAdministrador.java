package com.plexo.repositorios;


import com.plexo.actores.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAdministrador extends JpaRepository<Administrador, Integer> {
    Administrador findByUsuarioAndContrasenia(String usuario, String contrasenia);
    Administrador findByUsuario(String usuario);
}
