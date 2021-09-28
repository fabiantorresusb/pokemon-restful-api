package com.co.pokemon.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.pokemon.daos.PokemonDAO;
import com.co.pokemon.entities.Pokemon;

@RestController
@RequestMapping("pokemons")
public class PokemonRest {

	@Autowired
	private PokemonDAO pokemonDAO;
	
	/**
	 * Service to consult a List of Pokémon
	 * Operation GET =>[ http://localhost:8090/pokemons ]
	 * @return A List of Pokémon
	 */
	@GetMapping
	public ResponseEntity<List<Pokemon>> getListOfPokemon() {
				
		List<Pokemon> pokemons = pokemonDAO.findAll();
		return ResponseEntity.ok(pokemons);
		
	}
	
	/**
	 * Service to consult a List of Pokémon
	 * Operation GET =>[ http://localhost:8090/pokemons ]
	 * @return A List of Pokémon
	 */
	@RequestMapping(value="paginate/{page}-{size}", method = RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> getListOfPokemonPaginated(@PathVariable("page") int page, @PathVariable("size") int size) {
		
		int actualPage = page-1;		
		System.out.println("PAGE: " + actualPage);
		System.out.println("SIZE: " + size);
		
		// Ordenamiento
		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		
		// Paginación Empieza desde 0 		
		Pageable pageable = PageRequest.of( actualPage, size, sort );
		System.out.println("getPageNumber: " + pageable.getPageNumber());
		System.out.println("getPageSize: " + pageable.getPageSize());
		System.out.println("getOffset: " + pageable.getOffset());
		
		// Consulta de paginación
		Page<Pokemon> pokemonPage = pokemonDAO.findAll(pageable);
		return ResponseEntity.ok( pokemonPage.getContent() );
	}
	
	/**
	 * Service to get the total of Pokémons
	 * Operation GET =>[ http://localhost:8090/pokemons/total ]
	 * @return The total of Pokémons
	 */
	@RequestMapping(value="total", method = RequestMethod.GET)
	public ResponseEntity<Long> getTotalOfPokemons() {
				
		Long numberOfPokemons = pokemonDAO.count();
		return ResponseEntity.ok(numberOfPokemons);
		
	}
	
	
	/**
	 * Service to consult a Pokémon by Id
	 * Operation GET =>[ http://localhost:8090/pokemons/{pokemonId} ]
	 * @param pokemonId Unique Id of Pokémon
	 * @return A Pokémon object if exists
	 */
	@RequestMapping(value="{pokemonId}") 
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable("pokemonId") Long pokemonId ) {
				
		Optional<Pokemon> optionalPokemon = pokemonDAO.findById(pokemonId);
		
		if( optionalPokemon.isPresent() ) {
			return ResponseEntity.ok(optionalPokemon.get());
		} else {
			return ResponseEntity.noContent().build();
		}
							
	}
	
	/**
	 * Service to create a new Pokemon
	 * Operation POST => [ http://localhost:8090/pokemons/ ]
	 * @param pokemon A object of type Pokémon
	 * @return The new Pokémon object created
	 */
	@PostMapping
	public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
		Pokemon newPokemon = pokemonDAO.save(pokemon);
		return ResponseEntity.ok(newPokemon);
	}
	
	/**
	 * Service to update a Pokémon
	 * Operation PUT => [ http://localhost:8090/pokemons/ ]
	 * @param pokemon A object of type Pokémon
	 * @return A boolean state with the result of the transaction
	 */	
	@PutMapping
	public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon) {
		
		Optional<Pokemon> optionalPokemon = pokemonDAO.findById(pokemon.getId());
		
		if( optionalPokemon.isPresent() ) {
			Pokemon updatePokemon = optionalPokemon.get();
			updatePokemon.setNumeral(pokemon.getNumeral());
			updatePokemon.setName(pokemon.getName());
			updatePokemon.setType1(pokemon.getType1());
			updatePokemon.setType2(pokemon.getType2());
			updatePokemon.setTotal(pokemon.getTotal());
			updatePokemon.setHp(pokemon.getHp());
			updatePokemon.setAttack(pokemon.getAttack());
			updatePokemon.setDefense(pokemon.getDefense());
			updatePokemon.setSpAtk(pokemon.getSpAtk());
			updatePokemon.setSpDef(pokemon.getSpDef());
			updatePokemon.setSpeed(pokemon.getSpeed());
			updatePokemon.setGeneration(pokemon.getGeneration());
			updatePokemon.setLegendary(pokemon.getLegendary());
			pokemonDAO.save(updatePokemon);
			return ResponseEntity.ok(updatePokemon);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
		
	/**
	 * Service to delete a Pokémon
	 * Operation DELETE => [ http://localhost:8090/pokemons/{pokemonId} ]
	 * @param pokemonId Unique Id of Pokémon
	 * @return A boolean state with the result of the transaction
	 */
	@DeleteMapping(value="{pokemonId}") 
	public ResponseEntity<Boolean> deletePokemon(@PathVariable("pokemonId") Long pokemonId) {
		
		Optional<Pokemon> optionalPokemon = pokemonDAO.findById(pokemonId);		
		
		// Only if the pokémon exists
		if( optionalPokemon.isPresent() ) {
			pokemonDAO.deleteById(pokemonId);
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.ok(false);
		}
				
	}	
	
}