package com.osp.testwebservice.model.response;

import lombok.Data;

@Data
public class BaseResponse {
    public final Object data;
    public final Object message;
    public final Object statusCode;
    public final Object description;

}
