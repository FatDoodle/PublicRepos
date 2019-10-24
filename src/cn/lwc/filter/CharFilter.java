package cn.lwc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		arg0.setCharacterEncoding("UTF-8");
		 System.out.println("这里是..........." + this.getClass().getName());
		 System.out.println("字符编码是" + arg0.getCharacterEncoding());
		 System.out.println("toString..........." + arg0.toString());
		 System.out.println(arg0.getReader());
		 System.out.println("baseDictSource.dictId.............." +
		 arg0.getParameter("baseDictSource.dictId"));
		 System.out.println("baseDictIndustry.dictId.............." +
		 arg0.getParameter("baseDictIndustry.dictId"));
		 System.out.println("baseDictLevel.dictId.............." +
		 arg0.getParameter("baseDictLevel.dictId"));
		 String source=arg0.getParameter("baseDictSource.dictId");
		 if(source!=null){
		 String newSource=new String(source.getBytes("utf-8"), "GBK");
		 System.out.println(newSource);
		 }
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
