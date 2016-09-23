create table BadgePortlet_Badge (
	badgeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	badgeType LONG,
	assignDate DATE null,
	toUser LONG,
	toUserFullName VARCHAR(75) null,
	fromUser LONG,
	fromUserFullName VARCHAR(75) null,
	description VARCHAR(75) null
);

create table BadgePortlet_Subscriber (
	subscriberId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	subscriberUserId LONG,
	badgeType LONG
);

create table BadgePortlet_Subscribers (
	subscriberId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	subscriberUserId LONG,
	badgeType LONG
);