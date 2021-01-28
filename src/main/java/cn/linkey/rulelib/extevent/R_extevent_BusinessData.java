package cn.linkey.rulelib.extevent;

import cn.linkey.orm.doc.Document;
import cn.linkey.rule.rule.LinkeyRule;
import cn.linkey.workflow.factory.BeanCtx;
import cn.linkey.workflow.wf.ProcessEngine;

import java.util.HashMap;

/**
 *
 * 示例： 流程主表单数据写入到业务表中去
 * <p>把流程主表单数据拷贝到业务表单中去，所有字段同名</p>
 *
 * @author alibao Y , walkwithdream@163.com
 * <p>createTime 2021-01-28 14:00 </p>
 * @version v1.0
 */
public class R_extevent_BusinessData implements LinkeyRule {

    @Override
    public String run(HashMap<String, Object> params) throws Exception {

        //params为运行本规则时所传入的参数
        ProcessEngine engine= BeanCtx.getLinkeywf(); //获得流程引擎实例
        Document doc=engine.getDocument(); //获得流程实例文档对像

        //在业务表中创建一个文档对像并保存
        Document newDoc=BeanCtx.getDocumentBean("App_TempCRUD");
        doc.copyAllItems(newDoc); //把流程主表单数据拷贝到业务表单中去，所有字段同名
        //如果字段不同名则可以用newDoc.s("fd01",doc.g("Subject"));

        //如果业务表中的数据WF_OrUnid与doc的WF_OrUnid字段一至则为update否则为insert
        //如果不想用WF_OrUnid为关键字更新业务数据可以调用doc.setKeyid()方法更改key字段
        newDoc.save(); //直接保存文档对像即可

        return "";
    }
}
