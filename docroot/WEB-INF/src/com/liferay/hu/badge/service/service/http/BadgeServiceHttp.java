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

import com.liferay.hu.badge.service.service.BadgeServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link BadgeServiceUtil} service utility. The
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
 * @see BadgeServiceSoap
 * @see HttpPrincipal
 * @see BadgeServiceUtil
 * @generated
 */
@ProviderType
public class BadgeServiceHttp {
	public static boolean addBadge(HttpPrincipal httpPrincipal,
		java.util.Date date, long fromUserId, long toUserId, int badgeType,
		java.lang.String description) {
		try {
			MethodKey methodKey = new MethodKey(BadgeServiceUtil.class,
					"addBadge", _addBadgeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, date,
					fromUserId, toUserId, badgeType, description);

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

	public static java.util.List<com.liferay.hu.badge.service.model.Badge> getBadges(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(BadgeServiceUtil.class,
					"getBadges", _getBadgesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.hu.badge.service.model.Badge>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.hu.badge.service.model.Badge> getBadges(
		HttpPrincipal httpPrincipal, int badgeType) {
		try {
			MethodKey methodKey = new MethodKey(BadgeServiceUtil.class,
					"getBadges", _getBadgesParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, badgeType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.hu.badge.service.model.Badge>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BadgeServiceHttp.class);
	private static final Class<?>[] _addBadgeParameterTypes0 = new Class[] {
			java.util.Date.class, long.class, long.class, int.class,
			java.lang.String.class
		};
	private static final Class<?>[] _getBadgesParameterTypes2 = new Class[] {  };
	private static final Class<?>[] _getBadgesParameterTypes3 = new Class[] {
			int.class
		};
}