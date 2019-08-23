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

package com.yowshu.ec.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.yowshu.ec.model.Product;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProductCacheModel implements CacheModel<Product>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductCacheModel)) {
			return false;
		}

		ProductCacheModel productCacheModel = (ProductCacheModel)obj;

		if (productId == productCacheModel.productId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", detail=");
		sb.append(detail);
		sb.append(", price=");
		sb.append(price);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Product toEntityModel() {
		ProductImpl productImpl = new ProductImpl();

		if (uuid == null) {
			productImpl.setUuid("");
		}
		else {
			productImpl.setUuid(uuid);
		}

		productImpl.setProductId(productId);
		productImpl.setGroupId(groupId);
		productImpl.setCompanyId(companyId);
		productImpl.setUserId(userId);

		if (userName == null) {
			productImpl.setUserName("");
		}
		else {
			productImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productImpl.setCreateDate(null);
		}
		else {
			productImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productImpl.setModifiedDate(null);
		}
		else {
			productImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			productImpl.setName("");
		}
		else {
			productImpl.setName(name);
		}

		if (detail == null) {
			productImpl.setDetail("");
		}
		else {
			productImpl.setDetail(detail);
		}

		productImpl.setPrice(price);

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		productId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		detail = objectInput.readUTF();

		price = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(productId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (detail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detail);
		}

		objectOutput.writeInt(price);
	}

	public String uuid;
	public long productId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String detail;
	public int price;

}