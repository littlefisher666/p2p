package service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import dao.NewsDao;

import entity.News;
import service.NewsService;
/**
 * 新闻服务对象的实现
 * @author 靳雅楠
 *
 */
public class NewsServiceImpl implements NewsService {

	private NewsDao nd;
	
	@Override
	public void addNews(News news) {
		nd.insert(news);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> allNewsExceptFirst() {
		return (List<News>) newsIndex().remove(0);
	}

	@Override
	public News firstNews() {
		return newsIndex().get(0);
	}

	@Override
	public News newsDetail(Integer newsId) {
		return nd.selectById(newsId);
	}

	@Override
	public List<News> newsIndex() {
		return nd.selectAll();
	}

	@Override
	public List<News> newsManage() {
		return nd.selectAll();
	}

	@Override
	public void newsModify(News news) {
		nd.updateNews(news);
	}

	@Override
	public void newsSave(File image,String newFileName) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(image);
			String dir = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("images/news");
			File uploadImage = new File(dir,newFileName);
			out = new FileOutputStream(uploadImage);  
			byte[] buffer = new byte[1024 * 1024]; 
			int length;  
			while ((length = in.read(buffer)) > 0) {   
                out.write(buffer, 0, length);   
            }
            in.close();
            out.close(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	
	public NewsDao getNd() {
		return nd;
	}

	public void setNd(NewsDao nd) {
		this.nd = nd;
	}

}
