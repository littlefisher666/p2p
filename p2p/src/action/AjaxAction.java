package action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import service.NewsService;
import service.ProductService;
import util.JSONUtil;
import entity.News;
import entity.Product;

/**
 * 专门用来处理ajax的Action
 * @author 靳雅楠
 *
 */
public class AjaxAction extends BaseAction {
	
	private NewsService newsService;
	private ProductService productService;
	private Integer productType;
	private Integer lendingPeriod;
	private Double primeLendingRateFrom;
	private Double primeLendingRateTo;
	private Integer financingAmountFrom;
	private Integer financingAmountTo;
	private Integer page;
	private Integer pageSum;
	private List<Product> products;
	private List<News> allNews;
	private List<Object> data = new ArrayList<Object>();
	
	
	public String selectNewsByPage() throws Exception {
		List<News> ons = newsService.newsIndex();
		
		List<News> nns = new ArrayList<News>();
		if(ons.size() <= page*5-1) {
			for (int i = (page - 1)*5; i < ons.size(); i++) {
				nns.add(ons.get(i));
			}
		} else {
			for (int i = (page - 1)*5; i < page*5-1; i++) {
				nns.add(ons.get(i));
			}
		}
		allNews = nns;
		System.out.println("allNews:"+allNews);
		pageSum = ons.size()/5+1;
		data.add(allNews);
		data.add(pageSum);
		return SUCCESS;
	}
	
	public String selectProductByPage() throws Exception {
//		System.out.println("AjaxAction selectProductByPage page:"+page);
		if(0 == productType) {
			productType = null;
		}
		if(0 == lendingPeriod) {
			lendingPeriod = null;
		} 
		System.out.println("page="+page+"&productType="+productType+"&lendingPeriod="+lendingPeriod+"&primeLendingRateFrom="+primeLendingRateFrom+
				 "&primeLendingRateTo="+primeLendingRateTo+"&financingAmountFrom="+financingAmountFrom+"&financingAmountTo="+financingAmountTo); 
		
		List<Product> ops = productService
					.qryProductByType(financingAmountFrom, financingAmountTo, primeLendingRateFrom, primeLendingRateTo, productType, lendingPeriod);
		List<Product> nps = new ArrayList<Product>();
		if(ops.size() <= page*10-1) {
			for (int i = (page-1)*10; i < ops.size(); i++) {
				nps.add(ops.get(i));
			}
		} else {
			for (int i = (page-1)*10; i < page*10-1; i++) {
				nps.add(ops.get(i));
			}
		}
		System.out.println("ProductAction selectProductByPage ops:"+ops);
		products = nps;
		System.out.println("ProductAction selectProductByPage products:"+products);
		pageSum = ops.size()/10+1;
		data.add(products);
		data.add(pageSum);
		return SUCCESS;
	}
	
	public String selectProductByType() throws Exception {
		if(0 == productType) {
			productType = null;
		}
		if(0 == lendingPeriod) {
			lendingPeriod = null;
		} 
		System.out.println("page="+page+"&productType="+productType+"&lendingPeriod="+lendingPeriod+"&primeLendingRateFrom="+primeLendingRateFrom+
				 "&primeLendingRateTo="+primeLendingRateTo+"&financingAmountFrom="+financingAmountFrom+"&financingAmountTo="+financingAmountTo); 
		
		List<Product> ops = productService
					.qryProductByType(financingAmountFrom, financingAmountTo, primeLendingRateFrom, primeLendingRateTo, productType, lendingPeriod);
		List<Product> nps = new ArrayList<Product>();
		if(ops.size() > 10) {
			for (int i = 0; i < 10; i++) {
				nps.add(ops.get(i));
			}
		} else {
			nps = ops;
		}
		products = nps;
//		System.out.println("=========================================================================");
//		System.out.println(products);
		pageSum = ops.size()/10+1;
		data.add(products);
		data.add(pageSum);
		return SUCCESS;
	}
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}
	@JSON(serialize=false)
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Integer getLendingPeriod() {
		return lendingPeriod;
	}

	public void setLendingPeriod(Integer lendingPeriod) {
		this.lendingPeriod = lendingPeriod;
	}

	public Double getPrimeLendingRateFrom() {
		return primeLendingRateFrom;
	}

	public void setPrimeLendingRateFrom(Double primeLendingRateFrom) {
		this.primeLendingRateFrom = primeLendingRateFrom;
	}

	public Double getPrimeLendingRateTo() {
		return primeLendingRateTo;
	}

	public void setPrimeLendingRateTo(Double primeLendingRateTo) {
		this.primeLendingRateTo = primeLendingRateTo;
	}

	public Integer getFinancingAmountFrom() {
		return financingAmountFrom;
	}

	public void setFinancingAmountFrom(Integer financingAmountFrom) {
		this.financingAmountFrom = financingAmountFrom;
	}

	public Integer getFinancingAmountTo() {
		return financingAmountTo;
	}

	public void setFinancingAmountTo(Integer financingAmountTo) {
		this.financingAmountTo = financingAmountTo;
	}

	public NewsService getNewsService() {
		return newsService;
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



	
}
