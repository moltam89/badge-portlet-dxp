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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.hu.badge.service.service.http.BadgeServiceSoap}.
 *
 * @author Borkuti Peter
 * @see com.liferay.hu.badge.service.service.http.BadgeServiceSoap
 * @generated
 */
@ProviderType
public class BadgeSoap implements Serializable {
	public static BadgeSoap toSoapModel(Badge model) {
		BadgeSoap soapModel = new BadgeSoap();

		soapModel.setBadgeId(model.getBadgeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBadgeType(model.getBadgeType());
		soapModel.setAssignDate(model.getAssignDate());
		soapModel.setAssignYear(model.getAssignYear());
		soapModel.setAssignMonth(model.getAssignMonth());
		soapModel.setAssignDay(model.getAssignDay());
		soapModel.setToUser(model.getToUser());
		soapModel.setToUserFullName(model.getToUserFullName());
		soapModel.setFromUser(model.getFromUser());
		soapModel.setFromUserFullName(model.getFromUserFullName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static BadgeSoap[] toSoapModels(Badge[] models) {
		BadgeSoap[] soapModels = new BadgeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BadgeSoap[][] toSoapModels(Badge[][] models) {
		BadgeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BadgeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BadgeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BadgeSoap[] toSoapModels(List<Badge> models) {
		List<BadgeSoap> soapModels = new ArrayList<BadgeSoap>(models.size());

		for (Badge model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BadgeSoap[soapModels.size()]);
	}

	public BadgeSoap() {
	}

	public long getPrimaryKey() {
		return _badgeId;
	}

	public void setPrimaryKey(long pk) {
		setBadgeId(pk);
	}

	public long getBadgeId() {
		return _badgeId;
	}

	public void setBadgeId(long badgeId) {
		_badgeId = badgeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getBadgeType() {
		return _badgeType;
	}

	public void setBadgeType(long badgeType) {
		_badgeType = badgeType;
	}

	public Date getAssignDate() {
		return _assignDate;
	}

	public void setAssignDate(Date assignDate) {
		_assignDate = assignDate;
	}

	public Integer getAssignYear() {
		return _assignYear;
	}

	public void setAssignYear(Integer assignYear) {
		_assignYear = assignYear;
	}

	public Integer getAssignMonth() {
		return _assignMonth;
	}

	public void setAssignMonth(Integer assignMonth) {
		_assignMonth = assignMonth;
	}

	public Integer getAssignDay() {
		return _assignDay;
	}

	public void setAssignDay(Integer assignDay) {
		_assignDay = assignDay;
	}

	public long getToUser() {
		return _toUser;
	}

	public void setToUser(long toUser) {
		_toUser = toUser;
	}

	public String getToUserFullName() {
		return _toUserFullName;
	}

	public void setToUserFullName(String toUserFullName) {
		_toUserFullName = toUserFullName;
	}

	public long getFromUser() {
		return _fromUser;
	}

	public void setFromUser(long fromUser) {
		_fromUser = fromUser;
	}

	public String getFromUserFullName() {
		return _fromUserFullName;
	}

	public void setFromUserFullName(String fromUserFullName) {
		_fromUserFullName = fromUserFullName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _badgeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _badgeType;
	private Date _assignDate;
	private Integer _assignYear;
	private Integer _assignMonth;
	private Integer _assignDay;
	private long _toUser;
	private String _toUserFullName;
	private long _fromUser;
	private String _fromUserFullName;
	private String _description;
}