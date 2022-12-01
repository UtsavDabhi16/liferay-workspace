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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import democrudservice.exception.NoSuchAddressException;

import democrudservice.model.Address;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressUtil
 * @generated
 */
@ProviderType
public interface AddressPersistence extends BasePersistence<Address> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressUtil} to access the address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the address in the entity cache if it is enabled.
	 *
	 * @param address the address
	 */
	public void cacheResult(Address address);

	/**
	 * Caches the addresses in the entity cache if it is enabled.
	 *
	 * @param addresses the addresses
	 */
	public void cacheResult(java.util.List<Address> addresses);

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	public Address create(String addressId);

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address remove(String addressId) throws NoSuchAddressException;

	public Address updateImpl(Address address);

	/**
	 * Returns the address with the primary key or throws a <code>NoSuchAddressException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address findByPrimaryKey(String addressId)
		throws NoSuchAddressException;

	/**
	 * Returns the address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address, or <code>null</code> if a address with the primary key could not be found
	 */
	public Address fetchByPrimaryKey(String addressId);

	/**
	 * Returns all the addresses.
	 *
	 * @return the addresses
	 */
	public java.util.List<Address> findAll();

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
	public java.util.List<Address> findAll(int start, int end);

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
	public java.util.List<Address> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

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
	public java.util.List<Address> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the addresses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of students associated with the address.
	 *
	 * @param pk the primary key of the address
	 * @return long[] of the primaryKeys of students associated with the address
	 */
	public long[] getStudentPrimaryKeys(String pk);

	/**
	 * Returns all the address associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the addresses associated with the student
	 */
	public java.util.List<Address> getStudentAddresses(long pk);

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
	public java.util.List<Address> getStudentAddresses(
		long pk, int start, int end);

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
	public java.util.List<Address> getStudentAddresses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the number of students associated with the address.
	 *
	 * @param pk the primary key of the address
	 * @return the number of students associated with the address
	 */
	public int getStudentsSize(String pk);

	/**
	 * Returns <code>true</code> if the student is associated with the address.
	 *
	 * @param pk the primary key of the address
	 * @param studentPK the primary key of the student
	 * @return <code>true</code> if the student is associated with the address; <code>false</code> otherwise
	 */
	public boolean containsStudent(String pk, long studentPK);

	/**
	 * Returns <code>true</code> if the address has any students associated with it.
	 *
	 * @param pk the primary key of the address to check for associations with students
	 * @return <code>true</code> if the address has any students associated with it; <code>false</code> otherwise
	 */
	public boolean containsStudents(String pk);

	/**
	 * Adds an association between the address and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPK the primary key of the student
	 */
	public void addStudent(String pk, long studentPK);

	/**
	 * Adds an association between the address and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param student the student
	 */
	public void addStudent(String pk, democrudservice.model.Student student);

	/**
	 * Adds an association between the address and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPKs the primary keys of the students
	 */
	public void addStudents(String pk, long[] studentPKs);

	/**
	 * Adds an association between the address and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param students the students
	 */
	public void addStudents(
		String pk, java.util.List<democrudservice.model.Student> students);

	/**
	 * Clears all associations between the address and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address to clear the associated students from
	 */
	public void clearStudents(String pk);

	/**
	 * Removes the association between the address and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPK the primary key of the student
	 */
	public void removeStudent(String pk, long studentPK);

	/**
	 * Removes the association between the address and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param student the student
	 */
	public void removeStudent(String pk, democrudservice.model.Student student);

	/**
	 * Removes the association between the address and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPKs the primary keys of the students
	 */
	public void removeStudents(String pk, long[] studentPKs);

	/**
	 * Removes the association between the address and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param students the students
	 */
	public void removeStudents(
		String pk, java.util.List<democrudservice.model.Student> students);

	/**
	 * Sets the students associated with the address, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param studentPKs the primary keys of the students to be associated with the address
	 */
	public void setStudents(String pk, long[] studentPKs);

	/**
	 * Sets the students associated with the address, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the address
	 * @param students the students to be associated with the address
	 */
	public void setStudents(
		String pk, java.util.List<democrudservice.model.Student> students);

}