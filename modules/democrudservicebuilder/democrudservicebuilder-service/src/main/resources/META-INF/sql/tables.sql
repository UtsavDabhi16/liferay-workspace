create table stud_Student (
	studentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createdby LONG,
	modifiedby VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	enrollmentNo VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	contactNo VARCHAR(75) null,
	city VARCHAR(75) null
);
create table stud_Address (
                              addressId VARCHAR(75) not null primary key,
                              addressField1 VARCHAR(75) null,
                              addressField2 VARCHAR(75) null
);

create table stud_Student_Address (
	companyId LONG not null,
	addressId VARCHAR(75) not null,
	studentId LONG not null,
	primary key (addressId, studentId)
);