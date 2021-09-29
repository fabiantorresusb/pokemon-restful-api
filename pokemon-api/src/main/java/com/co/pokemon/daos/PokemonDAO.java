package com.co.pokemon.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.co.pokemon.entities.Pokemon;

/**
 * Pokemon Repository
 * @author Fabian Torres
 */
public interface PokemonDAO extends JpaRepository<Pokemon, Long>{

}