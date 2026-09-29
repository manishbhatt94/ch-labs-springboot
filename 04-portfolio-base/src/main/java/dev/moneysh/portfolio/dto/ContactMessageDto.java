package dev.moneysh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessageDto {

	private String name;

	private String email;

	private String subject;

	private String message;

}
