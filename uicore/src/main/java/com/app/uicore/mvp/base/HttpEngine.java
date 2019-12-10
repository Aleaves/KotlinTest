package com.app.uicore.mvp.base;

import java.util.Map;

public class HttpEngine<P extends BasePresenter> {

    private P p;

    public HttpEngine(P p){
        this.p = p;
    }

    public void post(Map<String,Object> map){
        if(true){
            if(null != p){
                p.onLoadDataSuccess(new BaseEntity());
            }
        }else{
            p.onLoadDataFailure("net error");
        }
    }

}
