package com.example.Hello.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
/*import org.springframework.stereotype.Component;*/

import com.example.Hello.util.SessionUtil;

/**
 * mycat拦截器，用于注释sql，查询或更改当前用户信息
 * @author YQ13512
 *
 */
@Intercepts(
        @Signature(type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class,Integer.class}))
/*@Component*/
public class MyInterceptor implements Interceptor{
	private static final String preState="/*!mycat:datanode=";
    private static final String afterState="*/";
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler  statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		Object object=null;
		while(metaStatementHandler.hasGetter("h")){
			object=metaStatementHandler.getValue("h");
			metaStatementHandler = SystemMetaObject.forObject(object);
		}
		statementHandler=(StatementHandler)object;
		String sql=(String)metaStatementHandler.getValue("delegate.boundSql.sql");
		/*
        String node=(String)TestController.threadLocal.get();
        */
		String node=(String) SessionUtil.getSession().getAttribute("corp");
		if(node!=null) {
            sql = preState + node + afterState + sql;
        }
		System.out.println("sql is "+sql);
        metaStatementHandler.setValue("delegate.boundSql.sql",sql);
        Object result = invocation.proceed();
        System.out.println("Invocation.proceed()");
        return result;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		String prop1 = properties.getProperty("prop1");
        String prop2 = properties.getProperty("prop2");
        System.out.println(prop1 + "------" + prop2);
	}
	
}
