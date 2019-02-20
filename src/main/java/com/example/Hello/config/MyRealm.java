package com.example.Hello.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Hello.dao.PermissionMapper;
import com.example.Hello.dao.RoleMapper;
import com.example.Hello.dao.RolePermissionMapper;
import com.example.Hello.dao.UserMapper;
import com.example.Hello.dao.UserRoleMapper;
import com.example.Hello.entity.RolePermission;
import com.example.Hello.entity.User;
import com.example.Hello.entity.UserRole;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		System.out.println("进入权限配置方法中");
		String username = (String) collection.getPrimaryPrincipal();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", username);
		User user = userMapper.getOne(map);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		map.put("user_id", user.getUser_id());
		List<UserRole> roleList = userRoleMapper.getAll(map);
		for (UserRole userRole : roleList) {
			authorizationInfo.addRole(roleMapper.getRole(userRole.getRole_id()));
			map.put("role_id", userRole.getRole_id());
			List<RolePermission> permissionList = rolePermissionMapper.getAll(map);
			for (RolePermission rolePermission : permissionList) {
				String permission = permissionMapper.getPermission(rolePermission.getPermission_id());
				System.out.println("权限是:"+permission);
				authorizationInfo.addStringPermission(permission);
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
	        throws AuthenticationException {
	    System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
	    //获取用户的输入的账号.
	    String username = (String)token.getPrincipal();
	    System.out.println(username);
	    String password = new String((char[])token.getCredentials());
	    System.out.println(password);
	    //通过username从数据库中查找 User对象，如果找到，没找到.
	    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("username", username);
	    User user = userMapper.getOne(map);
	    System.out.println("----->>userInfo="+user);
	    if(user == null){
	        return null;
	    }
	    System.out.println("看看我可爱的盐："+user.getSalt());
	    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	    		username, //用户名
	            user.getPassword(), //密码
	            //ByteSource.Util.bytes(user.getSalt()),//salt=username+salt
	            getName()  //realm name
	    );
	    authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
	    return authenticationInfo;
	}

}
