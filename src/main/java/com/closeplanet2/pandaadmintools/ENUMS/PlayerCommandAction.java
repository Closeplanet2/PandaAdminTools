package com.closeplanet2.pandaadmintools.ENUMS;

import com.closeplanet2.pandaspigotcore.PLAYER.TOGGLE_ACTIONS;

public enum PlayerCommandAction {
    TOGGLE_SEND_MESSAGES("Send Messages", TOGGLE_ACTIONS.PlayerSendMessageEvent, true),
    TOGGLE_GET_MESSAGES("Get Messages", TOGGLE_ACTIONS.PlayerGetMessageEvent, true),
    TOGGLE_BED_ENTER("Bed Enter", TOGGLE_ACTIONS.PlayerBedEnterEvent, true),
    TOGGLE_BED_LEAVE("Bed Leave", TOGGLE_ACTIONS.PlayerBedLeaveEvent, true),
    TOGGLE_COMMANDS("Send Commands", TOGGLE_ACTIONS.PlayerCommandSendEvent, true),
    TOGGLE_EXP_CHANGE("Exp Change", TOGGLE_ACTIONS.PlayerExpChangeEvent, true),
    TOGGLE_LEVEL_CHANGE("Level Change", TOGGLE_ACTIONS.PlayerLevelChangeEvent, true),
    TOGGLE_HARVEST("Harvest", TOGGLE_ACTIONS.PlayerHarvestBlockEvent, true),
    TOGGLE_INTERACT("Interact", TOGGLE_ACTIONS.PlayerInteractEvent, true),
    TOGGLE_ITEM_CONSUME("Item Consume", TOGGLE_ACTIONS.PlayerItemConsumeEvent, true),
    TOGGLE_MOVE("Move", TOGGLE_ACTIONS.PlayerSendMessageEvent, false),
    TOGGLE_TELEPORT("Teleport", TOGGLE_ACTIONS.PlayerTeleportEvent, true),
    TOGGLE_BLOCK_BREAK("Block Break", TOGGLE_ACTIONS.BlockBreakEvent, true),
    TOGGLE_BLOCK_PLACE("BLock Place", TOGGLE_ACTIONS.BlockPlaceEvent, true),
    TOGGLE_DROP_ITEMS("Drop Items", TOGGLE_ACTIONS.BlockDropEvent, true),
    TOGGLE_INVENTORY_OPEN("Inventory Open", TOGGLE_ACTIONS.InventoryOpenEvent, true),
    TOGGLE_DEAL_DAMAGE("Deal Damage", TOGGLE_ACTIONS.PlayerDamageEvent, true),
    TELEPORT_TO_PLAYER(null, null, false),
    SPECTATE_PLAYER(null, null, false),
    VIEW_INVENTORY(null, null, false),
    KICK_PLAYER(null, null, false),
    CLEAR_INVENTORY(null, null, false);

    public final String key;
    public final TOGGLE_ACTIONS toggle_actions;
    public final boolean runAsToggleAction;

    private PlayerCommandAction(String key, TOGGLE_ACTIONS toggle_actions, boolean runAsToggleAction){
        this.key = key;
        this.toggle_actions = toggle_actions;
        this.runAsToggleAction = runAsToggleAction;
    }
}
