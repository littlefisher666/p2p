package dao;

import java.io.Serializable;
import java.util.List;

/**
 * 通用的数据访问对象
 * @author 靳雅楠
 *
 */

public interface GenericDao<E extends Serializable,PK extends Serializable> {
	/**
	 * 保存一个实体对象
	 * @param e 实体对象
	 */
	public void insert(E e);
	
	/**
	 * 删除一个实体对象
	 * @param e 实体对象
	 */
	public void delete(E e);
	
	/**
	 * 根据主键删除一个实体对象
	 * @param id 主键
	 */
	public void deleteById(PK id);
	
	/**
	 * 更新一个实体对象
	 * @param e 实体对象
	 */
	public void update(E e);
	
	/**
	 * 根据主键查询一个实体对象
	 * @param id 主键
	 * @return 实体对象
	 */
	public E selectById(PK id);
	
	/**
	 * 查询所有的实体对象
	 * @return 封装了所有实体对象的集合
	 */
	public List<E> selectAll();	
}
