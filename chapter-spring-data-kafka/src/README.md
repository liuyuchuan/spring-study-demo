

#Kafka消息生产者和消费者demo程序

> 1、创建一个Spring的maven项目，引入依赖，引入JDK（这里使用1.8+）
```
<!-- 当前笔者使用的是最新版本2.6.0的kafka，如果有需要其他版本，请修改版本号 -->
<properties>
    <kafka.version>2.6.0</kafka.version>
</properties>

<!-- 引入kafka -->
<dependency>
    <groupId>org.apache.kafka</groupId>
    <artifactId>kafka_2.13</artifactId>
    <version>${kafka.version}</version>
</dependency>


<!-- 连接kafka 客户端 -->
<dependency>
    <groupId>org.apache.kafka</groupId>
    <artifactId>kafka-clients</artifactId>
    <version>${kafka.version}</version>
</dependency>


<!-- kafka 流处理jar库 -->
<dependency>
    <groupId>org.apache.kafka</groupId>
    <artifactId>kafka-streams</artifactId>
    <version>${kafka.version}</version>
</dependency>
```

> 2、启动zookeeper
```
// 使用默认配置
bin/zkServer.sh start

// 如果是新下载的zk，请将conf中的zoo_sample.cfg修改zoo.cfg，再执行启动命令，如果已经可以启动zk，请忽略此步骤，此过程全部使用默认配置
```

> 3、启动kafka
```
// 使用默认配置
bin/kafka-server-start.sh config/properties.conf
```

> 4、执行消费者客户端
```
main()方法执行即可，里面写了一个循环，用来模拟监听生产者生产消息
```

> 5、执行生产者客户端
```
执行生产者，向特定主题发送消息，在消费者控制台可以看到已经读取到生产者产生的消息，例如 Hello World
```