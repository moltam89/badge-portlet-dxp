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
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Badge service. Represents a row in the &quot;BadgePortlet_Badge&quot; database table, with each column mapped to a property of this class.
 *
 * @author Borkuti Peter
 * @see BadgeModel
 * @see com.liferay.hu.badge.service.model.impl.BadgeImpl
 * @see com.liferay.hu.badge.service.model.impl.BadgeModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.hu.badge.service.model.impl.BadgeImpl")
@ProviderType
public interface Badge extends BadgeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.hu.badge.service.model.impl.BadgeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Badge, Long> BADGE_ID_ACCESSOR = new Accessor<Badge, Long>() {
			@Override
			public Long get(Badge badge) {
				return badge.getBadgeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Badge> getTypeClass() {
				return Badge.class;
			}
		};
}