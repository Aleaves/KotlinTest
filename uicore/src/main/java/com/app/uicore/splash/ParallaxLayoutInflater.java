package com.app.uicore.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.lang.reflect.Constructor;

public class ParallaxLayoutInflater extends LayoutInflater {

    private static final String TAG = "==========";

    private ParallaxFragment fragment;

    protected ParallaxLayoutInflater(LayoutInflater original, Context newContext,ParallaxFragment fragment) {
        super(original, newContext);
        this.fragment = fragment;
        setFactory2(new ParallaxFactory(this));
    }

    @Override
    public LayoutInflater cloneInContext(Context context) {
        return new ParallaxLayoutInflater(this,context,fragment);
    }

    class ParallaxFactory implements Factory2{


        private LayoutInflater inflater;

        private final String[] sClassPrefix = {
                "android.widget.",
                "android.view."
        };

        public ParallaxFactory(LayoutInflater inflater){
            this.inflater = inflater;
        }

        @Override
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            View view= null;
            if (name.contains(".")) {
                view= createMyView(name, context, attrs);

            }else {
                for (String prefix : sClassPrefix) {
                    view = createMyView(prefix + name, context, attrs);
                    if (view != null) {
                        break;
                    }
                }
            }
            return null;
        }

        private View createMyView(String name, Context context, AttributeSet attributeSet) {
            try {
                Class clazz = Class.forName(name);
                Constructor<View> constructor = clazz.getConstructor(Context.class, AttributeSet.class);
                return  constructor.newInstance(context, attributeSet);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        public View onCreateView(String s, Context context, AttributeSet attributeSet) {
            return null;
        }
    }


}
