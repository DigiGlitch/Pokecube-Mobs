package pokecube.core.moves.implementations.attacks.special;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import pokecube.core.interfaces.IPokemob;
import pokecube.core.interfaces.pokemob.moves.MovePacket;
import pokecube.core.moves.templates.Move_Basic;

public class MovePresent extends Move_Basic
{

    public MovePresent()
    {
        super("present");
    }

    @Override
    public int getPWR(IPokemob user, Entity target)
    {
        double rand = new Random().nextDouble();
        if (rand < 0.4) { return 40; }
        if (rand < 0.7) { return 80; }
        if (rand < 0.8) { return 120; }
        return 0;
    }

    @Override
    public void postAttack(MovePacket packet)
    {
        super.postAttack(packet);
        if (packet.canceled || packet.failed) return;
        if (packet.PWR == 0 && packet.attacked instanceof EntityLivingBase)
        {
            EntityLivingBase toHeal = (EntityLivingBase) packet.attacked;
            float health = Math.min(toHeal.getHealth() + 80, toHeal.getMaxHealth());
            toHeal.setHealth(health);
        }
    }
}
