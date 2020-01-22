package scheduler.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author qhy
* @since 2020-01-22
*/
@Data
@TableName("sys_job")
public class SysJob implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 任务名称
    */
    @TableField("job_name")
    private String jobName;

    /**
    * 任务组名
    */
    @TableField("job_group")
    private String jobGroup;

    /**
    * 时间表达式
    */
    @TableField("job_cron")
    private String jobCron;

    /**
    * 类路径
    */
    @TableField("job_class_path")
    private String jobClassPath;

    /**
    * map参数
    */
    @TableField("job_data_map")
    private String jobDataMap;

    /**
    * 状态，1：启用，0：停用
    */
    @TableField("job_status")
    private Integer jobStatus;

    /**
    * 任务功能描述
    */
    @TableField("job_describe")
    private String jobDescribe;


}
