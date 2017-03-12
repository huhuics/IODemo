# Java I/O学习
+ **流**代表任何有能力产生数据的数据源对象或者是有能力接收数据的接收端对象。**流**屏蔽了实际I/O设备处理数据的细节
+ `FilterInputStream`和`FilterOutputStream`是用来提供装饰器类接口以控制特定输入流(`InputStream`)和输出流(`OutputStream`)的两个类，这两个类是装饰器的必要条件，以便能为所有正在被修饰的对象提供通用接口
+ `InputStreamReader`可以把`InputStream`转换为`Reader`，而`OutputStreamWriter`可以把`OutputStream`转换为`Writer`
+ `BufferedInputStream.available()`方法可以用来产生输入流的估计字节数
+ `Java NIO`速度的提升来自于所使用的结构更接近于操作系统执行`I/O`，**通道**和**缓冲器**。可以把它想象成一个煤矿，通道是包含煤层（数据）的矿藏，而缓冲器则是派送到矿藏的卡车。卡车载满煤炭而归，我们再从卡车上获得煤炭。也就是说我们没有直接和通道交互，我们只是和缓冲器交互，并把缓冲器派到通道。通道要么从缓冲器获得数据，要么向缓冲器发送数据。
