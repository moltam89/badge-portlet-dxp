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

package com.liferay.hu.badge.service.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.hu.badge.service.service.SubscriberServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link SubscriberServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Borkuti Peter
 * @see SubscriberServiceSoap
 * @see HttpPrincipal
 * @see SubscriberServiceUtil
 * @generated
 */
@ProviderType
public class SubscriberServiceHttp {
	public static void subscribe(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(SubscriberServiceUtil.class,
					"subscribe", _subscribeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static boolean isSubscribed(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(SubscriberServiceUtil.class,
					"isSubscribed", _isSubscribedParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.Long[] getSubscribers(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(SubscriberServiceUtil.class,
					"getSubscribers", _getSubscribersParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.Long[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SubscriberServiceHttp.class);
	private static final Class<?>[] _subscribeParameterTypes0 = new Class[] {  };
	private static final Class<?>[] _isSubscribedParameterTypes1 = new Class[] {  };
	private static final Class<?>[] _getSubscribersParameterTypes2 = new Class[] {
			
		};
}