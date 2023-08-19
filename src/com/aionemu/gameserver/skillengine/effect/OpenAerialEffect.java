/*
 * This file is part of Encom. **ENCOM FUCK OTHER SVN**
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
package com.aionemu.gameserver.skillengine.effect;

import com.aionemu.gameserver.model.gameobjects.Creature;
import com.aionemu.gameserver.model.stats.container.StatEnum;
import com.aionemu.gameserver.skillengine.model.Effect;
import com.aionemu.gameserver.skillengine.model.SpellStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpenAerialEffect")
public class OpenAerialEffect extends EffectTemplate
{
	@Override
    public void applyEffect(Effect effect) {
        if (!effect.getEffected().getEffectController().isAbnormalSet(AbnormalState.STUMBLE)) {
            effect.addToEffectedController();
            effect.getEffected().getEffectController().removeParalyzeEffects();
        }
    }
	
	@Override
	public void calculate(Effect effect) {
		super.calculate(effect, StatEnum.OPENAREIAL_RESISTANCE, SpellStatus.OPENAERIAL);
	}
	
	@Override
	public void startEffect(Effect effect) {
		final Creature effected = effect.getEffected();
		effected.getController().cancelCurrentSkill();
		effected.getMoveController().abortMove();
		effected.getEffectController().setAbnormal(AbnormalState.OPENAERIAL.getId());
		effect.setAbnormal(AbnormalState.OPENAERIAL.getId());
	}
	
	@Override
	public void endEffect(Effect effect) {
		effect.getEffected().getEffectController().unsetAbnormal(AbnormalState.OPENAERIAL.getId());
	}
}