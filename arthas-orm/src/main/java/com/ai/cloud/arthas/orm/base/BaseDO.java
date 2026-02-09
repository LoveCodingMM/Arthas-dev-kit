package com.ai.cloud.arthas.orm.base;

import com.ai.cloud.arthas.orm.annotation.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author <a href="mailto:liuyi304@jd.com">liuyi304</a>
 * @date 2026-02-09 16:48
 * @description BaseDO
 */

@Getter
@Setter
public class BaseDO<KEY> extends BaseObject<KEY>{

    @Column(name = "create_time", modifiable = false)
    private Date createTime = new Date();

    @Column(name = "modified_time", modifiable = false)
    private Date modifyTime = new Date();
}
