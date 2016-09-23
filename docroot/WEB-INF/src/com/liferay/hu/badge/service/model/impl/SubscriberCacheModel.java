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

package com.liferay.hu.badge.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.hu.badge.service.model.Subscriber;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subscriber in entity cache.
 *
 * @author Borkuti Peter
 * @see Subscriber
 * @generated
 */
@ProviderType
public class SubscriberCacheModel implements CacheModel<Subscriber>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubscriberCacheModel)) {
			return false;
		}

		SubscriberCacheModel subscriberCacheModel = (SubscriberCacheModel)obj;

		if (subscriberId == subscriberCacheModel.subscriberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subscriberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{subscriberId=");
		sb.append(subscriberId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", subscriberUserId=");
		sb.append(subscriberUserId);
		sb.append(", badgeType=");
		sb.append(badgeType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subscriber toEntityModel() {
		SubscriberImpl subscriberImpl = new SubscriberImpl();

		subscriberImpl.setSubscriberId(subscriberId);
		subscriberImpl.setGroupId(groupId);
		subscriberImpl.setCompanyId(companyId);
		subscriberImpl.setUserId(userId);

		if (userName == null) {
			subscriberImpl.setUserName(StringPool.BLANK);
		}
		else {
			subscriberImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			subscriberImpl.setCreateDate(null);
		}
		else {
			subscriberImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subscriberImpl.setModifiedDate(null);
		}
		else {
			subscriberImpl.setModifiedDate(new Date(modifiedDate));
		}

		subscriberImpl.setSubscriberUserId(subscriberUserId);
		subscriberImpl.setBadgeType(badgeType);

		subscriberImpl.resetOriginalValues();

		return subscriberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		subscriberId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		subscriberUserId = objectInput.readLong();

		badgeType = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(subscriberId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(subscriberUserId);

		objectOutput.writeLong(badgeType);
	}

	public long subscriberId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long subscriberUserId;
	public long badgeType;
}