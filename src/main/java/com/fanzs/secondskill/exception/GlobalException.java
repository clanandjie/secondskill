package com.fanzs.secondskill.exception;

import com.fanzs.secondskill.result.CodeMsg;

/**
 * Created by fzs on 2018/4/8.
 */
public class GlobalException extends RuntimeException{
    private static final long serialVersionUID=1L;

    private CodeMsg cm;

    public CodeMsg getCm() {
        return cm;
    }

    public void setCm(CodeMsg cm) {
        this.cm = cm;
    }

    public GlobalException(CodeMsg cm) {
        super(cm.getMsg());
        this.cm = cm;
    }
}
