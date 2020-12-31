package cn.linkey.flowserver;

import cn.linkey.orm.util.Tools;
import cn.linkey.workflow.api.WorkFlow;
import cn.linkey.workflow.api.WorkFlowImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 流程引擎接口服务
 * add by alibao 202012
 * walkwithdream@163.com
 */
@RestController
@SpringBootApplication
public class FlowAPI {

    // 注入数据源对象
    @Resource
    private DataSource dataSource;

    /**
     * 获取所有流程信息
     *
     * @return 流程JSON数组字符串
     * [{"FormNumber":"","NodeName":"测试流程","OtherProcessName":"","WF_OrUnid":"f27d7992052d5041e108f770123f57780980","formConfig":"{\"total\":2,\"rows\":[{\"name\":\"name\",\"lable\":\"姓名\",\"value\":\"\",\"required\":\"true\",\"inputtype\":\"text\",\"params\":\"\",\"readtype\":\"EDIT\",\"remark\":\"\"},{\"name\":\"phone\",\"lable\":\"电话\",\"value\":\"\",\"required\":\"\",\"inputtype\":\"text\",\"params\":\"\",\"readtype\":\"EDIT\",\"remark\":\"\"}]}","WF_AddName":"","WordTemplate":"","ExceedTime":"0","Folderid":"","Deptid":"","ArchiveTableName":"BPM_ArchivedData","ProcessNumber":"","Nodeid":"Process","Processid":"68ae8f3705ffa04ca708f28031e99aec5cc8","AutoArchive":"1","ProcessOwner":"","Status":"0","WF_Version":"1.0","ProcessStarter":"","WF_DocCreated":"2020-11-10 14:36:36","ExtNodeType":"Process","SortNum":"1001","WF_AddName_CN":"","SaveDataHistory":"0","FormNumberForMobile":"","PrintTemplate":"","ProcessReader":"","WF_LastModified":"2020-11-10 14:38:24","icons":"","ProcessDesigner":"","ExtendTableName":"xmldata","WF_Appid":"S029","NodeType":"Process"},{"FormNumber":"","NodeName":"含有会签流程","OtherProcessName":"","WF_OrUnid":"6b426bc2012190482409bec0b85182868d5a","formConfig":"{\"total\":2,\"rows\":[{\"name\":\"title\",\"lable\":\"名称\",\"value\":\"\",\"required\":\"true\",\"inputtype\":\"text\",\"params\":\"\",\"readtype\":\"EDIT\",\"remark\":\"\"},{\"name\":\"remarked\",\"lable\":\"备注\",\"value\":\"\",\"required\":\"false\",\"inputtype\":\"text\",\"params\":\"\",\"readtype\":\"EDIT\",\"remark\":\"\"}]}","WF_AddName":"","WordTemplate":"","ExceedTime":"0","Folderid":"","Deptid":"","ArchiveTableName":"BPM_ArchivedData","ProcessNumber":"AlibaoT003","Nodeid":"Process","Processid":"bafed41c07dd304dc30be4107b679b35a471","AutoArchive":"1","ProcessOwner":"","Status":"0","WF_Version":"1.0","ProcessStarter":"","WF_DocCreated":"2020-11-03 11:09:44","ExtNodeType":"Process","SortNum":"1002","WF_AddName_CN":"","SaveDataHistory":"0","FormNumberForMobile":"","PrintTemplate":"","ProcessReader":"","WF_LastModified":"2020-11-03 11:47:39","icons":"","ProcessDesigner":"","ExtendTableName":"xmldata","WF_Appid":"S029","NodeType":"Process"},{"FormNumber":"","NodeName":"含有分支流程","OtherProcessName":"","WF_OrUnid":"e224e9230819c048000be800da1785b50816","formConfig":"","WF_AddName":"","WordTemplate":"","ExceedTime":"0","Folderid":"","Deptid":"","ArchiveTableName":"BPM_ArchivedData","ProcessNumber":"AlibaoT002","Nodeid":"Process","Processid":"a09a4672024ec048ea09d700796b50d9f947","AutoArchive":"1","ProcessOwner":"","Status":"0","WF_Version":"1.0","ProcessStarter":"","WF_DocCreated":"2020-11-03 10:45:02","ExtNodeType":"Process","SortNum":"1001","WF_AddName_CN":"","SaveDataHistory":"0","FormNumberForMobile":"","PrintTemplate":"","ProcessReader":"","WF_LastModified":"2020-11-03 11:45:02","icons":"","ProcessDesigner":"","ExtendTableName":"xmldata","WF_Appid":"S029","NodeType":"Process"},{"FormNumber":"","NodeName":"直线测试流程","OtherProcessName":"","WF_OrUnid":"3341cc7409f80044980a9a40636a513ae31a","formConfig":"{\"total\":4,\"rows\":[{\"inputtype\":\"text\",\"lable\":\"姓名\",\"name\":\"name\",\"params\":\"\",\"readtype\":\"EDIT\",\"remark\":\"\",\"required\":\"true\",\"value\":\"\"},{\"inputtype\":\"text\",\"lable\":\"手机号\",\"name\":\"phone\",\"params\":\"\",\"readtype\":\"EDIT\",\"remark\":\"\",\"required\":\"true\",\"value\":\"\"},{\"inputtype\":\"checkbox\",\"lable\":\"性别\",\"name\":\"sex\",\"params\":\"\",\"readtype\":\"EDIT\",\"remark\":\"\",\"required\":\"false\",\"value\":\"\"},{\"inputtype\":\"text\",\"lable\":\"年龄\",\"name\":\"age\",\"params\":\"\",\"readtype\":\"EDIT\",\"remark\":\"\",\"required\":\"false\",\"value\":\"\"}]}","WF_AddName":"","WordTemplate":"","ExceedTime":"0","Folderid":"","Deptid":"","ArchiveTableName":"BPM_ArchivedData","ProcessNumber":"AlibaoT001","Nodeid":"Process","Processid":"433c77e90c28204ed90a0d400d27774580ac","AutoArchive":"1","ProcessOwner":"","Status":"0","WF_Version":"1.0","ProcessStarter":"","WF_DocCreated":"2020-10-29 14:25:42","ExtNodeType":"Process","SortNum":"1001","WF_AddName_CN":"","SaveDataHistory":"0","FormNumberForMobile":"","PrintTemplate":"","ProcessReader":"","WF_LastModified":"2020-11-04 23:57:21","icons":"","ProcessDesigner":"","ExtendTableName":"xmldata","WF_Appid":"S029","NodeType":"Process"},{"FormNumber":"","NodeName":"固定资产流程","OtherProcessName":"","WF_OrUnid":"0aa56bea028b8044e70b5fc0c2b7cd1806ac","formConfig":"","WF_AddName":"","WordTemplate":"","ExceedTime":"0","Folderid":"","Deptid":"","ArchiveTableName":"BPM_ArchivedData","ProcessNumber":"TP_FIRST","Nodeid":"Process","Processid":"b9d23b3106510048cc08ffd0321ea0209bff","AutoArchive":"1","ProcessOwner":"dgw1833","Status":"0","WF_Version":"1.0","ProcessStarter":"","WF_DocCreated":"2020-09-24 19:36:35","ExtNodeType":"Process","SortNum":"1001","WF_AddName_CN":"","SaveDataHistory":"0","FormNumberForMobile":"","PrintTemplate":"","ProcessReader":"","WF_LastModified":"2020-10-15 19:26:07","icons":"","ProcessDesigner":"","ExtendTableName":"xmldata","WF_Appid":"S029","NodeType":"Process"}]
     */
    @RequestMapping(value = "/osflow/getProcessMsg", method = RequestMethod.GET)
    public String getProcessMsg() {

        // 获取数据源
        Connection conn = null;
        String result = "";

        try {
            conn = dataSource.getConnection();
            WorkFlow workFlow = new WorkFlowImpl(conn);

            JSONArray processMsg = workFlow.getProcessMsg();
            result = processMsg.toJSONString();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }

        return result;
    }

