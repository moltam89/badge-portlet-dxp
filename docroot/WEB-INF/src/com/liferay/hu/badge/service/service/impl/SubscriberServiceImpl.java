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

import aQute.bnd.annotation.ProviderType;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.hu.badge.service.model.Subscriber;
import com.liferay.hu.badge.service.service.base.SubscriberServiceBaseImpl;
import com.liferay.hu.badge.utils.Account;
import com.liferay.portal.kernel.security.auth.PrincipalException;

/**
 * The implementation of the subscriber remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.hu.badge.service.service.SubscriberService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Borkuti Peter
 * @see SubscriberServiceBaseImpl
 * @see com.liferay.hu.badge.service.service.SubscriberServiceUtil
 */
@ProviderType
public class SubscriberServiceImpl extends SubscriberServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.hu.badge.service.service.SubscriberServiceUtil} to access the subscriber remote service.
	 */

	/**
	 * Subscribe/Unsubscribe for users
	 */
	public void subscribe() {
		try {
			long userId = getGuestOrUserId();

			List<Subscriber> subs = subscriberPersistence.findBysubscriberId(userId);

			//Subscribe
			if (subs.isEmpty()) {
				long subId = counterLocalService.increment();
				Subscriber sub = subscriberPersistence.create(subId);

				sub.setSubscriberId(subId);
				sub.setBadgeType(0);

				Account account = new Account(userService);

				sub.setUserId(account.currentUserId);
				sub.setCompanyId(account.companyId);
				sub.setCreateDate(account.createDate);
				sub.setGroupId(account.groupId);

				sub.setSubscriberUserId(account.currentUserId);

				subscriberPersistence.update(sub);
			}
			//Unsubscribe
			else {
				for (Subscriber sub: subs) {
					subscriberPersistence.remove(sub);
				}
			}

		} catch (PrincipalException e) {
			_log.error(e.getMessage());
		}
	}

	public boolean isSubscribed() {
		try {
			long userId = getGuestOrUserId();

			List<Subscriber> subs = subscriberPersistence.findBysubscriberId(userId);

			return !subs.isEmpty();

		} catch (PrincipalException e) {
			_log.error(e.getMessage());
		}

		return false;
	}

	public Long[] getSubscribers() {
		List<Subscriber> subs = subscriberPersistence.findAll();

		List<Long> subIds = new ArrayList<Long>();

		for (Subscriber s: subs) {
			subIds.add(s.getSubscriberUserId());
		}

		return subIds.toArray(new Long[0]);

	}

	private static Logger _log = Logger.getLogger(SubscriberServiceImpl.class);
}