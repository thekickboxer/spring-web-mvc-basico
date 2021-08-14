package br.com.dio.springwebmvc.repository;

import java.util.List;

import br.com.dio.springwebmvc.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    List<Jedi> findByNameContainingIgnoreCase(final String name);

}

/*
import br.com.dio.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    final List<Jedi> listaJedi;

    public JediRepository() {
        listaJedi = new ArrayList<>();
        //listaJedi.add(new Jedi("Luke", "Skywalker"));
    }

    public List<Jedi> getAllJedi() {
        return listaJedi;
    }

    public void add(Jedi jedi) {
        listaJedi.add(jedi);
    }

}
*/