    /**
     * 打开流程初始化
     *
     * @param userid    用户唯一ID
     * @param processid 流程ID
     * @param docUnid   文档ID，当新启动流程时，docUnid的值为start
     * @return
     */
    @RequestMapping(value = "/osflow/openProcess/{userid}/{processid}/{docUnid}", method = RequestMethod.GET)
    public String openProcess(@PathVariable("userid") String userid, @PathVariable("processid") String processid, @PathVariable("docUnid") String docUnid) {

        // 特殊处理，当新启动流程时，docUnid的值为start，实际传入值因为空
        if ("start".equals(docUnid)) {
            docUnid = "";
        }
        // 当流程ID为0时，视为不传processid
        if (Tools.isNotBlank(docUnid) && "0".equals(processid)) {
            processid = "";
        }


        // 获取数据源
        Connection conn = null;
        String result = "";

        try {
            conn = dataSource.getConnection();
            WorkFlow workFlow = new WorkFlowImpl(conn);

            JSONObject openInitJson = workFlow.openProcess(docUnid, processid, userid);
            result = openInitJson.toJSONString();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }

        return result;
    }


    /**
     * 启动或提交流程
     * @param processid  流程ID，流程启动时必填，其他情况可为空；可由getProcessMsg或openProcess接口获得；
     * @param docUnid    文档ID，也叫流程实例ID，流程启动时为空，其他情况必填；可由openProcess接口获得；
     * @param taskid     用户实例ID，选填，一般情况可传空，可由openProcess接口获得；
     * @param action     动作ID，GoToFirstNode、GoToOthers、EndUserTask、BackToDeliver、ReturnToAnyNode、BackToReturnUser、GoToAnyNode、GoToPrevUser、GoToPrevNode、GoToArchived、GoToNextParallelUser、GoToNextNode
     * @param currentNodeid   当前节点ID
     * @param nextNodeid      下一个节点ID，多个时逗号隔开；
     * @param nextUserList    下一个节点处理人，多个时逗号隔开，支持格式： ①user01,user02  ②user01$T10003,user02$T10002
     * @param copyUserList    传阅用户
     * @param userid          必填，必须是当前审批用户；可由userTodo或getApprovalInfo接口获得；
     * @param remark          流转记录
     * @param isBackFlag         选填，一般为空，只有回退动作时才需要填写，当为回退任意环节时，isBackFlag值可以为2，表示回退后需要直接返回给回退者；其余回退情况值为1；
     * @param reassignmentFlag   选填，一般为空，只有转交时才需要填写，需要转交者返回的标记1表示不需要，标记2表示需要；
     * @param formData           选填，JSONObject格式的字符串数据；
     * @return    审批结果格式：{"msg":"文档成功给环节(人事审批)用户(hanfeizi)进行处理!","Status":"ok"}  错误：{"msg":"文档已被其他用户处理或者您没有处理权限!","Status":"ok"}
     */
    @RequestMapping(value = "/osflow/submitProcess", method = RequestMethod.POST)
    public String submitProcess(@RequestParam(name = "processid") String processid, @RequestParam(name = "docUnid") String docUnid,
                                @RequestParam(name = "taskid", required = false) String taskid, @RequestParam(name = "action") String action,
                                @RequestParam(name = "currentNodeid", required = false) String currentNodeid, @RequestParam(name = "nextNodeid",required = false) String nextNodeid,
                                @RequestParam(name = "nextUserList", required = false) String nextUserList, @RequestParam(name = "copyUserList",required = false) String copyUserList,
                                @RequestParam(name = "userid") String userid, @RequestParam(name = "remark",required = false) String remark,
                                @RequestParam(name = "isBackFlag", required = false) String isBackFlag, @RequestParam(name = "reassignmentFlag",required = false) String reassignmentFlag,
                                @RequestParam(name = "maindata", required = false) String formData) {

        // 获取数据源
        Connection conn = null;
        String result = "";

        try {
            conn = dataSource.getConnection();
            WorkFlow workFlow = new WorkFlowImpl(conn);
            JSONObject maindata = JSONObject.parseObject(formData);

            result = workFlow.runProcess(processid, docUnid, taskid, action, currentNodeid,
                    nextNodeid, nextUserList, copyUserList, userid, remark, isBackFlag, reassignmentFlag, maindata);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }

        return result;
    }


