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

package com.liferay.hu.badge.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Badge}.
 * </p>
 *
 * @author Borkuti Peter
 * @see Badge
 * @generated
 */
@ProviderType
public class BadgeWrapper implements Badge, ModelWrapper<Badge> {
	public BadgeWrapper(Badge badge) {
		_badge = badge;
	}

	@Override
	public Class<?> getModelClass() {
		return Badge.class;
	}

	@Override
	public String getModelClassName() {
		return Badge.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("badgeId", getBadgeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("badgeType", getBadgeType());
		attributes.put("assignDate", getAssignDate());
		attributes.put("toUser", getToUser());
		attributes.put("toUserFullName", getToUserFullName());
		attributes.put("fromUser", getFromUser());
		attributes.put("fromUserFullName", getFromUserFullName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long badgeId = (Long)attributes.get("badgeId");

		if (badgeId != null) {
			setBadgeId(badgeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long badgeType = (Long)attributes.get("badgeType");

		if (badgeType != null) {
			setBadgeType(badgeType);
		}

		Date assignDate = (Date)attributes.get("assignDate");

		if (assignDate != null) {
			setAssignDate(assignDate);
		}

		Long toUser = (Long)attributes.get("toUser");

		if (toUser != null) {
			setToUser(toUser);
		}

		String toUserFullName = (String)attributes.get("toUserFullName");

		if (toUserFullName != null) {
			setToUserFullName(toUserFullName);
		}

		Long fromUser = (Long)attributes.get("fromUser");

		if (fromUser != null) {
			setFromUser(fromUser);
		}

		String fromUserFullName = (String)attributes.get("fromUserFullName");

		if (fromUserFullName != null) {
			setFromUserFullName(fromUserFullName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public Badge toEscapedModel() {
		return new BadgeWrapper(_badge.toEscapedModel());
	}

	@Override
	public Badge toUnescapedModel() {
		return new BadgeWrapper(_badge.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _badge.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _badge.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _badge.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _badge.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Badge> toCacheModel() {
		return _badge.toCacheModel();
	}

	@Override
	public int compareTo(Badge badge) {
		return _badge.compareTo(badge);
	}

	@Override
	public int hashCode() {
		return _badge.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _badge.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BadgeWrapper((Badge)_badge.clone());
	}

	/**
	* Returns the description of this badge.
	*
	* @return the description of this badge
	*/
	@Override
	public java.lang.String getDescription() {
		return _badge.getDescription();
	}

	/**
	* Returns the from user full name of this badge.
	*
	* @return the from user full name of this badge
	*/
	@Override
	public java.lang.String getFromUserFullName() {
		return _badge.getFromUserFullName();
	}

	/**
	* Returns the to user full name of this badge.
	*
	* @return the to user full name of this badge
	*/
	@Override
	public java.lang.String getToUserFullName() {
		return _badge.getToUserFullName();
	}

	/**
	* Returns the user name of this badge.
	*
	* @return the user name of this badge
	*/
	@Override
	public java.lang.String getUserName() {
		return _badge.getUserName();
	}

	/**
	* Returns the user uuid of this badge.
	*
	* @return the user uuid of this badge
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _badge.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _badge.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _badge.toXmlString();
	}

	/**
	* Returns the assign date of this badge.
	*
	* @return the assign date of this badge
	*/
	@Override
	public Date getAssignDate() {
		return _badge.getAssignDate();
	}

	/**
	* Returns the create date of this badge.
	*
	* @return the create date of this badge
	*/
	@Override
	public Date getCreateDate() {
		return _badge.getCreateDate();
	}

	/**
	* Returns the modified date of this badge.
	*
	* @return the modified date of this badge
	*/
	@Override
	public Date getModifiedDate() {
		return _badge.getModifiedDate();
	}

	/**
	* Returns the badge ID of this badge.
	*
	* @return the badge ID of this badge
	*/
	@Override
	public long getBadgeId() {
		return _badge.getBadgeId();
	}

	/**
	* Returns the badge type of this badge.
	*
	* @return the badge type of this badge
	*/
	@Override
	public long getBadgeType() {
		return _badge.getBadgeType();
	}

	/**
	* Returns the company ID of this badge.
	*
	* @return the company ID of this badge
	*/
	@Override
	public long getCompanyId() {
		return _badge.getCompanyId();
	}

	/**
	* Returns the from user of this badge.
	*
	* @return the from user of this badge
	*/
	@Override
	public long getFromUser() {
		return _badge.getFromUser();
	}

	/**
	* Returns the group ID of this badge.
	*
	* @return the group ID of this badge
	*/
	@Override
	public long getGroupId() {
		return _badge.getGroupId();
	}

	/**
	* Returns the primary key of this badge.
	*
	* @return the primary key of this badge
	*/
	@Override
	public long getPrimaryKey() {
		return _badge.getPrimaryKey();
	}

	/**
	* Returns the to user of this badge.
	*
	* @return the to user of this badge
	*/
	@Override
	public long getToUser() {
		return _badge.getToUser();
	}

	/**
	* Returns the user ID of this badge.
	*
	* @return the user ID of this badge
	*/
	@Override
	public long getUserId() {
		return _badge.getUserId();
	}

	@Override
	public void persist() {
		_badge.persist();
	}

	/**
	* Sets the assign date of this badge.
	*
	* @param assignDate the assign date of this badge
	*/
	@Override
	public void setAssignDate(Date assignDate) {
		_badge.setAssignDate(assignDate);
	}

	/**
	* Sets the badge ID of this badge.
	*
	* @param badgeId the badge ID of this badge
	*/
	@Override
	public void setBadgeId(long badgeId) {
		_badge.setBadgeId(badgeId);
	}

	/**
	* Sets the badge type of this badge.
	*
	* @param badgeType the badge type of this badge
	*/
	@Override
	public void setBadgeType(long badgeType) {
		_badge.setBadgeType(badgeType);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_badge.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this badge.
	*
	* @param companyId the company ID of this badge
	*/
	@Override
	public void setCompanyId(long companyId) {
		_badge.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this badge.
	*
	* @param createDate the create date of this badge
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_badge.setCreateDate(createDate);
	}

	/**
	* Sets the description of this badge.
	*
	* @param description the description of this badge
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_badge.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_badge.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_badge.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_badge.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the from user of this badge.
	*
	* @param fromUser the from user of this badge
	*/
	@Override
	public void setFromUser(long fromUser) {
		_badge.setFromUser(fromUser);
	}

	/**
	* Sets the from user full name of this badge.
	*
	* @param fromUserFullName the from user full name of this badge
	*/
	@Override
	public void setFromUserFullName(java.lang.String fromUserFullName) {
		_badge.setFromUserFullName(fromUserFullName);
	}

	/**
	* Sets the group ID of this badge.
	*
	* @param groupId the group ID of this badge
	*/
	@Override
	public void setGroupId(long groupId) {
		_badge.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this badge.
	*
	* @param modifiedDate the modified date of this badge
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_badge.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_badge.setNew(n);
	}

	/**
	* Sets the primary key of this badge.
	*
	* @param primaryKey the primary key of this badge
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_badge.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_badge.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the to user of this badge.
	*
	* @param toUser the to user of this badge
	*/
	@Override
	public void setToUser(long toUser) {
		_badge.setToUser(toUser);
	}

	/**
	* Sets the to user full name of this badge.
	*
	* @param toUserFullName the to user full name of this badge
	*/
	@Override
	public void setToUserFullName(java.lang.String toUserFullName) {
		_badge.setToUserFullName(toUserFullName);
	}

	/**
	* Sets the user ID of this badge.
	*
	* @param userId the user ID of this badge
	*/
	@Override
	public void setUserId(long userId) {
		_badge.setUserId(userId);
	}

	/**
	* Sets the user name of this badge.
	*
	* @param userName the user name of this badge
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_badge.setUserName(userName);
	}

	/**
	* Sets the user uuid of this badge.
	*
	* @param userUuid the user uuid of this badge
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_badge.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeWrapper)) {
			return false;
		}

		BadgeWrapper badgeWrapper = (BadgeWrapper)obj;

		if (Objects.equals(_badge, badgeWrapper._badge)) {
			return true;
		}

		return false;
	}

	@Override
	public Badge getWrappedModel() {
		return _badge;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _badge.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _badge.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_badge.resetOriginalValues();
	}

	private final Badge _badge;
}