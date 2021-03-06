/*
 * ToroDB
 * Copyright © 2014 8Kdata Technology (www.8kdata.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.torodb.backend.udt.record;

import com.torodb.backend.udt.Decimal128UDT;
import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UDTRecordImpl;

import java.math.BigDecimal;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value = {"http://www.jooq.org", "3.4.1"},
    comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Decimal128Record extends UDTRecordImpl<Decimal128Record> implements
    Record4<BigDecimal, Boolean, Boolean, Boolean> {

  public BigDecimal getValue() {
    return (BigDecimal) getValue(0);
  }

  public void setValue(BigDecimal value) {
    setValue(0, value);
  }

  public Boolean getInfinity() {
    return (Boolean) getValue(1);
  }

  public void setInfinity(Boolean infinity) {
    setValue(1, infinity);
  }

  public Boolean getNan() {
    return (Boolean) getValue(2);
  }

  public void setNan(Boolean nan) {
    setValue(2, nan);
  }

  public Boolean getNegativeZero() {
    return (Boolean) getValue(3);
  }

  public void setNegativeZero(Boolean negativeZero) {
    setValue(3, negativeZero);
  }

  private static final long serialVersionUID = -103355438;


  // -------------------------------------------------------------------------
  // Record2 type implementation
  // -------------------------------------------------------------------------
  @Override
  public Row4<BigDecimal, Boolean, Boolean, Boolean> fieldsRow() {
    return (Row4) super.fieldsRow();
  }

  @Override
  public Row4<BigDecimal, Boolean, Boolean, Boolean> valuesRow() {
    return (Row4) super.valuesRow();
  }

  @Override
  public Field<BigDecimal> field1() {
    return Decimal128UDT.VALUE;
  }

  @Override
  public Field<Boolean> field2() {
    return Decimal128UDT.IS_INFINITY;
  }

  @Override
  public Field<Boolean> field3() {
    return Decimal128UDT.IS_NaN;
  }

  @Override
  public Field<Boolean> field4() {
    return Decimal128UDT.IS_NEGATIVE_ZERO;
  }

  @Override
  public BigDecimal value1() {
    return getValue();
  }

  @Override
  public Boolean value2() {
    return getInfinity();
  }

  @Override
  public Boolean value3() {
    return getNan();
  }

  @Override
  public Boolean value4() {
    return getNegativeZero();
  }

  @Override
  public Record4<BigDecimal, Boolean, Boolean, Boolean> value1(BigDecimal bigDecimal) {
    setValue(bigDecimal);
    return this;
  }

  @Override
  public Record4<BigDecimal, Boolean, Boolean, Boolean> value2(Boolean aBoolean) {
    setInfinity(aBoolean);
    return this;
  }

  @Override
  public Record4<BigDecimal, Boolean, Boolean, Boolean> value3(Boolean aBoolean) {
    setNan(aBoolean);
    return this;
  }

  @Override
  public Record4<BigDecimal, Boolean, Boolean, Boolean> value4(Boolean aBoolean) {
    setNegativeZero(aBoolean);
    return this;
  }

  @Override
  public Record4<BigDecimal, Boolean, Boolean, Boolean> values(BigDecimal bigDecimal, Boolean aBoolean, Boolean aBoolean2, Boolean aBoolean3) {
    return this;
  }


  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------
  /**
   * Create a detached Decimal128Record
   */
  public Decimal128Record() {
    super(Decimal128UDT.DECIMAL_128_UDT);
  }

  public Decimal128Record(BigDecimal bigDecimal, Boolean aBoolean, Boolean aBoolean2, Boolean aBoolean3) {
    super(Decimal128UDT.DECIMAL_128_UDT);
    setValue(bigDecimal);
    setInfinity(aBoolean);
    setNan(aBoolean2);
    setNegativeZero(aBoolean3);
  }
}
