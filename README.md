# osflow-server

#### 介绍
osflow-server是基于Spring Boot 的流程微服务项目，对外提供Restful服务。

#### 软件架构
Spring Boot + osflow-engine + druid


#### 接口设计

```
1、获取所有流程信息                       /osflow/getProcessMsg
2、打开审批处理单前初始化                  /osflow/openProcess
3、启动或提交流程                         /osflow/submitProcess
4、获取审批过程信息                       /osflow/getApprovalInfo
5、获取用户代码信息                       /osflow/userTodo
```

#### 使用说明

流程定义工具：[osflow-designer](https://gitee.com/openEA/osflow-designer)

详细帮助文档：http://open.linkey.cn/osbpm/r?wf_num=P_openLinkey_N002&treeid=T_openLinkey_N003&docVn=osflow-server_1_0

