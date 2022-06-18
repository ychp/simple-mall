# 商城后端工程

## 工程规范

1. 统一包名前缀：com.yingchengpeng.mall
    - 不同的业务根据业务领域定义自己的包名
        - 开发中心：com.yingchengpeng.mall.open
        - 用户：com.yingchengpeng.mall.user
        - 商品：com.yingchengpeng.mall.item
        - 库存：com.yingchengpeng.mall.inventory
        - 价格：com.yingchengpeng.mall.price
        - 营销：com.yingchengpeng.mall.promotion
        - 交易：com.yingchengpeng.mall.trade
        - 支付：com.yingchengpeng.mall.pay
        - 结算：com.yingchengpeng.mall.settle
2. 工程结构（具体规范请查看每个package下的package-info.java） 格式

- **子领域**
    - **doc**: 设计文档
    - **doc/context**: 上下文
    - **doc/model**: 模型设计
    - **doc/service**: 服务设计
    - **子领域-gateway-rpc**: rpc服务定义,定义所有的rpc接口，外部仅依赖此包
    - **子领域-biz**: 当前领域的业务层，做业务逻辑实现
    - **子领域-dependency**: 防腐层定义(拆分工程后会有，当前单工程，暂时去掉这个模块),定义当前领域使用的所有外部服务的定义
    - **子领域-domain**: 领域实现,主要做领域模型和领域能力的管理
    - **子领域-infrastructure**: 基础设施层,主要做南向网关和北向网关的技术
- **mall-gateway-rpc**: rpc的基础类，用于定义通用的基类
- **mall-common**: 公共模块,主要放工具类
- **mall-config**: 配置模块，主要放一些配置类，和配置工具
- **mall-dependency-impl**: 防腐实现,实现所有子模块的依赖外部的实现
- **mall-dependency**: 防腐定义
- **mall-starter**: 启动模块


- **mall-gateway-rpc** rpc的基础模块
    - com.yingchengpeng.mall.gateway.rpc.dto.request: 请求基类
    - com.yingchengpeng.mall.gateway.rpc.dto.response: 响应基类
- **mall-user** 用户
- **mall-item** 商品
    - **mall-item-gateway-rpc**：dubbo接口和模型定义
        - com.yingchengpeng.mall.item.gateway.rpc.dto.request: 请求参数
            - 模型定义后缀Request
        - com.yingchengpeng.mall.item.gateway.rpc.dto.response: 响应
            - 模型定义后缀Response
        - com.yingchengpeng.mall.item.gateway.rpc.service: 接口定义
            - 读接口定义后缀 RpcReader
            - 写接口定义后缀 RpcWriter
    - **mall-user-biz**：业务功能实现
        - com.yingchengpeng.mall.item.biz.dto: 应用层服务参数定义
        - com.yingchengpeng.mall.item.biz.converter: 应用层模型 - 领域层模型转换器
        - com.yingchengpeng.mall.item.biz.component: 应用层公共组件
        - com.yingchengpeng.mall.item.biz.app: 应用层服务类
            - 读接口定义后缀 ReadApplication
            - 写接口定义后缀 WriteApplication
    - **mall-user-domain**：领域层
        - com.yingchengpeng.mall.user.domain.vo: 值对象
        - com.yingchengpeng.mall.user.domain.entity: 实体以及聚合
        - com.yingchengpeng.mall.user.domain.enums: 业务枚举定义
        - com.yingchengpeng.mall.user.domain.constants: 常量（按需定义）
        - com.yingchengpeng.mall.user.domain.param: 领域请求参数定义
        - com.yingchengpeng.mall.user.domain.event: 领域事件定义
        - com.yingchengpeng.mall.user.domain.event.pusher: 领域事件推送器定义
        - com.yingchengpeng.mall.user.domain.repository: 领域仓储定义
        - com.yingchengpeng.mall.user.domain.factory: 领域模型生成
        - com.yingchengpeng.mall.user.domain.service: 领域能力定义
        - com.yingchengpeng.mall.user.domain.service.impl: 领域能力实现
        - com.yingchengpeng.mall.user.domain.component: 领域内的通用组件实现
        - com.yingchengpeng.mall.user.domain.utils: 工具类（按需定义）
    - **mall-user-infrastructure**：基础设施层
        - com.yingchengpeng.mall.user.domain.repository.impl: 领域仓储实现
        - com.yingchengpeng.mall.user.gateway.rpc.converter: rpc服务参数转换器
        - com.yingchengpeng.mall.user.gateway.rpc.impl: rpc服务实现
        - com.yingchengpeng.mall.user.gateway.restful.converter: restful服务参数转换器
        - com.yingchengpeng.mall.user.gateway.restful.impl: restful服务实现
        - com.yingchengpeng.mall.user.domain.event.pusher.impl: 领域事件推送器实现
        - com.yingchengpeng.mall.user.message: 消息处理
- **mall-common**：通用能力和工具
    - com.yingchengpeng.mall.common.aspect: 通用切面服务(部分业务依赖外部服务)
        - com.yingchengpeng.mall.common.aspect.ApiExceptionAndLogAspect: 对外暴露的dubbo服务的异常处理和日志输出控制
    - com.yingchengpeng.mall.common.annotation: 切面注解
        - com.yingchengpeng.mall.common.annotation.ApiLog: 对外暴露的dubbo服务调用日志注解，如果接口上没有该注解，则不作日志输出
    - com.yingchengpeng.mall.common.code:错误码
        - com.yingchengpeng.mall.common.code.UserBizErrorCode: 用户错误码
        - com.yingchengpeng.mall.common.code.MallBizDependencyErrorCode: 外部依赖服务错误码
    - com.yingchengpeng.mall.common.constants:常量定义,非业务相关的常量
    - com.yingchengpeng.mall.common.enums:枚举定义,非业务相关的枚举
    - com.yingchengpeng.mall.common.exception:异常类
    - com.yingchengpeng.mall.common.utils:通用工具类
    - com.yingchengpeng.mall.common.dubbo.filter: dubbo服务拦截器
        - com.yingchengpeng.mall.common.dubbo.filter.ValidationFilter: 参数校验
        - com.yingchengpeng.mall.common.dubbo.filter.ConsumerLogFilter: 第三方dubbo服务调用日志
- **mall-config**：配置文件
    - com.yingchengpeng.mall.config.apollo: 阿波罗配置
    - com.yingchengpeng.mall.config.datasource: 数据源
    - com.yingchengpeng.mall.config.mybatis: 持久化层
- **mall-dependency**：
    - com.yingchengpeng.mall.dependency.dto.xxx.request: 防腐入参
    - com.yingchengpeng.mall.dependency.dto.xxx.response: 防腐反参
    - com.yingchengpeng.mall.dependency.dto.xxx.adaptor: 外部服务防腐层定义
- **mall-dependency-impl**：
    - com.yingchengpeng.mall.dependency.xxx.adaptor.imp: 对应领域的外部服务防腐层实现
    - com.yingchengpeng.mall.dependency.utils: 针对外部服务的工具接口
- **mall-starter**：启动





