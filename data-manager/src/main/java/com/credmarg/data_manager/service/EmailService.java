package com.credmarg.data_manager.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.credmarg.data_manager.dao.VendorEmailLog;
import com.credmarg.data_manager.repository.VendorEmailRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	private final JavaMailSender javaMailSender;
	final Logger logger = LogManager.getLogger(EmailService.class);

	@Autowired
	private VendorEmailRepository emailLogRepository;

	public List<VendorEmailLog> getAll() {
		return emailLogRepository.findByCreatedBy("Nishant_Kusalkar");
	}

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(VendorEmailLog empLog) {

		logger.info("Received request to send email to Vendor :: {}", empLog.getVendor_email());
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

		try {
			helper.setFrom("nishkusalkar@gmail.com");
			helper.setTo(empLog.getVendor_email());
			helper.setSubject("Payment-Status");
			helper.setText(empLog.getMessage(), true); // true indicates HTML content

			javaMailSender.send(mimeMessage);
			logger.info("Email send to vendor Successfully :: {}", empLog.getVendor_email());
			empLog.setCreatedBy("Nishant_Kusalkar");
			emailLogRepository.save(empLog);

		} catch (MessagingException e) {
			logger.info("Failed to send email to :: {}", empLog.getVendor_email() + " :: " + e.getMessage());

		}
	}
}
