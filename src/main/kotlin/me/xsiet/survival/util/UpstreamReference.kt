package me.xsiet.survival.util

import java.lang.ref.WeakReference

class UpstreamReference<T>(referent: T): WeakReference<T>(referent) {
    override fun get(): T {
        return super.get() ?: throw IllegalStateException(
            "Cannot get reference as it has already been Garbage Collected"
        )
    }
    override fun hashCode(): Int {
        return get().hashCode()
    }
    override fun equals(other: Any?): Boolean {
        return get() == other
    }
    override fun toString(): String {
        return get().toString()
    }
}