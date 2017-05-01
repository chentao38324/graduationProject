package com.netease.nim.demo.session.viewholder;

import android.util.Log;

import com.netease.nim.demo.session.extension.DefaultCustomAttachment;
import com.netease.nim.uikit.common.ui.recyclerview.adapter.BaseMultiItemFetchLoadAdapter;
import com.netease.nim.uikit.session.viewholder.MsgViewHolderText;

/**
 * Created by zhoujianghua on 2015/8/4.
 */
public class MsgViewHolderDefCustom extends MsgViewHolderText {

    public MsgViewHolderDefCustom(BaseMultiItemFetchLoadAdapter adapter) {
        super(adapter);
    }

    @Override
    protected String getDisplayText() {
        DefaultCustomAttachment attachment = null;
        try {
            Log.d("=====","类型："+message.getAttachment().getClass());
            attachment = (DefaultCustomAttachment) message.getAttachment();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }

        return "type: " + 0 + ", data: " + attachment.getContent();
    }
}
