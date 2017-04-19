package com.elitecore.base;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseActionSupport extends ActionSupport implements SessionAware, ParameterAware
{
  private static final long serialVersionUID = 1L;  
  protected SessionMap<String, Object> session;
  protected Map<String, String[]> parameters;
  
  protected String getModule()
  {
    return StringUtils.upperCase(getClass().getSimpleName());
  }
  
  public void setSession(Map<String, Object> session)
  {
    try
    {
      this.session = ((SessionMap)session);
    }
    catch (ClassCastException e)
    {
      e.printStackTrace();
    }
  }
  
  public void setParameters(Map<String, String[]> parameters)
  {
    this.parameters = parameters;
  }
  
  protected Map<String, String[]> getParameters()
  {
    return this.parameters;
  }
}
