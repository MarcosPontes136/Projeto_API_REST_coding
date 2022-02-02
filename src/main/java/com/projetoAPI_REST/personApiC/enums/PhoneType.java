package com.projetoAPI_REST.personApiC.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");
	
	private final String description;
}
