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

package democrudservice.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;stud_Student_Address&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @see Student
 * @generated
 */
public class stud_Student_AddressTable
	extends BaseTable<stud_Student_AddressTable> {

	public static final stud_Student_AddressTable INSTANCE =
		new stud_Student_AddressTable();

	public final Column<stud_Student_AddressTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<stud_Student_AddressTable, String> addressId =
		createColumn(
			"addressId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<stud_Student_AddressTable, Long> studentId =
		createColumn(
			"studentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private stud_Student_AddressTable() {
		super("stud_Student_Address", stud_Student_AddressTable::new);
	}

}