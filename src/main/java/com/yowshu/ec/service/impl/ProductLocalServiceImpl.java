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

package com.yowshu.ec.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.yowshu.ec.model.Product;
import com.yowshu.ec.service.ProductLocalServiceUtil;
import com.yowshu.ec.service.base.ProductLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.yowshu.ec.service.ProductLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.yowshu.ec.model.Product",
	service = AopService.class
)
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.yowshu.ec.service.ProductLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.yowshu.ec.service.ProductLocalServiceUtil</code>.
	 */
	public Product addProduct(String name,String detail, int price) {
		Product product = productPersistence.create(counterLocalService.increment());
		product.setName(name);
		product.setDetail(detail);
		product.setPrice(price);
		productPersistence.update(product);
		return product;
	}
	public void deleteProduct(Long productId) throws NoSuchModelException {
		productPersistence.remove(productId);
	}
	public void updateProduct(Long productId, String name, String detail, int price) throws NoSuchModelException {
		Product product = productPersistence.findByPrimaryKey(productId);
		product.setName(name);
		product.setDetail(detail);
		product.setPrice(price);
		productPersistence.update(product);
	}
}
