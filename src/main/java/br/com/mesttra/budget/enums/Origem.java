package br.com.mesttra.budget.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Origem {
	
	FEDERAL("FEDERAL"), STATE("STATE"), COUNTY("COUNTY");
	
	 private final String value;

}
