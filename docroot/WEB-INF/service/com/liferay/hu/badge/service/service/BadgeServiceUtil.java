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

package com.liferay.hu.badge.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the remote service utility for Badge. This utility wraps
 * {@link com.liferay.hu.badge.service.service.impl.BadgeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Borkuti Peter
 * @see BadgeService
 * @see com.liferay.hu.badge.service.service.base.BadgeServiceBaseImpl
 * @see com.liferay.hu.badge.service.service.impl.BadgeServiceImpl
 * @generated
 */
@ProviderType
public class BadgeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.hu.badge.service.service.impl.BadgeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean addBadge(java.util.Date date, long fromUserId,
		long toUserId, int badgeType, java.lang.String description) {
		return getService()
				   .addBadge(date, fromUserId, toUserId, badgeType, description);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.hu.badge.service.model.Badge> getBadges() {
		return getService().getBadges();
	}

	public static java.util.List<com.liferay.hu.badge.service.model.Badge> getBadges(
		int badgeType) {
		return getService().getBadges(badgeType);
	}

	public static void clearService() {
		_service = null;
	}

	public static BadgeService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BadgeService.class.getName());

			if (invokableService instanceof BadgeService) {
				_service = (BadgeService)invokableService;
			}
			else {
				_service = new BadgeServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(BadgeServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static BadgeService _service;
}