package cn.linkey.rulelib.extevent;

import cn.linkey.rule.rule.LinkeyRule;
import cn.linkey.workflow.factory.BeanCtx;

import java.util.HashMap;

/**
 * 示例：流程文档被退回时输出信息
 *
 * @author alibao Y , walkwithdream@163.com
 * <p>createTime 2021-01-28 14:42 </p>
 * @version v1.0
 */
public class R_extevent_ProcessReturn implements LinkeyRule {

    @Override
    public String run(HashMap<String, Object> params) throws Exception {

        //params为运行本规则时所传入的参数
        String actionid = (String) params.get("WF_Action"); //获得作id
        String sql = "select IsReturnAction from BPM_EngineActionConfig where Actionid='" + actionid + "'";
        String isReturnAction = BeanCtx.getRdb().getValueBySql(sql);
        if (isReturnAction.equals("1")) {
            //说明是回退事件
            System.out.println("文档(" + BeanCtx.getLinkeywf().getDocument().g("Subject") + ")被回退了!");
        }

        return "";
    }
}
