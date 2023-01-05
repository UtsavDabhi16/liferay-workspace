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

package eventdemo.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eventdemo.model.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Data in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataCacheModel implements CacheModel<Data>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataCacheModel)) {
			return false;
		}

		DataCacheModel dataCacheModel = (DataCacheModel)object;

		if (eventId == dataCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", SourceURL=");
		sb.append(SourceURL);
		sb.append(", hostName=");
		sb.append(hostName);
		sb.append(", Image=");
		sb.append(Image);
		sb.append(", Address=");
		sb.append(Address);
		sb.append(", Summary=");
		sb.append(Summary);
		sb.append(", TotalCount=");
		sb.append(TotalCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Data toEntityModel() {
		DataImpl dataImpl = new DataImpl();

		if (uuid == null) {
			dataImpl.setUuid("");
		}
		else {
			dataImpl.setUuid(uuid);
		}

		dataImpl.setEventId(eventId);

		if (SourceURL == null) {
			dataImpl.setSourceURL("");
		}
		else {
			dataImpl.setSourceURL(SourceURL);
		}

		if (hostName == null) {
			dataImpl.setHostName("");
		}
		else {
			dataImpl.setHostName(hostName);
		}

		if (Image == null) {
			dataImpl.setImage("");
		}
		else {
			dataImpl.setImage(Image);
		}

		if (Address == null) {
			dataImpl.setAddress("");
		}
		else {
			dataImpl.setAddress(Address);
		}

		if (Summary == null) {
			dataImpl.setSummary("");
		}
		else {
			dataImpl.setSummary(Summary);
		}

		if (TotalCount == null) {
			dataImpl.setTotalCount("");
		}
		else {
			dataImpl.setTotalCount(TotalCount);
		}

		dataImpl.resetOriginalValues();

		return dataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventId = objectInput.readLong();
		SourceURL = objectInput.readUTF();
		hostName = objectInput.readUTF();
		Image = objectInput.readUTF();
		Address = objectInput.readUTF();
		Summary = objectInput.readUTF();
		TotalCount = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventId);

		if (SourceURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SourceURL);
		}

		if (hostName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hostName);
		}

		if (Image == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Image);
		}

		if (Address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Address);
		}

		if (Summary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Summary);
		}

		if (TotalCount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TotalCount);
		}
	}

	public String uuid;
	public long eventId;
	public String SourceURL;
	public String hostName;
	public String Image;
	public String Address;
	public String Summary;
	public String TotalCount;

}