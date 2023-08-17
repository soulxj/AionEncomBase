/*
 * This file is part of Encom.
 *
 *  Encom is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Encom is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser Public License
 *  along with Encom.  If not, see <http://www.gnu.org/licenses/>.
 */
package ai.instance.shugoEmperorVault;

import com.aionemu.gameserver.ai2.AIName;
import com.aionemu.gameserver.ai2.NpcAI2;
import com.aionemu.gameserver.controllers.effect.PlayerEffectController;
import com.aionemu.gameserver.model.Race;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.serverpackets.SM_DIALOG_WINDOW;
import com.aionemu.gameserver.skillengine.SkillEngine;
import com.aionemu.gameserver.utils.PacketSendUtility;

/****/
/** Author (Encom)
/****/

@AIName("templarerk")
public class Brave_Templarerk_SoulAI2 extends NpcAI2
{
	@Override
	protected void handleDialogStart(Player player) {
		PacketSendUtility.sendPacket(player, new SM_DIALOG_WINDOW(getObjectId(), 1011));
	}
	
	@Override
	public boolean onDialogSelect(Player player, int dialogId, int questId, int extendedRewardIndex) {
		PlayerEffectController effectController = player.getEffectController();
		if (dialogId == 10000) {
			switch (getNpcId()) {
			    case 833491: //Brave Templarerk's Soul.
				    if (player.getCommonData().getRace() == Race.ELYOS) {
				        effectController.removeEffect(21830);
				        effectController.removeEffect(21831);
					    SkillEngine.getInstance().applyEffectDirectly(21829, player, player, 1200000 * 1); //Brave Templarerk's Soul.
					}
			    break;
				case 833494: //Brave Templarerk's Soul.
				    if (player.getCommonData().getRace() == Race.ASMODIANS) {
						effectController.removeEffect(21833);
				        effectController.removeEffect(21834);
					    SkillEngine.getInstance().applyEffectDirectly(21832, player, player, 1200000 * 1); //Brave Templarerk's Soul.
					}
			    break;
			}
		}
		PacketSendUtility.sendPacket(player, new SM_DIALOG_WINDOW(getObjectId(), 0));
		return true;
	}
}