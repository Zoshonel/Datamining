package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Profile;

public class EvaluerListener implements ActionListener {
	
	private IHM frame;
	
	public EvaluerListener(IHM _frame){
		super();
		this.frame=_frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Profile profile = new Profile(frame.getChamp_num_1_text(), frame.getChamp_num_2_text(), frame.getChamp_box_3_text(), frame.getChamp_num_4_text(), frame.getChamp_box_5_text(), frame.getChamp_box_6_text(), frame.getChamp_box_7_text());
		frame.getController().startEvaluate(profile);
	}

}
