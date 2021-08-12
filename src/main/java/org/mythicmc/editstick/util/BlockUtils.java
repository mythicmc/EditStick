package org.mythicmc.editstick.util;

import org.bukkit.Axis;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Orientable;

public class BlockUtils {
    public static void rotateBlock(Block block) {
        BlockData blockData = block.getBlockData();
        //-- Change "Facing"
        if (blockData instanceof Directional) {
            Directional directional = (Directional) blockData;
            BlockFace face = directional.getFacing();
            if (face == BlockFace.NORTH) {
                directional.setFacing(BlockFace.EAST);
            } else if (face == BlockFace.EAST) {
                directional.setFacing(BlockFace.SOUTH);
            } else if (face == BlockFace.SOUTH) {
                directional.setFacing(BlockFace.WEST);
            } else if (face == BlockFace.WEST) {
                if(directional.getFaces().contains(BlockFace.UP)){
                    directional.setFacing(BlockFace.UP);
                } else {
                    directional.setFacing(BlockFace.NORTH);
                }
            } else if(face == BlockFace.UP){
                directional.setFacing(BlockFace.DOWN);
            } else if(face == BlockFace.DOWN){
                directional.setFacing((BlockFace.NORTH));
            }
            block.setBlockData(directional);
        }
        //-- Change "Axis"
        else if (blockData instanceof Orientable) {
            Orientable orientation = (Orientable) blockData;
            Axis axis = orientation.getAxis();
            if (axis == Axis.X) {
                orientation.setAxis(Axis.Y);
                block.setBlockData(orientation);
            } else if (axis == Axis.Y) {
                orientation.setAxis(Axis.Z);
                block.setBlockData(orientation);
            } else if (axis == Axis.Z) {
                orientation.setAxis(Axis.X);
                block.setBlockData(orientation);
            }
        }
    }
}
