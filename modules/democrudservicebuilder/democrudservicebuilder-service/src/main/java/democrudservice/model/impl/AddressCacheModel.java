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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import democrudservice.model.Address;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Address in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressCacheModel implements CacheModel<Address>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AddressCacheModel)) {
			return false;
		}

		AddressCacheModel addressCacheModel = (AddressCacheModel)object;

		if (addressId.equals(addressCacheModel.addressId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{addressId=");
		sb.append(addressId);
		sb.append(", addressField1=");
		sb.append(addressField1);
		sb.append(", addressField2=");
		sb.append(addressField2);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Address toEntityModel() {
		AddressImpl addressImpl = new AddressImpl();

		if (addressId == null) {
			addressImpl.setAddressId("");
		}
		else {
			addressImpl.setAddressId(addressId);
		}

		if (addressField1 == null) {
			addressImpl.setAddressField1("");
		}
		else {
			addressImpl.setAddressField1(addressField1);
		}

		if (addressField2 == null) {
			addressImpl.setAddressField2("");
		}
		else {
			addressImpl.setAddressField2(addressField2);
		}

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressId = objectInput.readUTF();
		addressField1 = objectInput.readUTF();
		addressField2 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (addressId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressId);
		}

		if (addressField1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressField1);
		}

		if (addressField2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressField2);
		}
	}

	public String addressId;
	public String addressField1;
	public String addressField2;

}