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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Data}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Data
 * @generated
 */
public class DataWrapper
	extends BaseModelWrapper<Data> implements Data, ModelWrapper<Data> {

	public DataWrapper(Data data) {
		super(data);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
		attributes.put("SourceURL", getSourceURL());
		attributes.put("hostName", getHostName());
		attributes.put("Image", getImage());
		attributes.put("Address", getAddress());
		attributes.put("Summary", getSummary());
		attributes.put("TotalCount", getTotalCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String SourceURL = (String)attributes.get("SourceURL");

		if (SourceURL != null) {
			setSourceURL(SourceURL);
		}

		String hostName = (String)attributes.get("hostName");

		if (hostName != null) {
			setHostName(hostName);
		}

		String Image = (String)attributes.get("Image");

		if (Image != null) {
			setImage(Image);
		}

		String Address = (String)attributes.get("Address");

		if (Address != null) {
			setAddress(Address);
		}

		String Summary = (String)attributes.get("Summary");

		if (Summary != null) {
			setSummary(Summary);
		}

		String TotalCount = (String)attributes.get("TotalCount");

		if (TotalCount != null) {
			setTotalCount(TotalCount);
		}
	}

	@Override
	public Data cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this data.
	 *
	 * @return the address of this data
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the event ID of this data.
	 *
	 * @return the event ID of this data
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the host name of this data.
	 *
	 * @return the host name of this data
	 */
	@Override
	public String getHostName() {
		return model.getHostName();
	}

	/**
	 * Returns the image of this data.
	 *
	 * @return the image of this data
	 */
	@Override
	public String getImage() {
		return model.getImage();
	}

	/**
	 * Returns the primary key of this data.
	 *
	 * @return the primary key of this data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the source url of this data.
	 *
	 * @return the source url of this data
	 */
	@Override
	public String getSourceURL() {
		return model.getSourceURL();
	}

	/**
	 * Returns the summary of this data.
	 *
	 * @return the summary of this data
	 */
	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Returns the total count of this data.
	 *
	 * @return the total count of this data
	 */
	@Override
	public String getTotalCount() {
		return model.getTotalCount();
	}

	/**
	 * Returns the uuid of this data.
	 *
	 * @return the uuid of this data
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this data.
	 *
	 * @param Address the address of this data
	 */
	@Override
	public void setAddress(String Address) {
		model.setAddress(Address);
	}

	/**
	 * Sets the event ID of this data.
	 *
	 * @param eventId the event ID of this data
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the host name of this data.
	 *
	 * @param hostName the host name of this data
	 */
	@Override
	public void setHostName(String hostName) {
		model.setHostName(hostName);
	}

	/**
	 * Sets the image of this data.
	 *
	 * @param Image the image of this data
	 */
	@Override
	public void setImage(String Image) {
		model.setImage(Image);
	}

	/**
	 * Sets the primary key of this data.
	 *
	 * @param primaryKey the primary key of this data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the source url of this data.
	 *
	 * @param SourceURL the source url of this data
	 */
	@Override
	public void setSourceURL(String SourceURL) {
		model.setSourceURL(SourceURL);
	}

	/**
	 * Sets the summary of this data.
	 *
	 * @param Summary the summary of this data
	 */
	@Override
	public void setSummary(String Summary) {
		model.setSummary(Summary);
	}

	/**
	 * Sets the total count of this data.
	 *
	 * @param TotalCount the total count of this data
	 */
	@Override
	public void setTotalCount(String TotalCount) {
		model.setTotalCount(TotalCount);
	}

	/**
	 * Sets the uuid of this data.
	 *
	 * @param uuid the uuid of this data
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected DataWrapper wrap(Data data) {
		return new DataWrapper(data);
	}

}