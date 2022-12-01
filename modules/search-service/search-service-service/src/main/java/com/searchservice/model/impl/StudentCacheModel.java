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

package com.searchservice.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.searchservice.model.Student;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StudentCacheModel)) {
			return false;
		}

		StudentCacheModel studentCacheModel = (StudentCacheModel)object;

		if (studentId == studentCacheModel.studentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{studentId=");
		sb.append(studentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", lastname=");
		sb.append(lastname);
		sb.append(", std=");
		sb.append(std);
		sb.append(", address=");
		sb.append(address);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", gender=");
		sb.append(gender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setStudentId(studentId);

		if (name == null) {
			studentImpl.setName("");
		}
		else {
			studentImpl.setName(name);
		}

		if (lastname == null) {
			studentImpl.setLastname("");
		}
		else {
			studentImpl.setLastname(lastname);
		}

		if (std == null) {
			studentImpl.setStd("");
		}
		else {
			studentImpl.setStd(std);
		}

		if (address == null) {
			studentImpl.setAddress("");
		}
		else {
			studentImpl.setAddress(address);
		}

		if (phone == null) {
			studentImpl.setPhone("");
		}
		else {
			studentImpl.setPhone(phone);
		}

		if (gender == null) {
			studentImpl.setGender("");
		}
		else {
			studentImpl.setGender(gender);
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		studentId = objectInput.readInt();
		name = objectInput.readUTF();
		lastname = objectInput.readUTF();
		std = objectInput.readUTF();
		address = objectInput.readUTF();
		phone = objectInput.readUTF();
		gender = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(studentId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (lastname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastname);
		}

		if (std == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(std);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}
	}

	public int studentId;
	public String name;
	public String lastname;
	public String std;
	public String address;
	public String phone;
	public String gender;

}