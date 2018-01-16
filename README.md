#### 线程同步

##### 来自 Java多线程编程核心技术
> 当A线程调用anyObject对象加入synchronized关键字的X方法时，A线程就获得了X方法锁，更准备地讲，
是获得了对象的锁，所以其他线程必须等A线程执行完毕才可以调用X方法，但B线程可以随意调用其他的非synchronized同步方法。

> 当A线程调用anyObject对象加入synchronized关键字的方法时，A线程就获得了X方法所在的对象锁，所以其他线程必须等A线程
执行完毕才可以调用X方法，而B线程如果调用声明了synchronized关键字的非X方法时，必须等A线程将X方法执行完，也就是释放对象锁后才可以调用。

> 抛出异常会自动释放锁  
> 同步不能继承(覆盖父类的synchronized方法时，子类的方法也需要写上synchronized)

> synchronized(this)代码块锁定的是对象  
> 多线程调用同一个对象中的不同名称的synchronized同步方法或者synchronized(this)同步代码块时，调用的效果就是顺序执行，也就是同步、阻塞的。

> synchronized(x)代码块锁定(x非this)  
> 1)当多个线程同时执行synchroized(x){}同步代码时呈同步效果  
> 2)当其他线程执行x对象中synchroized同步方法时呈同步效果  
> 3)当其他线程执行x对象方法里面的synchronized(this)代码块时也呈现同步效果  
* 如果其他线程调用不加synchronized关键字方法时是异步的。
* 如果synchronized(x)中的x为String类型的话，可能会出现一些例外(因为jvm为String简单赋值作了一些缓存),同步时如果修改了x的值也会出现异步的情况，所以尽量不要使用String作为同步对象。
* synchronized(Object.class)时与所有的synchroized static 是同步的。


> wait()/notify() notifyAll()  
> 1) 执行完同步代码块就会释放对象的锁
> 2) 在执行同步代码块的过程中，遇到异常而导致线程终止，锁也会被释放  
> 3) 在执行同步代码块的过程中，执行了锁所属对象的wait()方法，这个线程会释放对象锁，而此线程对象会进入线程等待池中，等待被唤醒


> wait(long)  
> 带一个参数的wait方法的功能是等待某一个时间内是否有线程对锁进行唤醒，如果超过这个时间则自动唤醒.  

