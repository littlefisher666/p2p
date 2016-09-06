package dao;

import entity.Sysuser;

/**
 * 管理员数据访问对象
 * @author 靳雅楠
 *
 */
public interface SysuserDao extends GenericDao<Sysuser, Integer>{
	
	/**
	 * 根据管理员的用户名和密码登录
	 * @param sysuser 封装了管理员信息的对象
	 * @return 封装了管理员信息的对象
	 */
	public Sysuser selectBySysuser(Sysuser sysuser);
	
	/**
	 * 根据id修改密码
	 * @param sysuser 封装了管理员信息的对象
	 */
	public void updateSysuser(Sysuser sysuser);
}
