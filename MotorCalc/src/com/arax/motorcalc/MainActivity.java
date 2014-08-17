package com.arax.motorcalc;





import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.arax.motorcalc.bussiness.CalcAnswer;
import com.arax.motorcalc.bussiness.CalcStartMode;
import com.arax.motorcalc.bussiness.command.CalcAnswerCommand;
import com.arax.motorcalc.bussiness.command.CalcStartModeCommand;
import com.arax.motorcalc.data.Answer;
import com.arax.motorcalc.data.DataBaseHelper;
import com.arax.motorcalc.data.StartMode;
import com.google.inject.Inject;
import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.Validator.ValidationListener;
import com.mobsandgeeks.saripaar.annotation.NumberRule;
import com.mobsandgeeks.saripaar.annotation.NumberRule.NumberType;
import com.mobsandgeeks.saripaar.annotation.Required;

public class MainActivity extends RoboActivity implements ValidationListener{
	
     @InjectView(R.id.StartmodeSelect) Spinner startmodeSpinner;
     
 
     @Required(order = 1,messageResId=R.string.voltage_msg)
     @InjectView(R.id.voltageEdit) EditText voltageEdit;

     @Required(order = 1,messageResId=R.string.powerfactor_msg)
     @NumberRule(order = 1,messageResId=R.string.powerfactor_msg, type = NumberType.DOUBLE ,gt=0.1,lt=1)
     @InjectView(R.id.powerfactorEdit) EditText powerfactorEdit;
 	 
     @Required(order = 1,messageResId=R.string.effecieny_out_of_range)
     @NumberRule(order = 1,messageResId=R.string.effecieny_out_of_range, type = NumberType.DOUBLE ,gt=0.1,lt=1)
     @InjectView(R.id.efficiencyEdit) EditText efficeincyEdit;
 	 
 	 
     @InjectView(R.id.isBidirect) CheckBox isbidirectCheck;
     
     @Required(order = 1,messageResId=R.string.power_msg)
	 @InjectView(R.id.powerEdit) EditText powerEdit;
	 
	 @InjectView(R.id.calcBtn) Button calcBtn;

	 @Inject DataBaseHelper  helper;

	 @Inject CalcStartMode startmodeService;

	 @Inject CalcAnswer answerService;
	
	 
	 
 

 private Boolean isValid=true;

 Validator validator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);

	   this.setContentView(R.layout.activity_main);
	   
	    validator = new Validator(this);
	    validator.setValidationListener(this);
	 
	    
	    setValidationRules();
	   
	 
	    startmodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				StartMode sm=(StartMode)startmodeSpinner.getSelectedItem();
				
				if(sm!=StartMode.DOL){
					isbidirectCheck.setChecked(false);
					isbidirectCheck.setEnabled(false);
					
				}else{
					isbidirectCheck.setChecked(false);
					isbidirectCheck.setEnabled(true);
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	   powerEdit.addTextChangedListener(new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
		
			validator.validate();
		
		     if(!isValid){return;}
             Double power=Double.parseDouble(s.toString());
			
			StartMode sm=startmodeService.Execute(new CalcStartModeCommand(power));
	
			
			startmodeSpinner.setSelection(sm.ordinal());
	
	}});

	   voltageEdit.addTextChangedListener(new TextWatcher() {

		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			validator.validate();
			
		}
	});
	  
	   powerfactorEdit.addTextChangedListener(new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			validator.validate();
			
		}
	});

	   efficeincyEdit.addTextChangedListener(new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			validator.validate();
			
		}
	});
	   calcBtn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			

		
			 
			double power=Double.parseDouble(powerEdit.getText().toString());
			double powerfactor=Double.parseDouble(powerfactorEdit.getText().toString());
			double effeciency=Double.parseDouble(efficeincyEdit.getText().toString());
			int voltage=Integer.parseInt(voltageEdit.getText().toString());
			StartMode sm=(StartMode)startmodeSpinner.getSelectedItem();
			boolean isbidirect=isbidirectCheck.isChecked();
			CalcAnswerCommand answerCommand=new CalcAnswerCommand(power,powerfactor,effeciency,voltage,sm,isbidirect);
			Answer answer = null;
			try {
				answer = answerService.Execute(answerCommand);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			Intent answerIntent=new Intent(getApplicationContext(),AnswerActivity.class);
			
			answerIntent.putExtra("answer", answer);
		
			
			startActivity(answerIntent);
	
			
		}
	});
		
		
	    populateList();
		
		
	}

	private void setValidationRules() {
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
	
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	
				 return true;
				
	}



	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		
		if(resultCode==RESULT_CANCELED){
			return;
		}
		
		if(resultCode==AnswerActivity.RESULT_DELETE){
	
		}
		
		if(resultCode==RESULT_OK){
//		long extera=data.getLongExtra("ACB",0);
			
	
		
				
			
			
		}

			

	}

	private void populateList() {
	
		
		ArrayAdapter<StartMode> adp = new ArrayAdapter<StartMode>(this, android.R.layout.simple_list_item_1, StartMode.values());
		
		startmodeSpinner.setAdapter(adp);

	}

	@Override
	public void onValidationFailed(View failedView, Rule<?> failedRule) {
				calcBtn.setEnabled(false);
				isValid=false;
		String message = failedRule.getFailureMessage();

        if (failedView instanceof EditText) {
            failedView.requestFocus();
            ((EditText) failedView).setError(message);
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
		
	}

	@Override
	public void onValidationSucceeded() {
		calcBtn.setEnabled(true);
		isValid=true;
		
	}


	


	
}
