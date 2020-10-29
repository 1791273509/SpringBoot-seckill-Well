package cn.hrxwb.seckill.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "seckill")
@Data
public class Seckill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //    四种增长方式
 /*   TABLE：使用一个特定的数据库表格来保存主键。
    SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
    IDENTITY：主键由数据库自动生成（主要是自动增长型）
    AUTO：主键由程序控制。（默认）*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seckill_id",nullable = false)
    private long seckillId;
    private String name;
    private int number;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp createTime;
//   @Vsersion实现乐观锁
   /* 如对象中有version属性，并使用了@version，
   在更新数据时请带上version数据和主键，这样可直接利用save方法进行更新，
   当然这限于全部属性更新，局部更新时请使用@modify和@update方法。

    当乐观锁更新失败的时候，会抛出异常：
    org.springframework.orm.ObjectOptimisticLockingFailureException

    当使用mysql数据库且JPA主键策略为@GeneratedValue(strategy = GenerationType.IDENTITY)，
    全局更新未带version数据时，更新操作会变为保存操作。*/
    @Version
    private int version;

}
