/**
 * SNE-XACML: A high performance XACML evaluation engine.
 *
 * Copyright (C) 2013 Canh T. Ngo <canhnt@gmail.com>
 * System and Network Engineering Group, University of Amsterdam.
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA
 */
/**
 * System and Network Engineering Group
 * University of Amsterdam
 *
 */
package nl.uva.sne.midd.interval;

/**
 * @author Canh Ngo (t.c.ngo@uva.nl)
 *
 * @version 
 * @date: Sep 17, 2012
 */
public class EndPoint<T extends Comparable<T>> implements Comparable<EndPoint<T>> {
	
	private boolean fNegativeInfinity;
	
	private boolean fPositiveInfinity;
	
	private T value;

	public EndPoint(boolean negativeInfinity, boolean positiveInfinity) {
		if (!(negativeInfinity ^ positiveInfinity))
			throw new IllegalArgumentException("Only -inf or +inf at a time");
		
		this.fPositiveInfinity = positiveInfinity;
		this.fNegativeInfinity = negativeInfinity;
		this.value = null;
	}
	
	public EndPoint(T value) {
//		 special processing for missing attribute
//		if (value == null) {
//			this.fNegativeInfinity = true;
//			this.fPositiveInfinity = true;
//			this.value = value;
//		} else {
			// normal attribute
			this.fPositiveInfinity = false;
			this.fNegativeInfinity = false;
			this.value = value;			
//		}
	}
	
	public EndPoint(EndPoint<T> p) {
		this.fNegativeInfinity = p.fNegativeInfinity;
		this.fPositiveInfinity = p.fPositiveInfinity;
		
		// Should beware of deep cloning if T is an object type
		this.value = p.value;
	}

	@Override
	public int compareTo(EndPoint<T> o) {
		if (this.fPositiveInfinity) {
			return o.fPositiveInfinity ? 0 : 1;
		} else if (this.fNegativeInfinity) {
			return o.fNegativeInfinity ? 0 : -1;
		} else {
			if (o.fPositiveInfinity)
				return -1;
			else if (o.fNegativeInfinity)
				return 1;
			else
				return this.value.compareTo(o.value);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EndPoint))
			return false;
		
		EndPoint<T> other = (EndPoint<T>) obj;
		
		if (fNegativeInfinity != other.fNegativeInfinity)
			return false;
		if (fPositiveInfinity != other.fPositiveInfinity)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	public boolean getNegativeInfinity() {
		return this.fNegativeInfinity;
	}
	
	public boolean getPositiveInfinity() {
		return this.fPositiveInfinity;
	}
	
	public T getValue() {
		return this.value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (fNegativeInfinity ? 1231 : 1237);
		result = prime * result + (fPositiveInfinity ? 1231 : 1237);
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	public void setNegativeInfinity(boolean b){
		this.fPositiveInfinity = false;
		this.fNegativeInfinity = b;
		this.value = null;
	}
	
	public void setPositiveInfinity(boolean b){
		this.fPositiveInfinity = b;
		this.fNegativeInfinity = false;
		this.value = null;
	}

	public void setValue(T value) {
		this.fPositiveInfinity = false;
		this.fNegativeInfinity = false;
		this.value = value;
	}

	@Override
	public String toString(){
		return value.toString();
	}

	public Class<?> getType() {
		
		if (this.value != null)
			return value.getClass();
		else
			return null;
	}

//	@Override
//	public boolean equals(Object v) {
//		if (v instanceof EndPoint) {
//			EndPoint<T> p = (EndPoint<T>)v;
//			
//			if (this.fPositiveInfinity)
//				return p.fPositiveInfinity;
//			else if (this.fNegativeInfinity)
//				return p.fNegativeInfinity;
//			else
//				return this.value.equals(p.value);			
//		}
//		return false;		
//	}
//	
//	public int hashCode() {		
//		if (this.value != null)
//			return this.value.hashCode();
//		else if (this.fNegativeInfinity)
//			return this.fNegativeInfinity.hashCode();
//		else if (this.fPositiveInfinity)
//			return this.fPositiveInfinity.hashCode();
//		else 
//			throw new RuntimeException("Undetermined EndPoint value");
//	}
	
	
}
