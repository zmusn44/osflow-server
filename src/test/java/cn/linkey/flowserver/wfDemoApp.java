package cn.linkey.flowserver;

import cn.linkey.workflow.api.WorkFlow;
import cn.linkey.workflow.api.WorkFlowImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class wfDemoApp {


    private Connection conn;

    public static void main(String[] args) {

        wfDemoApp app = new wfDemoApp();
        // 获取数据源
        Connection conn = app.getConn();

        // 1 获得当前所有流程
//        app.getProcessMsg();

        // 2 打开流程审批单,（获取表单显示模板和业务数据接口）
//        app.openProcess("ff0c81f70938404056096810ecfa7baae53b",
//                "433c77e90c28204ed90a0d400d27774580ac","lili");

        // 3 启动或提交流程
//        app.submitProcess();

        // 4 获取审批过程信息
//        app.getApprovalInfo("4394e62009efd042960b5de0a89aa8543a08");

        // 获取用户待办列表
//        app.showToDo("admin");


        app.close();

    }

    /**
     * 启动流程、提交流程、审批流程
     */
    private void submitProcess() {
        WorkFlow workFlow = new WorkFlowImpl(conn);
        String processid = "433c77e90c28204ed90a0d400d27774580ac";
        String docUnid = ""; //流程文档ID
        String taskid = "";  // 用户任务ID【可选，多实例时则需要传】
        String action = "EndUserTask"; // 【提交动作】 GoToFirstNode、GoToOthers、EndUserTask、BackToDeliver、ReturnToAnyNode、
        // BackToReturnUser、GoToAnyNode、GoToPrevUser、GoToPrevNode、GoToArchived、GoToNextParallelUser、GoToNextNode
        String currentNodeid = ""; // 当前节点
        String nextNodeid = "T00002";   // 下一个节点
        String nextUserList = "admin"; // 下一个审批处理人ID
        String copyUserList = "";  // 传阅用户ID
        String userid = "lili";
        String remark = "lili给admin";
        String isBackFlag = ""; // 标记为回退，当为回退任意环节时，isBackFlag值可以为2，表示回退后需要直接返回给回退者
        String reassignmentFlag = ""; // 转交时是否需要转交者返回的标记1表示不需要2表示需要
        JSONObject maindata = new JSONObject();

        // 表单数据
//        maindata.put("name","lili");
//        maindata.put("phone","7758258");
//        maindata.put("sex","1");
//        maindata.put("age","22");

        String msg = workFlow.runProcess(processid, docUnid, taskid, action, currentNodeid,
                nextNodeid, nextUserList, copyUserList, userid, remark, isBackFlag, reassignmentFlag, maindata);
        System.out.println("流程提交结果：" + msg);
    }

    /**
     * 打开一个流程（获取表单显示模板和业务数据接口）
     * @param docUnid    文档ID
     * @param processid  流程ID
     * @param userid     用户ID
     */
    private void openProcess(String docUnid, String processid, String userid) {

        System.out.println("\n\n=====================" + userid + "打开流程=========================");
        WorkFlow workFlow = new WorkFlowImpl(conn);
        JSONObject object = workFlow.openProcess(docUnid, processid, userid);
        System.out.println(object.toJSONString());
    }

    /**
     * 获取审批过程信息
     * @param docUnid 文档ID
     */
    private void getApprovalInfo(String docUnid) {

        System.out.println("\n\n===========文档  " + docUnid + "  审批过程=============");
        WorkFlow workFlow = new WorkFlowImpl(conn);
        JSONObject object = workFlow.getApprovalInfo(docUnid);
        System.out.println(object.toJSONString());
    }


    /**
     * 获取用户待办
     *
     * @param userid
     */
    public void showToDo(String userid) {

        System.out.println("\n\n======================== 用户待办 =========================");

        WorkFlow workFlow = new WorkFlowImpl(conn);
        JSONArray TODOJSONArr = workFlow.getUserToDoInfo(userid);
        System.out.println(TODOJSONArr.toJSONString());
    }

    /**
     * 获取所有流程信息
     *
     * @return 所有流程信息的JSONObject对象
     */
    public void getProcessMsg() {

        System.out.println("\n\n========================所有流程信息=========================");

        WorkFlow workFlow = new WorkFlowImpl(conn);
        JSONArray processMsg = workFlow.getProcessMsg();
        System.out.println(processMsg.toJSONString());
    }

    /**
     * 获取连接 conn
     *
     * @return
     */
    private Connection getConn() {
        Connection conn = null;
        try {
            Properties properties = readPropertiesFile("application.yml");
            String driver = properties.getProperty("spring.datasource.driver-class-name");
            String url = properties.getProperty("spring.datasource.url");
            String username = properties.getProperty("spring.datasource.username");
            String password = properties.getProperty("spring.datasource.password");

            //加载驱动
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.conn = conn;
        return conn;
    }

    /**
     * 通过配置文件名读取内容
     *
     * @param fileName
     * @return
     */
    public static Properties readPropertiesFile(String fileName) {
        try {
            Resource resource = new ClassPathResource(fileName);
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            return props;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 关闭连接
     */
    private void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                conn = null;
                e.printStackTrace();
            }
        }
    }

}
