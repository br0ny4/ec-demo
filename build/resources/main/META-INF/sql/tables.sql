create table EC_Product (
	uuid_ VARCHAR(75) null,
	productId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	detail VARCHAR(75) null,
	price INTEGER
);