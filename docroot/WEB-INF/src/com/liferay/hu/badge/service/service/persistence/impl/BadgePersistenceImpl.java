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

package com.liferay.hu.badge.service.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.hu.badge.service.exception.NoSuchBadgeException;
import com.liferay.hu.badge.service.model.Badge;
import com.liferay.hu.badge.service.model.impl.BadgeImpl;
import com.liferay.hu.badge.service.model.impl.BadgeModelImpl;
import com.liferay.hu.badge.service.service.persistence.BadgePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Borkuti Peter
 * @see BadgePersistence
 * @see com.liferay.hu.badge.service.service.persistence.BadgeUtil
 * @generated
 */
@ProviderType
public class BadgePersistenceImpl extends BasePersistenceImpl<Badge>
	implements BadgePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BadgeUtil} to access the badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BadgeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BADGETYPE =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybadgeType",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybadgeType",
			new String[] { Long.class.getName() },
			BadgeModelImpl.BADGETYPE_COLUMN_BITMASK |
			BadgeModelImpl.ASSIGNDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BADGETYPE = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybadgeType",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the badges where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @return the matching badges
	 */
	@Override
	public List<Badge> findBybadgeType(long badgeType) {
		return findBybadgeType(badgeType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Badge> findBybadgeType(long badgeType, int start, int end) {
		return findBybadgeType(badgeType, start, end, null);
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
	@Override
	public List<Badge> findBybadgeType(long badgeType, int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return findBybadgeType(badgeType, start, end, orderByComparator, true);
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
	@Override
	public List<Badge> findBybadgeType(long badgeType, int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE;
			finderArgs = new Object[] { badgeType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BADGETYPE;
			finderArgs = new Object[] { badgeType, start, end, orderByComparator };
		}

		List<Badge> list = null;

		if (retrieveFromCache) {
			list = (List<Badge>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Badge badge : list) {
					if ((badgeType != badge.getBadgeType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_BADGETYPE_BADGETYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(badgeType);

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first badge in the ordered set where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findBybadgeType_First(long badgeType,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchBybadgeType_First(badgeType, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("badgeType=");
		msg.append(badgeType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the first badge in the ordered set where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchBybadgeType_First(long badgeType,
		OrderByComparator<Badge> orderByComparator) {
		List<Badge> list = findBybadgeType(badgeType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last badge in the ordered set where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findBybadgeType_Last(long badgeType,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchBybadgeType_Last(badgeType, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("badgeType=");
		msg.append(badgeType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the last badge in the ordered set where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchBybadgeType_Last(long badgeType,
		OrderByComparator<Badge> orderByComparator) {
		int count = countBybadgeType(badgeType);

		if (count == 0) {
			return null;
		}

		List<Badge> list = findBybadgeType(badgeType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Badge[] findBybadgeType_PrevAndNext(long badgeId, long badgeType,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = findByPrimaryKey(badgeId);

		Session session = null;

		try {
			session = openSession();

			Badge[] array = new BadgeImpl[3];

			array[0] = getBybadgeType_PrevAndNext(session, badge, badgeType,
					orderByComparator, true);

			array[1] = badge;

			array[2] = getBybadgeType_PrevAndNext(session, badge, badgeType,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Badge getBybadgeType_PrevAndNext(Session session, Badge badge,
		long badgeType, OrderByComparator<Badge> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BADGE_WHERE);

		query.append(_FINDER_COLUMN_BADGETYPE_BADGETYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(badgeType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Badge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the badges where badgeType = &#63; from the database.
	 *
	 * @param badgeType the badge type
	 */
	@Override
	public void removeBybadgeType(long badgeType) {
		for (Badge badge : findBybadgeType(badgeType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @return the number of matching badges
	 */
	@Override
	public int countBybadgeType(long badgeType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BADGETYPE;

		Object[] finderArgs = new Object[] { badgeType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_BADGETYPE_BADGETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(badgeType);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BADGETYPE_BADGETYPE_2 = "badge.badgeType = ?";

	public BadgePersistenceImpl() {
		setModelClass(Badge.class);
	}

	/**
	 * Caches the badge in the entity cache if it is enabled.
	 *
	 * @param badge the badge
	 */
	@Override
	public void cacheResult(Badge badge) {
		entityCache.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey(), badge);

		badge.resetOriginalValues();
	}

	/**
	 * Caches the badges in the entity cache if it is enabled.
	 *
	 * @param badges the badges
	 */
	@Override
	public void cacheResult(List<Badge> badges) {
		for (Badge badge : badges) {
			if (entityCache.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeImpl.class, badge.getPrimaryKey()) == null) {
				cacheResult(badge);
			}
			else {
				badge.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all badges.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BadgeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the badge.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Badge badge) {
		entityCache.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Badge> badges) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Badge badge : badges) {
			entityCache.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeImpl.class, badge.getPrimaryKey());
		}
	}

	/**
	 * Creates a new badge with the primary key. Does not add the badge to the database.
	 *
	 * @param badgeId the primary key for the new badge
	 * @return the new badge
	 */
	@Override
	public Badge create(long badgeId) {
		Badge badge = new BadgeImpl();

		badge.setNew(true);
		badge.setPrimaryKey(badgeId);

		badge.setCompanyId(companyProvider.getCompanyId());

		return badge;
	}

	/**
	 * Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge that was removed
	 * @throws NoSuchBadgeException if a badge with the primary key could not be found
	 */
	@Override
	public Badge remove(long badgeId) throws NoSuchBadgeException {
		return remove((Serializable)badgeId);
	}

	/**
	 * Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge that was removed
	 * @throws NoSuchBadgeException if a badge with the primary key could not be found
	 */
	@Override
	public Badge remove(Serializable primaryKey) throws NoSuchBadgeException {
		Session session = null;

		try {
			session = openSession();

			Badge badge = (Badge)session.get(BadgeImpl.class, primaryKey);

			if (badge == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(badge);
		}
		catch (NoSuchBadgeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Badge removeImpl(Badge badge) {
		badge = toUnwrappedModel(badge);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(badge)) {
				badge = (Badge)session.get(BadgeImpl.class,
						badge.getPrimaryKeyObj());
			}

			if (badge != null) {
				session.delete(badge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (badge != null) {
			clearCache(badge);
		}

		return badge;
	}

	@Override
	public Badge updateImpl(Badge badge) {
		badge = toUnwrappedModel(badge);

		boolean isNew = badge.isNew();

		BadgeModelImpl badgeModelImpl = (BadgeModelImpl)badge;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (badge.getCreateDate() == null)) {
			if (serviceContext == null) {
				badge.setCreateDate(now);
			}
			else {
				badge.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!badgeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				badge.setModifiedDate(now);
			}
			else {
				badge.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (badge.isNew()) {
				session.save(badge);

				badge.setNew(false);
			}
			else {
				badge = (Badge)session.merge(badge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BadgeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((badgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						badgeModelImpl.getOriginalBadgeType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BADGETYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE,
					args);

				args = new Object[] { badgeModelImpl.getBadgeType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BADGETYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE,
					args);
			}
		}

		entityCache.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey(), badge, false);

		badge.resetOriginalValues();

		return badge;
	}

	protected Badge toUnwrappedModel(Badge badge) {
		if (badge instanceof BadgeImpl) {
			return badge;
		}

		BadgeImpl badgeImpl = new BadgeImpl();

		badgeImpl.setNew(badge.isNew());
		badgeImpl.setPrimaryKey(badge.getPrimaryKey());

		badgeImpl.setBadgeId(badge.getBadgeId());
		badgeImpl.setGroupId(badge.getGroupId());
		badgeImpl.setCompanyId(badge.getCompanyId());
		badgeImpl.setUserId(badge.getUserId());
		badgeImpl.setUserName(badge.getUserName());
		badgeImpl.setCreateDate(badge.getCreateDate());
		badgeImpl.setModifiedDate(badge.getModifiedDate());
		badgeImpl.setBadgeType(badge.getBadgeType());
		badgeImpl.setAssignDate(badge.getAssignDate());
		badgeImpl.setToUser(badge.getToUser());
		badgeImpl.setToUserFullName(badge.getToUserFullName());
		badgeImpl.setFromUser(badge.getFromUser());
		badgeImpl.setFromUserFullName(badge.getFromUserFullName());
		badgeImpl.setDescription(badge.getDescription());

		return badgeImpl;
	}

	/**
	 * Returns the badge with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge
	 * @throws NoSuchBadgeException if a badge with the primary key could not be found
	 */
	@Override
	public Badge findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBadgeException {
		Badge badge = fetchByPrimaryKey(primaryKey);

		if (badge == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return badge;
	}

	/**
	 * Returns the badge with the primary key or throws a {@link NoSuchBadgeException} if it could not be found.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge
	 * @throws NoSuchBadgeException if a badge with the primary key could not be found
	 */
	@Override
	public Badge findByPrimaryKey(long badgeId) throws NoSuchBadgeException {
		return findByPrimaryKey((Serializable)badgeId);
	}

	/**
	 * Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge, or <code>null</code> if a badge with the primary key could not be found
	 */
	@Override
	public Badge fetchByPrimaryKey(Serializable primaryKey) {
		Badge badge = (Badge)entityCache.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeImpl.class, primaryKey);

		if (badge == _nullBadge) {
			return null;
		}

		if (badge == null) {
			Session session = null;

			try {
				session = openSession();

				badge = (Badge)session.get(BadgeImpl.class, primaryKey);

				if (badge != null) {
					cacheResult(badge);
				}
				else {
					entityCache.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeImpl.class, primaryKey, _nullBadge);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return badge;
	}

	/**
	 * Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge, or <code>null</code> if a badge with the primary key could not be found
	 */
	@Override
	public Badge fetchByPrimaryKey(long badgeId) {
		return fetchByPrimaryKey((Serializable)badgeId);
	}

	@Override
	public Map<Serializable, Badge> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Badge> map = new HashMap<Serializable, Badge>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Badge badge = fetchByPrimaryKey(primaryKey);

			if (badge != null) {
				map.put(primaryKey, badge);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Badge badge = (Badge)entityCache.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeImpl.class, primaryKey);

			if (badge == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, badge);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BADGE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Badge badge : (List<Badge>)q.list()) {
				map.put(badge.getPrimaryKeyObj(), badge);

				cacheResult(badge);

				uncachedPrimaryKeys.remove(badge.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeImpl.class, primaryKey, _nullBadge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the badges.
	 *
	 * @return the badges
	 */
	@Override
	public List<Badge> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Badge> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Badge> findAll(int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Badge> findAll(int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Badge> list = null;

		if (retrieveFromCache) {
			list = (List<Badge>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BADGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BADGE;

				if (pagination) {
					sql = sql.concat(BadgeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the badges from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Badge badge : findAll()) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges.
	 *
	 * @return the number of badges
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BADGE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BadgeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the badge persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BadgeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_BADGE = "SELECT badge FROM Badge badge";
	private static final String _SQL_SELECT_BADGE_WHERE_PKS_IN = "SELECT badge FROM Badge badge WHERE badgeId IN (";
	private static final String _SQL_SELECT_BADGE_WHERE = "SELECT badge FROM Badge badge WHERE ";
	private static final String _SQL_COUNT_BADGE = "SELECT COUNT(badge) FROM Badge badge";
	private static final String _SQL_COUNT_BADGE_WHERE = "SELECT COUNT(badge) FROM Badge badge WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "badge.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Badge exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Badge exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BadgePersistenceImpl.class);
	private static final Badge _nullBadge = new BadgeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Badge> toCacheModel() {
				return _nullBadgeCacheModel;
			}
		};

	private static final CacheModel<Badge> _nullBadgeCacheModel = new CacheModel<Badge>() {
			@Override
			public Badge toEntityModel() {
				return _nullBadge;
			}
		};
}