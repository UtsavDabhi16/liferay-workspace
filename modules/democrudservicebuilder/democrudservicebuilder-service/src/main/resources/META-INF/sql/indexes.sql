create index IX_9ED19B71 on stud_Student (city[$COLUMN_LENGTH:75$]);
create index IX_D6D20698 on stud_Student (groupId);
create index IX_224380C7 on stud_Student (lastName[$COLUMN_LENGTH:75$]);

create index IX_6F135E21 on stud_Student_Address (companyId);
create index IX_19B594DF on stud_Student_Address (studentId);