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

package eventdemo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Event_Data&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Data
 * @generated
 */
public class DataTable extends BaseTable<DataTable> {

	public static final DataTable INSTANCE = new DataTable();

	public final Column<DataTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DataTable, Long> eventId = createColumn(
		"eventId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DataTable, String> SourceURL = createColumn(
		"SourceURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DataTable, String> hostName = createColumn(
		"hostName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DataTable, String> Image = createColumn(
		"Image", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DataTable, String> Address = createColumn(
		"Address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DataTable, String> Summary = createColumn(
		"Summary", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DataTable, String> TotalCount = createColumn(
		"TotalCount", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DataTable() {
		super("Event_Data", DataTable::new);
	}

}