create table FOO_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table studentData (
	studentId INTEGER not null primary key,
	name VARCHAR(75) null,
	lastname VARCHAR(75) null,
	std VARCHAR(75) null,
	address VARCHAR(75) null,
	phone VARCHAR(75) null,
	gender VARCHAR(75) null
);