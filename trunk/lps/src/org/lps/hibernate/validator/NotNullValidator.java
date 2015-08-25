//$Id: NotNullValidator.java,v 1.1 2010/08/06 06:23:00 kfzx-xiezc Exp $
package org.lps.hibernate.validator;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.mapping.Column;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.SingleTableSubclass;
import org.hibernate.validator.PropertyConstraint;
import org.hibernate.validator.Validator;


public class NotNullValidator implements Validator<NotNull>, PropertyConstraint, Serializable {

	public boolean isValid(Object value) {
		if(value == null || value.toString().trim().length()==0){
			return false;
		}
		return true;
	}

	public void initialize(NotNull parameters) {
	}

	@SuppressWarnings("unchecked")
	public void apply(Property property) {
		if ( ! ( property.getPersistentClass() instanceof SingleTableSubclass ) ) {
			//single table should not be forced to null
			if ( !property.isComposite() ) { //composite should not add not-null on all columns
				Iterator<Column> iter = (Iterator<Column>) property.getColumnIterator();
				while ( iter.hasNext() ) {
					iter.next().setNullable( false );
				}
			}
		}
	}
}
