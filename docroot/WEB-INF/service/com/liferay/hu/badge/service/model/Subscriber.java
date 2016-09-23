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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Subscriber service. Represents a row in the &quot;BadgePortlet_Subscriber&quot; database table, with each column mapped to a property of this class.
 *
 * @author Borkuti Peter
 * @see SubscriberModel
 * @see com.liferay.hu.badge.service.model.impl.SubscriberImpl
 * @see com.liferay.hu.badge.service.model.impl.SubscriberModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.hu.badge.service.model.impl.SubscriberImpl")
@ProviderType
public interface Subscriber extends SubscriberModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.hu.badge.service.model.impl.SubscriberImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Subscriber, Long> SUBSCRIBER_ID_ACCESSOR = new Accessor<Subscriber, Long>() {
			@Override
			public Long get(Subscriber subscriber) {
				return subscriber.getSubscriberId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Subscriber> getTypeClass() {
				return Subscriber.class;
			}
		};
}