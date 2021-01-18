# osflow-server

#### 介绍
osflow-server是基于Spring Boot 的流程微服务项目，对外提供Restful服务。



#### 软件架构

Spring Boot + osflow-engine + lkengine-db + druid



#### 接口设计

```
一、流程审批接口

1、获取所有流程信息                       /osflow/getProcessMsg
2、打开审批处理单前初始化                  /osflow/openProcess
3、启动或提交流程                         /osflow/submitProcess
4、获取审批过程信息                       /osflow/getApprovalInfo
5、获取用户代码信息                       /osflow/userTodo


二、流程定义接口【已内置osflow-designer实现】

获取所有流程信息      /design/getProcessList
获取流程图形化配置    /design/getFlowChartGraphic/{processid}
获取节点配置信息      /design/getFlowChartModByNodeType/{processid}/{nodeid}
获取节点事件配置      /design/getFlowChartEventByNodeType/{processid}/{nodeid}
获取表单字段配置      /design/getFormConfig/{processid}
获取节点邮件配置      /design/getFlowChartMailConfigByNodeType/{processid}/{nodeid}
获取节点按钮配置      /design/getButtonConfig/{processid}/{nodeid}
获取邮件详细配置      /design/getFlowChartMailConfigByUnid/{unid}
保存各节点属性配置    /design/saveFlowChartModByNodeType/{processid}/{nodeid}/{extnodetype}
保存节点事件配置      /design/saveFlowChartEventByNodeType/{processid}/{nodeid}
保存表单字段配置      /design/saveFormConfig/{processid}
保存节点按钮配置      /design/setButtonConfig
保存流程图形化配置    /design/saveFlowChartGraphic
删除流程设计         /design/deleteProcessList/{processid}
新增流程id           /design/getUnid
删除节点属性配置     /design/actionFlowChartGraphic&Action=DeleteNode
缺省保存节点属性配置 /design/actionFlowChartGraphic?Action=SaveAllDefaultNode
删除节点邮件配置     /design/deleteFlowChartMailConfigByNodeType
保存节点邮件配置     /design/saveFlowChartMailConfigByNodeType
```



#### 使用说明

流程定义地址：http://localhost:8080/design/index.html

流程定义工具【已经内置项目中】：[osflow-designer](https://gitee.com/openEA/osflow-designer)

详细帮助文档：http://open.linkey.cn/osbpm/r?wf_num=P_openLinkey_N002&treeid=T_openLinkey_N003&docVn=osflow-server_1_0



####  开源声明

本项目采用双重许可模式(GPL协议 + 商业许可协议)

QQ交流群：823545910