package dev.moneysh.portfolio.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessageDto {

	@NotBlank(message = "Field 'name': Must not be blank.")
	@Size(min = 2, max = 50, message = "Field 'name': Invalid length. Expected length between 2 to 50 chars.")
	private String name;

	@NotBlank(message = "Field 'email': Must not be blank.")
	@Size(min = 6, max = 100, message = "Field 'email': Invalid length. Expected length between 6 to 100 chars.")
	@Email(message = "Field 'email': Invalid format. Must be a well-formed email address.")
	private String email;

	@NotBlank(message = "Field 'subject': Must not be blank.")
	@Size(min = 3, max = 120, message = "Field 'subject': Invalid length. Expected length between 3 to 120 chars.")
	private String subject;

	@NotBlank(message = "Field 'message': Must not be blank.")
	@Size(min = 5, max = 512, message = "Field 'message': Invalid length. Expected length between 5 to 512 chars.")
	private String message;

}
