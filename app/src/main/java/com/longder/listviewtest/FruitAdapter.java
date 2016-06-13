package com.longder.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 自定义的Fruit适配器，用来显示ListView中的每一项
 * Created by Longder on 2016/5/6.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    //layout文件id
    private int resourceId;

    /**
     * 重写父类的构造方法
     *
     * @param context  容器
     * @param resource 创建Adapter时传递进来的子项布局id
     * @param objects
     */
    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    /**
     * 每个子项被滚动出现到屏幕上时调用的方法，本方法返回的是每一个子项的视图
     *
     * @param position    该子项的位置
     * @param convertView 可以将布局进行缓存，提高效率
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //根据position获取Fruit实体
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        //判断布局是否进行了缓存
        if (convertView == null) {
            //填充布局，返回视图
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.textView = (TextView) view.findViewById(R.id.fruit_text);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
