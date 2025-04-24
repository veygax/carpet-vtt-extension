package dev.veygax.carpetvttextension.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public class LeashProxyEntity extends MobEntity {
    private final LivingEntity parent;
    private boolean removed = false;

    public LeashProxyEntity(LivingEntity parent) {
        super(EntityType.HORSE, parent.getWorld());
        this.parent = parent;
        this.setInvisible(true);
        this.setNoGravity(true);
        this.setSilent(true);
        this.setInvulnerable(true);
    }

    @Override
    public void tick() {
        if (!this.parent.isAlive() || this.parent.isRemoved()) {
            this.proxyRemove();
            return;
        }

        World world = this.getWorld();
        if (world != this.parent.getWorld()) {
            this.proxyRemove();
            return;
        }

        this.setPos(this.parent.getX(), this.parent.getY(), this.parent.getZ());
    }

    public void proxyRemove() {
        this.removed = true;
        this.discard();
    }

    public boolean proxyIsRemoved() {
        return this.removed || this.isRemoved();
    }
} 