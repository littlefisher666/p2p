package dao;

import java.util.List;

import entity.News;
/**
 * 新闻的数据访问对象
 * @author 靳雅楠
 *
 */
public interface NewsDao extends GenericDao<News, Integer> {
	
	/**
	 * 查询所有的news，按Date排序
	 * @return 封装了新闻信息的集合，如果未查询到则返回空的集合
	 */
	public List<News> selectAllByDate();
	
	/**
	 * 根据新闻id更改新闻的状态
	 * @param newsId 新闻id
	 * @param status 要修改成的状态
	 */
	public void updateNewsStatus(Integer newsId,String status);
	
	/**
	 * 根据newsId修改news内容
	 * @param news
	 */
	public void updateNews(News news);
	
}
