/*
 * =====================================================================================*
 * This file is part of Aion-Unique (Aion-Unique Home Software Development)             *
 * Aion-Unique Development is a closed Aion Project that use Old Aion Project Base      *
 * Like Aion-Lightning, Aion-Engine, Aion-Core, Aion-Extreme, Aion-NextGen, ArchSoft,   *
 * Aion-Ger, U3J, Encom And other Aion project, All Credit Content                      *
 * That they make is belong to them/Copyright is belong to them. And All new Content    *
 * that Aion-Unique make the copyright is belong to Aion-Unique                         *
 * You may have agreement with Aion-Unique Development, before use this Engine/Source   *
 * You have agree with all of Term of Services agreement with Aion-Unique Development   *
 * =====================================================================================*
 */
package quest.inggison_armor;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.questEngine.handlers.QuestHandler;
import com.aionemu.gameserver.questEngine.model.QuestDialog;
import com.aionemu.gameserver.questEngine.model.QuestEnv;
import com.aionemu.gameserver.questEngine.model.QuestState;
import com.aionemu.gameserver.questEngine.model.QuestStatus;

public class _11053These_Shoes_Are_Made_For_Stalking extends QuestHandler
{
	private final static int questId = 11053;
	
	public _11053These_Shoes_Are_Made_For_Stalking() {
		super(questId);
	}
	
	@Override
	public void register() {
		qe.registerQuestNpc(799015).addOnQuestStart(questId); //Siaqua
		qe.registerQuestNpc(799015).addOnTalkEvent(questId); //Siaqua
		qe.registerQuestNpc(799017).addOnTalkEvent(questId); //Sulinia
	}
	
	@Override
	public boolean onDialogEvent(QuestEnv env) {
		Player player = env.getPlayer();
		QuestState qs = player.getQuestStateList().getQuestState(questId);
		QuestDialog dialog = env.getDialog();
		int targetId = env.getTargetId();
		if (qs == null || qs.canRepeat()) {
			if (targetId == 799015) { //Siaqua
				if (dialog == QuestDialog.START_DIALOG) {
					return sendQuestDialog(env, 1011);
				} else {
					return sendQuestStartDialog(env);
				}
			}
		} else if (qs.getStatus() == QuestStatus.START) {
			if (targetId == 799017) { //Sulinia
				if (dialog == QuestDialog.START_DIALOG) {
					return sendQuestDialog(env, 2375);
				} else if (dialog == QuestDialog.CHECK_COLLECTED_ITEMS) {
					//Collect Dry Ettin Leaf (30)
                    //Collect Kinah (50000)
					long itemCount = player.getInventory().getItemCountByItemId(182206838);
					if (player.getInventory().tryDecreaseKinah(50000) && itemCount > 29) {
						player.getInventory().decreaseByItemId(182206838, 30);
						changeQuestStep(env, 0, 0, true);
						return sendQuestDialog(env, 5);
					} else
						return sendQuestDialog(env, 2716);
				} else if (dialog == QuestDialog.FINISH_DIALOG) {
					return defaultCloseDialog(env, 0, 0);
				}
			}
		} else if (qs.getStatus() == QuestStatus.REWARD) {
			if (targetId == 799017) //Sulinia
				return sendQuestEndDialog(env);
		}
		return false;
	}
}