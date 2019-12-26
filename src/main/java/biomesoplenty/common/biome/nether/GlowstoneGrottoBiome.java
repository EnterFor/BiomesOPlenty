package biomesoplenty.common.biome.nether;

import biomesoplenty.api.enums.BOPClimates;
import biomesoplenty.common.biome.NetherBiomeBOP;
import biomesoplenty.common.world.biome.BiomeFeatureHelper;
import biomesoplenty.common.world.gen.feature.BOPBiomeFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class GlowstoneGrottoBiome extends NetherBiomeBOP
{
    public GlowstoneGrottoBiome()
    {
        super((new Builder()).surfaceBuilder(SurfaceBuilder.NETHER, SurfaceBuilder.NETHERRACK_CONFIG).precipitation(RainType.NONE).category(Category.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).waterColor(4159204).waterFogColor(329011).parent((String)null));

        //Terrain
        this.addStructureStart(Feature.NETHER_BRIDGE.configured(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.2F)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.configured(DefaultBiomeFeatures.LAVA_SPRING_CONFIG).decorated(Placement.COUNT_VERY_BIASED_RANGE.configured(new CountRangeConfig(20, 8, 16, 256))));

        DefaultBiomeFeatures.addDefaultMushrooms(this);

        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.NETHER_BRIDGE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.configured(DefaultBiomeFeatures.OPEN_NETHER_SPRING_CONFIG).decorated(Placement.COUNT_RANGE.configured(new CountRangeConfig(8, 4, 8, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.RANDOM_PATCH, DefaultBiomeFeatures.HELL_FIRE_CONFIG, Placement.HELL_FIRE, new FrequencyConfig(10)));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.GLOWSTONE_BLOB, IFeatureConfig.NO_FEATURE_CONFIG, Placement.LIGHT_GEM_CHANCE, new FrequencyConfig(50)));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.GLOWSTONE_BLOB, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(50, 0, 0, 128)));

        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(BOPBiomeFeatures.GLOWSTONE_SPIKES, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(9)));

        //Base Decorations
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.RANDOM_PATCH, BiomeFeatureHelper.createClusterConfiguration(Blocks.BROWN_MUSHROOM.getDefaultState()), Placement.CHANCE_RANGE, new ChanceRangeConfig(0.25F, 0, 0, 128)));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.RANDOM_PATCH, BiomeFeatureHelper.createClusterConfiguration(Blocks.RED_MUSHROOM.getDefaultState()), Placement.CHANCE_RANGE, new ChanceRangeConfig(0.25F, 0, 0, 128)));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14), Placement.COUNT_RANGE, new CountRangeConfig(16, 10, 20, 128)));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33), Placement.MAGMA, new FrequencyConfig(4)));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.configured(DefaultBiomeFeatures.CLOSED_NETHER_SPRING_CONFIG).decorated(Placement.COUNT_RANGE.configured(new CountRangeConfig(16, 10, 20, 128))));

        //Entities
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.GHAST, 20, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_PIGMAN, 50, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.MAGMA_CUBE, 2, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 1, 4, 4));

        this.addWeight(BOPClimates.NETHER, 3);
    }
}