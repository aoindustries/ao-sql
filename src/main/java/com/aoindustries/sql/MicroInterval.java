/*
 * ao-sql - SQL and JDBC utilities.
 * Copyright (C) 2013, 2016, 2020  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-sql.
 *
 * ao-sql is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-sql is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-sql.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoindustries.sql;

import com.aoindustries.i18n.Resources;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Encapsulates an interval in microseconds.
 *
 * @author  AO Industries, Inc.
 */
final public class MicroInterval implements Serializable, Comparable<MicroInterval> {

	private static final Resources RESOURCES = Resources.getResources(MicroInterval.class.getPackage());

	private static final long serialVersionUID = 1;

	final private long intervalMicros;

	public MicroInterval(long intervalMicros) {
		this.intervalMicros = intervalMicros;
	}

	/**
	 * Gets the interval in microseconds.
	 */
	public long getIntervalMicros() {
		return intervalMicros;
	}

	@Override
	public String toString() {
		return toString(intervalMicros);
	}

	public static String toString(long intervalMicros) {
		if(intervalMicros < 1000000) return RESOURCES.getMessage("MicroInterval.toString.milli", BigDecimal.valueOf(intervalMicros, 3));
		return RESOURCES.getMessage("MicroInterval.toString.second", BigDecimal.valueOf(intervalMicros/1000, 3));
	}

	@Override
	public int compareTo(MicroInterval o) {
		if(intervalMicros<o.intervalMicros) return -1;
		if(intervalMicros>o.intervalMicros) return 1;
		return 0;
	}
}
