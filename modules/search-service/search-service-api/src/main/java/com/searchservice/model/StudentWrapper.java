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

package com.searchservice.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
public class StudentWrapper
	extends BaseModelWrapper<Student>
	implements ModelWrapper<Student>, Student {

	public StudentWrapper(Student student) {
		super(student);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentId", getStudentId());
		attributes.put("name", getName());
		attributes.put("lastname", getLastname());
		attributes.put("std", getStd());
		attributes.put("address", getAddress());
		attributes.put("phone", getPhone());
		attributes.put("gender", getGender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer studentId = (Integer)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		String std = (String)attributes.get("std");

		if (std != null) {
			setStd(std);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}
	}

	@Override
	public Student cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this student.
	 *
	 * @return the address of this student
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the gender of this student.
	 *
	 * @return the gender of this student
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the lastname of this student.
	 *
	 * @return the lastname of this student
	 */
	@Override
	public String getLastname() {
		return model.getLastname();
	}

	/**
	 * Returns the name of this student.
	 *
	 * @return the name of this student
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the phone of this student.
	 *
	 * @return the phone of this student
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the std of this student.
	 *
	 * @return the std of this student
	 */
	@Override
	public String getStd() {
		return model.getStd();
	}

	/**
	 * Returns the student ID of this student.
	 *
	 * @return the student ID of this student
	 */
	@Override
	public int getStudentId() {
		return model.getStudentId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this student.
	 *
	 * @param address the address of this student
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the gender of this student.
	 *
	 * @param gender the gender of this student
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the lastname of this student.
	 *
	 * @param lastname the lastname of this student
	 */
	@Override
	public void setLastname(String lastname) {
		model.setLastname(lastname);
	}

	/**
	 * Sets the name of this student.
	 *
	 * @param name the name of this student
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the phone of this student.
	 *
	 * @param phone the phone of this student
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the std of this student.
	 *
	 * @param std the std of this student
	 */
	@Override
	public void setStd(String std) {
		model.setStd(std);
	}

	/**
	 * Sets the student ID of this student.
	 *
	 * @param studentId the student ID of this student
	 */
	@Override
	public void setStudentId(int studentId) {
		model.setStudentId(studentId);
	}

	@Override
	protected StudentWrapper wrap(Student student) {
		return new StudentWrapper(student);
	}

}