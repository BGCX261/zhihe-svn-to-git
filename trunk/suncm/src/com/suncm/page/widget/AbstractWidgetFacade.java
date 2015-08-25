package com.suncm.page.widget;

import com.suncm.pojo.SuncmProcatePageset;

public abstract class AbstractWidgetFacade implements IWidgetFacade {
	
	protected SuncmProcatePageset core = null;
	
	public SuncmProcatePageset getCore() {
		return core;
	}

	public void setCore(SuncmProcatePageset core) {
		this.core = core;
	}



}
