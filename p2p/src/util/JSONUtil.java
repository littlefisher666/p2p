package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.ProductType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;


/**
 * JSON转换工具类
 * @author 靳雅楠
 *
 */
public class JSONUtil {
	public static String productToJSON(List products) {
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			
			@Override
			public boolean apply(Object source, String name, Object value) {
				if("productName".equals(name) || "companyName".equals(name) || "productTypeName".equals(name) || 
				   "primeLendingRateFrom".equals(name) || "primeLendingRateTo".equals(name) || "financingAmountFrom".equals(name) || 
				   "financingAmountTo".equals(name) || "period".equals(name) || "company".equals(name) || "productType".equals(name) ||
				   "lendingPeriod".equals(name)){
					return false;
				} else {
					return true;
				}
			}
		});
		String productJSON = JSONArray.fromObject(products,config).toString();
		return productJSON;
	}
	
	
	
	
	
	
	
	
	
	
	
}
