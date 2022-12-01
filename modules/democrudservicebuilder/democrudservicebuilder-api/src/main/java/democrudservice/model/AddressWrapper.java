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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
public class AddressWrapper
	extends BaseModelWrapper<Address>
	implements Address, ModelWrapper<Address> {

	public AddressWrapper(Address address) {
		super(address);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("addressField1", getAddressField1());
		attributes.put("addressField2", getAddressField2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String addressId = (String)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		String addressField1 = (String)attributes.get("addressField1");

		if (addressField1 != null) {
			setAddressField1(addressField1);
		}

		String addressField2 = (String)attributes.get("addressField2");

		if (addressField2 != null) {
			setAddressField2(addressField2);
		}
	}

	@Override
	public Address cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address field1 of this address.
	 *
	 * @return the address field1 of this address
	 */
	@Override
	public String getAddressField1() {
		return model.getAddressField1();
	}

	/**
	 * Returns the address field2 of this address.
	 *
	 * @return the address field2 of this address
	 */
	@Override
	public String getAddressField2() {
		return model.getAddressField2();
	}

	/**
	 * Returns the address ID of this address.
	 *
	 * @return the address ID of this address
	 */
	@Override
	public String getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the primary key of this address.
	 *
	 * @return the primary key of this address
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address field1 of this address.
	 *
	 * @param addressField1 the address field1 of this address
	 */
	@Override
	public void setAddressField1(String addressField1) {
		model.setAddressField1(addressField1);
	}

	/**
	 * Sets the address field2 of this address.
	 *
	 * @param addressField2 the address field2 of this address
	 */
	@Override
	public void setAddressField2(String addressField2) {
		model.setAddressField2(addressField2);
	}

	/**
	 * Sets the address ID of this address.
	 *
	 * @param addressId the address ID of this address
	 */
	@Override
	public void setAddressId(String addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the primary key of this address.
	 *
	 * @param primaryKey the primary key of this address
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected AddressWrapper wrap(Address address) {
		return new AddressWrapper(address);
	}

}