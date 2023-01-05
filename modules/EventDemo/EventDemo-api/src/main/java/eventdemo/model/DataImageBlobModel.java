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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the Image column in Data.
 *
 * @author Brian Wing Shun Chan
 * @see Data
 * @generated
 */
public class DataImageBlobModel {

	public DataImageBlobModel() {
	}

	public DataImageBlobModel(long eventId) {
		_eventId = eventId;
	}

	public DataImageBlobModel(long eventId, Blob ImageBlob) {
		_eventId = eventId;
		_ImageBlob = ImageBlob;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public Blob getImageBlob() {
		return _ImageBlob;
	}

	public void setImageBlob(Blob ImageBlob) {
		_ImageBlob = ImageBlob;
	}

	private long _eventId;
	private Blob _ImageBlob;

}