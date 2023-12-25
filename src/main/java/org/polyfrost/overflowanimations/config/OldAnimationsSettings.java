package org.polyfrost.overflowanimations.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.PageLocation;
import cc.polyfrost.oneconfig.config.migration.VigilanceMigrator;
import cc.polyfrost.oneconfig.config.migration.VigilanceName;
import net.minecraft.client.Minecraft;
import org.polyfrost.overflowanimations.OverflowAnimations;
import org.polyfrost.overflowanimations.hooks.AnimationExportUtils;

@SuppressWarnings("unused")
public class OldAnimationsSettings extends Config {

    @Switch(
            name = "2D Dropped Items",
            description = "Renders items as sprites rather than as models.",
            subcategory = "2D Dropped Items"
    )
    public static boolean itemSprites = false;

    @Checkbox(name = "1.7 Item Sprite Colors",
            description = "Changes the colors of the dropped item sprites to be brighter just like in 1.7.",
            subcategory = "2D Dropped Items"
    )
    public static boolean itemSpritesColor = false;

    @Checkbox(
            name = "Remove Glint From Sprites",
            description = "This will disable the enchantment glint for both dropped items and projectiles. Only works with 2D items enabled.",
            subcategory = "2D Dropped Items"
    )
    public static boolean spritesGlint = false;

    @Switch(
            name = "Rotation Fix",
            description = "Allows dropped items to face the player properly without being stuck on the Y-Axis.",
            subcategory = "2D Dropped Items"
    )
    public static boolean rotationFix = true;

    // Interaction
    @Switch(
            name = "1.7 Block-Hitting Animation",
            description = "Re-enables the block-hitting animations.",
            subcategory = "Interaction"
    )
    @VigilanceName(
            name = "1.7 Block-Hitting Animation",
            category = "Animations",
            subcategory = "Interaction"
    )
    public static boolean oldBlockhitting = true;

    @Switch(
            name = "1.7 Smoother Sneaking",
            description = "Smoothens the player camera to appear just like the 1.7 smoother sneaking camera.",
            subcategory = "Interaction"
    )
    @VigilanceName(
            name = "1.7 Smoother Sneaking",
            category = "Animations",
            subcategory = "Interaction"
    )
    public static boolean smoothSneaking = true;

    @Switch(
            name = "1.7 Armor Damage Tint",
            description = "Allows the armor to also have the damage tint applied to it.",
            subcategory = "Interaction"
    )
    @VigilanceName(
            name = "1.7 Red Armor Tint",
            category = "Animations",
            subcategory = "Interaction"
    )
    public static boolean redArmor = true;

    @Switch(
            name = "1.7 Item Switching Animation",
            description = "Re-enables the item switch animation from 1.7.",
            subcategory = "Interaction"
    )
    @VigilanceName(
            name = "1.7 Item Switching Animation",
            category = "Animations",
            subcategory = "Interaction"
    )
    public static boolean itemSwitch = true;

    @Switch(
            name = "1.7 Punching During Usage",
            description = "Purely visual feature. Re-enables the ability to consume food or block a sword whilst punching a block.",
            subcategory = "Interaction")
    @VigilanceName(
            name = "1.7 Punching During Usage",
            category = "Animations",
            subcategory = "Interaction"
    )
    public static boolean punching = true;

    @Checkbox(
            name = "1.7 Punch-During-Usage Particles",
            description = "Spawns Particles whilst Punching During Usage",
            subcategory = "Interaction"
    )
    public static boolean punchingParticles = true;

    // Positions
    @Switch(
            name = "1.7 First-Person Item Transformations",
            description = "Brings back the old item positions from 1.7.",
            subcategory = "Position"
    )
    public static boolean firstTransformations = true;

    @Switch(
            name = "1.7 Third-Person Item Transformations",
            description = "Brings back the old item positions from 1.7.",
            subcategory = "Position"
    )
    public static boolean thirdTransformations = true;

    @Checkbox(
            name = "1.7 First-Person Fishing Rod Position",
            description = "Brings back the old fishing rod position from 1.7.",
            subcategory = "Position"
    )
    public static boolean fishingRodPosition = true;

    @Checkbox(
            name = "1.7 First-Person Carpet Position",
            description = "Brings back the old carpet position from 1.7.",
            subcategory = "Position"
    )
    public static boolean firstPersonCarpetPosition = true;

    @Checkbox(
            name = "1.7 Third-Person Carpet Position",
            description = "Brings back the old carpet position from 1.7.",
            subcategory = "Position"
    )
    public static boolean thirdPersonCarpetPosition = true;

    @Switch(
            name = "1.7 Projectiles Transformations",
            description = "Mirrors and transforms projectiles so that they're facing the correct direction and in the same position as 1.7 or 1.9+.",
            subcategory = "Position"
    )
    public static boolean oldProjectiles = true;

