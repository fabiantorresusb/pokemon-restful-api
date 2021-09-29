package com.co.pokemon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity that represents a Pokémon object with its attributes.
 * @author Fabian Torres
 */

@Entity
@Table(name="pokemons")
public class Pokemon {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="numeral", nullable=false)
	private Integer numeral;
	
	@Column(name="name", nullable=false, length = 50)
	private String name;
	
	@Column(name="type1", nullable=false, length = 30)
	private String type1;
	
	@Column(name="type2", nullable=false, length = 30)
	private String type2;
	
	@Column(name="total", nullable=false)
	private Integer total;
	
	@Column(name="hp", nullable=false)
	private Integer hp;
	
	@Column(name="attack", nullable=false)
	private Integer attack;
	
	@Column(name="defense", nullable=false)
	private Integer defense;
	
	@Column(name="spAtk", nullable=false)
	private Integer spAtk;
	
	@Column(name="spDef", nullable=false)
	private Integer spDef;
	
	@Column(name="speed", nullable=false)
	private Integer speed;
	
	@Column(name="generation", nullable=false)
	private Byte generation;
	
	@Column(name="legendary", nullable=false, length = 5)
	private String legendary;
	
	/**
	 * Constructor by default
	 */
	public Pokemon() {
		
	}

	/**
	 * Constructor with Parameters
	 * @param id
	 * @param numeral
	 * @param name
	 * @param type1
	 * @param type2
	 * @param total
	 * @param hp
	 * @param attack
	 * @param defense
	 * @param spAtk
	 * @param spDef
	 * @param speed
	 * @param generation
	 * @param legendary
	 */
	public Pokemon(Long id, Integer numeral, String name, String type1, String type2, Integer total, Integer hp,
			Integer attack, Integer defense, Integer spAtk, Integer spDef, Integer speed, Byte generation,
			String legendary) {
		this.id = id;
		this.numeral = numeral;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.total = total;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.generation = generation;
		this.legendary = legendary;
	}

	/** Methods: Get and Set **/
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getNumeral() {
		return numeral;
	}
	
	public void setNumeral(Integer numeral) {
		this.numeral = numeral;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType1() {
		return type1;
	}
	
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	public String getType2() {
		return type2;
	}
	
	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getHp() {
		return hp;
	}
	
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	
	public Integer getAttack() {
		return attack;
	}
	
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	
	public Integer getDefense() {
		return defense;
	}
	
	public void setDefense(Integer defense) {
		this.defense = defense;
	}
	
	public Integer getSpAtk() {
		return spAtk;
	}
	
	public void setSpAtk(Integer spAtk) {
		this.spAtk = spAtk;
	}
	
	public Integer getSpDef() {
		return spDef;
	}
	
	public void setSpDef(Integer spDef) {
		this.spDef = spDef;
	}
	
	public Integer getSpeed() {
		return speed;
	}
	
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	
	public Byte getGeneration() {
		return generation;
	}
	
	public void setGeneration(Byte generation) {
		this.generation = generation;
	}
	
	public String getLegendary() {
		return legendary;
	}
	
	public void setLegendary(String legendary) {
		this.legendary = legendary;
	}
		
}