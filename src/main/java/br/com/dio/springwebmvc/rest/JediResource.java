package br.com.dio.springwebmvc.rest;

import br.com.dio.springwebmvc.exception.JediNotFoundException;
import br.com.dio.springwebmvc.model.Jedi;
import br.com.dio.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JediResource {

    @Autowired
    private JediRepository repository;

    @GetMapping("/jedi")
    public List<Jedi> getAllJedi() {
        return repository.findAll();
    }

    @GetMapping("/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {

        final Optional<Jedi> jedi = repository.findById(id);

        if(jedi.isPresent()) {
            return ResponseEntity.ok(jedi.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi) {
        return repository.save(jedi);
    }

    @PutMapping("/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi dto) {

        final Optional<Jedi> jediEntity = repository.findById(id);
        final Jedi jedi;

        if(jediEntity.isPresent()) {
            jedi = jediEntity.get();
        } else {
            return ResponseEntity.notFound().build();
        }

        jedi.setName(dto.getName());
        jedi.setLastName(dto.getLastName());

        return ResponseEntity.ok(repository.save(jedi));

    }

    @DeleteMapping("/jedi/{id}")
    public ResponseEntity deleteJedi(@PathVariable("id") Long id) {

        final Optional<Jedi> jedi = repository.findById(id);

        if(jedi.isPresent()) {
            repository.delete(jedi.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
