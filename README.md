# WebShopping
This is a repository of my class homework.

***
# 作业要求
## 设计并实现一套商品销售平台。主要功能有：
### 展示和购买部分
- 商品及新闻文章的展示：含有首页中商品的展示，商品列表展示；商品详细页面及小部件的展示；购物车页面中推荐的商品展示等；新闻、文章、通知等展示；诸如配送流程、常见问题等文章内容展示；
- 站内搜索：搜索页面的展示；可提供新闻文章及商品的检索功能；
- 购物车：用户购买商品加入到购物车，进行正常的购物流程，含有对商品购物车商品基础管理。
- 用户中心：用户注册登录功能；相关的收货地址；基本资料管理，订单的管理，针对商品的评价等功能。
- 积分管理：提供用户积分管理功能，提高用户对平台的粘性，提升销售的效果。
- 在线客服功能：添加微信等即时通讯软件与客户进行及时沟通。
- 在线支付功能：接入支付宝、微信支付等接口的安装与调试，保证正常的付款流程。
### 销售管理部分
+ 商品管理：商品分类管理，商品规格属性管理，商品标签管理，商品单位管理， 商品促销设置管理，商品新增、编辑、下架、删除、库存等。
+ 订单系统：订单列表；对订单的处理操作，发货、退货、查询、打印等功能。
### 统计部分
- 销售订单统计系统：日销售月统计、月销售年统计、指定时间段内的销售统计等。
### 系统管理部分
+ 新闻文章管理：通知公告管理、公司新闻、行业新闻管理、文章的新增、删除、编辑、置顶、支持富图文编辑功能。
+ 注册账户管理：注册账户管理含有停用(恢复)、重置密码等。
+ 广告管理：广告的发布、编辑、删除；展示的分类选择、是否按照时间点。
+ 后台用户角色权限管理：平台后台管理的不同角色的管理权限的分配与设置；指定后台账户角色权限。
+ 数据备份：保证数据的安全性，需要定期做备份；针对备份数据的管理。
+ 系统设置：自身账户的安全设置，修改密码等功能；消息提醒，有新订单新注册用户后消息提醒。
***

***
### 以下是个人的一些想法
> 更多的想法请自行添加，这样有利于集合思想。
+ 首先用来接收数据的类型使用List<?>来接收数据，这样一个泛型的接收有利于数据的处理
***

***
### 我们的项目中所引入的JPA的语法规则（编写接口时的语法规范）
#### 后面的可能用不到，但是可以作为参考
| KeyWord | Sample | JPQLsnippet |
| :---------------: | :-----------------------------: | :-----------------------: |
| And | findByLastnameAndFirstname | … where x.lastname = ?1 and x.firstname = ?2 |
| Or | findByLastnameOrFirstname | … where x.lastname = ?1 or x.firstname = ?2 |
| Is,Equals | findByFirstname,findByFirstnameIs,findByFirstnameEquals | … where x.firstname = ?1 |
| Between | findByStartDateBetween | … where x.startDate between ?1 and ?2 |
| LessThan | findByAgeLessThan | … where x.age < ?1 |
| LessThanEqual | findByAgeLessThanEqual | … where x.age ⇐ ?1 |
| GreaterThan | findByAgeGreaterThan | … where x.age > ?1 |
| GreaterThanEqual | findByAgeGreaterThanEqual | … where x.age >= ?1 |
| After | findByStartDateAfter | … where x.startDate > ?1 |
| Before | findByStartDateBefore | … where x.startDate < ?1 |
| IsNull | findByAgeIsNull | … where x.age is null |
| IsNotNull,NotNull | findByAge(Is)NotNull | … where x.age not null |
| Like | findByFirstnameLike | … where x.firstname like ?1 |
| NotLike | findByFirstnameNotLike | … where x.firstname not like ?1 |
| StartingWith | findByFirstnameStartingWith | … where x.firstname like ?1(parameter bound with appended %) |
| EndingWith | findByFirstnameEndingWith | … where x.firstname like ?1(parameter bound with prepended %) |
| Containing | findByFirstnameContaining | … where x.firstname like ?1(parameter bound wrapped in%) |
| OrderBy | findByAgeOrderByLastnameDesc | … where x.age = ?1 order by x.lastname desc |
| Not | findByLastnameNot | … where x.lastname <> ?1 |
| In | findByAgeIn(Collection<Age> ages) | … where x.age in ?1 |
| NotIn | findByAgeNotIn(Collection<Age> age) | … where x.age not in ?1 |
| True | findByActiveTrue() | … where x.active = true |
| False | findByActiveFalse() | … where x.active = false |
| IgnoreCase | findByFirstnameIgnoreCase | … where UPPER(x.firstame) = UPPER(?1) |

***