<%@page import="java.util.Collections"%>
<%@page import="com.liferay.hu.badge.service.service.BadgeServiceUtil"%>
<%@page import="com.liferay.hu.badge.service.service.SubscriberServiceUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.hu.badge.utils.Emails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.hu.badge.service.model.Badge"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.hu.badge.portlet.BadgePortlet"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"%>
<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

This is the <b>Badge v0.25</b> portlet.

<%
	OrderByComparator obc = (OrderByComparator)
		OrderByComparatorFactoryUtil.create("User", "fullName", true);

	List<User> users = new ArrayList<User>();
	{
		List<User> usersTmp = UserLocalServiceUtil.getUsers(-1, -1);

		for (User user: usersTmp) {
			if (user.isActive()) {
				users.add(user);
			}
		}
	}

	Collections.sort(users, obc);

	int badgeType = BadgePortlet.getBadgeType(portletPreferences);
	String badgeTypeString = BadgePortlet.getBadgeTypeString(badgeType);
	List<Badge> badges = BadgeServiceUtil.getBadges(badgeType);
	Calendar today = Calendar.getInstance();
	boolean isAdminMode = GetterUtil.getBoolean(portletPreferences.getValue("adminmode", "false"), false);
	boolean isSelfAdminMode = GetterUtil.getBoolean(portletPreferences.getValue("selfadminmode", "false"), false);
	User loggedInUser = (User) request.getAttribute(WebKeys.USER);
	long loggedInUserId = -1;
	if (loggedInUser != null) {
		loggedInUserId = loggedInUser.getUserId();
	}

	boolean isSubscribed = SubscriberServiceUtil.isSubscribed();

	//http://stackoverflow.com/questions/8413353/why-does-liferay-6-0-6-include-the-portlet-action-parameter-in-the-post-render-u
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:actionURL var="addBadgeURL" name="addBadgeAction"></portlet:actionURL>

<aui:form name="temp" action="#">
	<aui:input type="checkbox" name="subscribe" label="subscribe-to-badges"
		checked="<%= isSubscribed %>"
		onChange="Liferay.Service('/badge-portlet.subscriber/subscribe',function() {});"
	>
	</aui:input>
	<aui:input type="hidden" name="redirect" value="<%= redirect %>"></aui:input>
</aui:form>

 
<aui:form name="addBadgeForm" action="<%= addBadgeURL %>" method="POST">

	<% if (isAdminMode || isSelfAdminMode) {%>

	<liferay-ui:input-date
		name="assignDate"
		disabled="<%= false %>"
		dayValue="<%= today.get(Calendar.DAY_OF_MONTH) %>" dayParam="assignDay"
		monthValue="<%= today.get(Calendar.MONTH) %>" monthParam="assignMonth"
		yearValue="<%= today.get(Calendar.YEAR) %>" yearParam="assignYear"
		firstDayOfWeek="<%= today.getFirstDayOfWeek() - 1 %>"
	/>
	<% } %>

	<% if (isAdminMode) {%>
	<aui:select name="fromUser" title="from-user" required="true">
		<aui:option value="">Select the From user</aui:option>
		<% 
			for (User user: users) {
				Long userId = user.getUserId();
				String userName = Emails.getUserName(user);
				%>
				<aui:option value="<%= userId %>"><%= userName %></aui:option>
				<%
			}
		%>
	</aui:select>

	<% } %>

	<aui:select name="toUser" title="to-user" required="true">
		<aui:option value=""><%= LanguageUtil.get(request, "select-to-user") %></aui:option>
		<% 
			for (User user: users) {
				Long userId = user.getUserId();
				if (loggedInUserId != userId) {
					String userName = Emails.getUserName(user);
					%>
					<aui:option value="<%= userId %>"><%= userName %></aui:option>
					<%
				}
			}
		%>
	</aui:select>

	<aui:input name="description">
		<aui:validator name="maxLength">128</aui:validator>
	</aui:input>

	<aui:input type="submit" name="addBadgeSubmit" value="<%= LanguageUtil.get(request, "add-badge-" + badgeTypeString) %>" label="add-badge"></aui:input>
</aui:form>

<liferay-ui:search-container total="<%= badges.size() %>">

	<liferay-ui:search-container-results
		results="<%=
			badges.subList(
				searchContainer.getStart(),
				Math.min(searchContainer.getEnd(), badges.size()))
				%>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.hu.badge.service.model.Badge"
		modelVar="badge"
	>

<%-- When I used column-date, the date selector did not work in the input form --%>
	<liferay-ui:search-container-column-date
		property="assignDate"
		name="Date"
	/>

	<%
		String imgName = BadgePortlet.getBadgeTypeString(badge.getBadgeType());
	%>

	<liferay-ui:search-container-column-text name="badge-type">
		<img class="badgeimage" src="<%= request.getContextPath() %>/images/<%= imgName %>badge.png"/>
	</liferay-ui:search-container-column-text>

	<liferay-ui:search-container-column-text
		name="to-user"
		property="toUserFullName"
	/>

	<liferay-ui:search-container-column-text
		name="from-user"
		property="fromUserFullName"
	/>

	<liferay-ui:search-container-column-text
		name="description"
		property="description"
	/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>