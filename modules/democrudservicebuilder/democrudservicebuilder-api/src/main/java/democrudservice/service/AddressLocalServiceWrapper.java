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

package democrudservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AddressLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AddressLocalService
 * @generated
 */
public class AddressLocalServiceWrapper
	implements AddressLocalService, ServiceWrapper<AddressLocalService> {

	public AddressLocalServiceWrapper() {
		this(null);
	}

	public AddressLocalServiceWrapper(AddressLocalService addressLocalService) {
		_addressLocalService = addressLocalService;
	}

	/**
	 * Adds the address to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param address the address
	 * @return the address that was added
	 */
	@Override
	public democrudservice.model.Address addAddress(
		democrudservice.model.Address address) {

		return _addressLocalService.addAddress(address);
	}

	@Override
	public void addStudentAddress(
		long studentId, democrudservice.model.Address address) {

		_addressLocalService.addStudentAddress(studentId, address);
	}

	@Override
	public void addStudentAddress(long studentId, String addressId) {
		_addressLocalService.addStudentAddress(studentId, addressId);
	}

	@Override
	public void addStudentAddresses(
		long studentId,
		java.util.List<democrudservice.model.Address> addresses) {

		_addressLocalService.addStudentAddresses(studentId, addresses);
	}

	@Override
	public void addStudentAddresses(long studentId, String[] addressIds) {
		_addressLocalService.addStudentAddresses(studentId, addressIds);
	}

	@Override
	public void clearStudentAddresses(long studentId) {
		_addressLocalService.clearStudentAddresses(studentId);
	}

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	@Override
	public democrudservice.model.Address createAddress(String addressId) {
		return _addressLocalService.createAddress(addressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the address from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param address the address
	 * @return the address that was removed
	 */
	@Override
	public democrudservice.model.Address deleteAddress(
		democrudservice.model.Address address) {

		return _addressLocalService.deleteAddress(address);
	}

	/**
	 * Deletes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws PortalException if a address with the primary key could not be found
	 */
	@Override
	public democrudservice.model.Address deleteAddress(String addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressLocalService.deleteAddress(addressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteStudentAddress(
		long studentId, democrudservice.model.Address address) {

		_addressLocalService.deleteStudentAddress(studentId, address);
	}

	@Override
	public void deleteStudentAddress(long studentId, String addressId) {
		_addressLocalService.deleteStudentAddress(studentId, addressId);
	}

	@Override
	public void deleteStudentAddresses(
		long studentId,
		java.util.List<democrudservice.model.Address> addresses) {

		_addressLocalService.deleteStudentAddresses(studentId, addresses);
	}

	@Override
	public void deleteStudentAddresses(long studentId, String[] addressIds) {
		_addressLocalService.deleteStudentAddresses(studentId, addressIds);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _addressLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _addressLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addressLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _addressLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>democrudservice.model.impl.AddressModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _addressLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>democrudservice.model.impl.AddressModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _addressLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _addressLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _addressLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public democrudservice.model.Address fetchAddress(String addressId) {
		return _addressLocalService.fetchAddress(addressId);
	}

	/**
	 * Returns the address with the primary key.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws PortalException if a address with the primary key could not be found
	 */
	@Override
	public democrudservice.model.Address getAddress(String addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressLocalService.getAddress(addressId);
	}

	/**
	 * Returns a range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>democrudservice.model.impl.AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of addresses
	 */
	@Override
	public java.util.List<democrudservice.model.Address> getAddresses(
		int start, int end) {

		return _addressLocalService.getAddresses(start, end);
	}

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	@Override
	public int getAddressesCount() {
		return _addressLocalService.getAddressesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _addressLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<democrudservice.model.Address> getStudentAddresses(
		long studentId) {

		return _addressLocalService.getStudentAddresses(studentId);
	}

	@Override
	public java.util.List<democrudservice.model.Address> getStudentAddresses(
		long studentId, int start, int end) {

		return _addressLocalService.getStudentAddresses(studentId, start, end);
	}

	@Override
	public java.util.List<democrudservice.model.Address> getStudentAddresses(
		long studentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<democrudservice.model.Address> orderByComparator) {

		return _addressLocalService.getStudentAddresses(
			studentId, start, end, orderByComparator);
	}

	@Override
	public int getStudentAddressesCount(long studentId) {
		return _addressLocalService.getStudentAddressesCount(studentId);
	}

	/**
	 * Returns the studentIds of the students associated with the address.
	 *
	 * @param addressId the addressId of the address
	 * @return long[] the studentIds of students associated with the address
	 */
	@Override
	public long[] getStudentPrimaryKeys(String addressId) {
		return _addressLocalService.getStudentPrimaryKeys(addressId);
	}

	@Override
	public boolean hasStudentAddress(long studentId, String addressId) {
		return _addressLocalService.hasStudentAddress(studentId, addressId);
	}

	@Override
	public boolean hasStudentAddresses(long studentId) {
		return _addressLocalService.hasStudentAddresses(studentId);
	}

	@Override
	public void setStudentAddresses(long studentId, String[] addressIds) {
		_addressLocalService.setStudentAddresses(studentId, addressIds);
	}

	/**
	 * Updates the address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param address the address
	 * @return the address that was updated
	 */
	@Override
	public democrudservice.model.Address updateAddress(
		democrudservice.model.Address address) {

		return _addressLocalService.updateAddress(address);
	}

	@Override
	public AddressLocalService getWrappedService() {
		return _addressLocalService;
	}

	@Override
	public void setWrappedService(AddressLocalService addressLocalService) {
		_addressLocalService = addressLocalService;
	}

	private AddressLocalService _addressLocalService;

}