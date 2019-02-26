package javax.servlet;
/**
 * 负责封装请求参数对象
 * @author SUN公司
 * @version	1.0
 * @since	1.0
 *
 */
public interface ServletRequest {
	/**
	 * 获取单个参数的值
	 * @param key 
	 * @return String
	 */
	String getParameterValue(String key);
	/**
	 * 获取多选框的值
	 * @param key
	 * @return String[]
	 */
	String[] getParameterValues(String key);
}
