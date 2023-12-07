package com.First.Jobs.repositories;



import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.First.Jobs.models.Usuario;



@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	//ArrayList<Usuario> findByPassword(Integer password);

    Usuario findByNumero(String numero);

    Usuario findByTipo(String tipo);    

    Usuario findByPassword(String password);
}
