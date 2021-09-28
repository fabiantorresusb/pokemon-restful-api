package com.co.pokemon;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.co.pokemon.daos.PokemonDAO;
import com.co.pokemon.entities.Pokemon;
import com.co.pokemon.rest.PokemonRest;

/**
 * JUnit - Test Unit
 * @author Fabian Torres
 */

// @SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PokemonApiApplicationTests {
	
	private final int STATUS_OK = 200;
	
	@Mock
	private PokemonDAO pokemonDAO;
	
	@Mock
	private Pokemon pokemon;
	
	@InjectMocks
	private PokemonRest pokemonRest;
	
   	/**
	 * Test ListOfPokemons
	 */
	@Test
	public void testListOfPokemons() {
		ResponseEntity<List<Pokemon>> pokemons = pokemonRest.getListOfPokemon();
		System.out.println("CODE: " + pokemons.getStatusCodeValue());	
		assertTrue(STATUS_OK == pokemons.getStatusCodeValue());
	}
	

	// ------------------------------
	// .. Another Tests Required
	// ------------------------------
}
