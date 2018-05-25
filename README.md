# JDBCTest
## <a id = "web08">web08_JDBC</a>
A hello-world test for JDBC.</br>
### 基本步骤
* 1、注册驱动</br>
      Class.forName("com.mysql.jdbc.Driver");
* 2、获取连接</br>
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08?useSSL=false","root","`password`");
* 3、获取状态</br>
      stm = con.createStatement();</br>
      推荐使用</br>
       &emsp;&emsp;prepareStatement("select * from tbl_users where uname = ? and upassword = ?");</br>
       &emsp;&emsp;pst.setString(1, username);</br>
       &emsp;&emsp;pst.setString(2, password);</br>
      模式</br>
* 4、运行sql</br>
  * 4.1 DML操作</br>
    stm.executeUpdate("insert into tbl_users values(null,'ali','12121735')");</br>
  * 4.2 DQL操作</br>
    stm.executeQuery("select * from tbl_users");</br>
* 4、获取操作结果</br>
  * 4.1 DML操作</br>
    返回int数据（更新行数）</br>
  * 4.2 DQL操作</br>
    * 返回ResultSet rs</br>
    * while(rs.next())</br>
				System.out.println("序号： "+rs.getString(1)+" 用户名："+rs.getString(2)+" 密码："+rs.getString("upassword"));</br>
 * 5、注销所有相关类</br>
      rs.close();</br>
			stm.close();</br>
			con.close();</br>
## web09_JDBC
JDBC 应用类提取</br>
### 第一种：基本提取方式
按照<a href = "#web08">web08_JDBC</a>进行基本的驱动注册、连接、状态获取的提取和注销
### 第二种：.properties文件通过ResourceBundle读取数据</br>
* 1、在./src文件夹下新建db.properties文件，输入键值对</br>
* 2、通过ResourceBundle示例读取数据</br>
* 3、注销相关类</br>
### 第三种：.properties文件通过文件流读取数据</br>
* 1、获取properties文件输入流</br>
* 2、创建properties对象</br>
* 3、加载输入流</br>
* 4、读取数据</br>
* 5、注销相关类</br>


## web10_JDBC
### com.jdbc.alixia.DataSourceJDBC (自定义数据连接池)
#### 基本实现：MyDataSource.java</br>
* 1、创建MyDataSource类实现DataSource接口</br>
* 2、创建一个容器（本案例使用LinkedList以利于频繁添加删除操作）用于储存Connection对象，并加入几个Connection</br>
* 3、重写getConnection()方法，返回LinkedList中的Connection对象</br>
* 4、添加归还Connection方法</br>
#### 增强Connection：MyConnection.java(使用装饰者设计模式)</br>
* 1、创建MyConnectio类实现Connection接口</br>
* 2、定义一个待增强类（Connection）变量；书写构造函数接受待增强待增强类（Connection）
* 3、重写需要增强的方法close() ps.需要新增连接池LinkedList<Connection> pool内部变量，并在构造函数里进行接收</br>
* 4、需要重写prepareStatement(sql)方法</br>
#### 其他</br>
* 1、MyDataSource1.java是在MyConnection基础上实现的数据连接池</br>
* 2、TestMyDataSource.java编写工具测试
### com.jdbc.alixia.utils (c3p0/dbup数据池)
#### c3p0(C3P0Utils.java)
* 1、导入c3p0-0.9.1.2.jar数据包</br>
* 2、Build Path:导入编译路径</br>
* 3、在src文件夹下创建一个c3p0-config.xml文件，并书写.mxl里的属性</br>
* 4、生成ComboPooledDataSource变量（会自动搜寻c3p0-config.xml并分析属性创建ComboPooledDataSource）</br>
* 5、书写getDataSource()方法，返回ComboPooledDataSource变量</br>
* 6、书写getConnectione()方法，返回一个从ComboPooledDataSource连接池里获取的Connection</br>
#### dbup(DBUPUtils.java)
* 1、导入commons-dbcp-1.4.jar数据包和commons-pool-1.5.6.jar数据包</br>
* 2、Build Path:导入编译路径</br>
* 1、在src文件夹下创建一个.properties文件，并书写键值对</br>
* 2、以输入流的形式读入.properties文件</br>
* 3、生成properties对象并载入输入流</br>
* 4、使用BasicDataSourceFactory.createDataSource(props)获取DataSource</br>
* 5、书写getDataSource()方法</br>
* 6、书写getConnectione()方法</br>
### com.jdbc.alixia.test (测试类)
#### TestMyDataSource.java
* 测试自建数据连接池
#### TestC3p0.java
* 使用C3P0Utils类（连接池）获取Connection
#### TestDBCPU.java
* 使用DBCPUtils类（连接池）获取Connection
#### TestDBUtils.java：增删改
* 1、创建核心类QueryRunner
* 2、编写sql语句
* 3、为占位符设置数值 Object[] params
* 4、执行添加操作
#### TestDBUtils1.java：查询用户信息
* 1、创建核心类QueryRunne
* 2、编写sql语句（如果有占位符需要在下一步为占位符设置数值 Object[] params）
* 3、执行查询操作


