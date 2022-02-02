package com.projetoAPI_REST.personApiC.dto.resquest;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.projetoAPI_REST.personApiC.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	
	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;

}