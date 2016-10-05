package com.liferay.hu.badge.utils;

import java.util.Date;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.util.GroupThreadLocal;

public class Account {
	public final long companyId;
	public final long groupId;
	public final Date createDate;
	public final long currentUserId;

	public Account() {
		currentUserId = 0;
		companyId = CompanyThreadLocal.getCompanyId();
		groupId = GroupThreadLocal.getGroupId();
		createDate = new Date();
	}

	public Account(UserService userService) {
		User currentUser;

		long userId = 0;

		try {
			currentUser = userService.getCurrentUser();

			if (currentUser != null) {
				userId = currentUser.getUserId();
			}
		} catch (PortalException e1) {
			_log.debug(e1.getMessage());
		} catch (SystemException e1) {
			_log.debug(e1.getMessage());
		}

		currentUserId = userId;

		companyId = CompanyThreadLocal.getCompanyId();
		groupId = GroupThreadLocal.getGroupId();
		createDate = new Date();
	}

	private static final Logger _log = Logger.getLogger(Account.class);
}
