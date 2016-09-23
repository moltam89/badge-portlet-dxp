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

import com.liferay.hu.badge.service.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class SubscriberClp extends BaseModelImpl<Subscriber>
	implements Subscriber {
	public SubscriberClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Subscriber.class;
	}

	@Override
	public String getModelClassName() {
		return Subscriber.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _subscriberId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubscriberId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subscriberId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subscriberId", getSubscriberId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("subscriberUserId", getSubscriberUserId());
		attributes.put("badgeType", getBadgeType());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subscriberId = (Long)attributes.get("subscriberId");

		if (subscriberId != null) {
			setSubscriberId(subscriberId);
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

		Long subscriberUserId = (Long)attributes.get("subscriberUserId");

		if (subscriberUserId != null) {
			setSubscriberUserId(subscriberUserId);
		}

		Long badgeType = (Long)attributes.get("badgeType");

		if (badgeType != null) {
			setBadgeType(badgeType);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getSubscriberId() {
		return _subscriberId;
	}

	@Override
	public void setSubscriberId(long subscriberId) {
		_subscriberId = subscriberId;

		if (_subscriberRemoteModel != null) {
			try {
				Class<?> clazz = _subscriberRemoteModel.getClass();

				Method method = clazz.getMethod("setSubscriberId", long.class);

				method.invoke(_subscriberRemoteModel, subscriberId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_subscriberRemoteModel != null) {
			try {
				Class<?> clazz = _subscriberRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_subscriberRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_subscriberRemoteModel != null) {
			try {
				Class<?> clazz = _subscriberRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_subscriberRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_subscriberRemoteModel != null) {
			try {
				Class<?> clazz = _subscriberRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_subscriberRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_subscriberRemoteModel != null) {
			try {
				Class<?> clazz = _subscriberRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_subscriberRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_subscriberRemoteModel != null) {
			try {
				Class<?> clazz = _subscriberRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_subscriberRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_subscriberRemoteModel != null) {
			try {
				Class<?> clazz = _subscriberRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_subscriberRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubscriberUserId() {
		return _subscriberUserId;
	}

	@Override
	public void setSubscriberUserId(long subscriberUserId) {
		_subscriberUserId = subscriberUserId;

		if (_subscriberRemoteModel != null) {
			try {
				Class<?> clazz = _subscriberRemoteModel.getClass();

				Method method = clazz.getMethod("setSubscriberUserId",
						long.class);

				method.invoke(_subscriberRemoteModel, subscriberUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubscriberUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getSubscriberUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setSubscriberUserUuid(String subscriberUserUuid) {
	}

	@Override
	public long getBadgeType() {
		return _badgeType;
	}

	@Override
	public void setBadgeType(long badgeType) {
		_badgeType = badgeType;

		if (_subscriberRemoteModel != null) {
			try {
				Class<?> clazz = _subscriberRemoteModel.getClass();

				Method method = clazz.getMethod("setBadgeType", long.class);

				method.invoke(_subscriberRemoteModel, badgeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSubscriberRemoteModel() {
		return _subscriberRemoteModel;
	}

	public void setSubscriberRemoteModel(BaseModel<?> subscriberRemoteModel) {
		_subscriberRemoteModel = subscriberRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _subscriberRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_subscriberRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public Subscriber toEscapedModel() {
		return (Subscriber)ProxyUtil.newProxyInstance(Subscriber.class.getClassLoader(),
			new Class[] { Subscriber.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubscriberClp clone = new SubscriberClp();

		clone.setSubscriberId(getSubscriberId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSubscriberUserId(getSubscriberUserId());
		clone.setBadgeType(getBadgeType());

		return clone;
	}

	@Override
	public int compareTo(Subscriber subscriber) {
		long primaryKey = subscriber.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubscriberClp)) {
			return false;
		}

		SubscriberClp subscriber = (SubscriberClp)obj;

		long primaryKey = subscriber.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{subscriberId=");
		sb.append(getSubscriberId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", subscriberUserId=");
		sb.append(getSubscriberUserId());
		sb.append(", badgeType=");
		sb.append(getBadgeType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hu.badge.service.model.Subscriber");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>subscriberId</column-name><column-value><![CDATA[");
		sb.append(getSubscriberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscriberUserId</column-name><column-value><![CDATA[");
		sb.append(getSubscriberUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>badgeType</column-name><column-value><![CDATA[");
		sb.append(getBadgeType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _subscriberRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}