
# 前言
宠物星球（Petplanet）旨在为宠物提供日常交流和流浪宠物认领服务，为宠物打造温馨的家园。本项目采用前后端分离，使用一系列主流后端和后端技术构建和自动化部署。

# 项目介绍
宠物星球（Petplanet）是一个专注于宠物交流和流浪宠物认领的网站。我们致力于为宠物爱好者提供一个温馨的社区，让他们能够分享自己的宠物经验、故事和照片，并与其他爱宠之人进行互动交流。

在宠物星球上，您可以注册账号并加入我们的社区。通过发布帖子、评论和回复，您可以与其他宠物爱好者分享您的养宠心得，获取有价值的建议和技巧。这里是一个互相学习和成长的平台，让您能够结识到来自不同背景和经验的宠物爱好者。

此外，宠物星球还致力于帮助流浪宠物找到合适的家庭。我们提供了流浪宠物认领服务，让您能够浏览并选择合适的流浪宠物，向相关机构提交认领申请。我们会确保每一只流浪宠物都能获得温暖的家庭，得到应有的照顾和关爱。

除了交流和认领服务，宠物星球还为您提供了宠物用品的市场。您可以在我们的平台上浏览并购买各类宠物用品，包括食品、玩具、床铺、笼子等。我们精选了高质量的产品，以确保您的宠物能够享受到舒适和健康的生活。

无论您是新手宠物主人还是经验丰富的养宠专家，宠物星球都将为您提供有益的宠物日常知识。我们提供了丰富的宠物护理和饲养知识，涵盖健康护理、饮食营养、行为训练等方面。通过学习和了解这些知识，您可以更好地照顾自己的宠物，给予它们最好的关怀和爱护。

欢迎加入宠物星球，与我们一起打造一个温暖而有爱的宠物社区！

web前端链接：[https://github.com/WePetPlanet/PetPlanet-frontend](https://github.com/WePetPlanet/PetPlanet-frontend)
# 项目文档
文档地址：暂定

api地址：[https://app.apifox.com/project/3601668](https://app.apifox.com/project/3601668)

# 功能和特点
**宠物社区**: 用户可以注册账号并加入宠物社区，在论坛上发布帖子、评论和回复，与其他宠物爱好者进行交流和互动。

**流浪宠物认领**: 提供通过宠物信息浏览和搜索，选择并申请认领合适的流浪宠物。

**宠物市场**: 用户可以浏览并购买各类宠物用品，包括食品、玩具、床铺、笼子等。

**宠物日常知识**: 提供丰富的宠物护理和饲养知识，帮助用户了解如何照顾自己的宠物。

**用户身份验证和授权**: 使用 JWT 和 Spring Security 实现用户身份验证和授权管理，保护用户数据的安全性。

**消息队列**: 使用 RabbitMQ 实现异步消息处理，提高系统的可扩展性和稳定性。

**缓存优化:** 使用 Redis 缓存频繁访问的数据，加速响应速度。
多数据库支持: 使用 MongoDB 存储社区帖子和评论等非结构化数据，使用 MySQL 存储关系型数据。

**对象存储:** 使用 MinIO 对象存储系统来存储用户上传的图片和视频。
API 文档: 使用 Swagger-UI 自动生成 API 文档，便于开发者和用户查看和测试 API 接口。

**全文搜索**: 集成 Elasticsearch 实现全文搜索功能，帮助用户快速查找相关宠物信息和帖子。

**容器化部署:** 使用 Docker 运行容器化应用程序，简化部署和运维流程。
# 技术栈
宠物星球采用了一系列主流后端技术，包括 Spring Cloud、RabbitMQ、Redis、MongoDB、MySQL、MyBatis-Plus、Elasticsearch、MinIO、JWT、Swagger-UI、Spring Security 和 Docker 等。我们致力于提供稳定、安全和高效的在线体验，以满足用户的需求。

该网站使用了以下主流后端技术：

**Spring Cloud Alibaba**: 微服务框架，实现分布式系统架构。

**Spring Boot**: 快速创建独立的 Spring 应用程序。

**Docker**: 容器化平台，简化应用程序的部署和管理。

**kafka**: 消息队列，实现异步消息处理和削峰填谷。

**MySQL**: 关系型数据库，用于存储结构化数据。

**Redis**: 高性能键值存储数据库，用于缓存频繁访问的数据。

**MongoDB**: NoSQL 文档数据库，用于存储社区帖子和评论等非结构化数据。

**Elasticsearch**: 分布式搜索和分析引擎，提供全文搜索功能。

**MyBatis-Plus**: 简化 MyBatis 查询和持久化操作的框架。

**Docker**: 容器化平台，简化应用程序的部署和管理。

**JWT**: JSON Web Token，用于实现用户身份验证和授权。

**Spring Security**: 身份验证和授权框架，保护用户数据的安全性。

**MinIO**: 对象存储系统，用于存储用户上传的图片和视频文件。

**Swagger-UI**: 自动生成 RESTful API 文档，方便开发者查看和测试接口。

# 贡献
欢迎对该项目进行改进和贡献！如果你有任何建议或发现了 bug，请提交 Issue 或创建 Pull Request。
# 加入我们
如果有意向，愿意一起开发，一起交流，一起进步，欢迎加入我们，联系方式：3445669973@qq.com
