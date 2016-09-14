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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BadgeService}.
 *
 * @author Borkuti Peter
 * @see BadgeService
 * @generated
 */
@ProviderType
public class BadgeServiceWrapper implements BadgeService,
	ServiceWrapper<BadgeService> {
	public BadgeServiceWrapper(BadgeService badgeService) {
		_badgeService = badgeService;
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _badgeService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _badgeService.getOSGiServiceIdentifier();
	}

	@Override
	public BadgeService getWrappedService() {
		return _badgeService;
	}

	@Override
	public void setWrappedService(BadgeService badgeService) {
		_badgeService = badgeService;
	}

	private BadgeService _badgeService;
}