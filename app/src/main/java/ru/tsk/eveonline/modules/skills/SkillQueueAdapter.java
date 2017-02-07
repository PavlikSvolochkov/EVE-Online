package ru.tsk.eveonline.modules.skills;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import ru.tsk.eveonline.R;
import ru.tsk.eveonline.logic.SkillQueueItem;


public class SkillQueueAdapter extends BaseAdapter {

    private List<SkillQueueItem> skillQueueItemList;

    private Context context;
    private LayoutInflater layoutInflater;

    @BindView(R.id.skillName)
    protected TextView skillName;
    @BindView(R.id.skillLevel)
    protected TextView skillLevel;
    @BindView(R.id.endTime)
    protected TextView endTime;

    public SkillQueueAdapter(Context context, List<SkillQueueItem> skillQueueItemList) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.skillQueueItemList = skillQueueItemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.skill_queue_item, null);
        }

        SkillQueueItem item = (SkillQueueItem) getItem(position);

        skillName.setText(item.getTypeID());
        skillLevel.setText(item.getLevel());
        endTime.setText(item.getEndTime());

        return view;
    }

    @Override
    public int getCount() {
        return skillQueueItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return skillQueueItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
