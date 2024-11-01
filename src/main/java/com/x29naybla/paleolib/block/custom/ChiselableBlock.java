package com.x29naybla.paleolib.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.x29naybla.paleolib.block.entity.ChiselableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

import javax.annotation.Nullable;

public class ChiselableBlock extends BaseEntityBlock {
    public static final MapCodec<ChiselableBlock> CODEC = RecordCodecBuilder.mapCodec((p_344647_) -> {
        return p_344647_.group(BuiltInRegistries.BLOCK.byNameCodec().fieldOf("turns_into").forGetter(ChiselableBlock::getTurnsInto), BuiltInRegistries.SOUND_EVENT.byNameCodec().fieldOf("chisel_sound").forGetter(ChiselableBlock::getChiselSound), BuiltInRegistries.SOUND_EVENT.byNameCodec().fieldOf("chisel_completed_sound").forGetter(ChiselableBlock::getChiselCompletedSound), propertiesCodec()).apply(p_344647_, ChiselableBlock::new);
    });
    private static final IntegerProperty DUSTED;
    public static final int TICK_DELAY = 2;
    private final Block turnsInto;
    private final SoundEvent chiselSound;
    private final SoundEvent chiselCompletedSound;

    public MapCodec<ChiselableBlock> codec() {
        return CODEC;
    }

    public ChiselableBlock(Block turnsInto, SoundEvent chiselSound, SoundEvent chiselCompletedSound, BlockBehaviour.Properties properties) {
        super(properties);
        this.turnsInto = turnsInto;
        this.chiselSound = chiselSound;
        this.chiselCompletedSound = chiselCompletedSound;
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(DUSTED, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DUSTED});
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        level.scheduleTick(pos, this, 2);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        level.scheduleTick(pos, this, 2);
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity var6 = level.getBlockEntity(pos);
        if (var6 instanceof ChiselableBlockEntity chiselableblockentity) {
            chiselableblockentity.checkReset();
        }

    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(16) == 0) {
        }

    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChiselableBlockEntity(pos, state);
    }

    public Block getTurnsInto() {
        return this.turnsInto;
    }

    public SoundEvent getChiselSound() {
        return this.chiselSound;
    }

    public SoundEvent getChiselCompletedSound() {
        return this.chiselCompletedSound;
    }

    static {
        DUSTED = BlockStateProperties.DUSTED;
    }
}
