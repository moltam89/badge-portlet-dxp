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
 * Provides a wrapper for {@link SubscriberService}.
 *
 * @author Borkuti Peter
 * @see SubscriberService
 * @generated
 */
@ProviderType
public class SubscriberServiceWrapper implements SubscriberService,
	ServiceWrapper<SubscriberService> {
	public SubscriberServiceWrapper(SubscriberService subscriberService) {
		_subscriberService = subscriberService;
	}

	@Override
	public boolean isSubscribed() {
		return _subscriberService.isSubscribed();
	}

	@Override
	public java.lang.Long[] getSubscribers() {
		return _subscriberService.getSubscribers();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _subscriberService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _subscriberService.getOSGiServiceIdentifier();
	}

	/**
	* Subscribe/Unsubscribe for users
	*/
	@Override
	public void subscribe() {
		_subscriberService.subscribe();
	}

	@Override
	public SubscriberService getWrappedService() {
		return _subscriberService;
	}

	@Override
	public void setWrappedService(SubscriberService subscriberService) {
		_subscriberService = subscriberService;
	}

	private SubscriberService _subscriberService;
}