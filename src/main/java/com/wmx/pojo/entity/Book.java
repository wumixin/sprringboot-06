package com.wmx.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author wumixin
 * @date 2020/7/28
 **/
@Table(name = "book")
@ToString
@Data
@ApiModel("图书")
public class Book implements Serializable {
    @Id
    private Integer id;
    @ApiModelProperty("图书名称")
    private String name;
    private Integer aid;

}
