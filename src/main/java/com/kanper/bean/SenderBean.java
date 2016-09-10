package com.kanper.bean;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SenderBean extends Authenticator {
	private String userName = null;
	private String password = null;

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
