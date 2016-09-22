package com.liferay.hu.badge.utils;

import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;

import org.apache.log4j.Logger;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

public class Emails {
	public static String NOTIFYUSR_SUBJECT = "You got a badge!";
	public static String NOTIFYSUBSCRIBERS_SUBJECT = "A badge was assigned!";
	public static String NOTIFYUSR_BODY = "Congratulation!\n\nYou got a %1$s badge from %2$s";
	public static String NOTIFYSUBSCRIBERS_BODY = "%1$s gave a %2$s badge to %3$s";

	public static boolean notifyUser(long toUserId, long fromUserId, int badgeType, PortletRequest request) {
		String emailAddr = _getEmailAddr(toUserId);
		if (Validator.isNull(emailAddr)) {
			_log.error("There is no email address for user " + toUserId);
			return false;
		}

		String fromUserName = _getUserName(fromUserId);
		String badgeName = _getBadgeName(badgeType);

		String subject = NOTIFYUSR_SUBJECT;
		String body = String.format(NOTIFYUSR_BODY, badgeName, fromUserName);

		InternetAddress to = new InternetAddress();
		to.setAddress(emailAddr);

		MailMessage message = new MailMessage();

		message.setBody(body);
		message.setSubject(subject);
		message.setFrom(getCompanyAdminEmailAddr(request));
		message.setTo(to);
		message.setHTMLFormat(false);

		try {
			_log.error("message:" + message.toString());
			MailEngine.send(message);
			_log.error("message done");
		} catch (MailEngineException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static void notifySubscribers(long[] subscribers, long fromUserId, long toUserId, int badgeType) {
		
	}

	public static InternetAddress getCompanyAdminEmailAddr(PortletRequest request) {
		InternetAddress addr = new InternetAddress();
		Company company = null;
		try {
			company = PortalUtil.getCompany(request);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		if (company != null) {
			String strAddr = company.getEmailAddress();
			addr.setAddress(strAddr);
		};

		return addr;
	}

	private static String _getEmailAddr(long userId) {
		String emailAddr = "";
		
		try {
			User user = UserLocalServiceUtil.getUser(userId);

			emailAddr = user.getEmailAddress();
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}

		return emailAddr;
	}
	

	private static String _getUserName(long userId) {
		String userName = "";
		
		try {
			User user = UserLocalServiceUtil.getUser(userId);

			userName = user.getFullName();
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}

		return userName;
	}

	private static String _getBadgeName(int badgeType) {
		return (badgeType == 0) ? "Thank You":"Respect";
	}

	private static Logger _log = Logger.getLogger(Emails.class); 
}
