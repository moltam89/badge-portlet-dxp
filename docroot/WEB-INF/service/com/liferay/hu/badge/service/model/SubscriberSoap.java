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
 * This class is used by SOAP remote services, specifically {@link com.liferay.hu.badge.service.service.http.SubscriberServiceSoap}.
 *
 * @author Borkuti Peter
 * @see com.liferay.hu.badge.service.service.http.SubscriberServiceSoap
 * @generated
 */
@ProviderType
public class SubscriberSoap implements Serializable {
	public static SubscriberSoap toSoapModel(Subscriber model) {
		SubscriberSoap soapModel = new SubscriberSoap();

		soapModel.setSubscriberId(model.getSubscriberId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSubscriberUserId(model.getSubscriberUserId());
		soapModel.setBadgeType(model.getBadgeType());

		return soapModel;
	}

	public static SubscriberSoap[] toSoapModels(Subscriber[] models) {
		SubscriberSoap[] soapModels = new SubscriberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubscriberSoap[][] toSoapModels(Subscriber[][] models) {
		SubscriberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubscriberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubscriberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubscriberSoap[] toSoapModels(List<Subscriber> models) {
		List<SubscriberSoap> soapModels = new ArrayList<SubscriberSoap>(models.size());

		for (Subscriber model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubscriberSoap[soapModels.size()]);
	}

	public SubscriberSoap() {
	}

	public long getPrimaryKey() {
		return _subscriberId;
	}

	public void setPrimaryKey(long pk) {
		setSubscriberId(pk);
	}

	public long getSubscriberId() {
		return _subscriberId;
	}

	public void setSubscriberId(long subscriberId) {
		_subscriberId = subscriberId;
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

	public long getSubscriberUserId() {
		return _subscriberUserId;
	}

	public void setSubscriberUserId(long subscriberUserId) {
		_subscriberUserId = subscriberUserId;
	}

	public long getBadgeType() {
		return _badgeType;
	}

	public void setBadgeType(long badgeType) {
		_badgeType = badgeType;
	}

	private long _subscriberId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _subscriberUserId;
	private long _badgeType;
}