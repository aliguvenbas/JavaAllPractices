package com.ag.enum_;

public enum ExtraGroupStatusWithValue {
	NOT_SYNCED("NOT_SYNCED..."), SYNCING("SYNCING..."), SYNC_FAILED("SYNC_FAILED..."), SYNCED("SYNCED...");

	String s;

	ExtraGroupStatusWithValue(String s) {
		this.s = s;
	}

	public String getValue() {
		return s;
	}
}
