> 记录项目中遇到的问题
## docker 启动mysql遇到的问题以及解决的方案
> Docker容器做端口映射报错
 docker: Error response from daemon: driver failed programming external connectivity on endpoint lamp3 (46b7917c940f7358948e55ec2df69a4dec2c6c7071b002bd374e8dbf0d40022c): (iptables failed: iptables --wait -t nat -A DOCKER -p tcp -d 0/0 --dport 86 -j DNAT --to-destination 172.17.0.2:80 ! -i docker0: iptables: No chain/target/match by that name.
 解决方法
 docker服务启动时定义的自定义链DOCKER被清除
 重启即可systemctl restart docker

## docker 安装mysql
[参考链接](https://www.runoob.com/docker/docker-install-mysql.html)
```text
# docker 中下载 mysql
docker pull mysql

#启动
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Lzslov123! -d mysql

#进入容器
docker exec -it mysql-test bash
redis 进入容器的命令
docker exec -it redis-test /bin/bash
#登录mysql
mysql -u root -p
ALTER USER 'root'@'localhost' IDENTIFIED BY 'Lzslov123!';

#添加远程登录用户
CREATE USER 'liaozesong'@'%' IDENTIFIED WITH mysql_native_password BY 'Lzslov123!';
GRANT ALL PRIVILEGES ON *.* TO 'liaozesong'@'%';
```
mysql 用户名 root，密码 在password.txt 中

## Mysql 解决1251 client does not support ...问题
[参照链接](https://blog.csdn.net/u012604745/article/details/80632860)
客户端连接mysql，问题：1251 client does not support ...
> 2.修改用户密码
  这个为修改远端连接MySQL的密码
  ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456'; 
  更新user为root，host为% 的密码为123456
  这个为修改本地连接MySQL的密码
  ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '123456';
  更新user为root，host为localhost 的密码为123456