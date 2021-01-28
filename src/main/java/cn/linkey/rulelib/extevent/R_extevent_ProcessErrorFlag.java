package cn.linkey.rulelib.extevent;

import cn.linkey.orm.dao.Rdb;
import cn.linkey.rule.rule.LinkeyRule;
import cn.linkey.workflow.factory.BeanCtx;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.JdbcUtils;

import java.sql.Connection;
import java.util.HashMap;

/**
 *
 * 流程出错时把流程标记为异常状态
 *
 * @author alibao Y , walkwithdream@163.com
 * <p>createTime 2021-01-28 15:13 </p>
 * @version v1.0
 */
public class R_extevent_ProcessErrorFlag implements LinkeyRule {

    @Override
    public String run(HashMap<String, Object> params) throws Exception {

        Connection newConn = null;
        Rdb rdb = BeanCtx.getRdb();

        try {
            newConn = new DruidDataSource().getConnection(); //获得一个新链接,以免被回滚掉
            String sql = "update BPM_MainData set WF_Folderid='ERROR' where WF_OrUnid='" + BeanCtx.getLinkeywf().getDocUnid() + "'";
            rdb.execSql(newConn, sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(newConn);
        }

        return "";
    }

}
