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

package democrudservice.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import democrudservice.model.Address;

import democrudservice.service.AddressLocalService;
import democrudservice.service.AddressLocalServiceUtil;
import democrudservice.service.persistence.AddressPersistence;
import democrudservice.service.persistence.StudentFinder;
import democrudservice.service.persistence.StudentPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;


public abstract class AddressLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AddressLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AddressLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AddressLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Address addAddress(Address address) {
		address.setNew(true);

		return addressPersistence.update(address);
	}

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	@Override
	@Transactional(enabled = false)
	public Address createAddress(String addressId) {
		return addressPersistence.create(addressId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Address deleteAddress(String addressId) throws PortalException {
		return addressPersistence.remove(addressId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Address deleteAddress(Address address) {
		return addressPersistence.remove(address);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return addressPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Address.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return addressPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return addressPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return addressPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return addressPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return addressPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Address fetchAddress(String addressId) {
		return addressPersistence.fetchByPrimaryKey(addressId);
	}

	/**
	 * Returns the address with the primary key.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws PortalException if a address with the primary key could not be found
	 */
	@Override
	public Address getAddress(String addressId) throws PortalException {
		return addressPersistence.findByPrimaryKey(addressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return addressPersistence.create((String)primaryKeyObj);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return addressLocalService.deleteAddress((Address)persistedModel);
	}

	@Override
	public BasePersistence<Address> getBasePersistence() {
		return addressPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return addressPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Address> getAddresses(int start, int end) {
		return addressPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	@Override
	public int getAddressesCount() {
		return addressPersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Address updateAddress(Address address) {
		return addressPersistence.update(address);
	}

	/**
	 */

	/**
	 * Returns the studentIds of the students associated with the address.
	 *
	 * @param addressId the addressId of the address
	 * @return long[] the studentIds of students associated with the address
	 */
	@Override
	public long[] getStudentPrimaryKeys(String addressId) {
		return addressPersistence.getStudentPrimaryKeys(addressId);
	}

	/**
	 */
	@Override
	public List<Address> getStudentAddresses(long studentId) {
		return addressPersistence.getStudentAddresses(studentId);
	}

	/**
	 */
	@Override
	public List<Address> getStudentAddresses(
		long studentId, int start, int end) {

		return addressPersistence.getStudentAddresses(studentId, start, end);
	}

	/**
	 */
	@Override
	public List<Address> getStudentAddresses(
		long studentId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return addressPersistence.getStudentAddresses(
			studentId, start, end, orderByComparator);
	}

	/**


	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			AddressLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		addressLocalService = (AddressLocalService)aopProxy;

		_setLocalServiceUtilService(addressLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AddressLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Address.class;
	}

	protected String getModelClassName() {
		return Address.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = addressPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		AddressLocalService addressLocalService) {

		try {
			Field field = AddressLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, addressLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected AddressLocalService addressLocalService;

	@Reference
	protected AddressPersistence addressPersistence;

	@Reference
	protected StudentPersistence studentPersistence;

	@Reference
	protected StudentFinder studentFinder;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}