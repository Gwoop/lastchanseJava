package com.example.lastchanse.pacege;

import com.example.lastchanse.models.Ochenka;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Ochenkarepository extends CrudRepository<Ochenka,Long> {

    public List<Ochenka> findByTaskoc_id(Long id);

}
