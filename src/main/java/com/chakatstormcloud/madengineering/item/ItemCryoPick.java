package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class ItemCryoPick extends ItemPickaxe{
	
	public ItemCryoPick(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(MadEngineering.MODID, unlocalizedName);
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		if (state.getBlock() == Blocks.OBSIDIAN) {
			return this.efficiency * 5;
		}
		return super.getDestroySpeed(stack, state);
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		// TODO Auto-generated method stub
		return super.onEntitySwing(entityLiving, stack);
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
		boolean did=false;
		World w = player.getEntityWorld();
		for(int i=0;i<6;i++) {   //tests all 6 positions surrounding the given one
			int[] xyz = {0,0,0}; //by first testing each axis +1
			xyz[i%3] = i<3?1:-1; //and then testing each axis -1
			BlockPos tpos = pos.add(xyz[0],xyz[1], xyz[2]);
			IBlockState blo = w.getBlockState(tpos);
			
			if(blo.getBlock() instanceof BlockLiquid) {
				did=true;
				if (!w.isRemote) {
					int lv = blo.getValue(BlockLiquid.LEVEL).intValue();
					if(blo.getMaterial() == Material.LAVA){
						if(lv==0) {
							w.setBlockState(tpos, Blocks.OBSIDIAN.getDefaultState(), 3);
						}else {
							w.setBlockState(tpos, Blocks.COBBLESTONE.getDefaultState(), 3);
						}
						
					}else if(blo.getMaterial() == Material.WATER) {
						if(lv==0) {
							w.setBlockState(tpos, Blocks.PACKED_ICE.getDefaultState(), 3);
						}else {
							w.setBlockState(tpos, Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS, lv%8), 3);
							//TODO level mod 8, probably isn't the best solution here, but I can't decipher BlockLiquid shit rn
						}
					}
				}
			}
		}
		if (did) {
			if (!w.isRemote) {
				itemstack.attemptDamageItem(1, player.getRNG(), (EntityPlayerMP) player);
			}else{
				w.playSound(player, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (w.rand.nextFloat() - w.rand.nextFloat()) * 0.8F);
			}
		}
		
		
		return super.onBlockStartBreak(itemstack, pos, player);
	}
	
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		boolean res = super.onLeftClickEntity(stack, player, entity);
		if ((!res)&&entity instanceof EntityLiving) {
			((EntityLiving)entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1800, 2));
		}
		return res;
	}

}
