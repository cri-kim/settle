package com.pilot.common.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XSSFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		log.info("XSSFilter IN");
		filterChain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
		log.info("XSSFilter OUT");
	}

}
class RequestWrapper extends HttpServletRequestWrapper{

	public RequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }
  
    public String[] getParameterValues(String parameter) {
      String[] values = super.getParameterValues(parameter);
      if (values==null)  {
                  return null;
          }
      int count = values.length;
      String[] encodedValues = new String[count];
      for (int i = 0; i < count; i++) {
                 encodedValues[i] = cleanXSS(values[i]);
       }
      return encodedValues;
    }
  
    public String getParameter(String parameter) {
          String value = super.getParameter(parameter);
          if (value == null) {
                 return null;
                  }
          return cleanXSS(value);
    }
  
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return cleanXSS(value);
  
    }
  
    private String cleanXSS(String value) {
		value = value.replaceAll("&", "&amp;")
				 .replaceAll("<", "&lt;")
				 .replaceAll(">","&gt;")
				 .replaceAll("\"", "&quot;")
				 .replaceAll("\'", "&lsquot")
				 .replaceAll("`", "&rsquot")
				 .replaceAll("%", "&#37;")
				 .replaceAll("%2F", "");
		System.out.print("aa" + value);
        return value;
    }
	
}
