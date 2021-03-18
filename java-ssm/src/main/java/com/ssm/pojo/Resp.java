package com.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resp <T>{

    private Integer code;
    private String msg;
    private T data;

    public Resp(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static Resp suc(){
        return new Resp(200,"成功");
    }

    public static Resp err(){
        return new Resp(500,"失败");
    }
    public static Resp suc(Object obj){
        return new Resp(200,"成功",obj);
    }




}
