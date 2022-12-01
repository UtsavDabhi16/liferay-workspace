/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.searchservice.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;studentData&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
public class StudentTable extends BaseTable<StudentTable> {

	public static final StudentTable INSTANCE = new StudentTable();

	public final Column<StudentTable, Integer> studentId = createColumn(
		"studentId", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<StudentTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentTable, String> lastname = createColumn(
		"lastname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentTable, String> std = createColumn(
		"std", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private StudentTable() {
		super("studentData", StudentTable::new);
	}

}