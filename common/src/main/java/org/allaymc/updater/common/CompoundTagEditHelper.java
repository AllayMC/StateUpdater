package org.allaymc.updater.common;

import lombok.Getter;

import java.util.*;

public class CompoundTagEditHelper {
    private final Deque<Map<String, Object>> parentTags = new ArrayDeque<>();
    private final Deque<String> tagNames = new ArrayDeque<>();

    @Getter
    private Map<String, Object> rootTag;
    private Object currentTag;

    public CompoundTagEditHelper(Map<String, Object> tag) {
        this.rootTag = tag;
        this.currentTag = tag;
    }

    public Object getTag() {
        return this.currentTag;
    }

    public Map<String, Object> getCompoundTag() {
        if (this.currentTag instanceof Map) {
            return (Map<String, Object>) this.currentTag;
        }

        return null;
    }

    public Map<String, Object> getParent() {
        return this.parentTags.isEmpty() ? null : this.parentTags.peekLast();
    }

    public boolean canPopChild() {
        return !this.parentTags.isEmpty();
    }

    public void popChild() {
        if (!this.parentTags.isEmpty()) {
            this.currentTag = this.parentTags.pollLast();
            this.tagNames.pollLast();
        }
    }

    public void pushChild(String name) {
        Objects.requireNonNull(name, "name");
        if (!(this.currentTag instanceof Map)) {
            throw new IllegalStateException("Current tag is not a Compound type");
        }

        var compoundTag = (Map<String, Object>) this.currentTag;
        if (!compoundTag.containsKey(name)) {
            throw new NoSuchElementException("Tag '" + name + "' does not exist");
        }

        this.parentTags.addLast(compoundTag);
        this.tagNames.addLast(name);
        this.currentTag = compoundTag.get(name);
    }

    public void replaceWith(String name, Object newTag) {
        if (parentTags.isEmpty()) {
            this.rootTag = new HashMap<>();
            this.rootTag.put(name, newTag);
            this.currentTag = this.rootTag.get(name);
            return;
        }

        var parent = this.parentTags.getLast();
        if (parent != null) {
            parent.remove(this.tagNames.pollLast());
            parent.put(name, newTag);
            this.tagNames.offerLast(name);
        }

        this.currentTag = newTag;
    }
}
