package service;

import java.util.List;

import entity.Product;

/**
 * 产品服务对象
 * @author 靳雅楠
 *
 */
public interface ProductService {

	/**
	 * 查询所有的产品信息
	 * @return 封装了产品信息的List集合，当产品不存在时，返回一个空的List集合
	 */
	public List<Product> qryProductAll();
	
	/**
	 * 根据条件查询产品
	 * @param financingAmountFrom 最低利率
	 * @param financingAmountTo 最高利率
	 * @param primeLendingRateFrom 最低贷款规模
	 * @param primeLendingRateTo 最高贷款规模
	 * @param productTypeId 产品类型id
	 * @param lendingPeriodId 贷款周期id
	 * @return 封装了产品信息的List集合，当产品不存在时，返回一个空的List集合
	 */
	public List<Product> qryProductByType(Integer financingAmountFrom, Integer financingAmountTo,
									      Double primeLendingRateFrom, Double primeLendingRateTo,
										  Integer productTypeId,Integer lendingPeriodId);
	
	/**
	 * 按照产品贷款周期查询所有的产品信息
	 * @param lendingPeriodId 贷款周期的id
	 * @return 封装了产品信息的List集合，当产品不存在时，返回一个空的List集合
	 */
	public List<Product> qryProductByLendingPeriod(Integer lendingPeriodId);
	
	/**
	 * 按照产品贷款利率的范围查询所有的产品信息
	 * @param primeLendingRateFrom 贷款利率的最低值
	 * @param primeLendingRateTo 贷款利率的最高值
	 * @return 封装了产品信息的List集合，当产品不存在时，返回一个空的List集合
	 */
	public List<Product> qryProductByPrimeLendingRate(Double primeLendingRateFrom,Double primeLendingRateTo);
	
	/**
	 * 按照产品贷款规模的范围查询所有的产品信息
	 * @param financingAmountFrom 贷款规模的最低值
	 * @param financingAmountTo 贷款规模的最高值
	 * @return 封装了产品信息的List集合，当产品不存在时，返回一个空的List集合
	 */
	public List<Product> qryProductByFinancingAmount(Integer financingAmountFrom,Integer financingAmountTo);
	
	/**
	 * 按照产品id查询一个产品信息
	 * @param productId 产品id
	 * @return 封装了产品信息的对象
	 */
	public Product qryProductById(Integer productId);
	
	/**
	 * 首页显示所有产品信息（默认按Date排序）
	 * @return 封装了产品信息的List集合，当产品不存在时，返回一个空的List集合
	 */
	public List<Product> index();
	
	/**
	 * product首页显示当前产品的详细信息并可申请
	 * @param productId 产品id
	 * @return 封装了产品信息的对象
	 */
	public Product productIndex(Integer productId);
	
	/**
	 * 产品管理页面显示的信息
	 * @param userName 管理员的userName(即产品的linkMan)
	 * @return 封装了产品信息的List集合，当产品不存在时，返回一个空的List集合
	 */
	public List<Product> productManager(String userName);
	
	/**
	 * 在线申请管理页面显示的信息
	 * @return 封装了所有产品信息的集合，当产品不存在时，返回一个空的List集合
	 */
	public List<Product> onlineApply();
	
	/**
	 * 添加一件产品
	 * @param product 封装了产品信息的对象
	 */
	public void addProduct(Product product);
	
	/**
	 * 根据产品id查询产品详细信息
	 * @param productId 产品id
	 * @return 封装了产品信息的对象
	 */
	public Product productDetail(Integer productId);
	
	/**
	 * 修改产品信息
	 * @param product 封装了产品信息的对象
	 */
	public void productModify(Product product);
	
}








