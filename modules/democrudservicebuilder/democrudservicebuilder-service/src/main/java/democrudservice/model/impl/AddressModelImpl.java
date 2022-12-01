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

package democrudservice.model.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import democrudservice.model.Address;
import democrudservice.model.AddressModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Address service. Represents a row in the &quot;stud_Address&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AddressModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AddressImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressImpl
 * @generated
 */
@JSON(strict = true)
public class AddressModelImpl
	extends BaseModelImpl<Address> implements AddressModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a address model instance should use the <code>Address</code> interface instead.
	 */
	public static final String TABLE_NAME = "stud_Address";

	public static final Object[][] TABLE_COLUMNS = {
		{"addressId", Types.VARCHAR}, {"addressField1", Types.VARCHAR},
		{"addressField2", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("addressId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("addressField1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("addressField2", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table stud_Address (addressId VARCHAR(75) not null primary key,addressField1 VARCHAR(75) null,addressField2 VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table stud_Address";

	public static final String ORDER_BY_JPQL =
		" ORDER BY address.addressId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY stud_Address.addressId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ADDRESSID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public static final String MAPPING_TABLE_STUD_STUDENT_ADDRESS_NAME =
		"stud_Student_Address";

	public static final Object[][] MAPPING_TABLE_STUD_STUDENT_ADDRESS_COLUMNS =
		{
			{"companyId", Types.BIGINT}, {"addressId", Types.VARCHAR},
			{"studentId", Types.BIGINT}
		};

	public static final String MAPPING_TABLE_STUD_STUDENT_ADDRESS_SQL_CREATE =
		"create table stud_Student_Address (companyId LONG not null,addressId VARCHAR(75) not null,studentId LONG not null,primary key (addressId, studentId))";

	public AddressModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _addressId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setAddressId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _addressId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Address.class;
	}

	@Override
	public String getModelClassName() {
		return Address.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Address, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Address, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Address, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Address)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Address, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Address, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Address)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Address, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Address, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Address, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Address, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Address, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Address, Object>>();
		Map<String, BiConsumer<Address, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Address, ?>>();

		attributeGetterFunctions.put("addressId", Address::getAddressId);
		attributeSetterBiConsumers.put(
			"addressId", (BiConsumer<Address, String>)Address::setAddressId);
		attributeGetterFunctions.put(
			"addressField1", Address::getAddressField1);
		attributeSetterBiConsumers.put(
			"addressField1",
			(BiConsumer<Address, String>)Address::setAddressField1);
		attributeGetterFunctions.put(
			"addressField2", Address::getAddressField2);
		attributeSetterBiConsumers.put(
			"addressField2",
			(BiConsumer<Address, String>)Address::setAddressField2);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getAddressId() {
		if (_addressId == null) {
			return "";
		}
		else {
			return _addressId;
		}
	}

	@Override
	public void setAddressId(String addressId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_addressId = addressId;
	}

	@JSON
	@Override
	public String getAddressField1() {
		if (_addressField1 == null) {
			return "";
		}
		else {
			return _addressField1;
		}
	}

	@Override
	public void setAddressField1(String addressField1) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_addressField1 = addressField1;
	}

	@JSON
	@Override
	public String getAddressField2() {
		if (_addressField2 == null) {
			return "";
		}
		else {
			return _addressField2;
		}
	}

	@Override
	public void setAddressField2(String addressField2) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_addressField2 = addressField2;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public Address toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Address>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AddressImpl addressImpl = new AddressImpl();

		addressImpl.setAddressId(getAddressId());
		addressImpl.setAddressField1(getAddressField1());
		addressImpl.setAddressField2(getAddressField2());

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	@Override
	public Address cloneWithOriginalValues() {
		AddressImpl addressImpl = new AddressImpl();

		addressImpl.setAddressId(
			this.<String>getColumnOriginalValue("addressId"));
		addressImpl.setAddressField1(
			this.<String>getColumnOriginalValue("addressField1"));
		addressImpl.setAddressField2(
			this.<String>getColumnOriginalValue("addressField2"));

		return addressImpl;
	}

	@Override
	public int compareTo(Address address) {
		String primaryKey = address.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Address)) {
			return false;
		}

		Address address = (Address)object;

		String primaryKey = address.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Address> toCacheModel() {
		AddressCacheModel addressCacheModel = new AddressCacheModel();

		addressCacheModel.addressId = getAddressId();

		String addressId = addressCacheModel.addressId;

		if ((addressId != null) && (addressId.length() == 0)) {
			addressCacheModel.addressId = null;
		}

		addressCacheModel.addressField1 = getAddressField1();

		String addressField1 = addressCacheModel.addressField1;

		if ((addressField1 != null) && (addressField1.length() == 0)) {
			addressCacheModel.addressField1 = null;
		}

		addressCacheModel.addressField2 = getAddressField2();

		String addressField2 = addressCacheModel.addressField2;

		if ((addressField2 != null) && (addressField2.length() == 0)) {
			addressCacheModel.addressField2 = null;
		}

		return addressCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Address, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Address, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Address, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Address)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Address, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Address, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Address, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Address)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Address>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Address.class, ModelWrapper.class);

	}

	private String _addressId;
	private String _addressField1;
	private String _addressField2;

	public <T> T getColumnValue(String columnName) {
		Function<Address, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Address)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("addressId", _addressId);
		_columnOriginalValues.put("addressField1", _addressField1);
		_columnOriginalValues.put("addressField2", _addressField2);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("addressId", 1L);

		columnBitmasks.put("addressField1", 2L);

		columnBitmasks.put("addressField2", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Address _escapedModel;

}