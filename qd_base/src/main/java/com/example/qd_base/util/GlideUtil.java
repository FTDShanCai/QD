package com.example.qd_base.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class GlideUtil {
    private GlideUtil() {
    }

    public static void load(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

}
