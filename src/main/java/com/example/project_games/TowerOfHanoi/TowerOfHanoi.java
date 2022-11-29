package com.example.project_games.TowerOfHanoi;

import lombok.ToString;

@ToString
public class TowerOfHanoi {
    private Integer disk;

    public TowerOfHanoi() {
    }

    public TowerOfHanoi(Integer disk) {
        this.disk = disk;
    }

    public Integer getDisk() {
        return disk;
    }

    public void setDisk(Integer disk) {
        this.disk = disk;
    }
}
