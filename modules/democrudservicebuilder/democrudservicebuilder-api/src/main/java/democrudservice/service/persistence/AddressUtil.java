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

package democrudservice.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import democrudservice.model.Address;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the address service. This utility wraps <code>democrudservice.service.persistence.impl.AddressPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressPersistence
 * @generated
 */
public class AddressUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Address address) {
		getPersistence().clearCache(address);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Address> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Address> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Address> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Address> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Address update(Address address) {
		return getPersistence().update(address);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Address update(
		Address address, ServiceContext serviceContext) {

		return getPersistence().update(address, serviceContext);
	}

	/**
	 * Caches the address in the entity cache if it is enabled.
	 *
	 * @param address the address
	 */
	public static void cacheResult(Address address) {
		getPersistence().cacheResult(address);
	}

	/**
	 * Caches the addresses in the entity cache if it is enabled.
	 *
	 * @param addresses the addresses
	 */
	public static void cacheResult(List<Address> addresses) {
		getPersistence().cacheResult(addresses);
	}

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	public static Address create(String addressId) {
		return getPersistence().create(addressId);
	}

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public static Address remove(String addressId)
		throws democrudservice.exception.NoSuchAddressException {

		return getPersistence().remove(addressId);
	}

	public static Address updateImpl(Address address) {
		return getPersistence().updateImpl(address);
	}

	/**
	 * Returns the address with the primary key or throws a <code>NoSuchAddressException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public static Address findByPrimaryKey(String addressId)
		throws democrudservice.exception.NoSuchAddressException {

		return getPersistence().findByPrimaryKey(addressId);
	}

	/**
	 * Returns the address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address, or <code>null</code> if a address with the primary key could not be found
	 */
	public static Address fetchByPrimaryKey(String addressId) {
		return getPersistence().fetchByPrimaryKey(addressId);
	}

	/**
	 * Returns all the addresses.
	 *
	 * @return the addresses
	 */
	public static List<Address> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of addresses
	 */
	public static List<Address> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addresses
	 */
	public static List<Address> findAll(
		int start, int end, OrderByComparator<Address> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of addresses
	 */
	public static List<Address> findAll(
		int start, int end, OrderByComparator<Address> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the addresses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of students associated with the address.
	 *
	 * @param pk the primary key of the address
	 * @return long[] of the primaryKeys of students associated with the address
	 */
	public static long[] getStudentPrimaryKeys(String pk) {
		return getPersistence().getStudentPrimaryKeys(pk);
	}

	/**
	 * Returns all the address associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the addresses associated with the student
	 */
	public static List<Address> getStudentAddresses(long pk) {
		return getPersistence().getStudentAddresses(pk);
	}

	/**
	 * Returns all the address associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of addresses associated with the student
	 */
	public static List<Address> getStudentAddresses(
		long pk, int start, int end) {

		return getPersistence().getStudentAddresses(pk, start, end);
	}

	/**
	 * Returns all the address associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addresses associated with the student
	 */
	public static List<Address> getStudentAddresses(
		long pk, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().getStudentAddresses(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of students associated with the address.
	 *
	 * @param pk the primary key of the address
	 * @return the number of students associated with the address
	 */
	public static int getStudentsSize(String pk) {
		return getPersistence().getStudentsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the student is associated with the address.
	 *
	 * @param pk the primary key of the address
	 * @param studentPK the primary key of the student
	 * @return <code>true</code> if the student is associated with the address; <code>false</code> otherwise
	 */
	public static boolean containsStudent(String pk, long studentPK) {
		return getPersistence().containsStudent(pk, studentPK);
	}

	/**
	 * Returns <code>true</code> if the address has any students associated with it.
	 *
	 * @param pk the primary key of the address to check for associations with students
	 * @return <code>true</code> if the address has any students associated with it; <code>false</code> otherwise
	 */
	public static boolean containsStudents(String pk) {
		return getPersistence().containsStudents(pk);
	}

	/**
	 * Adds an association between the address and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPK the primary key of the student
	 */
	public static void addStudent(String pk, long studentPK) {
		getPersistence().addStudent(pk, studentPK);
	}

	/**
	 * Adds an association between the address and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param student the student
	 */
	public static void addStudent(
		String pk, democrudservice.model.Student student) {

		getPersistence().addStudent(pk, student);
	}

	/**
	 * Adds an association between the address and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPKs the primary keys of the students
	 */
	public static void addStudents(String pk, long[] studentPKs) {
		getPersistence().addStudents(pk, studentPKs);
	}

	/**
	 * Adds an association between the address and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param students the students
	 */
	public static void addStudents(
		String pk, List<democrudservice.model.Student> students) {

		getPersistence().addStudents(pk, students);
	}

	/**
	 * Clears all associations between the address and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address to clear the associated students from
	 */
	public static void clearStudents(String pk) {
		getPersistence().clearStudents(pk);
	}

	/**
	 * Removes the association between the address and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPK the primary key of the student
	 */
	public static void removeStudent(String pk, long studentPK) {
		getPersistence().removeStudent(pk, studentPK);
	}

	/**
	 * Removes the association between the address and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param student the student
	 */
	public static void removeStudent(
		String pk, democrudservice.model.Student student) {

		getPersistence().removeStudent(pk, student);
	}

	/**
	 * Removes the association between the address and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPKs the primary keys of the students
	 */
	public static void removeStudents(String pk, long[] studentPKs) {
		getPersistence().removeStudents(pk, studentPKs);
	}

	/**
	 * Removes the association between the address and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param students the students
	 */
	public static void removeStudents(
		String pk, List<democrudservice.model.Student> students) {

		getPersistence().removeStudents(pk, students);
	}

	/**
	 * Sets the students associated with the address, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPKs the primary keys of the students to be associated with the address
	 */
	public static void setStudents(String pk, long[] studentPKs) {
		getPersistence().setStudents(pk, studentPKs);
	}

	/**
	 * Sets the students associated with the address, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param students the students to be associated with the address
	 */
	public static void setStudents(
		String pk, List<democrudservice.model.Student> students) {

		getPersistence().setStudents(pk, students);
	}

	public static AddressPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AddressPersistence _persistence;

}