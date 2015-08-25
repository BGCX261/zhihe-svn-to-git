package org.lps.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.Session;
import org.jboss.seam.Component;
import org.jboss.seam.faces.FacesMessages;

public class UniqueValidator implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		if (arg2 == null)
			return;
		Session session = (Session) Component.getInstance("hibernateSession");
		String propertypath = (String) arg1.getAttributes().get("propertypath");
		String errorkey = (String) arg1.getAttributes().get("errorkey");
		String oriValue = (String) arg1.getAttributes().get("oriValue");
		if(oriValue != null && oriValue.trim().length() != 0){
			if(oriValue.equals(arg2.toString())){
				return;
			}
		}
		String tname = propertypath.substring(0, propertypath.indexOf("."));
		String pname = propertypath.substring(propertypath.indexOf(".") + 1);

		Long count = (Long) session.createQuery(
				"select count(*) from " + tname + " u where u." + pname
						+ "=:param").setString("param", arg2.toString())
				.uniqueResult();
		if (count.longValue() != 0) {
			if (errorkey == null) {
				errorkey = "validator_unique";
			}

			FacesMessage message = FacesMessages.createFacesMessage(
					FacesMessage.SEVERITY_INFO, errorkey,
					"The value is duplicated!", arg1.getId());
			throw new ValidatorException(message);
		}

	}

}
