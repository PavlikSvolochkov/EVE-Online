package ru.tsk.eveonline.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ru.tsk.eveonline.R;
import ru.tsk.eveonline.logic.SkillQueueItem;

public class SkillQueueAdapter extends BaseAdapter {

    private TextView skillNameTV;
    private TextView endTimeTV;

    private SkillQueueItem item;
    private List<SkillQueueItem> items;

    private Activity activity;
    private LayoutInflater inflater;

    public SkillQueueAdapter(Activity activity, List<SkillQueueItem> items) {
        super();
        this.activity = activity;
        this.items = items;
        this.item = new SkillQueueItem();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_skill_queue, null);

            skillNameTV = (TextView) convertView.findViewById(R.id.skillName);
            endTimeTV = (TextView) convertView.findViewById(R.id.endTime);
        }

        item = items.get(position);

        skillNameTV.setText(items.get(position).getTypeID());
        endTimeTV.setText(item.getEndTime());

        return convertView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