    /**
     * 获取审批过程信息
     */
    @RequestMapping("/osflow/getApprovalInfo/{docUnid}")
    public Object getApprovalInfo(@PathVariable("docUnid") String docUnid) {
        // 获取数据源
        Connection conn = null;
        String result = "";

        try {
            conn = dataSource.getConnection();
            WorkFlow workFlow = new WorkFlowImpl(conn);

            JSONObject approvalInfo = workFlow.getApprovalInfo(docUnid);
            result = approvalInfo.toJSONString();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }

        return result;
    }

    /**
     * 获取用户待办信息
     */
    @RequestMapping("/osflow/userTodo/{userid}")
    public Object userTodo(@PathVariable("userid") String userid) {

        // 特殊处理，当useid只为all时，表示获取所有代办，此时userid设置为空
        if ("all".equals(userid)) {
            userid = "";
        }

        // 获取数据源
        Connection conn = null;
        String result = "";

        try {
            conn = dataSource.getConnection();
            WorkFlow workFlow = new WorkFlowImpl(conn);

            JSONArray userToDOInfo = workFlow.getUserToDoInfo(userid);
            result = userToDOInfo.toJSONString();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }

        return result;
    }


    /**
     * 关闭连接简易方法
     *
     * @param conn 数据库连接
     */
    private void close(Connection conn) {
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
