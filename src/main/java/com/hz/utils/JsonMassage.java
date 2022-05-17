package com.hz.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonMassage<T> {
    private Integer code; // 错误代码  0代码成功
    private String msg;
    private Integer count;//总条数
    private T data; //数据

    public JsonMassage(Integer code){
        this.code = code;
        this.msg = this.code>0?"操作成功":"操作失败";
        this.data=getData();
    }


}
