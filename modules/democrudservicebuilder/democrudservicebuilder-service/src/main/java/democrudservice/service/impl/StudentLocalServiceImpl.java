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

package democrudservice.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.SystemException;
import democrudservice.model.Student;
import democrudservice.service.base.StudentLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=democrudservice.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {

	public List<Student> getStudentFormCity(String city) throws SystemException {
		return this.studentPersistence.findByCity(city);
	}


	public List<Student> getStudentByFistName(String firstName){
		return studentFinder.getStudentsByFirstName(firstName);
}

	public List<Student> findByEntryfirstkName(long studentId) throws SystemException {
		return studentFinder.findByFName(studentId);
	}

	public void removeByLastName(String lastName)
	{

		this.studentPersistence.removeByLastName(lastName);
	}

	public List<Student> getForPagination(int start,int end)
	{
		return studentFinder.getForPagination(start,end);
	}
}