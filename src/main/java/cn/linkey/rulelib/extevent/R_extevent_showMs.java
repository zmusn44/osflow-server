package cn.linkey.rulelib.extevent;

import cn.linkey.orm.doc.Document;
import cn.linkey.rule.rule.LinkeyRule;
import cn.linkey.workflow.factory.BeanCtx;
import cn.linkey.workflow.wf.ProcessEngine;

import java.util.HashMap;

/**
 * 扩展流程事件调用示例
 * 1、必须在cn.linkey.rulelib.extevent包下，名字必须为R_extevent_开头
 * 2、默认返回空字符串，不能返回null
 *
 * @author alibao Y , walkwithdream@163.com
 * <p>createTime 2021-01-27 15:52 </p>
 * @version v1.0
 */
public class R_extevent_showMs implements LinkeyRule {


    @Override
    public String run(HashMap<String, Object> params) throws Exception {
        //params为运行本规则时所传入的参数
        ProcessEngine engine = BeanCtx.getLinkeywf(); //获得流程引擎实例
        Document doc = engine.getDocument(); //获得流程实例文档对像

        // 获取调用事件的类型
        String Eventid = (String) params.get("Eventid");
        System.out.println("当前节点： " + engine.getCurrentNodeid() + "    流程事件类型： " + Eventid);

        // 流程文档信息
        // System.out.println(doc.toJson());

        return "";
    }
}
