# Java I/O学习
+ **流**代表任何有能力产生数据的数据源对象或者是有能力接收数据的接收端对象。**流**屏蔽了实际I/O设备处理数据的细节。
+ `FilterInputStream`和`FilterOutputStream`是用来提供装饰器类接口以控制特定输入流(`InputStream`)和输出流(`OutputStream`)的两个类，这两个类是装饰器的必要条件，以便能为所有正在被修饰的对象提供通用接口。
+ `InputStreamReader`可以把`InputStream`转换为`Reader`，而`OutputStreamWriter`可以把`OutputStream`转换为`Writer`
