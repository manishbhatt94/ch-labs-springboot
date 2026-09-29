package dev.moneysh.portfolio.service;

import dev.moneysh.portfolio.dto.ContactMessageDto;
import dev.moneysh.portfolio.entity.ContactMessage;

public interface ContactMessageService {

	ContactMessage saveContactMessage(ContactMessageDto contactMessageDto);

}
