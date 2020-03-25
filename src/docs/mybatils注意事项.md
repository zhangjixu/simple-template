#### spring-mybatis.xml 注意点
* 1 在 spring-mybatis.xml 文件里配置数据源以及 dao 包和 mapper.xml 文件的路径
#### mapper.xml 文件注意点
* 1 mapper.xml 文件提供 sql 语句给 sqlSession 执行
* 2 mybatis 的 dao 接口方法名要和 mapper.xml 文件里的 id 一致
* 3 如果数据库表中的字段和实体类名称不一致 可在 mapper 文件里做一次映射
* 4 在 mapper.xml 文件里 resultType 是 sql 映射文件中定义返回值类型，返回值有基本类型，对象类型，List类型，Map类型等
* 5 \# 将传入的数据都当成一个字符串，会对自动传入的数据加一个双引号。如：order by \#{user_id}，如果传入的值是111,那么解析成sql时的值为order by “111”, 如果传入的值是id，则解析成的sql为order by “id”。
* 6 $ 将传入的数据直接显示生成在sql中。如：order by ${user_id}，如果传入的值是111,那么解析成sql时的值为order by 111, 如果传入的值是id，则解析成的sql为order by id
* 7 建议使用 # 可以一定程度上避免 sql 注入
#### dao 层接口注意点
* 1 mybatis 扫描 dao 层会自动生成 dao 包下面接口的实现类
* 2 mybatils 传多个参数时可以在 dao 层使用 @Param("id") String id 形式




