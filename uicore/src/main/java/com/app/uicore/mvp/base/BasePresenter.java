package com.app.uicore.mvp.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseView> {

    private WeakReference<V> vWeakReference;
    private HttpEngine httpEngine;

    public BasePresenter(V v){
        httpEngine = new HttpEngine(this);
        vWeakReference = new WeakReference<>(v);
    }

    //解除绑定View
    public void unBindView(){
        if(vWeakReference != null){
            vWeakReference.clear();
            vWeakReference = null;
            System.gc();
        }
    }

    public V getView(){
        return vWeakReference.get();
    }

    protected abstract void onLoadDataSuccess(BaseEntity entity);

    protected abstract void onLoadDataFailure(String msg);


}
