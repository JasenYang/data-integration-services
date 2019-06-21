package com.aimspeed.gatherer.service.rule;

import java.util.List;

import com.aimspeed.common.vo.ResultVo;
import com.aimspeed.gatherer.entity.bean.mysql.request.CookieMySqlBean;
import com.aimspeed.gatherer.entity.bean.mysql.request.RequestHeaderMySqlBean;
import com.aimspeed.gatherer.entity.bean.mysql.request.RequestParamMySqlBean;
import com.aimspeed.gatherer.entity.bean.mysql.rule.CrawlerMySqlBean;
import com.aimspeed.gatherer.entity.bean.mysql.user.UserMySqlBean;
import com.aimspeed.gatherer.service.httpclient.HttpClientResult;
import com.aimspeed.mysql.BaseMySqlService;

/**
 * 基础规则表
 * @author AimSpeed
 */
public interface CrawlerService extends BaseMySqlService<CrawlerMySqlBean> {
	
	/**
	 * 验证是否已存在后再保存
	 * @author AimSpeed
	 * @param sysUserBean
	 * @param crawlerBean
	 * @return ResultVo 
	 */
	ResultVo save(UserMySqlBean sysUserBean,CrawlerMySqlBean crawlerBean);
	
	/**
	 * 取消添加采集者，删除所有添加过的request包的数据，采集规则数据
	 * @author AimSpeed
	 * @param sysUserBean
	 * @param id
	 * @return ResultVo 
	 */
	ResultVo cancelAddCrawler(UserMySqlBean sysUserBean,Integer id);
	
	/**
	 * 通过改变状态决定是否要运行
	 * @author AimSpeed
	 * @param loginAccount
	 * @param id
	 * @param flag
	 * @return ResultVo 
	 */
	ResultVo runOfChangeStatus(String loginAccount,Integer id,String flag);

	/**
	 * 根据采集的Id查询到对应的配置信息，获取访问对应URL所返回的信息
	 * @author AimSpeed
	 * @param crawlerId
	 * @param requestUrl
	 * @return HttpClientResult 
	 */
	HttpClientResult crawlerRuleToRequest(Integer crawlerId,String requestUrl);
	
	/**
	 * 根据采集的Id查询到对应的配置信息，获取访问对应URL所返回的信息
	 * @author AimSpeed
	 * @param sequence
	 * @param requestUrl
	 * @return HttpClientResult 
	 */
	HttpClientResult crawlerRuleToRequest(String sequence,String requestUrl);

	/**
	 * 根据采集的Id查询到对应的配置信息，获取访问对应URL所返回的信息
	 * @param sequence
	 * @param requestUrl
	 * @param reqHeader
	 * @param requestParam
	 * @param cookie
	 * @return HttpClientResult  
	 */
	HttpClientResult crawlerRuleToRequest(String sequence,String requestUrl,Boolean reqHeader,Boolean requestParam,Boolean cookie);
	
	/**
	 * 根据配置信息，获取访问对应URL所返回的信息
	 * @author AimSpeed
	 * @param requestUrl
	 * @param crawlerBean
	 * @param cookieBeans
	 * @param reqHeaderMsgBeans
	 * @return HttpClientResult 
	 */
	HttpClientResult crawlerRuleToRequest(String requestUrl,CrawlerMySqlBean crawlerBean,List<RequestParamMySqlBean> requestParamBeans,List<CookieMySqlBean> cookieBeans,List<RequestHeaderMySqlBean> reqHeaderMsgBeans);
	
	/**
	 * 判断是否是异步页面
	 * @author AimSpeed
	 * @param sequence
	 * @param isAsync
	 * @return ResultVo
	 */
//	ResultVo isAsync(String sequence, String isAsync);
	
	

	 

}
