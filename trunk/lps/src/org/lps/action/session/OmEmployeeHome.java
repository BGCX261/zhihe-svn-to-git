package org.lps.action.session;

import org.hibernate.Session;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.HibernateEntityHome;
import org.lps.base.BaseModifiableHibernateDataModel;
import org.lps.entity.OmEmployee;

@Name("omEmployeeHome")
public class OmEmployeeHome extends HibernateEntityHome<OmEmployee>
{


	@In
	private Session hibernateSession;

	private BaseModifiableHibernateDataModel<OmEmployee> dataModel;

	public BaseModifiableHibernateDataModel<OmEmployee> getDataModel() {
		if(dataModel == null){
			dataModel = new BaseModifiableHibernateDataModel<OmEmployee>(OmEmployee.class) ;
		}
		if(dataModel.getSession() == null){
		dataModel.setSession(hibernateSession);
		}
		return dataModel;
	}

    public void setOmEmployeeEmpId(Long id)
    {
        setId(id);
    }

    public Long getOmEmployeeEmpId()
    {
        return (Long) getId();
    }

    @Override
    protected OmEmployee createInstance()
    {
        OmEmployee omEmployee = new OmEmployee();
        return omEmployee;
    }

    public void load()
    {
        if (isIdDefined())
        {
            wire();
        }
    }

    public void wire()
    {
        getInstance();
    }

    public boolean isWired()
    {
        return true;
    }

    public OmEmployee getDefinedInstance()
    {
        return isIdDefined() ? getInstance() : null;
    }
    
    @Override
	public String persist() {
		// 
    	String result = null;
    	try{
    		result =  super.persist();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		this.dataModel.clearCache(true, true);
		return result;
	}

	@Override
	public String remove() {
		String result =  super.remove();
		this.dataModel.clearCache(true, true);
		return result;
	}

	@Override
	public String update() {
		String result =  super.update();
		this.dataModel.clearCache(false, true);
		return result;
	}


}

