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

package com.liferay.hu.badge.service.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.hu.badge.service.service.SubscriberServiceUtil;

import java.util.Arrays;

/**
 * @author Borkuti Peter
 * @generated
 */
@ProviderType
public class SubscriberServiceClpInvoker {
	public SubscriberServiceClpInvoker() {
		_methodName26 = "getOSGiServiceIdentifier";

		_methodParameterTypes26 = new String[] {  };

		_methodName31 = "subscribe";

		_methodParameterTypes31 = new String[] {  };

		_methodName32 = "isSubscribed";

		_methodParameterTypes32 = new String[] {  };

		_methodName33 = "getSubscribers";

		_methodParameterTypes33 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SubscriberServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			SubscriberServiceUtil.subscribe();

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SubscriberServiceUtil.isSubscribed();
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SubscriberServiceUtil.getSubscribers();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
}