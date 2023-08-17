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
package quest.quest_specialize;

import com.aionemu.gameserver.model.gameobjects.Npc;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.questEngine.handlers.QuestHandler;
import com.aionemu.gameserver.questEngine.model.QuestDialog;
import com.aionemu.gameserver.questEngine.model.QuestEnv;
import com.aionemu.gameserver.questEngine.model.QuestState;
import com.aionemu.gameserver.questEngine.model.QuestStatus;
import com.aionemu.gameserver.services.QuestService;

/****/
/** Author Ghostfur & Unknown (Aion-Unique)
/****/

public class _14152_Spoiler_Alert extends QuestHandler
 {
	private final static int questId = 14152;
	
    public _14152_Spoiler_Alert() {
        super(questId);
    }
	
    @Override
    public void register() {
        qe.registerQuestNpc(204504).addOnQuestStart(questId); //Sofne.
        qe.registerQuestNpc(204504).addOnTalkEvent(questId); //Sofne.
        qe.registerQuestNpc(204574).addOnTalkEvent(questId); //Finn.
        qe.registerQuestNpc(203705).addOnTalkEvent(questId); //Jumentis.
		qe.registerQuestNpc(212151).addOnKillEvent(questId); //Chairman Garnis.
    }
	
    @Override
    public boolean onDialogEvent(QuestEnv env) {
        final Player player = env.getPlayer();
		final QuestState qs = player.getQuestStateList().getQuestState(questId);
		int var = qs.getQuestVarById(0);
        int targetId = env.getTargetId();
        if (env.getVisibleObject() instanceof Npc) {
            targetId = ((Npc) env.getVisibleObject()).getNpcId();
        } if (qs == null || qs.getStatus() == QuestStatus.NONE) {
            if (targetId == 204504) { //Sofne.
				switch (env.getDialog()) {
					case START_DIALOG: {
						return sendQuestDialog(env, 1011);
					} case ACCEPT_QUEST: {
						return sendQuestDialog(env, 4);
					} case REFUSE_QUEST: {
						QuestService.startQuest(env);
						qs.setQuestVarById(5, 1);
						updateQuestStatus(env);
                        return sendQuestDialog(env, 1003);
					} case REFUSE_QUEST_2: {
                        return sendQuestDialog(env, 1004);
					}
				}
            }
		} else if (qs.getStatus() == QuestStatus.START) {
			if (targetId == 204574) { //Finn.
				switch (env.getDialog()) {
					case START_DIALOG: {
						return sendQuestDialog(env, 1352);
					} case STEP_TO_1: {
						qs.setQuestVarById(5, 2);
						updateQuestStatus(env);
						giveQuestItem(env, 182215481, 1);
						return closeDialogWindow(env);					
					}
				}
			} else if (targetId == 203705) { //Jumentis.
				switch (env.getDialog()) {
					case START_DIALOG: {
						return sendQuestDialog(env, 1693);
					} case STEP_TO_2: {
						removeQuestItem(env, 182215481, 1);
						qs.setQuestVarById(5, 0);
						qs.setQuestVarById(0, 0);
						updateQuestStatus(env);
						return closeDialogWindow(env);					
					}
				}
			}
		} else if (qs.getStatus() == QuestStatus.REWARD) {
			if (targetId == 204504) { //Sofne.
				if (env.getDialog() == QuestDialog.USE_OBJECT && var == 1) {
					return sendQuestDialog(env, 2375);
				} else {
					return sendQuestEndDialog(env);
				}
			}
		}
		return false;		
	}
	
	@Override
    public boolean onKillEvent(QuestEnv env) {
        final Player player = env.getPlayer();
        final QuestState qs = player.getQuestStateList().getQuestState(questId);
        if (qs == null || qs.getStatus() != QuestStatus.START) {
            return false;
        }
        int var = qs.getQuestVarById(0);
        int targetId = 0;
        if (env.getVisibleObject() instanceof Npc) {
            targetId = ((Npc) env.getVisibleObject()).getNpcId();
        } if (targetId == 212151 && var == 0) { //Chairman Garnis.
			qs.setQuestVarById(0, 1);
			qs.setStatus(QuestStatus.REWARD);
			updateQuestStatus(env);
			return true;
		}
		return false;
	}
}