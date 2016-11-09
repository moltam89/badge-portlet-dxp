/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the applicable 
 * Liferay software end user license agreement ("License Agreement")
 * found on www.liferay.com/legal/eulas. You may also contact Liferay, Inc.
 * for a copy of the License Agreement. You may not use this file except in
 * compliance with the License Agreement. 
 * See the License Agreement for the specific language governing
 * permissions and limitations under the License Agreement, including 
 * but not limited to distribution rights of the Software.
 *
 */

package com.liferay.hu.badge.service.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.hu.badge.service.model.Badge;
import com.liferay.hu.badge.service.service.base.BadgeServiceBaseImpl;
import com.liferay.hu.badge.utils.Account;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the badge remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.hu.badge.service.service.BadgeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Borkuti Peter
 * @see BadgeServiceBaseImpl
 * @see com.liferay.hu.badge.service.service.BadgeServiceUtil
 */
@ProviderType
public class BadgeServiceImpl extends BadgeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.hu.badge.service.service.BadgeServiceUtil} to access the badge remote service.
	 */
	 	public boolean addBadge(Calendar date, long fromUserId, long toUserId,
			int badgeType, String description) {
	 	int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		int day = date.get(Calendar.DAY_OF_MONTH);

		Badge badge = _getBadge(badgeType, year, month, day, fromUserId, toUserId);

		Account account = new Account(userService);

		String fromUserName = _getUserFullNameById(fromUserId);
		String toUserName = _getUserFullNameById(toUserId);

		badge.setBadgeType(badgeType);
		badge.setDescription(description);
		badge.setToUser(toUserId);
		badge.setFromUser(fromUserId);
		badge.setAssignDate(date.getTime());
		badge.setAssignYear(date.get(Calendar.YEAR));
		badge.setAssignMonth(date.get(Calendar.MONTH));
		badge.setAssignDay(date.get(Calendar.DAY_OF_MONTH));
		badge.setToUserFullName(toUserName);
		badge.setFromUserFullName(fromUserName);

		badge.setCompanyId(account.companyId);
		badge.setCreateDate(account.createDate);
		badge.setGroupId(account.groupId);
		badge.setUserId(account.currentUserId);

		try {
			badgePersistence.update(badge);
		} catch (SystemException e) {
			_log.debug(e.getMessage());
			return false;
		}

		return true;
	}

	private String _getUserFullNameById(long userId) {
		String userName = "";
		try {
			User user = userLocalService.fetchUser(userId);
			userName = user.getFullName();
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		}

		return userName;
	}

	public List<Badge> getBadges() {
		List<Badge> badges = new ArrayList<Badge>();

		OrderByComparator obc = (OrderByComparator) OrderByComparatorFactoryUtil.create("badgeportlet_badge", "assignDate", false); 

		try {
			badges = badgePersistence.findAll(-1, -1, obc);
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		}

		return badges;
	}

	public List<Badge> getBadges(int badgeType) {
		List<Badge> badges = new ArrayList<Badge>();

		OrderByComparator obc = (OrderByComparator) OrderByComparatorFactoryUtil.create("badgeportlet_badge", "assignDate", false); 

		try {
			badges = badgePersistence.findBybadgeType(badgeType, -1, -1, obc);
		} catch (SystemException e) {
			_log.debug(e.getMessage());
		}

		return badges;
	}

	private Badge _getBadge(long badgeType, int year, int month, int day,
			long fromUserId, long toUserId) {
		Badge badge = null;

		List<Badge> badges =
				badgePersistence.findBybadgeTypeYearMontDayFromTo(badgeType,
					year, month, day, fromUserId, toUserId);

		if (badges.isEmpty()) {
			long badgeId = counterLocalService.increment();
			badge = badgePersistence.create(badgeId);
		}
		else {
			badge = badges.get(0);
		}

		return badge;
	}

	private static Logger _log = Logger.getLogger(BadgeServiceImpl.class); 

}