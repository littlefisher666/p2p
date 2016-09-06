package action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.News;
import entity.Product;

import service.NewsService;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;

/**
 * 新闻的Action对象
 * @author 靳雅楠
 *
 */
public class NewsAction extends BaseAction{

	private NewsService newsService;
	private List<News> allNews;
	private News news;
	private News firstNews;
	private Integer newsId;
	private Integer page;
	private Integer pageSum;
	private File image;
	private String imageFileName;
	
	

	/*
	 * Action业务方法
	 */
	public String newsIndex() throws Exception {
		List<News> ons = newsService.newsIndex();
		List<News> nns = new ArrayList<News>();
		if(ons.size() > 5) {
			for (int i = 0; i < 5; i++) {
				nns.add(ons.get(i));
			}
			allNews = nns;
		} else {
			allNews = ons;
		}
		firstNews = allNews.get(0);
		pageSum = ons.size()/5+1;
		System.out.println("pageSum:"+pageSum);
		return SUCCESS;
		
	}
	
	public String firstNews() throws Exception {
		news = newsService.firstNews();
		return SUCCESS;
	}
	
	public String allNewsExceptFirst() throws Exception {
		allNews = newsService.allNewsExceptFirst();
		return SUCCESS;
	}
	
	public String newsManage() throws Exception {
		allNews = newsService.newsManage();
		return SUCCESS;
	}
	
	public String newsAdd() throws Exception {
		System.out.println("NewsAction newsAdd uploadFileName:"+imageFileName);
		long now = System.currentTimeMillis();
		int index = imageFileName.lastIndexOf(".");
		String newFileName = now + imageFileName.substring(index);
		System.out.println("NewsAction newsAdd newFileName:"+newFileName);
		news.setCreateAt(new Date());
		news.setImage(newFileName);
		newsService.newsSave(image,newFileName);
		newsService.addNews(news);
		return SUCCESS;
	}
	
	public String newsDetail() throws Exception {
		news = newsService.newsDetail(newsId);
		return SUCCESS;
	}
	
	public String newsModify() throws Exception {
		newsService.newsModify(news);
		return SUCCESS;
	}
	
	public String toNewsModify() throws Exception {
		news = newsService.newsDetail(newsId);
		return SUCCESS;
	}
	
	
	
	/*
	 * GET/SET方法
	 */
	public NewsService getNewsService() {
		return newsService;
	}

	public News getFirstNews() {
		return firstNews;
	}

	public void setFirstNews(News firstNews) {
		this.firstNews = firstNews;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSum() {
		return pageSum;
	}

	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public List<News> getAllNews() {
		return allNews;
	}

	public void setAllNews(List<News> allNews) {
		this.allNews = allNews;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	
	
	
	
	
	
	
}
