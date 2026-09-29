package dev.moneysh.portfolio.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import dev.moneysh.portfolio.dto.ContactMessageDto;
import dev.moneysh.portfolio.entity.ContactMessage;
import dev.moneysh.portfolio.repository.ContactMessageRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {

	private final ContactMessageRepository contactMessageRepository;

	@Override
	public ContactMessage saveContactMessage(ContactMessageDto contactMessageDto) {

		ContactMessage contactMessage = new ContactMessage();
		contactMessage.setName(contactMessageDto.getName());
		contactMessage.setEmail(contactMessageDto.getEmail());
		contactMessage.setSubject(contactMessageDto.getSubject());
		contactMessage.setMessage(contactMessageDto.getMessage());
		contactMessage.setCreatedAt(LocalDateTime.now());

		return contactMessageRepository.save(contactMessage);
	}

}
