/*
 *     This file is part of ToroDB.
 *
 *     ToroDB is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General PublicSchema License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ToroDB is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General PublicSchema License for more details.
 *
 *     You should have received a copy of the GNU Affero General PublicSchema License
 *     along with ToroDB. If not, see <http://www.gnu.org/licenses/>.
 *
 *     Copyright (c) 2014, 8Kdata Technology
 *     
 */

package com.torodb.torod.db.backends.udt;

import com.torodb.torod.db.backends.meta.TorodbSchema;
import com.torodb.torod.db.backends.udt.records.TwelveBytesRecord;

import org.jooq.impl.UDTImpl;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.1" },
                            comments = "This class is generated by jOOQ")
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TwelveBytesUDT extends UDTImpl<TwelveBytesRecord> {

	private static final long serialVersionUID = -552117608;

	/**
	 * The singleton instance of <code>torodb.twelve_bytes</code>
	 */
	public static final TwelveBytesUDT TWELVE_BYTES = new TwelveBytesUDT();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TwelveBytesRecord> getRecordType() {
		return TwelveBytesRecord.class;
	}

	/**
	 * The attribute <code>torodb.twelve_bytes.upper</code>.
	 */
	public static final org.jooq.UDTField<TwelveBytesRecord, Integer> UPPPER = createField("upper", org.jooq.impl.SQLDataType.INTEGER, TWELVE_BYTES);

	/**
	 * The attribute <code>torodb.twelve_bytes.middle</code>.
	 */
	public static final org.jooq.UDTField<TwelveBytesRecord, Integer> MIDDLE = createField("middle", org.jooq.impl.SQLDataType.INTEGER, TWELVE_BYTES);

	/**
	 * The attribute <code>torodb.twelve_bytes.lower</code>.
	 */
	public static final org.jooq.UDTField<TwelveBytesRecord, Integer> LOWER = createField("lower", org.jooq.impl.SQLDataType.INTEGER, TWELVE_BYTES);

	/**
	 * No further instances allowed
	 */
	private TwelveBytesUDT() {
		super("twelve_bytes", TorodbSchema.TORODB);

		// Initialise data type
		getDataType();
	}
}