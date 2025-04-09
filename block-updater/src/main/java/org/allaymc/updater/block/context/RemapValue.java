package org.allaymc.updater.block.context;

/**
 * @author IWareQ
 */
public record RemapValue(Object oldValue, Object newValue) implements StateEditor {
}
