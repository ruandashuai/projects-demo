package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "admin")
public class Admin implements Serializable {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //管理员名字
    @Column(length = 30, nullable = false, unique = true)
    private String name;

    //密码
    @Column(length = 30, nullable = false)
    private String password;

    //账号创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