    @Switch(
            name = "1.7 Third-Person Arm Block Position",
            description = "Brings back the old arm rotation while blocking from 1.7.",
            subcategory = "Position")
    public static boolean oldArmPosition = true;

    @Switch(
            name = "1.7 Third-Person Sword Block Position",
            description = "Brings back the old sword rotation while blocking from 1.7.",
            subcategory = "Position"
    )
    @VigilanceName(
            name = "1.7 3rd Person Block Animation",
            category = "Animations",
            subcategory = "Position"
    )
    public static boolean thirdPersonBlock = true;

    @Switch(
            name = "1.7 XP Orbs Position",
            description = "Brings back the old XP Orbs position from 1.7.",
            subcategory = "Position"
    )
    public static boolean oldXPOrbs = true;

    @Switch(
            name = "1.7 Pickup Animation Position",
            description = "Brings back the old item pickup position from 1.7.",
            subcategory = "Position"
    )
    public static boolean oldPickup = true;

    // HUD
    @Switch(
            name = "1.7 Health Bar Flashing",
            description = "Disables the heart flashing texture while taking damage similar to 1.7.",
            subcategory = "HUD"
    )
    @VigilanceName(
            name = "Remove Health Bar Flashing",
            category = "Animations",
            subcategory = "HUD"
    )
    public static boolean oldHealth = true;

    @Dropdown(
            name = "Debug Menu Crosshair Style",
            description = "Allows you to choose between the 1.7, the vanilla 1.8, and the 1.12+ debug screen crosshair. 1.12+ Debug Screen Crosshair fixes Patcher's Parallax Fix Feature!",
            subcategory = "HUD",
            options = {"1.7", "1.8", "1.12+"}
    )
    public int debugCrosshairMode = 2;

    @Dropdown(
            name = "Debug Menu Style",
            description = "Reverts the debug menu to be aesthetically similar to 1.7",
            options = {"1.7", "1.8", "Disable Background"},
            subcategory = "HUD"
    )
    public int debugScreenMode = 1;

    @Dropdown(
            name = "Tab Menu Style",
            description = "Allows you to choose between the 1.7 tab menu, the 1.8 tab menu, and disabling the player heads in the tab menu.",
            options = {"1.7", "1.8", "Disable Heads"},
            subcategory = "HUD"
    )
    public int tabMode = 1;

    // Miscellaneous
    @Switch(
            name = "1.15+ Armor Enchantment Glint",
            description = "Back-ports the 1.15 armor glint rendering.",
            category = "Misc", subcategory = "Modern"
    )
    public static boolean enchantmentGlintNew = true;

    @Switch(
            name = "1.15+ Backwards Walk Animation",
            description = "Back-ports the 1.15 walking animation.",
            category = "Misc", subcategory = "Modern"
    )
    public static boolean modernMovement = false;

