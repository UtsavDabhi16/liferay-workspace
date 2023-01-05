create table Event_Data (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	SourceURL VARCHAR(75) null,
	hostName VARCHAR(75) null,
	Image VARCHAR(75) null,
	Address VARCHAR(75) null,
	Summary VARCHAR(75) null,
	TotalCount VARCHAR(75) null
);