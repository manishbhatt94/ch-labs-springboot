package dev.moneysh.portfolio.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import dev.moneysh.portfolio.dto.ContactMessageDto;
import dev.moneysh.portfolio.entity.ContactMessage;
import dev.moneysh.portfolio.repository.ContactMessageRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {

	private final ContactMessageRepository contactMessageRepository;

	private final ModelMapper modelMapper;

	@Override
	public ContactMessage saveContactMessage(ContactMessageDto contactMessageDto) {

		ContactMessage contactMessage = modelMapper.map(contactMessageDto, ContactMessage.class);
		contactMessage.setCreatedAt(LocalDateTime.now());

		return contactMessageRepository.save(contactMessage);
	}

}
