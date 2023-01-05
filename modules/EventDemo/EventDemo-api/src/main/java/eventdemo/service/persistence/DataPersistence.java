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

package eventdemo.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eventdemo.exception.NoSuchDataException;

import eventdemo.model.Data;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataUtil
 * @generated
 */
@ProviderType
public interface DataPersistence extends BasePersistence<Data> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataUtil} to access the data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching datas
	 */
	public java.util.List<Data> findByUuid(String uuid);

	/**
	 * Returns a range of all the datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @return the range of matching datas
	 */
	public java.util.List<Data> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching datas
	 */
	public java.util.List<Data> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Data>
			orderByComparator);

	/**
	 * Returns an ordered range of all the datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching datas
	 */
	public java.util.List<Data> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Data>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data
	 * @throws NoSuchDataException if a matching data could not be found
	 */
	public Data findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Data>
				orderByComparator)
		throws NoSuchDataException;

	/**
	 * Returns the first data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data, or <code>null</code> if a matching data could not be found
	 */
	public Data fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Data>
			orderByComparator);

	/**
	 * Returns the last data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data
	 * @throws NoSuchDataException if a matching data could not be found
	 */
	public Data findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Data>
				orderByComparator)
		throws NoSuchDataException;

	/**
	 * Returns the last data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data, or <code>null</code> if a matching data could not be found
	 */
	public Data fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Data>
			orderByComparator);

	/**
	 * Returns the datas before and after the current data in the ordered set where uuid = &#63;.
	 *
	 * @param eventId the primary key of the current data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data
	 * @throws NoSuchDataException if a data with the primary key could not be found
	 */
	public Data[] findByUuid_PrevAndNext(
			long eventId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Data>
				orderByComparator)
		throws NoSuchDataException;

	/**
	 * Removes all the datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching datas
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the data in the entity cache if it is enabled.
	 *
	 * @param data the data
	 */
	public void cacheResult(Data data);

	/**
	 * Caches the datas in the entity cache if it is enabled.
	 *
	 * @param datas the datas
	 */
	public void cacheResult(java.util.List<Data> datas);

	/**
	 * Creates a new data with the primary key. Does not add the data to the database.
	 *
	 * @param eventId the primary key for the new data
	 * @return the new data
	 */
	public Data create(long eventId);

	/**
	 * Removes the data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the data
	 * @return the data that was removed
	 * @throws NoSuchDataException if a data with the primary key could not be found
	 */
	public Data remove(long eventId) throws NoSuchDataException;

	public Data updateImpl(Data data);

	/**
	 * Returns the data with the primary key or throws a <code>NoSuchDataException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the data
	 * @return the data
	 * @throws NoSuchDataException if a data with the primary key could not be found
	 */
	public Data findByPrimaryKey(long eventId) throws NoSuchDataException;

	/**
	 * Returns the data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the data
	 * @return the data, or <code>null</code> if a data with the primary key could not be found
	 */
	public Data fetchByPrimaryKey(long eventId);

	/**
	 * Returns all the datas.
	 *
	 * @return the datas
	 */
	public java.util.List<Data> findAll();

	/**
	 * Returns a range of all the datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @return the range of datas
	 */
	public java.util.List<Data> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of datas
	 */
	public java.util.List<Data> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Data>
			orderByComparator);

	/**
	 * Returns an ordered range of all the datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of datas
	 * @param end the upper bound of the range of datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of datas
	 */
	public java.util.List<Data> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Data>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of datas.
	 *
	 * @return the number of datas
	 */
	public int countAll();

}