    @Switch(
            name = "1.7 Held Item Lighting",
            description = "Modifies the held item lighting to resemble 1.7.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean oldItemLighting = true;

    @Switch(
            name = "1.7 Miss Penalty Swing Animation",
            description = "This option is purely visual. During the miss penalty, the player's arm will still swing and show particles just like in 1.7.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean visualSwing = true;

    @Switch(
            name = "1.7 Third-Person Fishing Rod Cast Texture",
            description = "For some reason, in 1.7, when a fishing rod is cast, the third person texture becomes a stick rather than the fishing rod texture. This feature brings back that questionable feature.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean fishingStick = false;

    @Switch(
            name = "Allow Particles to No-Clip",
            description = "Allows particles to no clip through blocks by simply not checking for collisions.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean particleNoClip = false;

    @Switch(
            name = "Render Fireball Projectile as a Model",
            description = "Renders the thrown fireball projectiles as models rather than as sprites.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean fireballModel = false;

    @Switch(
            name = "Rod Line Position Based on FOV",
            description = "Includes the player's FOV when calculating the fishing rod cast line position.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean fixRod = true;

    @Switch(
            name = "Block Breaking Fixes",
            description = "Resets block removing while using an item or when the player is out of range of a block.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean breakFix = false;

    @Switch(
            name = "Disable Entity/Mob Third-Person Item Transformations",
            description = "Allows/Disallows mobs or entities to have third person item positions applied to them.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean entityTransforms = true;

    @Switch(
            name = "Disable Punching During Usage in Adventure Mode",
            description = "Allows/Disallows the punching during usage feature in Adventure Mode.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean adventurePunching = false;

    @Switch(
            name = "Disable Punching During Usage in Adventure Mode",
            description = "Allows/Disallows the punching during usage feature in Adventure Mode.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean adventureBlockHit = false;

    @Checkbox(
            name = "Disable Punch-During-Usage Particles in Adventure Mode",
            description = "Allows/Disallows the particles played while punching during usage to appear while in Adventure Mode.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean adventureParticles = true;

    @Switch(
            name = "Disable Hurt Camera Shake",
            description = "Disables the camera damage shake.",
            category = "Misc", subcategory = "Fixes, QOL, and Tweaks"
    )
    public static boolean noHurtCam = false;

    @Switch(
            name = "Old Lunar/CheatBreaker Block-Hit Position",
            description = "Brings back the weird block-hitting position from older versions of Lunar Client or CheatBreaker!",
            category = "Misc", subcategory = "Fun"
    )
    public static boolean lunarBlockhit = false;

    @Switch(
            name = "Allow Clicking While Using an Item",
            description = "This option is purely visual. Allows the player to swing while clicking and using an item.",
            category = "Misc", subcategory = "Fun"
    )
    public static boolean fakeBlockHit = false;

    @Switch(
            name = "Global Toggle",
            description = "This option globally enables/disables custom item transformations",
            category = "Customize Item Positions"
    )
    public static boolean globalPositions = true;

    @Button(
            name = "Globally Reset ALL Item Transformations",
            text = "Reset",
            category = "Customize Item Positions"
    )
    Runnable resetGlobally = (() -> {
        Minecraft.getMinecraft().displayGuiScreen(null);
        itemPositionX = 0.0F;
        itemPositionY = 0.0F;
        itemPositionZ = 0.0F;
        itemRotationYaw = 0.0F;
        itemRotationPitch = 0.0F;
        itemRotationRoll = 0.0F;
        itemScale = 0.0F;

        advancedSettings.itemSwingPositionX = 0.0F;
        advancedSettings.itemSwingPositionY = 0.0F;
        advancedSettings.itemSwingPositionZ = 0.0F;
        advancedSettings.itemSwingSpeed = 0.0F;
        advancedSettings.itemSwingSpeedHaste = 0.0F;
        advancedSettings.itemSwingSpeedFatigue = 0.0F;
        ItemPositionAdvancedSettings.shouldScaleSwing = false;
        ItemPositionAdvancedSettings.disableSwing = false;
        ItemPositionAdvancedSettings.ignoreHaste = false;

        advancedSettings.consumePositionX = 0.0F;
        advancedSettings.consumePositionY = 0.0F;
        advancedSettings.consumePositionZ = 0.0F;
        advancedSettings.consumeRotationYaw = 0.0F;
        advancedSettings.consumeRotationPitch = 0.0F;
        advancedSettings.consumeRotationRoll = 0.0F;
        advancedSettings.consumeScale = 0.0F;
        advancedSettings.consumeIntensity = 0.0F;
        advancedSettings.consumeSpeed = 0.0F;
        ItemPositionAdvancedSettings.shouldScaleEat = false;

        advancedSettings.blockedPositionX = 0.0F;
        advancedSettings.blockedPositionY = 0.0F;
        advancedSettings.blockedPositionZ = 0.0F;
        advancedSettings.blockedRotationYaw = 0.0F;
        advancedSettings.blockedRotationPitch = 0.0F;
        advancedSettings.blockedRotationRoll = 0.0F;
        advancedSettings. blockedScale = 0.0F;

        advancedSettings.droppedPositionX = 0.0F;
        advancedSettings.droppedPositionY = 0.0F;
        advancedSettings.droppedPositionZ = 0.0F;
        advancedSettings.droppedRotationYaw = 0.0F;
        advancedSettings.droppedRotationPitch = 0.0F;
        advancedSettings.droppedRotationRoll = 0.0F;
        advancedSettings.droppedScale = 0.0F;

        advancedSettings.projectilePositionX = 0.0F;
        advancedSettings.projectilePositionY = 0.0F;
        advancedSettings.projectilePositionZ = 0.0F;
        advancedSettings.projectileRotationYaw = 0.0F;
        advancedSettings.projectileRotationPitch = 0.0F;
        advancedSettings.projectileRotationRoll = 0.0F;
        advancedSettings.projectileScale = 0.0F;

        advancedSettings.fireballPositionX = 0.0F;
        advancedSettings.fireballPositionY = 0.0F;
        advancedSettings.fireballPositionZ = 0.0F;
        advancedSettings.fireballRotationYaw = 0.0F;
        advancedSettings.fireballRotationPitch = 0.0F;
        advancedSettings.fireballRotationRoll = 0.0F;
        advancedSettings.fireballScale = 0.0F;
        save();
        openGui();
    });

    @Button(
            name = "Copy / Export Item Positions As String",
            text = "Export",
            description = "Exports the item positions as a Base64 string. Will be copied to your clipboard.",
            category = "Customize Item Positions"
    )
    public void exportItemPositions() {
        AnimationExportUtils.exportItemPositions();
    }

    @Button(
            name = "Import Overflow / Dulkir Item Positions As String",
            text = "Import",
            description = "Exports the item positions as a Base64 string. Will be copied to your clipboard.",
            category = "Customize Item Positions"
    )
    public void importItemPositions() {
        Minecraft.getMinecraft().displayGuiScreen(null);
        AnimationExportUtils.importItemPositions();
        openGui();
    }

    @Button(
            name = "Transfer Dulkir Item Positions",
            text = "Transfer",
            description = "Transfers your DulkirMod item positions to OverflowAnimations.",
            category = "Customize Item Positions"
    )
    public void transferDulkirItemPositions() {
        Minecraft.getMinecraft().displayGuiScreen(null);
        AnimationExportUtils.transferDulkirConfig();
        openGui();
    }

    // Item Positions Customization
    @Slider(
            name = "Item X Position",
            min = -1.5F, max = 1.5F,
            category = "Customize Item Positions", subcategory = "Item Position",
            instant = true
    )
    public float itemPositionX = 0.0F;

    @Slider(
            name = "Item Y Position",
            min = -1.5F, max = 1.5F,
            category = "Customize Item Positions", subcategory = "Item Position",
            instant = true
    )
    public float itemPositionY = 0.0F;

    @Slider(
            name = "Item Z Position",
            min = -1.5F, max = 1.5F,
            category = "Customize Item Positions", subcategory = "Item Position",
            instant = true
    )
    public float itemPositionZ = 0.0F;

    @Slider(
            name = "Item Rotation Yaw",
            min = -180f, max = 180f, step = 1,
            category = "Customize Item Positions", subcategory = "Item Position",
            instant = true
    )
    public float itemRotationYaw = 0.0F;

    @Slider(
            name = "Item Rotation Pitch",
            min = -180f, max = 180f, step = 1,
            category = "Customize Item Positions", subcategory = "Item Position",
            instant = true
    )
    public float itemRotationPitch = 0.0F;

    @Slider(
            name = "Item Rotation Roll",
            min = -180f, max = 180f, step = 1,
            category = "Customize Item Positions", subcategory = "Item Position",
            instant = true
    )
    public float itemRotationRoll = 0.0F;

    @Slider(
            name = "Item Scale",
            min = -1.5f, max = 1.5f,
            category = "Customize Item Positions", subcategory = "Item Position",
            instant = true
    )
    public float itemScale = 0.0F;

    @Button(
            name = "Reset Item Transformations",
            text = "Reset",
            category = "Customize Item Positions", subcategory = "Item Position"
    )
    Runnable resetItem = (() -> {
        Minecraft.getMinecraft().displayGuiScreen(null);
        itemPositionX = 0.0F;
        itemPositionY = 0.0F;
        itemPositionZ = 0.0F;
        itemRotationYaw = 0.0F;
        itemRotationPitch = 0.0F;
        itemRotationRoll = 0.0F;
        itemScale = 0.0F;
        save();
        openGui();
    });

    @Page(
            name = "Advanced Item Customization Settings",
            description = "Customize all sorts of item positions!",
            location = PageLocation.BOTTOM,
            category = "Customize Item Positions", subcategory = "Item Position"
    )
    public static ItemPositionAdvancedSettings advancedSettings = new ItemPositionAdvancedSettings();

    public static boolean didTheFunnyDulkirThingElectricBoogaloo = false;

    @Exclude public static final OldAnimationsSettings INSTANCE = new OldAnimationsSettings();

    public OldAnimationsSettings() {
        super(new Mod(OverflowAnimations.NAME, ModType.PVP, "/overflowanimations_dark.svg", new VigilanceMigrator("./config/sk1eroldanimations.toml")), "overflowanimations.json");
        initialize();

        // Sprites
        addDependency("rotationFix", "itemSprites");
        addDependency("spritesGlint", "itemSprites");
        addDependency("itemSpritesColor", "itemSprites");
        // Interactions
        addDependency("punching", "oldBlockhitting");
        addDependency("punchingParticles", "oldBlockhitting");
        addDependency("adventureParticles", "oldBlockhitting");
        addDependency("adventurePunching", "oldBlockhitting");
        addDependency("adventureParticles", "punchingParticles");
        addDependency("punchingParticles", "punching");
        addDependency("adventureParticles", "punching");
        addDependency("adventurePunching", "punching");
        // Transformations
        addDependency("firstPersonCarpetPosition", "itemTransformations");
        addDependency("fixRod", "itemTransformations");
        addDependency("entityTransforms", "thirdTransformations");
    }
}