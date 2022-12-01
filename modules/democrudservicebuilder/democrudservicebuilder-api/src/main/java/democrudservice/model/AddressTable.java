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
 * The table class for the &quot;stud_Address&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
public class AddressTable extends BaseTable<AddressTable> {

	public static final AddressTable INSTANCE = new AddressTable();

	public final Column<AddressTable, String> addressId = createColumn(
		"addressId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<AddressTable, String> addressField1 = createColumn(
		"addressField1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> addressField2 = createColumn(
		"addressField2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AddressTable() {
		super("stud_Address", AddressTable::new);
	}

}