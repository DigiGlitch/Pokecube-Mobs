package pokecube.core.database.abilities.o;

import pokecube.core.database.abilities.Ability;
import pokecube.core.interfaces.IPokemob;
import pokecube.core.interfaces.IPokemob.MovePacket;

public class Oblivious extends Ability
{
    @Override
    public void onMoveUse(IPokemob mob, MovePacket move)
    {
        mob.getMoveStats().infatuateTarget = null;
        move.infatuateTarget = false;
    }

    @Override
    public void onUpdate(IPokemob mob)
    {
        mob.getMoveStats().infatuateTarget = null;
    }

}
