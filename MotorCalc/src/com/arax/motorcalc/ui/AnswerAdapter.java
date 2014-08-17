package com.arax.motorcalc.ui;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;




import com.arax.motorcalc.R;
import com.arax.motorcalc.data.AnswerItem;

public class AnswerAdapter extends ArrayAdapter<AnswerItem> {
	
	private final Context context;
	private final List<AnswerItem> values;
	public AnswerAdapter(Context context, List<AnswerItem> objects) {
		super(context,R.layout.row, objects);
		this.context = context;
		this.values = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 LayoutInflater inflater = (LayoutInflater) context	.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 View rowView = inflater.inflate(R.layout.row, parent, false);
		 AnswerItem item=values.get(position);
		 TextView textView = (TextView) rowView.findViewById(R.id.spec);
		 textView.setText(item.getSpecification());
		 ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		 
		 int imageid = R.drawable.err;
		 
		 
		 switch (item.getType()) {
			case Current:
				imageid=R.drawable.amp;
				break;
		case C1:
			imageid=R.drawable.c1;
			break;
		case C2:
			imageid=R.drawable.c2;
			break;
		case C3:
			imageid=R.drawable.c3;
			break;
		case CBidirect:
			imageid=R.drawable.cbidirect;
			break;
		case SSD:
			imageid=R.drawable.ssd;
			
			break;
		case VSD:
			imageid=R.drawable.vsd;
			break;
		case Guard:
			imageid=R.drawable.bimetal;
			break;
		case ACB:
			
			break;
		case MCB:
			
			break;
		case MCCB:
			imageid=R.drawable.mccb;
			break;
		case TMB:
			imageid=R.drawable.tmb;
			break;
			
		default:
			break;
		}
		 
		 imageView.setImageResource(imageid);
		return rowView;
	}

}
