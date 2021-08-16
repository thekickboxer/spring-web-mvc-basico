package br.com.dio.springwebmvc.repository;

import java.util.List;

import br.com.dio.springwebmvc.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    List<Jedi> findByNameContainingIgnoreCase(final String name);

    List<Jedi> findByLastNameContainingIgnoreCase(final String lastName);

}
