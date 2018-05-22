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
