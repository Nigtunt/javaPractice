package Mybatis.test;

/**
 * @Author: YHQ
 * @Date: 2020/3/6 14:06
 */
public class 缓存 {
    /**
     * （1）、一级缓存基于PerpetualCache 的 HashMap本地缓存，其存储作用域为 Session，
     *          当 Session flush 或 close 之后，该Session中的所有 Cache 就将清空。
     *
     * （2）、二级缓存与一级缓存其机制相同，默认也是采用 PerpetualCache，HashMap存储，
     *          不同在于其存储作用域为 Mapper(Namespace)，并且可自定义存储源，如 Ehcache。
     *
     * （3）、对于缓存数据更新机制，当某一个作用域(一级缓存Session/二级缓存Namespaces)
     *          的进行了 C/U/D 操作后，默认该作用域下所有 select 中的缓存将被clear。
     *
     *   1.2默认MyBatis的一级缓存是开启的
     *   1.3一级缓存仅在同一个会话（SQLSession）中有效
     *   1.4、清空一级缓存
     *      （1）、当对表执行增删改时缓存将清空
     *      （2）、手动清空  session.clearCache()
     *   1.5、开启二级缓存
     *   1.5.2、单个Mapper XML映射文件开关
     *  默认Mapper XML映射文件是不采用cache。在配置文件加一行就可以支持cache：
     *      <cache/>
     *      <cache eviction="LRU" flushInterval="100000" size="1024" readOnly="true"/>
     *
     *   　1. 映射语句文件中的所有select语句将会被缓存。
     *
     * 　　2. 映射语句文件中的所有insert，update和delete语句会刷新缓存。
     *
     * 　　3. 缓存会使用Least Recently Used（LRU，最近最少使用的）算法来收回。
     *
     * 　　4. 缓存会根据指定的时间间隔来刷新。
     *
     * 　　5. 缓存会存储1024个对象
     */
}
