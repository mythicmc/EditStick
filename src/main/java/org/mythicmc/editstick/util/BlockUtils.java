package org.mythicmc.editstick.util;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;

public class BlockUtils {
    public static void rotateBlock(Block block) {
        BlockData blockData = block.getBlockData();
        if (blockData instanceof Directional) {
            Directional directional = (Directional) blockData;
            BlockFace face = directional.getFacing();
            if (face == BlockFace.NORTH) {
                directional.setFacing(BlockFace.EAST);
                block.setBlockData(directional);
            } else if (face == BlockFace.EAST) {
                directional.setFacing(BlockFace.SOUTH);
                block.setBlockData(directional);
            } else if (face == BlockFace.SOUTH) {
                directional.setFacing(BlockFace.WEST);
                block.setBlockData(directional);
            } else if (face == BlockFace.WEST) {
                directional.setFacing(BlockFace.NORTH);
                block.setBlockData(directional);
            }
        }
    }
}
