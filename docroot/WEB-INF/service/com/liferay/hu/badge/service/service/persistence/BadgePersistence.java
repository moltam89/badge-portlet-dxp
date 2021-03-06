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

import com.liferay.hu.badge.service.exception.NoSuchBadgeException;
import com.liferay.hu.badge.service.model.Badge;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Borkuti Peter
 * @see com.liferay.hu.badge.service.service.persistence.impl.BadgePersistenceImpl
 * @see BadgeUtil
 * @generated
 */
@ProviderType
public interface BadgePersistence extends BasePersistence<Badge> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BadgeUtil} to access the badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the badges where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @return the matching badges
	*/
	public java.util.List<Badge> findBybadgeType(long badgeType);

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
	public java.util.List<Badge> findBybadgeType(long badgeType, int start,
		int end);

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
	public java.util.List<Badge> findBybadgeType(long badgeType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public java.util.List<Badge> findBybadgeType(long badgeType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findBybadgeType_First(long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the first badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchBybadgeType_First(long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the last badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findBybadgeType_Last(long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the last badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchBybadgeType_Last(long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the badges before and after the current badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public Badge[] findBybadgeType_PrevAndNext(long badgeId, long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Removes all the badges where badgeType = &#63; from the database.
	*
	* @param badgeType the badge type
	*/
	public void removeBybadgeType(long badgeType);

	/**
	* Returns the number of badges where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @return the number of matching badges
	*/
	public int countBybadgeType(long badgeType);

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
	public java.util.List<Badge> findBybadgeTypeYearMontDayFromTo(
		long badgeType, java.lang.Integer assignYear,
		java.lang.Integer assignMonth, java.lang.Integer assignDay,
		long fromUser, long toUser);

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
	public java.util.List<Badge> findBybadgeTypeYearMontDayFromTo(
		long badgeType, java.lang.Integer assignYear,
		java.lang.Integer assignMonth, java.lang.Integer assignDay,
		long fromUser, long toUser, int start, int end);

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
	public java.util.List<Badge> findBybadgeTypeYearMontDayFromTo(
		long badgeType, java.lang.Integer assignYear,
		java.lang.Integer assignMonth, java.lang.Integer assignDay,
		long fromUser, long toUser, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public java.util.List<Badge> findBybadgeTypeYearMontDayFromTo(
		long badgeType, java.lang.Integer assignYear,
		java.lang.Integer assignMonth, java.lang.Integer assignDay,
		long fromUser, long toUser, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache);

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
	public Badge findBybadgeTypeYearMontDayFromTo_First(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

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
	public Badge fetchBybadgeTypeYearMontDayFromTo_First(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public Badge findBybadgeTypeYearMontDayFromTo_Last(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

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
	public Badge fetchBybadgeTypeYearMontDayFromTo_Last(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public Badge[] findBybadgeTypeYearMontDayFromTo_PrevAndNext(long badgeId,
		long badgeType, java.lang.Integer assignYear,
		java.lang.Integer assignMonth, java.lang.Integer assignDay,
		long fromUser, long toUser,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

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
	public void removeBybadgeTypeYearMontDayFromTo(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser);

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
	public int countBybadgeTypeYearMontDayFromTo(long badgeType,
		java.lang.Integer assignYear, java.lang.Integer assignMonth,
		java.lang.Integer assignDay, long fromUser, long toUser);

	/**
	* Caches the badge in the entity cache if it is enabled.
	*
	* @param badge the badge
	*/
	public void cacheResult(Badge badge);

	/**
	* Caches the badges in the entity cache if it is enabled.
	*
	* @param badges the badges
	*/
	public void cacheResult(java.util.List<Badge> badges);

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	public Badge create(long badgeId);

	/**
	* Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public Badge remove(long badgeId) throws NoSuchBadgeException;

	public Badge updateImpl(Badge badge);

	/**
	* Returns the badge with the primary key or throws a {@link NoSuchBadgeException} if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public Badge findByPrimaryKey(long badgeId) throws NoSuchBadgeException;

	/**
	* Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge, or <code>null</code> if a badge with the primary key could not be found
	*/
	public Badge fetchByPrimaryKey(long badgeId);

	@Override
	public java.util.Map<java.io.Serializable, Badge> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the badges.
	*
	* @return the badges
	*/
	public java.util.List<Badge> findAll();

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
	public java.util.List<Badge> findAll(int start, int end);

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
	public java.util.List<Badge> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public java.util.List<Badge> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the badges from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	*/
	public int countAll();
}