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

package com.seconddemo.builder.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;employee&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
public class EmployeeTable extends BaseTable<EmployeeTable> {

	public static final EmployeeTable INSTANCE = new EmployeeTable();

	public final Column<EmployeeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, Integer> eid = createColumn(
		"eid", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<EmployeeTable, String> ename = createColumn(
		"ename", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EmployeeTable() {
		super("employee", EmployeeTable::new);
	}

}