package dev.moneysh.portfolio.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contact_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private Long messageId;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 100, nullable = false, unique = true)
	private String email;

	@Column(length = 120, nullable = false)
	private String subject;

	@Column(length = 512, nullable = false)
	private String message;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

}
