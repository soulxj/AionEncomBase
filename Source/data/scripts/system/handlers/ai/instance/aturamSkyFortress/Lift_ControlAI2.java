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
package ai.instance.aturamSkyFortress;

import com.aionemu.gameserver.ai2.AIName;
import com.aionemu.gameserver.ai2.NpcAI2;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.serverpackets.SM_DIALOG_WINDOW;
import com.aionemu.gameserver.services.teleport.TeleportService2;
import com.aionemu.gameserver.utils.PacketSendUtility;

/****/
/** Author (Encom)
/****/

@AIName("Lift_Control")
public class Lift_ControlAI2 extends NpcAI2
{
	@Override
	protected void handleDialogStart(Player player) {
		PacketSendUtility.sendPacket(player, new SM_DIALOG_WINDOW(getOwner().getObjectId(), 1011));
	}
	
	@Override
    public boolean onDialogSelect(final Player player, int dialogId, int questId, int extendedRewardIndex) {
		int instanceId = getPosition().getInstanceId();
		switch (getNpcId()) {
		    case 730538: //Lift Control.
		        switch (player.getWorldId()) {
		            case 300240000: //Aturam Sky Fortress.
				        if (dialogId == 10000) {
							TeleportService2.teleportTo(player, 300240000, instanceId, 691.5343f, 457.017f, 655.5343f, (byte) 0);
					    }
				    break;
			    } switch (player.getWorldId()) {
		            case 300241000: //[Event] Aturam Sky Fortress.
				        if (dialogId == 10000) {
							TeleportService2.teleportTo(player, 300241000, instanceId, 691.5343f, 457.017f, 655.5343f, (byte) 0);
					    }
				    break;
			    }
			break;
		}
		return true;
	}
}