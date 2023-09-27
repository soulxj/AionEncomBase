/*

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
package com.aionemu.gameserver.model.templates.bonus_service;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanke on 12/02/2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "F2pBonusAttr", propOrder = {"bonusAttr"})
public class F2pBonusAttr
{
    @XmlElement(name = "bonus_attr")
    protected List<F2pPenalityAttr> bonusAttr;

    @XmlAttribute(name = "buff_id", required = true)
    protected int buffId;

    public List<F2pPenalityAttr> getPenaltyAttr() {
        if (bonusAttr == null) {
            bonusAttr = new ArrayList<F2pPenalityAttr>();
        }
        return bonusAttr;
    }

    public int getBuffId() {
        return buffId;
    }

    public void setBuffId(int value) {
        buffId = value;
    }
}