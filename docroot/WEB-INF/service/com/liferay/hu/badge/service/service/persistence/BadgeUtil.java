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

package com.liferay.hu.badge.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.hu.badge.service.model.Badge;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the badge service. This utility wraps {@link com.liferay.hu.badge.service.service.persistence.impl.BadgePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Borkuti Peter
 * @see BadgePersistence
 * @see com.liferay.hu.badge.service.service.persistence.impl.BadgePersistenceImpl
 * @generated
 */
@ProviderType
public class BadgeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Badge badge) {
		getPersistence().clearCache(badge);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Badge> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Badge> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Badge> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Badge update(Badge badge) {
		return getPersistence().update(badge);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Badge update(Badge badge, ServiceContext serviceContext) {
		return getPersistence().update(badge, serviceContext);
	}

	/**
	* Returns all the badges where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @return the matching badges
	*/
	public static List<Badge> findBybadgeType(long badgeType) {
		return getPersistence().findBybadgeType(badgeType);
	}

	/**
	* Returns a range of all the badges where badgeType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeType the badge type
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of matching badges
	*/
	public static List<Badge> findBybadgeType(long badgeType, int start, int end) {
		return getPersistence().findBybadgeType(badgeType, start, end);
	}

	/**
	* Returns an ordered range of all the badges where badgeType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeType the badge type
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findBybadgeType(long badgeType, int start,
		int end, OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .findBybadgeType(badgeType, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the badges where badgeType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeType the badge type
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findBybadgeType(long badgeType, int start,
		int end, OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybadgeType(badgeType, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findBybadgeType_First(long badgeType,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.hu.badge.service.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBybadgeType_First(badgeType, orderByComparator);
	}

	/**
	* Returns the first badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchBybadgeType_First(long badgeType,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .fetchBybadgeType_First(badgeType, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findBybadgeType_Last(long badgeType,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.hu.badge.service.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBybadgeType_Last(badgeType, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchBybadgeType_Last(long badgeType,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .fetchBybadgeType_Last(badgeType, orderByComparator);
	}

	/**
	* Returns the badges before and after the current badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge[] findBybadgeType_PrevAndNext(long badgeId,
		long badgeType, OrderByComparator<Badge> orderByComparator)
		throws com.liferay.hu.badge.service.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBybadgeType_PrevAndNext(badgeId, badgeType,
			orderByComparator);
	}

	/**
	* Removes all the badges where badgeType = &#63; from the database.
	*
	* @param badgeType the badge type
	*/
	public static void removeBybadgeType(long badgeType) {
		getPersistence().removeBybadgeType(badgeType);
	}

	/**
	* Returns the number of badges where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @return the number of matching badges
	*/
	public static int countBybadgeType(long badgeType) {
		return getPersistence().countBybadgeType(badgeType);
	}

	/**
	* Returns all the badges where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @return the matching badges
	*/
	public static List<Badge> findBybadgeTypeYearMontDayFromTo(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser) {
		return getPersistence()
				   .findBybadgeTypeYearMontDayFromTo(badgeType, assignYear,
			assignMonth, assignDay, fromUser, toUser);
	}

	/**
	* Returns a range of all the badges where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of matching badges
	*/
	public static List<Badge> findBybadgeTypeYearMontDayFromTo(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser, int start,
		int end) {
		return getPersistence()
				   .findBybadgeTypeYearMontDayFromTo(badgeType, assignYear,
			assignMonth, assignDay, fromUser, toUser, start, end);
	}

	/**
	* Returns an ordered range of all the badges where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findBybadgeTypeYearMontDayFromTo(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser, int start,
		int end, OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .findBybadgeTypeYearMontDayFromTo(badgeType, assignYear,
			assignMonth, assignDay, fromUser, toUser, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the badges where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findBybadgeTypeYearMontDayFromTo(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser, int start,
		int end, OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybadgeTypeYearMontDayFromTo(badgeType, assignYear,
			assignMonth, assignDay, fromUser, toUser, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first badge in the ordered set where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findBybadgeTypeYearMontDayFromTo_First(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.hu.badge.service.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBybadgeTypeYearMontDayFromTo_First(badgeType,
			assignYear, assignMonth, assignDay, fromUser, toUser,
			orderByComparator);
	}

	/**
	* Returns the first badge in the ordered set where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchBybadgeTypeYearMontDayFromTo_First(
		long badgeType, java.lang.Integer assignYear,
		java.lang.Integer assignMonth, java.lang.Integer assignDay,
		long fromUser, long toUser, OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .fetchBybadgeTypeYearMontDayFromTo_First(badgeType,
			assignYear, assignMonth, assignDay, fromUser, toUser,
			orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findBybadgeTypeYearMontDayFromTo_Last(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.hu.badge.service.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBybadgeTypeYearMontDayFromTo_Last(badgeType,
			assignYear, assignMonth, assignDay, fromUser, toUser,
			orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchBybadgeTypeYearMontDayFromTo_Last(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .fetchBybadgeTypeYearMontDayFromTo_Last(badgeType,
			assignYear, assignMonth, assignDay, fromUser, toUser,
			orderByComparator);
	}

	/**
	* Returns the badges before and after the current badge in the ordered set where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge[] findBybadgeTypeYearMontDayFromTo_PrevAndNext(
		long badgeId, long badgeType, java.lang.Integer assignYear,
		java.lang.Integer assignMonth, java.lang.Integer assignDay,
		long fromUser, long toUser, OrderByComparator<Badge> orderByComparator)
		throws com.liferay.hu.badge.service.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBybadgeTypeYearMontDayFromTo_PrevAndNext(badgeId,
			badgeType, assignYear, assignMonth, assignDay, fromUser, toUser,
			orderByComparator);
	}

	/**
	* Removes all the badges where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63; from the database.
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	*/
	public static void removeBybadgeTypeYearMontDayFromTo(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser) {
		getPersistence()
			.removeBybadgeTypeYearMontDayFromTo(badgeType, assignYear,
			assignMonth, assignDay, fromUser, toUser);
	}

	/**
	* Returns the number of badges where badgeType = &#63; and assignYear = &#63; and assignMonth = &#63; and assignDay = &#63; and fromUser = &#63; and toUser = &#63;.
	*
	* @param badgeType the badge type
	* @param assignYear the assign year
	* @param assignMonth the assign month
	* @param assignDay the assign day
	* @param fromUser the from user
	* @param toUser the to user
	* @return the number of matching badges
	*/
	public static int countBybadgeTypeYearMontDayFromTo(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser) {
		return getPersistence()
				   .countBybadgeTypeYearMontDayFromTo(badgeType, assignYear,
			assignMonth, assignDay, fromUser, toUser);
	}

	/**
	* Caches the badge in the entity cache if it is enabled.
	*
	* @param badge the badge
	*/
	public static void cacheResult(Badge badge) {
		getPersistence().cacheResult(badge);
	}

	/**
	* Caches the badges in the entity cache if it is enabled.
	*
	* @param badges the badges
	*/
	public static void cacheResult(List<Badge> badges) {
		getPersistence().cacheResult(badges);
	}

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	public static Badge create(long badgeId) {
		return getPersistence().create(badgeId);
	}

	/**
	* Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge remove(long badgeId)
		throws com.liferay.hu.badge.service.exception.NoSuchBadgeException {
		return getPersistence().remove(badgeId);
	}

	public static Badge updateImpl(Badge badge) {
		return getPersistence().updateImpl(badge);
	}

	/**
	* Returns the badge with the primary key or throws a {@link NoSuchBadgeException} if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge findByPrimaryKey(long badgeId)
		throws com.liferay.hu.badge.service.exception.NoSuchBadgeException {
		return getPersistence().findByPrimaryKey(badgeId);
	}

	/**
	* Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge, or <code>null</code> if a badge with the primary key could not be found
	*/
	public static Badge fetchByPrimaryKey(long badgeId) {
		return getPersistence().fetchByPrimaryKey(badgeId);
	}

	public static java.util.Map<java.io.Serializable, Badge> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the badges.
	*
	* @return the badges
	*/
	public static List<Badge> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of badges
	*/
	public static List<Badge> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of badges
	*/
	public static List<Badge> findAll(int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of badges
	*/
	public static List<Badge> findAll(int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the badges from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BadgePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BadgePersistence)PortletBeanLocatorUtil.locate(com.liferay.hu.badge.service.service.ClpSerializer.getServletContextName(),
					BadgePersistence.class.getName());

			ReferenceRegistry.registerReference(BadgeUtil.class, "_persistence");
		}

		return _persistence;
	}

	private static BadgePersistence _persistence;
}