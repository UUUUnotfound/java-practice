订阅模式：
1、一个生产者，多个消费者
2、每个消费者都有自己的队列
3、生产者咩有直接把消费发送到队列，而是发到了交换机 exchange
4、咩个队列都要绑定到交换机上
5、生成者发送的消息，经过交换机到达队列，就能实现一个消息呗多个消费者消费

如：注册 -：邮件和短信

交换机：

匿名转发 ""；
fanout 不处理路由键
direct 处理路由键
topic 将路由键和莫模式进行匹配 
-- * 匹配一个
-- # 匹配一个或多个     