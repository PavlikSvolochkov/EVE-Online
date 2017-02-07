package ru.tsk.eveonline.modules.skills;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import ru.tsk.eveonline.R;
import ru.tsk.eveonline.logic.SkillQueueItem;


public class SkillQueueAdapter extends BaseAdapter {

    private List<SkillQueueItem> skillQueueItemList;

    private final Context context;
    private final LayoutInflater layoutInflater;

    public SkillQueueAdapter(Context context, List<SkillQueueItem> skillQueueItemList) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.skillQueueItemList = skillQueueItemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.skill_queue_item, null);
        }

        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
