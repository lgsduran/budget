package br.com.mesttra.budget.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.mesttra.budget.enums.Origem;
import br.com.mesttra.budget.enums.PossibleDestinations;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Entity
@Table(name = "budget")
public @Data class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "budget_id")
	private long id;
	
	@Column(name = "total_amount")
	private Double totalAmount;

	@Column(name = "spent_amount")
	private Double spentAmount;

	@Column(name = "possible_destinations")
	@Enumerated(EnumType.STRING)
	private PossibleDestinations possibleDestinations;
	
	@Enumerated(EnumType.STRING)
	private Origem origem;

}
