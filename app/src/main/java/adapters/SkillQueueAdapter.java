package adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ru.tsk.eveonline.R;

public class SkillQueueAdapter extends BaseAdapter {

  private TextView skillNameTV;
  private TextView endTimeTV;

  private Activity activity;
  private LayoutInflater inflater;

  public SkillQueueAdapter(Activity activity) {

  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    inflater = activity.getLayoutInflater();

    if (convertView == null) {
      convertView = inflater.inflate(R.layout.activity_skill_queue, null);
      skillNameTV = (TextView) convertView.findViewById(R.id.skillName);
      endTimeTV = (TextView) convertView.findViewById(R.id.trainingTime);
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
