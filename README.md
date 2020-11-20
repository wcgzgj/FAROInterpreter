![image-20201105103510041](https://gitee.com/faro/images/raw/master/img/20201105103531.png)



# MyList解释器

## 作业要求

模仿Shell的样式

完成一个ischema语法的解释器

实现赋值和加成乘除四则运算



## 人员安排

### 组长：

张健（FARO_Z）

![image-20201019125418567](https://gitee.com/faro/images/raw/master/img/20201019132909.png)

### 职责：

> 搭建程序的总架构
>
> 实现解释器的核心算法
>
> 设计解释器的界面



### 组员

> 五名组员自行fork主程序
>
> 并在发现bug或者有修改建议的时候
>
> 发送issue并创建pr
>
> 等待组长审核，再进行merge



## 运行界面

![开始界面.jpg](https://gitee.com/faro/images/raw/master/img/20201120165421.jpg)



## 算法分析

这项作业的主要算法，体现在解释器部分，要保证解释器能正确识别括号，运算符，还是有一些难度的。这里，我将解释器分成以下几个部分：

1. **字符串Token化**

   > 要将一个字符串，分字符变成字符串数组，又要保证不会误伤多位数和多字符变量
   >
   > 这里的实现方式是将 + - * / = (   )   这几个字符，在字符串中全部替换为前后都有空格的模式，即 "+"  变成 " + "
   >
   > 然后再调用split函数

   ```java
   //转换前
   "(+(* b 22)(/14 a))"
   //转换后
   [+, (, *, b, 22, ), (, /, 14, a, )]
   ```

2. **构建语法树**

   > 要以闭包括号，或者基本操作符为单位，递归进行建树的操作
   >
   > 对于以下token流（计算操作）：
   >
   > ```java
   > [+, (, *, b, 22, ), (, /, 14, a, )]
   > ```
   >
   > 构建的语法树应为：
   >
   > <img src="https://gitee.com/faro/images/raw/master/img/20201120173310.png" alt="image-20201120171119852" style="zoom:50%;" />
   >
   >
   > 对于以下token流（赋值操作）：
   >
   > ```java
   > [=,a,(,/,b,(,+,4,2,),)]
   > ```
   >
   > 构建的语法树应为：
   >
   > <img src="https://gitee.com/faro/images/raw/master/img/20201120173311.png" alt="image-20201120171750764" style="zoom:50%;" />

3. **判断语法树正误**

   通过上面的语法树的绘制，我们可以看到以下规律：

   > 对于<font color="red">格式正确</font>的token流
   >
   > 如果是<font color="blue">计算操作</font>，则必须保证非叶子节点都是运算符，且没有“=”存在
   > 所有叶子节点，不允许出现运算符
   >
   > <img src="https://gitee.com/faro/images/raw/master/img/20201120173312.png" alt="image-20201120172235407" style="zoom:50%;" />
   >
   > 如果是<font color="blue">赋值操作</font>，则必须保证根节点的左子树只能有一个元素，且必须是变量（不能是运算符或者数字）
   > 根节点必须是赋值符号 “=” 
   >
   > <img src="https://gitee.com/faro/images/raw/master/img/20201120173313.png" alt="image-20201120172612909" style="zoom:50%;" />


